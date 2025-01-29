package com.solvd.universitymanager.persistence;

import com.solvd.universitymanager.domain.core.Department;

import java.util.List;

public interface DepartmentRepository {

    void create(Department department, Integer facultyId);

    Department findById(Integer id);

    List<Department> findAll();

    List<Department> findAllWithCourses();

    void update(Department department);

    void delete(Integer id);

}
