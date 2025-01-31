package com.solvd.universitymanager.parser;

import com.solvd.universitymanager.domain.core.Department;
import com.solvd.universitymanager.domain.core.Faculty;
import com.solvd.universitymanager.domain.core.University;
import com.solvd.universitymanager.domain.courses.Course;
import com.solvd.universitymanager.domain.courses.Grade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class DomParser {

    private static final Logger LOGGER = LogManager.getLogger(DomParser.class);

    public static void main(String[] args) {
        University university = new University();
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            InputStream inputStream = DomParser.class.getClassLoader().getResourceAsStream("university.xml");
            if(inputStream == null){
                throw new FileNotFoundException("File can't be found.");
            }

            Document document = builder.parse(inputStream);
            document.getDocumentElement().normalize();

            Element root = document.getDocumentElement();
            LOGGER.info("Root element: {}", root.getNodeName());

            String nameUniversity = root.getElementsByTagName("name").item(0).getTextContent();
            String address = root.getElementsByTagName("address").item(0).getTextContent();
            LOGGER.info("Name of university: {}. Address: {}", nameUniversity, address);
            university.setName(nameUniversity);
            university.setAddress(address);
            university.setFaculties(parseFaculties(root));
            LOGGER.info("University data: {}", university);
        }catch (Exception e){
            LOGGER.error(e);
        }
    }

    private static List<Faculty> parseFaculties(Element parent){
        List<Faculty> faculties = new ArrayList<>();
        NodeList nodeList = parent.getElementsByTagName("faculty");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element facultyElement = (Element) nodeList.item(i);
            Faculty faculty = new Faculty();
            faculty.setName(getTagValue(facultyElement, "name"));
            faculty.setDepartments(parseDepartments(facultyElement));
            faculties.add(faculty);
        }
        return faculties;
    }

    private static List<Department> parseDepartments(Element parent){
        List<Department> departments = new ArrayList<>();
        NodeList nodeList = parent.getElementsByTagName("department");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element departmentElement = (Element) nodeList.item(i);
            Department department = new Department();
            department.setName(getTagValue(departmentElement, "name"));
            department.setCourses(parseCourses(departmentElement));
            departments.add(department);
        }
        return departments;
    }

    private static List<Course> parseCourses(Element parent){
        List<Course> courses = new ArrayList<>();
        NodeList nodeList = parent.getElementsByTagName("course");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element courseElement = (Element) nodeList.item(i);
            Course course = new Course();
            course.setCode(Integer.valueOf(getTagValue(courseElement, "code")));
            course.setName(getTagValue(courseElement, "name"));
            course.setGrade(parseGrade(courseElement));
            courses.add(course);
        }
        return courses;
    }

    private static Grade parseGrade(Element parent){
        Grade grade = new Grade();
        NodeList nodeList = parent.getElementsByTagName("grade");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element gradeElement = (Element) nodeList.item(i);
            grade.setGradeValue(Integer.valueOf(getTagValue(gradeElement, "gradeValue")));
        }
        return grade;
    }

    private static String getTagValue(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        return (nodeList.getLength() > 0) ? nodeList.item(0).getTextContent() : "No data";
    }
}
