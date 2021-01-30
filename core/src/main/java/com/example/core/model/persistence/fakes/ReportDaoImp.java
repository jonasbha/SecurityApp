package com.example.core.model.persistence.fakes;

import com.example.core.model.Report;
import com.example.core.model.persistence.daos.IReportDao;

import java.util.ArrayList;

public class ReportDaoImp implements IReportDao {

    ArrayList<Report> reports = new ArrayList<>();

    @Override
    public void create(Report report) {
        reports.add(report);
    }

    @Override
    public Report read(Report report) {
        for (int i = 0; i < reports.size(); i++)
            if (reports.get(i) == report)
                return report;
        return null;
    }
}
