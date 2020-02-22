package com.airlines.app.servlets;

import com.airlines.app.database.DatabaseWorker;
import com.airlines.app.entities.User;
import com.airlines.app.helpers.EmailValidator;
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

public class SignupServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(SignupServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        if(session.getAttribute("currOnline") != null){
            resp.sendRedirect("/");
            return;
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/signup.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        BasicConfigurator.configure();
        EmailValidator validator = new EmailValidator();
        String login = req.getParameter("login");
        String password = req.getParameter("pass");
        String mail = req.getParameter("mail");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        if (!login.equals("")){
            if (!password.equals("")){
                    if (!name.equals("")){
                        if (!surname.equals("")){
                            if (!mail.equals("")){
                                if(validator.validate(mail)){
                                   log.info("mail is valid");
                                    try {
                                        User user = new User(login,password,name,surname,mail);
                                        DatabaseWorker databaseWorker = DatabaseWorker.getInstance();
                                        databaseWorker.addUser(user);
                                    } catch (SQLException e) {
                                        log.error(e);
                                    }
                                }
                            }else {
                                req.setAttribute("error", "Введите почту");
                            }
                        }else {
                            req.setAttribute("error", "Введите фамилию");
                        }
                    }else {
                        req.setAttribute("error", "Введите имя");
                    }
            }else {
                req.setAttribute("error", "Введите пароль");
            }
        }else {
            req.setAttribute("error", "Введите логин");
        }
        req.setAttribute("userLogin", login);
        req.setAttribute("userPass", password);
        req.setAttribute("userMail", mail);
        req.setAttribute("userName", name);
        req.setAttribute("userSurname", surname);

        doGet(req, resp);
    }
}
