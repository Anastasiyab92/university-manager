package com.solvd.universitymanager.service;

import com.solvd.universitymanager.domain.courses.Grade;

import java.util.List;

public interface GradeService {

    Grade addGrade(Grade grade);

    List<Grade> listGrades();

    Grade findGradeById(Long id);

    void modifyGrade(Long id, double newValue);

    void removeFaculty(Long id);
}
