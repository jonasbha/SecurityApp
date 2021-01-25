package com.example.core.model.account;

import java.util.ArrayList;
import java.util.HashMap;

public interface IAccount {

    boolean loggInn(String username, String password);

    boolean changePassword(String password);

    void requestNewPasswordLink(String email);
}
