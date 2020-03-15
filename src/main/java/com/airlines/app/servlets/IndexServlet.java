package com.airlines.app.servlets;

import com.airlines.app.database.DatabaseWorker;
import com.airlines.app.entities.Plane;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class IndexServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(IndexServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BasicConfigurator.configure();
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        DatabaseWorker databaseWorker = null;
        try {
            databaseWorker = DatabaseWorker.getInstance();
        } catch (SQLException e) {
            log.error(e);
        }
        if(session.getAttribute("currOnline") != null){
            req.setAttribute("isLoggedIn", "OK");
            req.setAttribute("login", databaseWorker.getLoginById((Integer) session.getAttribute("currOnline")));
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BasicConfigurator.configure();
        req.setCharacterEncoding("UTF-8");
        /*String planeId = req.getParameter("id");
        log.info(planeId);
        HttpSession session = req.getSession();
        if (session.getAttribute("currOnline") == null)
        {
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/errors/notLoggedError.jsp");
            requestDispatcher.forward(req, resp);
            return;
        }*/
        DatabaseWorker databaseWorker = null;
        try {
            databaseWorker = DatabaseWorker.getInstance();
        } catch (SQLException e) {
            log.error(e);
        }
        String from = req.getParameter("from");
        String to = req.getParameter("destination");
        String beg = req.getParameter("dateOfBeg");
        String pClass = req.getParameter("planeClass");
        List<Plane> departure = databaseWorker.getPlaneByDeparture(from);
        List<Plane> destination = databaseWorker.getPlaneByDestination(to);
        log.info("Dest: " + destination);
        log.info("Dep: " + departure);
        log.info(from + " " + to + " " + beg + " " + " " + pClass);
        doGet(req,resp);
    }
}
