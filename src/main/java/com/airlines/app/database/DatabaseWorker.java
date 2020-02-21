package com.airlines.app.database;

import com.airlines.app.entities.Plane;
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
}
