package com.airlines.app.servlets;

import com.airlines.app.database.DatabaseWorker;
import com.airlines.app.entities.Plane;
import com.airlines.app.helpers.NotDirectRoutesOutputHelper;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RouteServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(RouteServlet.class);

    private ArrayList<Plane> getDateDirect(String from, String to, String date){
        DatabaseWorker databaseWorker = null;
        try {
            databaseWorker = DatabaseWorker.getInstance();
        } catch (SQLException e) {
            log.error(e);
        }
        ArrayList<Plane> direct = databaseWorker.getPlanesFromToDate(from,to, date);
        log.info(direct);
        return direct;
    }

    private ArrayList<NotDirectRoutesOutputHelper> getDateNotDirect(String from, String to, String date){
        DatabaseWorker databaseWorker = null;
        try {
            databaseWorker = DatabaseWorker.getInstance();
        } catch (SQLException e) {
            log.error(e);
        }
        List<Plane> departure = databaseWorker.getPlaneByDepartureDate(from, date);
        List<Plane> destination = databaseWorker.getPlaneByDestinationDate(to, date);
        ArrayList<NotDirectRoutesOutputHelper> notDirect = new ArrayList<>();
        for (Plane planeDep : departure) {
            for (Plane planeDest : destination) {
                if (planeDep.getTo().equals(planeDest.getFrom()) && planeDep.getDate().equals(planeDest.getDate())){
                    int price = planeDep.getPrice()+planeDest.getPrice();
                    notDirect.add(new NotDirectRoutesOutputHelper(planeDep.getName(),planeDep.getType(),planeDep.getCompany(),
                            planeDep.getSeats(),planeDep.getFrom(),planeDep.getTo(),planeDest.getTo(),price,planeDep.getDate()));
                }
            }
        }
        return notDirect;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BasicConfigurator.configure();
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        String from = (String) session.getAttribute("from");
        String to = (String) session.getAttribute("to");
        String beg = (String) session.getAttribute("beg");
        String pClass = (String) session.getAttribute("pClass");
        log.info(from + " " + to + " " + beg + " " + pClass);
        log.info("from: " + from.equals(""));
        log.info("to: " + to.equals(""));
        log.info("beg: " + beg.equals(""));
        log.info("pClass: " + pClass.equals(""));
        if (beg.equals("") && !pClass.equals("")){
            //Методы с учетом класса без даты
        }
        if (!beg.equals("") && pClass.equals("")){
            List<Plane> dateDirect = getDateDirect(from,to, beg);
            List<NotDirectRoutesOutputHelper> dateNotDirect = getDateNotDirect(from,to,beg);
            log.info("DIR: " + dateDirect);
            log.info("NOTDIR: " + dateNotDirect);
            req.setAttribute("dirList", dateDirect);
            req.setAttribute("notDirList", dateNotDirect);
        }
        if (!beg.equals("") && !pClass.equals("")){
            //Методы с учетом даты и класса
        }
        if (beg.equals("") && pClass.equals("")){
            //Методы без учета даты и класса
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/routes.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BasicConfigurator.configure();
        req.setCharacterEncoding("UTF-8");
        doGet(req,resp);
    }
}
