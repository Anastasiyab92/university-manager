package com.solvd.universitymanager.service;

import com.solvd.universitymanager.domain.core.Department;

import java.util.List;

public interface DepartmentService {

    Department addDepartment(Department department, Integer facultyId);

    List<Department> listDepartment();

    Department findDepartmentById(Integer id);

    void modifyDepartment(Integer id, String newName);

    void removeDepartment(Integer id);

}
