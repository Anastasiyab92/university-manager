package com.solvd.universitymanager.service.impl;

import com.solvd.universitymanager.domain.core.Department;
import com.solvd.universitymanager.domain.core.Faculty;
import com.solvd.universitymanager.persistence.FacultyRepository;
import com.solvd.universitymanager.persistence.impl.FacultyRepositoryImpl;
import com.solvd.universitymanager.service.DepartmentService;
import com.solvd.universitymanager.service.FacultyService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class FacultyServiceImpl implements FacultyService {

    private static final Logger LOGGER = LogManager.getLogger(FacultyServiceImpl.class);

    private final FacultyRepository facultyRepository;
    private final DepartmentService departmentService;

    public FacultyServiceImpl() {
        this.facultyRepository = new FacultyRepositoryImpl();
        this.departmentService = new DepartmentServiceImpl();
    }

    @Override
    public Faculty addFaculty(Faculty faculty, Integer universityId) {
        faculty.setId(null);
        facultyRepository.create(faculty,universityId);

        if (faculty.getDepartments() != null) {
            List<Department> departments = faculty.getDepartments().stream()
                    .map(department -> departmentService.addDepartment(department, faculty.getId()))
                    .collect(Collectors.toList());
            faculty.setDepartments(departments);
        }
        return faculty;
    }

    @Override
    public List<Faculty> listFaculties() {
        return facultyRepository.findAll();
    }

    @Override
    public Faculty findFacultyById(Integer id) {
        return facultyRepository.findById(id);
    }

    @Override
    public void modifyFaculty(Integer id, String newName) {
        Faculty faculty = facultyRepository.findById(id);
        if (faculty != null) {
            faculty.setName(newName);
            facultyRepository.update(faculty);
        } else {
            LOGGER.warn("Faculty with ID {} not found.", id);
        }

    }

    @Override
    public void removeFaculty(Integer id) {
        facultyRepository.delete(id);
    }
}
