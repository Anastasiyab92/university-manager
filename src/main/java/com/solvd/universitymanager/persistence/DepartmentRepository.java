package com.solvd.universitymanager.persistence;

import com.solvd.universitymanager.domain.core.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentRepository {

    void create(@Param("department") Department department, @Param("facultyId") Integer facultyId);

    Department findById(Integer id);

    List<Department> findAll();

    List<Department> findAllWithCourses();

    void update(Department department);

    void delete(Integer id);

}
