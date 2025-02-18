package com.solvd.universitymanager.service.impl;

import com.solvd.universitymanager.domain.courses.Grade;
import com.solvd.universitymanager.persistence.GradeRepository;
import com.solvd.universitymanager.persistence.impl.GradeMapperImpl;
import com.solvd.universitymanager.service.GradeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class GradeServiceImpl implements GradeService {

    private static final Logger LOGGER = LogManager.getLogger(GradeServiceImpl.class);

    private final GradeRepository gradeRepository;

    public GradeServiceImpl() {
        //this.gradeRepository = new GradeRepositoryImpl();
        this.gradeRepository = new GradeMapperImpl();
    }

    @Override
    public Grade addGrade(Grade grade) {
        grade.setId(null);
        gradeRepository.create(grade);
        return grade;
    }

    @Override
    public List<Grade> listGrades() {
        return gradeRepository.findAll();
    }

    @Override
    public Grade findGradeById(Long id) {
        return gradeRepository.findById(id);
    }

    @Override
    public void modifyGrade(Long id, Integer newValue) {
        Grade grade = gradeRepository.findById(id);
        if (grade != null) {
            grade.setGradeValue(newValue);
            gradeRepository.update(grade);
        } else {
            LOGGER.warn("Grade with ID {} not found.", id);
        }
    }

    @Override
    public void removeFaculty(Long id) {

    }
}
