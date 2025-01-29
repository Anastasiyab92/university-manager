package com.solvd.universitymanager.persistence;

import com.solvd.universitymanager.domain.courses.Grade;

import java.util.List;

public interface GradeRepository {

    void create(Grade grade);

    Grade findById(Long id);

    List<Grade> findAll();

    void update(Grade grade);

    void delete(Long id);

}
