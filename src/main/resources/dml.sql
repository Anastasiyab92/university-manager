INSERT INTO `university.db`.`universities` (`name`, `address`) VALUES
('Harvard University', 'Cambridge, MA');


INSERT INTO `university.db`.`faculties` (`name`, `university_id`) VALUES
('Engineering', 1),
('Arts and Humanities', 1),
('Science', 1),
('Business', 1),
('Law', 1);


INSERT INTO `university.db`.`departments` (`name`, `faculty_id`) VALUES
('Computer Science', 1),
('Mechanical Engineering', 1),
('Literature', 2),
('Physics', 3),
('Economics', 4),
('Civil Law',5);

INSERT INTO `university.db`.`grades` (`value`) VALUES
(85), (90), (95), (88), (92);


INSERT INTO `university.db`.`courses` (`name`, `code`, `department_id`, `grade_id`) VALUES
('Data Structures', 101, 1, 1),
('Thermodynamics', 102, 2, 2),
('Shakespeare Studies', 201, 3, 3),
('Quantum Mechanics', 301, 4, 4),
('Microeconomics', 401, 5, 5);


INSERT INTO `university.db`.`students` (`firstname`, `lastname`, `email`, `yearOfReceipt`, `major`) VALUES
('Fiona', 'Clark', 'fiona.clark@example.com', '2020-09-01', 'Computer Science'),
('George', 'Harris', 'george.harris@example.com', '2021-09-01', 'Engineering'),
('Hannah', 'Lee', 'hannah.lee@example.com', '2023-09-01', 'Literature'),
('Ian', 'White', 'ian.white@example.com', '2022-09-01', 'Physics'),
('Jane', 'Adams', 'jane.adams@example.com', '2020-09-01', 'Economics'),
('Anna', 'Wilson', 'anna.wilson@example.com', '2020-09-01', 'Computer Science'),
('Brian', 'Moore', 'brian.moore@example.com', '2020-09-01', 'Computer Science'),
('Clara', 'Johnson', 'clara.johnson@example.com', '2020-09-01', 'Computer Science'),
('David', 'Roberts', 'david.roberts@example.com', '2021-09-01', 'Engineering'),
('Emma', 'Evans', 'emma.evans@example.com', '2021-09-01', 'Engineering'),
('Frank', 'Thompson', 'frank.thompson@example.com', '2021-09-01', 'Engineering'),
('Grace', 'Walker', 'grace.walker@example.com', '2023-09-01', 'Literature'),
('Henry', 'Hall', 'henry.hall@example.com', '2023-09-01', 'Literature'),
('Isla', 'Allen', 'isla.allen@example.com', '2023-09-01', 'Literature'),
('Jack', 'Young', 'jack.young@example.com', '2022-09-01', 'Physics'),
('Katie', 'Harris', 'katie.harris@example.com', '2022-09-01', 'Physics'),
('Leo', 'Martin', 'leo.martin@example.com', '2022-09-01', 'Physics'),
('Mia', 'Wright', 'mia.wright@example.com', '2020-09-01', 'Economics'),
('Noah', 'King', 'noah.king@example.com', '2020-09-01', 'Economics'),
('Olivia', 'Baker', 'olivia.baker@example.com', '2020-09-01', 'Economics'),
('Paul', 'Carter', 'paul.carter@example.com', '2019-09-01', 'Computer Science'),
('Freya', 'Long', 'freya.long@example.com', '2021-09-01', 'Engineering'),
('Ethan', 'Cruz', 'ethan.cruz@example.com', '2023-09-01', 'Literature'),
('Daisy', 'Myers', 'daisy.myers@example.com', '2022-09-01', 'Physics'),
('Sam', 'Stewart', 'sam.stewart@example.com', '2020-09-01', 'Economics'),
('Quinn', 'Mitchell', 'quinn.mitchell@example.com', '2019-09-01', 'Computer Science'),
('Ruby', 'Parker', 'ruby.parker@example.com', '2019-09-01', 'Computer Science'),
('Tina', 'Hughes', 'tina.hughes@example.com', '2019-09-01', 'Computer Science'),
('Cody', 'Hill', 'cody.hill@example.com', '2021-09-01', 'Engineering'),
('Bella', 'Sanders', 'bella.sanders@example.com', '2021-09-01', 'Engineering'),
('Aaron', 'Clark', 'aaron.clark@example.com', '2021-09-01', 'Engineering'),
('Sophia', 'James', 'sophia.james@example.com', '2023-09-01', 'Literature'),
('Liam', 'Ross', 'liam.ross@example.com', '2023-09-01', 'Literature'),
('Eve', 'Blake', 'eve.blake@example.com', '2023-09-01', 'Literature'),
('Adam', 'Dunn', 'adam.dunn@example.com', '2022-09-01', 'Physics'),
('Zoe', 'Bell', 'zoe.bell@example.com', '2022-09-01', 'Physics'),
('Yara', 'Gray', 'yara.gray@example.com', '2022-09-01', 'Physics'),
('Xavier', 'Morgan', 'xavier.morgan@example.com', '2020-09-01', 'Economics'),
('Wendy', 'Foster', 'wendy.foster@example.com', '2020-09-01', 'Economics'),
('Victor', 'Green', 'victor.green@example.com', '2020-09-01', 'Economics');



INSERT INTO `university.db`.`instructors` (`firstname`, `lastname`, `email`, `departments_id`, `qualification`) VALUES
('Victor', 'Green', 'victor.green@example.com', 1, 'PhD'),
('Wendy', 'Foster', 'wendy.foster@example.com', 2, 'MSc'),
('Xavier', 'Morgan', 'xavier.morgan@example.com', 3, 'PhD'),
('Yara', 'Gray', 'yara.gray@example.com', 4, 'MSc'),
('Zoe', 'Bell', 'zoe.bell@example.com', 5, 'PhD'),
('Adam', 'Dunn', 'adam.dunn@example.com', 1, 'PhD'),
('Eve', 'Blake', 'eve.blake@example.com', 2, 'PhD'),
('Liam', 'Ross', 'liam.ross@example.com', 3, 'MSc'),
('Sophia', 'James', 'sophia.james@example.com', 4, 'PhD'),
('Aaron', 'Clark', 'aaron.clark@example.com', 5, 'PhD');


INSERT INTO `university.db`.`administrators` (`firstname`, `lastname`, `email`, `position`, `faculties_id`, `qualification`) VALUES
('Bella', 'Sanders', 'bella.sanders@example.com', 'Vice Dean', 1, 'PhD'),
('Cody', 'Hill', 'cody.hill@example.com', 'Dean', 2, 'MSc'),
('Daisy', 'Myers', 'daisy.myers@example.com', 'Dean', 3, 'MBA'),
('Ethan', 'Cruz', 'ethan.cruz@example.com', 'Dean', 4, 'PhD'),
('Freya', 'Long', 'freya.long@example.com', 'Dean', 5, 'MSc');


INSERT INTO `university.db`.`schedules` (`date`, `time`, `course_id`, `students_id`, `instructors_id`, `weekday`) VALUES
('2023-01-10', '10:00:00', 1, 1, 1, 'Monday'),
('2023-01-11', '11:00:00', 2, 2, 2, 'Tuesday'),
('2023-01-12', '12:00:00', 3, 3, 3, 'Wednesday'),
('2023-01-13', '13:00:00', 4, 4, 4, 'Thursday'),
('2023-01-14', '14:00:00', 5, 5, 5, 'Friday');


INSERT INTO `university.db`.`student_courses` (`students_id`, `courses_id`) VALUES
(1, 1), (2, 2), (3, 3), (4, 4), (5, 5),
(6, 1), (7, 1), (8, 1), (9, 2), (10, 2),
(11, 2), (12, 3), (13, 3), (14, 3), (15, 4),
(16, 4), (17, 4), (18, 4), (19, 5), (20, 4),
(21,1), (22, 2), (23, 3), (24, 4), (25, 5),
(26, 1), (27, 1), (28, 1), (29, 2), (30, 2),
(31, 2), (32, 3), (33, 3), (34, 3), (35, 4),
(36, 4), (37, 4), (38, 4), (39, 5), (40, 4);

INSERT INTO `university.db`.`instructors_courses` (`instructors_id`, `courses_id`) VALUES
(1, 1), (2, 2), (3, 3), (4, 4), (5, 5),
(6, 1), (7, 2), (8, 3), (9, 4), (10, 5);