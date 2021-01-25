package com.example.core.model;

import java.util.List;

public interface Communication {
    Message sendMessage();
    List<Message> openReceivedMessage();
}
