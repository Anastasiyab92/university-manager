package com.solvd.universitymanager.domain.courses;

public class Grade {

    private Long id;
    private double gradeValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getGradeValue() {
        return gradeValue;
    }

    public void setGradeValue(double gradeValue) {
        this.gradeValue = gradeValue;
    }

    @Override
    public String toString() {
        return "Grade : " + "value = " + gradeValue;
    }
}
