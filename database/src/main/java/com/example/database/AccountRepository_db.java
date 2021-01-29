package com.example.database;

import com.example.core.model.communication.Report;
import com.example.core.model.repository.IAccountRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccountRepository_db implements IAccountRepository {


    Connection connect() {
        try {
            String url = "jdbc:mysql://158.39.188.206/";
            String userName = "datasikkerhet";
            String password = "/xu6U@$WN";

            return DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    };
/*
    public boolean verifyCredentials(String username, String password) {

        for (Map.Entry<String, String> set : credentials.entrySet())
            if (set.getKey().equals(username) && set.getValue().equals(password))
                return true;
        return false;
    }
*/
    @Override
    public boolean verifyCredentials(String username, String password) {
        return false;
    }

    @Override
    public void addCredential(String username, String password) {

    }

    @Override
    public void updatePassword(String username, String password) {

    }

    @Override
    public void updateUsername(String username) {

    }

    @Override
    public void addReport(Report report) {

    }
}