package com.example.core.model.account;

import java.util.ArrayList;
import java.util.HashMap;

public interface Account {

    boolean loggInn(String username, String password);

    boolean changePassword(String password);

    void requestNewPasswordLink(String email);
}
