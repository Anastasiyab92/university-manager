package com.solvd.universitymanager.domain.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "university")
@XmlAccessorType(XmlAccessType.FIELD)
public class University {
    @JsonIgnore
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("address")
    private String address;

    @XmlElementWrapper(name = "faculties")
    @XmlElement(name = "faculty")
    @JsonProperty("faculties")
    private List<Faculty> faculties;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    @Override
    public String toString() {
        return "University name: " + "\n" + name + "\n"
                + "Address: " + address + "\n"
                + "List of faculties: " + faculties;
    }
}
