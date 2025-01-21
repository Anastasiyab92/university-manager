package com.solvd.universitymanager.people;

public class Instructor extends Person {

    private Long id;
    private String qualification;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    @Override
    public String getRole() {
        return "Instructor";
    }


}
