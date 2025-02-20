import com.solvd.universitymanager.domain.core.*;
import com.solvd.universitymanager.domain.courses.Course;
import com.solvd.universitymanager.domain.courses.EnrollmentLogger;
import com.solvd.universitymanager.domain.courses.EnrollmentNotifier;
import com.solvd.universitymanager.domain.courses.Grade;
import com.solvd.universitymanager.domain.people.Person;
import com.solvd.universitymanager.domain.people.Student;
import com.solvd.universitymanager.domain.people.StudentFactory;
import com.solvd.universitymanager.service.UniversityService;
import com.solvd.universitymanager.service.impl.UniversityServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        //Builder and Factory
        Person student1 = StudentFactory.createStudent("Alex", "Bloch", "alexbloch@gmail.com",
                LocalDate.of(2024,9,1), "Literature");

        Person student2 = StudentFactory.createStudent("Donald", "Gates", "donaldgates@gmail.com",
                LocalDate.of(2024,9,1), "Engineering");

        LOGGER.info(student1);
        LOGGER.info(student2);

        Grade gradeCourseOxford1 = new Grade();
        gradeCourseOxford1.setGradeValue(85);

        Grade gradeCourseOxford2 = new Grade();
        gradeCourseOxford2.setGradeValue(80);

        //Abstract factory. UniversityFactory
        HumanDivisionUniversityFactory humanDivision = new HumanDivisionUniversityFactory();

        Course courseEnglishLiterature = humanDivision.createCourse(55,"English Literature", gradeCourseOxford1, new ArrayList<>());
        courseEnglishLiterature.getStudents().add((Student)student1);

        Department departmentEnglish = humanDivision.createDepartment("English Language and Literature", new ArrayList<>());
        departmentEnglish.getCourses().add(courseEnglishLiterature);

        Faculty facultyHumanitiesDivision = humanDivision.createFaculty("Humanities Division", new ArrayList<>());
        facultyHumanitiesDivision.getDepartments().add(departmentEnglish);

        MathematicalInstituteUniversityFactory mathematicalInstitute = new MathematicalInstituteUniversityFactory();
        Course courseNumericalMethods = mathematicalInstitute.createCourse(65,"Numerical Methods",gradeCourseOxford2, new ArrayList<>());
        courseNumericalMethods.getStudents().add((Student)student2);
        Department departmentMathematics = mathematicalInstitute.createDepartment("Applied Mathematics", new ArrayList<>());
        departmentMathematics.getCourses().add(courseNumericalMethods);
        Faculty facultyMathematical = mathematicalInstitute.createFaculty("Mathematical Institute", new ArrayList<>());
        facultyMathematical.getDepartments().add(departmentMathematics);

        //Listener pattern
        EnrollmentNotifier notifier = new EnrollmentNotifier();
        EnrollmentLogger logger = new EnrollmentLogger();
        notifier.addListener(logger);
        courseNumericalMethods.setNotifier(notifier);
        courseEnglishLiterature.setNotifier(notifier);
        courseEnglishLiterature.enrollStudent((Student) student1);
        courseNumericalMethods.enrollStudent((Student)student2);

        UniversityService universityService = new UniversityServiceImpl();
        University oxfordUniversity = new University();
        oxfordUniversity.setName("University of Oxford");
        oxfordUniversity.setAddress("UK");
        oxfordUniversity.setFaculties(new ArrayList<>());
        oxfordUniversity.getFaculties().add(facultyMathematical);
        oxfordUniversity.getFaculties().add(facultyHumanitiesDivision);

        universityService.addUniversity(oxfordUniversity);

//        List<University> universities = universityService.listUniversities();

        List<University> universityList = universityService.findAllUniversitiesWithFaculties();

        LOGGER.info(universityList);
    }
}