package com.solvd.universitymanager.persistence;

import com.solvd.universitymanager.domain.core.Faculty;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FacultyRepository {

    void create(@Param("faculty") Faculty faculty, @Param("universityId") Integer universityId);

    Faculty findById(Integer id);

    List<Faculty> findAll();

    List<Faculty> findAllWithDepartments();

    void update(Faculty faculty);

    void delete(Integer id);

}
