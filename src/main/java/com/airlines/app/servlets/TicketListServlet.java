package com.airlines.app.servlets;

import com.airlines.app.database.DatabaseWorker;
import com.airlines.app.entities.Ticket;
import com.airlines.app.helpers.TicketsOutputHelper;
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
import java.util.ArrayList;
import java.util.List;

public class TicketListServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(TicketListServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BasicConfigurator.configure();
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        if (session.getAttribute("currOnline") == null)
        {
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/errors/ticketError.jsp");
            requestDispatcher.forward(req, resp);
            return;
        }
        DatabaseWorker databaseWorker = null;
        try {
            databaseWorker = DatabaseWorker.getInstance();
            List<Ticket> tickets = databaseWorker.getTicketByUserId((Integer) session.getAttribute("currOnline"));
            log.info(tickets);
            TicketsOutputHelper ticketsOutputHelper = null;
            List<TicketsOutputHelper> currTickets = new ArrayList<>();
            for (Ticket ticket: tickets) {
                ticketsOutputHelper = new TicketsOutputHelper(ticket.getId(),ticket.getSeat(), ticket.getDateOfBeg(), ticket.getDateOfEnd(),
                        ticket.getTerminal(),ticket.getGate(), databaseWorker.getUsernameById(ticket.getIdUser()),
                        databaseWorker.getUserSurnameById(ticket.getIdUser()), databaseWorker.getPlaneNameById(ticket.getIdPlane()),
                        databaseWorker.getPlaneTypeById(ticket.getIdPlane()));
                currTickets.add(ticketsOutputHelper);
            }
            log.info(currTickets);
        } catch (SQLException e) {
            log.error(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
