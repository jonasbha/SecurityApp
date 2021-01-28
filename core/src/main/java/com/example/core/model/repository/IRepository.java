package com.example.core.model.repository;

import com.example.core.model.communication.Report;

public interface IRepository {

    boolean verifyCredentials(String username, String password);

    void addCredential(String username, String password);

    void updatePassword(String username, String password);

    void updateUsername(String username);

    // reports
    void addReport(Report report);
}
