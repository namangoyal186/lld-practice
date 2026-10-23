package com.linkedinsystem;

public class Education {
    private int startYear;
    private int endYear;
    private String institution;
    private String degree;

    public Education(int startYear, int endYear, String institution, String degree) {
        this.startYear = startYear;
        this.endYear = endYear;
        this.institution = institution;
        this.degree = degree;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Education{" +
                "startYear=" + startYear +
                ", endYear=" + endYear +
                ", institution='" + institution + '\'' +
                ", degree='" + degree + '\'' +
                '}';
    }
}
