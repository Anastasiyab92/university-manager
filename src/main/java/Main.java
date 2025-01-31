import com.solvd.universitymanager.domain.core.Department;
import com.solvd.universitymanager.domain.core.Faculty;
import com.solvd.universitymanager.domain.core.University;
import com.solvd.universitymanager.domain.courses.Course;
import com.solvd.universitymanager.domain.courses.Grade;
import com.solvd.universitymanager.service.UniversityService;
import com.solvd.universitymanager.service.impl.UniversityServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        Grade gradeCourseOxford1 = new Grade();
        gradeCourseOxford1.setGradeValue(85);

        Grade gradeCourseOxford2 = new Grade();
        gradeCourseOxford2.setGradeValue(80);

        Course englishLiteratureCourse = new Course();
        englishLiteratureCourse.setCode(50);
        englishLiteratureCourse.setName("English Literature");
        englishLiteratureCourse.setGrade(gradeCourseOxford1);

        Course numericalMethodsCourse = new Course();
        numericalMethodsCourse.setCode(60);
        numericalMethodsCourse.setName("Numerical Methods");
        numericalMethodsCourse.setGrade(gradeCourseOxford2);

        Department literatureDepartment = new Department();
        literatureDepartment.setName("English Language and Literature");
        literatureDepartment.setCourses(new ArrayList<>());
        literatureDepartment.getCourses().add(englishLiteratureCourse);

        Department appliedMathematicsDepartment = new Department();
        appliedMathematicsDepartment.setName("Applied Mathematics");
        appliedMathematicsDepartment.setCourses(new ArrayList<>());
        appliedMathematicsDepartment.getCourses().add(numericalMethodsCourse);

        Faculty humanitiesDivisionFaculty = new Faculty();
        humanitiesDivisionFaculty.setName("Humanities Division");
        humanitiesDivisionFaculty.setDepartments(new ArrayList<>());
        humanitiesDivisionFaculty.getDepartments().add(literatureDepartment);

        Faculty mathematicalInstituteFaculty = new Faculty();
        mathematicalInstituteFaculty.setName("Mathematical Institute");
        mathematicalInstituteFaculty.setDepartments(new ArrayList<>());
        mathematicalInstituteFaculty.getDepartments().add(appliedMathematicsDepartment);

        UniversityService universityService = new UniversityServiceImpl();
        University oxfordUniversity = new University();
        oxfordUniversity.setName("University of Oxford");
        oxfordUniversity.setAddress("UK");
        oxfordUniversity.setFaculties(new ArrayList<>());
        oxfordUniversity.getFaculties().add(humanitiesDivisionFaculty);
        oxfordUniversity.getFaculties().add(mathematicalInstituteFaculty);

        oxfordUniversity = universityService.addUniversity(oxfordUniversity);

        List<University> universityList = universityService.findAllUniversitiesWithFaculties();

        LOGGER.info(universityList);
    }
}