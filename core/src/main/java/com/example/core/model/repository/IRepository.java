package com.example.core.model.repository;

import java.util.ArrayList;
import java.util.HashMap;

public interface IRepository {

    boolean verifyCredentials(String username, String password);

    void addCredential(String username, String password);

    void updatePassword(String username, String password);

    void updateUsername(String username);
}
