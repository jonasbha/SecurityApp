package com.example.core.model.course;

import com.example.core.model.course.Message;

public class Report {
    private final Message message;
    private String issue;

    public Report(Message message, String issue) {
        this.message = message;
        this.issue = issue;
    }

    public String getIssue() {
        return issue;
    }
}
