package com.airlines.app.database;

import com.airlines.app.entities.Plane;
import com.airlines.app.entities.Ticket;
import com.airlines.app.entities.User;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

/**
 * Singleton класс для работы с БД
 * @author Bezdushnyi Vladyslav
 */

public class DatabaseWorker {
    private static DatabaseWorker instance;
    private static final Logger log = Logger.getLogger(DatabaseWorker.class);
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/airlines?serverTimezone=UTC";
    private String username = "root";
    private String password = "qwerty";


    /**Метод для подключения к базе данных
     * @throws SQLException
     */
    private DatabaseWorker() throws SQLException {
        BasicConfigurator.configure();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            log.error("Unable to connect to db ", e);
        }
    }

    public Connection getConnection(){
        return connection;
    }

    /**
     * Метод для получения экземпляра класса
     * @return class instance
     * @throws SQLException
     */
    public static DatabaseWorker getInstance() throws SQLException {
        if(instance == null){
            instance = new DatabaseWorker();
        } else if(instance.getConnection().isClosed()){
            instance = new DatabaseWorker();
        }
        return instance;
    }

    /**
     * Метод для добавления юзера в БД;
     * Используется при регистрации
     * @param user
     */
    public void addUser(User user){
        log.info("Creating a user");
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("insert into user (Login, Password, Name, Surname, Mail) values(?,?,?,?,?)");
            preparedStatement.setString(1,user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getName());
            preparedStatement.setString(4, user.getSurname());
            preparedStatement.setString(5, user.getMail());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            log.error(e);
        }
    }

    public int loginUser(String userLogin, String userPass){
        int userId = -1;
        String sql = "SELECT idUser FROM user WHERE Login = " + "'" + userLogin + "'" + " AND Password = " + "'" + userPass + "'";
        try{
            ResultSet id = connection.createStatement().executeQuery(sql);
            while (id.next()){
                userId = id.getInt("idUser");
            }
        }catch (SQLException e) {
            log.info(e);
        }
        return userId;
    }

    public ArrayList<Plane> getPlaneList(){
        ArrayList<Plane> planes = new ArrayList<>();
        try {
            ResultSet planeSet = connection.createStatement().executeQuery("SELECT * FROM plane");
            while (planeSet.next()){
                planes.add(new Plane(planeSet.getInt(1), planeSet.getString(2),planeSet.getString(3),
                        planeSet.getString(4),planeSet.getInt(5),planeSet.getString(6),
                        planeSet.getString(7),planeSet.getString(8),planeSet.getInt(9),
                        planeSet.getString(10)));
            }
        } catch (SQLException e) {
            log.error(e);
        }
        return planes;
    }

    public String getLoginById(int id){
        String userLogin = null;
        String sql = "SELECT * FROM user WHERE idUser = " + id;
        try{
            ResultSet name = connection.createStatement().executeQuery(sql);
            while (name.next()){
                userLogin = name.getString("Login");
            }
        } catch (SQLException e){
            log.error(e);
        }
        return userLogin;
    }

    public ArrayList<Ticket> getTicketByUserId (int id){
        ArrayList<Ticket> tickets = new ArrayList<>();
        try{
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT  * FROM ticket WHERE idUser = " + id);
            while (resultSet.next()){
                tickets.add(new Ticket(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),
                        resultSet.getInt(4),resultSet.getString(5),resultSet.getString(6),
                        resultSet.getString(7),resultSet.getString(8)));
            }
        } catch (SQLException e){
            log.error(e);
        }
        return tickets;
    }

    public String getUsernameById (int id){
        String name = null;
        String sql = "SELECT Name FROM user WHERE idUser = " + id;
        try{
            ResultSet names = connection.createStatement().executeQuery(sql);
            while (names.next()){
                name = names.getString("Name");
            }
        } catch (SQLException e){
            log.error(e);
        }
        return name;
    }

    public String getUserSurnameById (int id){
        String surName = null;
        String sql = "SELECT Surname FROM user WHERE idUser = " + id;
        try{
            ResultSet names = connection.createStatement().executeQuery(sql);
            while (names.next()){
                surName = names.getString("Surname");
            }
        } catch (SQLException e){
            log.error(e);
        }
        return surName;
    }

    public String getPlaneNameById (int id){
        String name = null;
        String sql = "SELECT Name FROM plane WHERE idPlane = " + id;
        try{
            ResultSet names = connection.createStatement().executeQuery(sql);
            while (names.next()){
                name = names.getString("Name");
            }
        } catch (SQLException e){
            log.error(e);
        }
        return name;
    }

    public String getPlaneTypeById (int id){
        String type = null;
        String sql = "SELECT Type FROM plane WHERE idPlane = " + id;
        try{
            ResultSet names = connection.createStatement().executeQuery(sql);
            while (names.next()){
                type = names.getString("Type");
            }
        } catch (SQLException e){
            log.error(e);
        }
        return type;
    }

    public ArrayList<Plane> getPlaneByDestinationDate(String dest, String date){
        String sql = "SELECT * FROM plane WHERE plane.To = '" + dest + "' AND plane.Date = '" + date +"'";
        ArrayList<Plane> planes = new ArrayList<>();
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            while (resultSet.next()){
                planes.add(new Plane(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),
                        resultSet.getString(4),resultSet.getInt(5),resultSet.getString(6),
                        resultSet.getString(7),resultSet.getString(8),resultSet.getInt(9),
                        resultSet.getString(10)));
            }
        } catch (SQLException e) {
            log.error(e);
        }
        return planes;
    }

    public ArrayList<Plane> getPlaneByDestination(String dest){
        String sql = "SELECT * FROM plane WHERE plane.To = '" + dest + "'";
        ArrayList<Plane> planes = new ArrayList<>();
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            while (resultSet.next()){
                planes.add(new Plane(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),
                        resultSet.getString(4),resultSet.getInt(5),resultSet.getString(6),
                        resultSet.getString(7),resultSet.getString(8),resultSet.getInt(9),
                        resultSet.getString(10)));
            }
        } catch (SQLException e) {
            log.error(e);
        }
        return planes;
    }

    public ArrayList<Plane> getPlaneByDepartureDate(String dep, String date){
        String sql = "SELECT * FROM plane WHERE plane.From = '" + dep + "' AND plane.Date = '" + date + "'";
        ArrayList<Plane> planes = new ArrayList<>();
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            while (resultSet.next()){
                planes.add(new Plane(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),
                        resultSet.getString(4),resultSet.getInt(5),resultSet.getString(6),
                        resultSet.getString(7),resultSet.getString(8),resultSet.getInt(9),
                        resultSet.getString(10)));
            }
        } catch (SQLException e) {
            log.error(e);
        }
        return planes;
    }

    public ArrayList<Plane> getPlaneByDepartureDate(String dep){
        String sql = "SELECT * FROM plane WHERE plane.From = '" + dep + "'";
        ArrayList<Plane> planes = new ArrayList<>();
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            while (resultSet.next()){
                planes.add(new Plane(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),
                        resultSet.getString(4),resultSet.getInt(5),resultSet.getString(6),
                        resultSet.getString(7),resultSet.getString(8),resultSet.getInt(9),
                        resultSet.getString(10)));
            }
        } catch (SQLException e) {
            log.error(e);
        }
        return planes;
    }

    public ArrayList<Plane> getPlanesFromToDate(String from, String to, String date){
        String sql = "SELECT * FROM plane WHERE plane.From = '" + from + "' AND plane.TO = '" + to + "'" +
                " AND plane.Date = '" + date +"'";
        ArrayList<Plane> planes = new ArrayList<>();
        try{
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            while (resultSet.next()){
                planes.add(new Plane(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),
                        resultSet.getString(4),resultSet.getInt(5),resultSet.getString(6),
                        resultSet.getString(7),resultSet.getString(8),resultSet.getInt(9),
                        resultSet.getString(10)));
            }
        } catch (SQLException e) {
            log.error(e);
        }
        return planes;
    }

    public ArrayList<Plane> getPlanesFromTo(String from, String to){
        String sql = "SELECT * FROM plane WHERE plane.From = '" + from + "' AND plane.TO = '" + to + "'";
        ArrayList<Plane> planes = new ArrayList<>();
        try{
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            while (resultSet.next()){
                planes.add(new Plane(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),
                        resultSet.getString(4),resultSet.getInt(5),resultSet.getString(6),
                        resultSet.getString(7),resultSet.getString(8),resultSet.getInt(9),
                        resultSet.getString(10)));
            }
        } catch (SQLException e) {
            log.error(e);
        }
        return planes;
    }
}
