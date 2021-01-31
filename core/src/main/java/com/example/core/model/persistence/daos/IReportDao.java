package com.example.core.model.persistence.daos;

import com.example.core.model.course.Report;

import java.util.ArrayList;

public interface IReportDao {

    ArrayList<Report> reports = new ArrayList<>();

    void create(Report report);

    Report read(Report report);
}
