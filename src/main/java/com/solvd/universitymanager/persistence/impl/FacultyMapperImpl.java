package com.solvd.universitymanager.persistence.impl;

import com.solvd.universitymanager.domain.core.Faculty;
import com.solvd.universitymanager.persistence.FacultyRepository;
import com.solvd.universitymanager.persistence.MybatisSessionHolder;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class FacultyMapperImpl implements FacultyRepository {

    @Override
    public void create(Faculty faculty, Integer universityId) {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            FacultyRepository facultyRepository = session.getMapper(FacultyRepository.class);
            facultyRepository.create(faculty, universityId);
        }

    }

    @Override
    public Faculty findById(Integer id) {
        Faculty faculty;
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            FacultyRepository facultyRepository = session.getMapper(FacultyRepository.class);
            faculty = facultyRepository.findById(id);
        }
        return faculty;
    }

    @Override
    public List<Faculty> findAll() {
        List<Faculty> facultyList;
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            FacultyRepository facultyRepository = session.getMapper(FacultyRepository.class);
            facultyList = facultyRepository.findAll();
        }
        return facultyList;
    }

    @Override
    public List<Faculty> findAllWithDepartments() {
        List<Faculty> facultyList;
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            FacultyRepository facultyRepository = session.getMapper(FacultyRepository.class);
            facultyList = facultyRepository.findAllWithDepartments();
        }
        return facultyList;
    }

    @Override
    public void update(Faculty faculty) {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            FacultyRepository facultyRepository = session.getMapper(FacultyRepository.class);
            facultyRepository.update(faculty);
        }
    }

    @Override
    public void delete(Integer id) {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            FacultyRepository facultyRepository = session.getMapper(FacultyRepository.class);
            facultyRepository.delete(id);
        }
    }
}
