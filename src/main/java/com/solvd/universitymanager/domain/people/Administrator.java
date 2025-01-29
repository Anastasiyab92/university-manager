package com.solvd.universitymanager.domain.people;

public class Administrator extends Person {

    private Long id;
    private String position;
    private String qualification;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    @Override
    public String getRole() {
        return "Faculty Administration.";
    }

}
