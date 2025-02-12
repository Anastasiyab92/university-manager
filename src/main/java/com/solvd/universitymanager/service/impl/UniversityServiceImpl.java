package com.solvd.universitymanager.service.impl;


import com.solvd.universitymanager.domain.core.Faculty;
import com.solvd.universitymanager.domain.core.University;
import com.solvd.universitymanager.persistence.UniversityRepository;
import com.solvd.universitymanager.persistence.impl.UniversityMapperImpl;
import com.solvd.universitymanager.persistence.impl.UniversityRepositoryImpl;
import com.solvd.universitymanager.service.FacultyService;
import com.solvd.universitymanager.service.UniversityService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class UniversityServiceImpl implements UniversityService {

    private static final Logger LOGGER = LogManager.getLogger(UniversityServiceImpl.class);

    private final UniversityRepository universityRepository;
    private final FacultyService facultyService;


    public UniversityServiceImpl() {
        //this.universityRepository = new UniversityRepositoryImpl();
        this.universityRepository = new UniversityMapperImpl();
        this.facultyService = new FacultyServiceImpl();
    }

    @Override
    public University addUniversity(University university) {
        university.setId(null);
        universityRepository.create(university);

        if (university.getFaculties() != null) {
            List<Faculty> faculties = university.getFaculties().stream()
                    .map(faculty -> facultyService.addFaculty(faculty, university.getId()))
                    .collect(Collectors.toList());
            university.setFaculties(faculties);

        }
        return university;
    }

    @Override
    public List<University> listUniversities() {
        return universityRepository.findAll();
    }

    @Override
    public List<University> findAllUniversitiesWithFaculties() {
        return universityRepository.findAllWithFaculties();
    }

    @Override
    public University findUniversityById(Integer id) {
        return universityRepository.findById(id);
    }

    @Override
    public void modifyUniversity(Integer id, String newName, String newAddress) {
        University university = universityRepository.findById(id);
        if (university != null) {
            university.setName(newName);
            university.setAddress(newAddress);
            universityRepository.update(university);
        } else {
            LOGGER.warn("University with ID {} not found.", id);
        }

    }

    @Override
    public void removeUniversity(Integer id) {
        universityRepository.delete(id);
    }
}
