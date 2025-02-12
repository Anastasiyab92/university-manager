package com.solvd.universitymanager.persistence.impl;

import com.solvd.universitymanager.domain.core.Department;
import com.solvd.universitymanager.persistence.DepartmentRepository;
import com.solvd.universitymanager.persistence.MybatisSessionHolder;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DepartmentMapperImpl implements DepartmentRepository {

    @Override
    public void create(Department department, Integer facultyId) {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            DepartmentRepository departmentRepository = session.getMapper(DepartmentRepository.class);
            departmentRepository.create(department, facultyId);
        }
    }

    @Override
    public Department findById(Integer id) {
        Department department;
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            DepartmentRepository departmentRepository = session.getMapper(DepartmentRepository.class);
            department = departmentRepository.findById(id);
        }
        return department;
    }

    @Override
    public List<Department> findAll() {
        List<Department> departmentList;
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            DepartmentRepository departmentRepository = session.getMapper(DepartmentRepository.class);
            departmentList = departmentRepository.findAll();
        }
        return departmentList;
    }

    @Override
    public List<Department> findAllWithCourses() {
        List<Department> departmentList;
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            DepartmentRepository departmentRepository = session.getMapper(DepartmentRepository.class);
            departmentList = departmentRepository.findAllWithCourses();
        }
        return departmentList;
    }

    @Override
    public void update(Department department) {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            DepartmentRepository departmentRepository = session.getMapper(DepartmentRepository.class);
            departmentRepository.update(department);
        }
    }

    @Override
    public void delete(Integer id) {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            DepartmentRepository departmentRepository = session.getMapper(DepartmentRepository.class);
            departmentRepository.delete(id);
        }
    }
}
