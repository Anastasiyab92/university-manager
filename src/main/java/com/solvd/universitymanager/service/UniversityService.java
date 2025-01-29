package com.solvd.universitymanager.service;

import com.solvd.universitymanager.domain.core.University;

import java.util.List;

public interface UniversityService {

    University addUniversity(University university);

    List<University> listUniversities();

    List<University> findAllUniversitiesWithFaculties();

    University findUniversityById(Integer id);

    void modifyUniversity(Integer id, String newName, String newAddress);

    void removeUniversity(Integer id);

}
