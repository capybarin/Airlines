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

    private ArrayList<Plane> getDirect (String from, String to){
        DatabaseWorker databaseWorker = null;
        try {
            databaseWorker = DatabaseWorker.getInstance();
        } catch (SQLException e) {
            log.error(e);
        }
        ArrayList<Plane> direct = databaseWorker.getPlanesFromTo(from,to);
        log.info(direct);
        return direct;
    }

    private ArrayList<NotDirectRoutesOutputHelper> getNotDirect (String from, String to){
        DatabaseWorker databaseWorker = null;
        try {
            databaseWorker = DatabaseWorker.getInstance();
        } catch (SQLException e) {
            log.error(e);
        }
        List<Plane> departure = databaseWorker.getPlaneByDeparture(from);
        List<Plane> destination = databaseWorker.getPlaneByDestination(to);
        ArrayList<NotDirectRoutesOutputHelper> notDirect = new ArrayList<>();
        for (Plane planeDep : departure) {
            for (Plane planeDest : destination) {
                if (planeDep.getTo().equals(planeDest.getFrom())){
                    int price = planeDep.getPrice()+planeDest.getPrice();
                    notDirect.add(new NotDirectRoutesOutputHelper(planeDep.getName(),planeDep.getType(),planeDep.getCompany(),
                            planeDep.getSeats(),planeDep.getFrom(),planeDep.getTo(),planeDest.getTo(),price,planeDep.getDate()));
                }
            }
        }
        return notDirect;
    }

    private ArrayList<Plane> getTypeDirect (String from, String to, String type){
        DatabaseWorker databaseWorker = null;
        try {
            databaseWorker = DatabaseWorker.getInstance();
        } catch (SQLException e) {
            log.error(e);
        }
        ArrayList<Plane> direct = databaseWorker.getPlanesTypeFromTo(from,to, type);
        log.info(direct);
        return direct;
    }

    private ArrayList<NotDirectRoutesOutputHelper> getTypeNotDirect (String from, String to, String type){
        DatabaseWorker databaseWorker = null;
        try {
            databaseWorker = DatabaseWorker.getInstance();
        } catch (SQLException e) {
            log.error(e);
        }
        List<Plane> departure = databaseWorker.getPlaneByTypeDeparture(from, type);
        List<Plane> destination = databaseWorker.getPlaneByTypeDestination(to, type);
        ArrayList<NotDirectRoutesOutputHelper> notDirect = new ArrayList<>();
        for (Plane planeDep : departure) {
            for (Plane planeDest : destination) {
                if (planeDep.getTo().equals(planeDest.getFrom()) && planeDep.getType().equals(planeDest.getType())){
                    int price = planeDep.getPrice()+planeDest.getPrice();
                    notDirect.add(new NotDirectRoutesOutputHelper(planeDep.getName(),planeDep.getType(),planeDep.getCompany(),
                            planeDep.getSeats(),planeDep.getFrom(),planeDep.getTo(),planeDest.getTo(),price,planeDep.getDate()));
                }
            }
        }
        return notDirect;
    }

    private ArrayList<Plane> getTypeDateDirect (String from, String to, String type, String date){
        DatabaseWorker databaseWorker = null;
        try {
            databaseWorker = DatabaseWorker.getInstance();
        } catch (SQLException e) {
            log.error(e);
        }
        ArrayList<Plane> direct = databaseWorker.getPlanesTypeDateFromTo(from,to, type, date);
        log.info(direct);
        return direct;
    }

    private ArrayList<NotDirectRoutesOutputHelper> getTypeDateNotDirect (String from, String to, String type, String date){
        DatabaseWorker databaseWorker = null;
        try {
            databaseWorker = DatabaseWorker.getInstance();
        } catch (SQLException e) {
            log.error(e);
        }
        List<Plane> departure = databaseWorker.getPlaneByTypeDateDeparture(from, type, date);
        List<Plane> destination = databaseWorker.getPlaneByTypeDateDestination(to, type, date);
        ArrayList<NotDirectRoutesOutputHelper> notDirect = new ArrayList<>();
        for (Plane planeDep : departure) {
            for (Plane planeDest : destination) {
                if (planeDep.getTo().equals(planeDest.getFrom()) && planeDep.getType().equals(planeDest.getType())
                        && planeDep.getDate().equals(planeDest.getDate())){
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
        if (from == null || to == null || beg == null || pClass==null){
            resp.sendRedirect("/errors/routeError.jsp");
            return;
        }
        log.info(from + " " + to + " " + beg + " " + pClass);
        if (beg.equals("") && !pClass.equals("")){
            List<Plane> directType = getTypeDirect(from, to, pClass);
            List<NotDirectRoutesOutputHelper> notDirectType = getTypeNotDirect(from, to, pClass);
            req.setAttribute("dirList", directType);
            req.setAttribute("notDirList", notDirectType);
        }
        if (!beg.equals("") && pClass.equals("")){
            List<Plane> dateDirect = getDateDirect(from,to, beg);
            List<NotDirectRoutesOutputHelper> dateNotDirect = getDateNotDirect(from,to,beg);
            req.setAttribute("dirList", dateDirect);
            req.setAttribute("notDirList", dateNotDirect);
        }
        if (!beg.equals("") && !pClass.equals("")){
            List<Plane> typeDateDirect = getTypeDateDirect(from, to, pClass, beg);
            List<NotDirectRoutesOutputHelper> typeDateNotDirect = getTypeDateNotDirect(from, to, pClass, beg);
            req.setAttribute("dirList", typeDateDirect);
            req.setAttribute("notDirList", typeDateNotDirect);
        }
        if (beg.equals("") && pClass.equals("")){
            List<Plane> direct = getDirect(from,to);
            List<NotDirectRoutesOutputHelper> notDirect = getNotDirect(from,to);
            req.setAttribute("dirList", direct);
            req.setAttribute("notDirList", notDirect);
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
