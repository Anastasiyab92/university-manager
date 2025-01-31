-- Delete/Update statements
SET SQL_SAFE_UPDATES = 0;

-- Delete student from course. When student was sent down.
DELETE FROM student_courses
WHERE students_id = 9 AND courses_id = 2;

-- Delete instructor from course.
DELETE FROM instructors_courses
WHERE instructors_id = 3;

-- Delete instructor from list of instructors
DELETE FROM instructors
WHERE id = 3;

-- Delete student from list of students
DELETE FROM students
WHERE id = 35;

-- Delete students who finished studies.
DELETE FROM students
WHERE YEAR(`yearOfReceipt`) = 2019;

-- Delete student from university
DELETE FROM students
WHERE id = 1;

-- Delete course in instructors_course

DELETE FROM instructors_courses
WHERE courses_id =3;

-- Delete course
DELETE FROM courses WHERE id = 3;

-- Delete administrator from faculty
DELETE FROM administrators
WHERE id = 5;

-- Delete course from schedule
DELETE FROM schedules
WHERE course_id = 3;

-- Updated student's information
UPDATE students SET lastname = 'Tramp', email = 'alice.tramp@example.com'
WHERE email = 'alice.johnson@example.com';

-- Updated qualification of instructor
UPDATE instructors SET qualification = 'PhD'
WHERE id = 2;

-- Update administrator's position
UPDATE administrators SET position = 'Dean'
WHERE id = 1;

-- Change schedule
UPDATE schedules SET time = '12:30:00'
WHERE id = 2;

-- Change code of course
UPDATE courses SET code = 111
WHERE name = 'Data Structures';

-- Updated value
UPDATE grades SET value = 80
WHERE id = 4;

-- Update courses grades
UPDATE grades SET value = 81
WHERE id = 2;

UPDATE grades SET value = 87
WHERE id = 5;

-- Rename column
ALTER TABLE students
RENAME COLUMN yearOfReceipt to `year_receipt`;

-- Added column in table students
ALTER TABLE students
ADD COLUMN `study_year` ENUM( '1','2','3','4','5','graduate');

-- Auto added value in column study_year
UPDATE students
SET study_year = CASE
    WHEN YEAR(CURDATE()) - YEAR(`year_receipt`) = 0 THEN '1'
    WHEN YEAR(CURDATE()) - YEAR(`year_receipt`) = 1 THEN '2'
    WHEN YEAR(CURDATE()) - YEAR(`year_receipt`) = 2 THEN '3'
    WHEN YEAR(CURDATE()) - YEAR(`year_receipt`) = 3 THEN '4'
    WHEN YEAR(CURDATE()) - YEAR(`year_receipt`) = 4 THEN '5'
    ELSE 'graduate'
END;

-- Added column in table
ALTER TABLE `students`
ADD COLUMN `university_id` SMALLINT UNSIGNED;

-- Added id of university where student's studying.
UPDATE students SET university_id = 1;

-- Added fk for contact with university.
ALTER TABLE students
ADD CONSTRAINT fk_students_universities
FOREIGN KEY (university_id) REFERENCES universities(id);

-- Added column grade_course
ALTER TABLE student_courses
ADD COLUMN grade_course ENUM( '1','2','3','4','5', 'pass', 'fail') NULL;

-- added student grades
UPDATE student_courses
SET grade_course = CASE
    WHEN students_id = 2 AND courses_id = 2 THEN '5'
    WHEN students_id = 3 AND courses_id = 3 THEN '5'
    WHEN students_id = 4 AND courses_id = 4 THEN '5'
    WHEN students_id = 9 AND courses_id = 2 THEN '5'
    WHEN students_id = 12 AND courses_id = 3 THEN '5'
    WHEN students_id = 15 AND courses_id = 4 THEN '5'
    WHEN students_id = 31 AND courses_id = 4 THEN '5'
    WHEN students_id = 32 AND courses_id = 4 THEN '5'
    ELSE grade_course
END
WHERE students_id IN (2, 3, 4, 9, 12, 15, 31, 32);

UPDATE student_courses
SET grade_course = CASE
    WHEN students_id = 10 AND courses_id = 2 THEN '4'
    WHEN students_id = 11 AND courses_id = 2 THEN '4'
    WHEN students_id = 13 AND courses_id = 3 THEN '4'
    WHEN students_id = 14 AND courses_id = 3 THEN '4'
    WHEN students_id = 16 AND courses_id = 4 THEN '4'
    WHEN students_id = 23 AND courses_id = 4 THEN '4'
    WHEN students_id = 24 AND courses_id = 2 THEN '4'
    WHEN students_id = 30 AND courses_id = 4 THEN '4'
    ELSE grade_course
END
WHERE students_id IN (10,11,13,14,16,23,24,30);

UPDATE student_courses
SET grade_course = CASE
    WHEN students_id = 17 AND courses_id = 4 THEN '3'
    WHEN students_id = 21 AND courses_id = 2 THEN '3'
    WHEN students_id = 25 AND courses_id = 2 THEN '3'
    WHEN students_id = 26 AND courses_id = 2 THEN '3'
    ELSE grade_course
END
WHERE students_id IN (17,21,25,26);

-- out all active student who has grade_course 5
SELECT
s.id AS student_id,
s.lastname AS student_name,
s.major AS student_major,
s.study_year AS study_year,
u.name AS university_name,
f.name AS faculty_name,
d.name AS department_name,
c.name AS course_name,
sc.grade_course AS grade_course

FROM universities u
LEFT JOIN faculties f ON u.id = f.university_id
LEFT JOIN departments d ON f.id = d.faculty_id
LEFT JOIN courses c ON d.id = c.department_id
LEFT JOIN student_courses sc ON c.id = sc.courses_id
LEFT JOIN students s ON sc.students_id = s.id

WHERE u.name = 'Harvard University' AND sc.grade_course = 5.0
ORDER BY s.id;

-- A list of students who study as an economist and entered in 2020
SELECT
s.id AS student_id,
s.firstname AS firstname,
s.lastname AS lastname,
s.major AS major,
s.year_receipt AS year_receipt
FROM students s
WHERE s.major = 'Economics' AND s.year_receipt = '2020-09-01'
ORDER BY s.lastname;

-- List of instructors in university
SELECT
i.firstname AS firstname,
i.lastname AS lastname,
i.qualification AS qualification
FROM instructors i;

-- List of students who study in university
SELECT
s.id AS student_id,
s.firstname AS firstname,
s.lastname AS lastname,
s.major AS major,
s.year_receipt AS year_receipt
FROM students s
WHERE NOT s.study_year = 'graduate';

-- returns all records from both faculties and departments, whether there is a match or not
SELECT
    f.id AS faculty_id,
    f.name AS faculty_name,
    d.id AS department_id,
    d.name AS department_name
FROM faculties f
LEFT JOIN departments d ON f.id = d.faculty_id
UNION
SELECT
    f.id AS faculty_id,
    f.name AS faculty_name,
    d.id AS department_id,
    d.name AS department_name
FROM departments d
RIGHT JOIN faculties f ON d.faculty_id = f.id;

-- count of students who study on the 5 course.
SELECT COUNT(*) AS number_students
FROM students
WHERE study_year = 5
ORDER BY study_year;

-- out of student of each year
SELECT
    s.year_receipt AS year_receipt,
    COUNT(s.id) AS student_count
FROM students s
GROUP BY s.year_receipt;

-- Average grade for the course that is higher 3.5
SELECT
    c.name AS course_name,
    ROUND((AVG(sc.grade_course)),2) AS average_grade
FROM courses c
INNER JOIN student_courses sc ON c.id = sc.courses_id
GROUP BY c.name
HAVING average_grade > 3.5;

-- number of students per major
SELECT
    s.major AS student_major,
    COUNT(s.id) AS student_count
FROM students s
GROUP BY s.major;

-- Performance of university
SELECT
u.name AS university_name,
ROUND((AVG(sc.grade_course)),2) AS university_performance
FROM universities u
LEFT JOIN faculties f ON u.id = f.university_id
LEFT JOIN departments d ON f.id = d.faculty_id
LEFT JOIN courses c ON d.id = c.department_id
LEFT JOIN student_courses sc ON c.id = sc.courses_id
GROUP BY u.name;

SET SQL_SAFE_UPDATES = 1;