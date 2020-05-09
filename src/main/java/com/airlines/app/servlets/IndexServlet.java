package com.airlines.app.servlets;

import com.airlines.app.database.DatabaseWorker;
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
        String from = req.getParameter("from");
        String to = req.getParameter("destination");
        String beg = req.getParameter("dateOfBeg");
        String pClass = req.getParameter("planeClass");
        HttpSession session = req.getSession();
        session.setAttribute("from", from);
        session.setAttribute("to", to);
        session.setAttribute("beg", beg);
        session.setAttribute("pClass", pClass);
        resp.sendRedirect("/routes");
        return;
    }
}
