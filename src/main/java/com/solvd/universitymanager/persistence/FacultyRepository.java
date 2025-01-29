package com.solvd.universitymanager.persistence;

import com.solvd.universitymanager.domain.core.Faculty;

import java.util.List;

public interface FacultyRepository {

    void create(Faculty faculty, Integer universityId);

    Faculty findById(Integer id);

    List<Faculty> findAll();

    List<Faculty> findAllWithDepartments();

    void update(Faculty faculty);

    void delete(Integer id);

}
