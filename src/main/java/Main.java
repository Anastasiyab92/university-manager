import com.solvd.universitymanager.domain.core.Department;
import com.solvd.universitymanager.domain.core.Faculty;
import com.solvd.universitymanager.domain.core.University;
import com.solvd.universitymanager.domain.courses.Course;
import com.solvd.universitymanager.domain.courses.Grade;
import com.solvd.universitymanager.service.*;
import com.solvd.universitymanager.service.impl.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        UniversityService universityService = new UniversityServiceImpl();
        University oxfordUniversity = new University();
        oxfordUniversity.setName("University of Oxford");
        oxfordUniversity.setAddress("UK");
        universityService.addUniversity(oxfordUniversity);

        FacultyService facultyService = new FacultyServiceImpl();
        Faculty humanitiesDivisionFaculty = new Faculty();
        humanitiesDivisionFaculty.setName("Humanities Division");
        humanitiesDivisionFaculty.setDepartments(new ArrayList<>());
        facultyService.addFaculty(humanitiesDivisionFaculty, oxfordUniversity.getId());

        Faculty mathematicalInstituteFaculty = new Faculty();
        mathematicalInstituteFaculty.setName("Mathematical Institute");
        mathematicalInstituteFaculty.setDepartments(new ArrayList<>());
        facultyService.addFaculty(mathematicalInstituteFaculty, oxfordUniversity.getId());

        DepartmentService departmentService = new DepartmentServiceImpl();
        Department literatureDepartment = new Department();
        literatureDepartment.setName("English Language and Literature");
        literatureDepartment.setCourses(new ArrayList<>());
        departmentService.addDepartment(literatureDepartment, humanitiesDivisionFaculty.getId());

        Department appliedMathematicsDepartment = new Department();
        appliedMathematicsDepartment.setName("Applied Mathematics");
        appliedMathematicsDepartment.setCourses(new ArrayList<>());
        departmentService.addDepartment(literatureDepartment, mathematicalInstituteFaculty.getId());

        CourseService courseService = new CourseServiceImpl();
        Course englishLiteratureCourse = new Course();
        englishLiteratureCourse.setCode(50);
        englishLiteratureCourse.setName("English Literature");
        englishLiteratureCourse.setGrades(new ArrayList<>());
        courseService.addCourse(englishLiteratureCourse, literatureDepartment.getId());

        Course numericalMethodsCourse = new Course();
        numericalMethodsCourse.setCode(60);
        numericalMethodsCourse.setName("Numerical Methods");
        numericalMethodsCourse.setGrades(new ArrayList<>());
        courseService.addCourse(englishLiteratureCourse, appliedMathematicsDepartment.getId());

        GradeService gradeService = new GradeServiceImpl();
        Grade gradeCourseOxford1 = new Grade();
        gradeCourseOxford1.setGradeValue(85);
        gradeService.addGrade(gradeCourseOxford1);

        Grade gradeCourseOxford2 = new Grade();
        gradeCourseOxford2.setGradeValue(80);
        gradeService.addGrade(gradeCourseOxford2);


        List<University> universityList = universityService.findAllUniversitiesWithFaculties();
        LOGGER.info(universityList);

    }
}