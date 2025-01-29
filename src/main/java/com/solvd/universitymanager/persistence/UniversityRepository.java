package com.solvd.universitymanager.persistence;

import com.solvd.universitymanager.domain.core.University;

import java.util.List;

public interface UniversityRepository {

    void create(University university);

    University findById(Integer id);

    List<University> findAll();

    List<University> findAllWithFaculties();

    void update(University university);

    void delete(Integer id);

}
