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

    //TODO: Сделать с помощью сесси маркеры где находится пользователь, и по ним делать ретурны по страницам

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        if(session.getAttribute("currOnline") != null){
            resp.sendRedirect("/");
            return;
        }
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
                int userId = databaseWorker.loginUser(name,pass);
                session.setAttribute("currOnline", userId);
                resp.sendRedirect("/");
                return;
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
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/errors/notLoggedError.jsp");
            requestDispatcher.forward(req, resp);
        } else{
            writer.println("hello "+session.getAttribute("currOnline"));
        }
 */