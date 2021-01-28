package com.example.core.model.account;

import com.example.core.model.Dialogue;
import com.example.core.model.Message;

import java.util.List;

public interface ICommunication {
    boolean sendMessage(Message msg);
    boolean openDialog(Dialogue dialogue);
    List<Dialogue> listAllDialogs();
}
