package com.solvd.universitymanager.service.impl;

import com.solvd.universitymanager.domain.core.Department;
import com.solvd.universitymanager.domain.courses.Course;
import com.solvd.universitymanager.persistence.DepartmentRepository;
import com.solvd.universitymanager.persistence.impl.DepartmentRepositoryImpl;
import com.solvd.universitymanager.service.CourseService;
import com.solvd.universitymanager.service.DepartmentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class DepartmentServiceImpl implements DepartmentService {

    private static final Logger LOGGER = LogManager.getLogger(DepartmentServiceImpl.class);

    private final DepartmentRepository departmentRepository;
    private final CourseService courseService;

    public DepartmentServiceImpl() {
        this.departmentRepository = new DepartmentRepositoryImpl();
        this.courseService = new CourseServiceImpl();
    }

    @Override
    public Department addDepartment(Department department, Integer facultyId) {
        department.setId(null);

        if (department.getCourses() != null) {
            List<Course> courses = department.getCourses().stream()
                    .map(course -> courseService.addCourse(course, department.getId()))
                    .collect(Collectors.toList());
            department.setCourses(courses);
            departmentRepository.create(department, facultyId);
        }
        return department;
    }

    @Override
    public List<Department> listDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findDepartmentById(Integer id) {
        return departmentRepository.findById(id);
    }

    @Override
    public void modifyDepartment(Integer id, String newName) {
        Department department = departmentRepository.findById(id);
        if (department != null) {
            department.setName(newName);
            departmentRepository.update(department);
        } else {
            LOGGER.warn("Faculty with ID {} not found.", id);
        }

    }

    @Override
    public void removeDepartment(Integer id) {
        departmentRepository.delete(id);
    }
}
