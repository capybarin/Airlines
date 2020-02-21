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
}