package com.example.core.model.account;

import com.example.core.model.Dialog;
import com.example.core.model.Message;

import java.util.List;

public interface ICommunication {
    boolean sendMessage(Message msg);
    boolean openDialog(Dialog dialog);
    List<Dialog> listAllDialogs();
}
