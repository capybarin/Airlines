package com.airlines.app.database;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.sql.*;

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
}
