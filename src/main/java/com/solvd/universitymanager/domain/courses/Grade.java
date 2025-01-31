package com.solvd.universitymanager.domain.courses;

public class Grade {

    private Long id;
    private Integer gradeValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGradeValue() {
        return gradeValue;
    }

    public void setGradeValue(Integer gradeValue) {
        this.gradeValue = gradeValue;
    }

    @Override
    public String toString() {
        return "Grade : " + "value = " + gradeValue;
    }
}
