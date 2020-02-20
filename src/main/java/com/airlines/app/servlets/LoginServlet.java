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

public class LoginServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(LoginServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        BasicConfigurator.configure();
        String name = req.getParameter("name");
        String pass = req.getParameter("pass");
        try {
            DatabaseWorker databaseWorker = DatabaseWorker.getInstance();
            if(databaseWorker.loginUser(name, pass)>0){
                HttpSession session = req.getSession();
                session.setAttribute("currOnline", databaseWorker.loginUser(name, pass));
                //resp.sendRedirect("/afterLoginTest");
                //return;
            } else {
                req.setAttribute("error", "Логин или пароль введен не правильно");
            }
        } catch (SQLException e) {
            log.error(e);
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/login.jsp");
        requestDispatcher.forward(req, resp);
    }
}


/*
if (session.getAttribute("currOnline") == null)
        {
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/views/error.jsp");
            requestDispatcher.forward(req, resp);
        } else{
            writer.println("hello "+session.getAttribute("currOnline"));
        }
 */