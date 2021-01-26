package com.example.core.model;

public class Report {
    private Message message;
    private String issue;

    public Report(Message message, String issue) {
        this.message = message;
        this.issue = issue;
    }

    public String getIssue() {
        return issue;
    }
}
