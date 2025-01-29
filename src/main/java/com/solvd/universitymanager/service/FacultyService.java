package com.solvd.universitymanager.service;

import com.solvd.universitymanager.domain.core.Faculty;

import java.util.List;

public interface FacultyService {

    Faculty addFaculty(Faculty faculty, Integer universityId);

    List<Faculty> listFaculties();

    Faculty findFacultyById(Integer id);

    void modifyFaculty(Integer id, String newName);

    void removeFaculty(Integer id);
}
