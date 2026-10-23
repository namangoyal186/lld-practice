package com.linkedinsystem;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Experience {
    private String title;
    private String company;
    private LocalDate startDate;
    private LocalDate endDate;

    public Experience(String title, String company, LocalDate startDate, LocalDate endDate) {
        this.title = title;
        this.company = company;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "title='" + title + '\'' +
                ", company='" + company + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
