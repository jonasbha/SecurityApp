package com.example.core.model.repository;

import com.example.core.model.communication.Report;
import com.example.core.model.repository.IRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FakeRepo implements IRepository {

    HashMap<String, String> credentials = new HashMap<>();

    public FakeRepo() {
        credentials.put("Geir", "Hollund");
    }

    ArrayList<Report> reports = new ArrayList<>();

    @Override
    public boolean verifyCredentials(String username, String password) {

        for (Map.Entry<String, String> set : credentials.entrySet())
            if (set.getKey().equals(username) && set.getValue().equals(password))
                return true;
        return false;
    }

    @Override
    public void addCredential(String username, String password) {
        credentials.put(username, password);
    }

    @Override
    public void updatePassword(String username, String password) {
        for (Map.Entry<String, String> set : credentials.entrySet()) {
            if (set.getKey().equals(username))
                set.setValue(password);
        }
    }

    @Override
    public void updateUsername(String username) {
        for (Map.Entry<String, String> set : credentials.entrySet()) {
            if (set.getKey().equals(username)) {
                String password = set.getValue();
                credentials.remove(username);
                credentials.put(username, password);
            }

        }
    }

    @Override
    public void addReport(Report report) {
        reports.add(report);
    }
}