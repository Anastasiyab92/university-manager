package com.solvd.universitymanager.persistence.impl;

import com.solvd.universitymanager.domain.courses.Grade;
import com.solvd.universitymanager.persistence.GradeRepository;
import com.solvd.universitymanager.persistence.MybatisSessionHolder;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class GradeMapperImpl implements GradeRepository {

    @Override
    public void create(Grade grade) {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            GradeRepository gradeRepository = session.getMapper(GradeRepository.class);
            gradeRepository.create(grade);
        }
    }

    @Override
    public Grade findById(Long id) {
        Grade grade;
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            GradeRepository gradeRepository = session.getMapper(GradeRepository.class);
            grade = gradeRepository.findById(id);
        }
        return grade;
    }

    @Override
    public List<Grade> findAll() {
        List<Grade> gradeList;
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            GradeRepository gradeRepository = session.getMapper(GradeRepository.class);
            gradeList = gradeRepository.findAll();
        }
        return gradeList;
    }

    @Override
    public void update(Grade grade) {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            GradeRepository gradeRepository = session.getMapper(GradeRepository.class);
            gradeRepository.update(grade);
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            GradeRepository gradeRepository = session.getMapper(GradeRepository.class);
            gradeRepository.delete(id);
        }
    }
}
