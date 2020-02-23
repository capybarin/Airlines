package com.airlines.app.database;

import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class DatabaseWorkerTest {

    @Test
    public void getLoginById() {
        String expected = "capych";
        DatabaseWorker databaseWorker = null;
        try {
            databaseWorker = DatabaseWorker.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String actual = databaseWorker.getLoginById(1);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getUsernameById() {
        String expected = "Vlad";
        DatabaseWorker databaseWorker = null;
        try {
            databaseWorker = DatabaseWorker.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String actual = databaseWorker.getUsernameById(1);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getUserSurnameById() {
        String expected = "Bezd";
        DatabaseWorker databaseWorker = null;
        try {
            databaseWorker = DatabaseWorker.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String actual = databaseWorker.getUserSurnameById(1);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getPlaneNameById() {
        String expected = "Boeing 737";
        DatabaseWorker databaseWorker = null;
        try {
            databaseWorker = DatabaseWorker.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String actual = databaseWorker.getPlaneNameById(1);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getPlaneTypeById() {
        String expected = "Business-class";
        DatabaseWorker databaseWorker = null;
        try {
            databaseWorker = DatabaseWorker.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String actual = databaseWorker.getPlaneTypeById(1);
        Assert.assertEquals(expected,actual);
    }
}