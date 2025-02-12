package com.solvd.universitymanager.persistence.impl;

import com.solvd.universitymanager.domain.core.University;
import com.solvd.universitymanager.persistence.MybatisSessionHolder;
import com.solvd.universitymanager.persistence.UniversityRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UniversityMapperImpl implements UniversityRepository {

    @Override
    public void create(University university) {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            UniversityRepository universityRepository = session.getMapper(UniversityRepository.class);
            universityRepository.create(university);
        }
    }

    @Override
    public University findById(Integer id) {
        University university;
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            UniversityRepository universityRepository = session.getMapper(UniversityRepository.class);
            university = universityRepository.findById(id);
        }
        return university;
    }

    @Override
    public List<University> findAll() {
        List<University> universityList;
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            UniversityRepository universityRepository = session.getMapper(UniversityRepository.class);
            universityList = universityRepository.findAll();
        }
        return universityList;
    }

    @Override
    public List<University> findAllWithFaculties() {
        List<University> universityList;
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            UniversityRepository universityRepository = session.getMapper(UniversityRepository.class);
            universityList = universityRepository.findAllWithFaculties();
        }
        return universityList;
    }

    @Override
    public void update(University university) {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            UniversityRepository universityRepository = session.getMapper(UniversityRepository.class);
            universityRepository.update(university);
        }
    }

    @Override
    public void delete(Integer id) {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            UniversityRepository universityRepository = session.getMapper(UniversityRepository.class);
            universityRepository.delete(id);
        }
    }
}
