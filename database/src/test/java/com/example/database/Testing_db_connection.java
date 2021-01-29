package com.example.database;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class Testing_db_connection {

    ResultSet rs;
    Connection conn;

    @Test
    public void connected() throws SQLException {

        try {
            String url = "jdbc:mysql://158.39.188.206/";
            String userName = "datasikkerhet";
            String password = "/xu6U@$WN";

            conn = DriverManager.getConnection(url, userName, password);
            rs = conn.prepareStatement("Select 1 FROM Student;").executeQuery();
            assertEquals("s", rs);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            rs.close();
            conn.close();
        }
    }
}