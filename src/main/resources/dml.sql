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


INSERT INTO `university.db`.`courses` (`name`, `code`, `department_id`) VALUES
('Data Structures', 101, 1),
('Thermodynamics', 102, 2),
('Shakespeare Studies', 201, 3),
('Quantum Mechanics', 301, 4),
('Microeconomics', 401, 5);


INSERT INTO `university.db`.`persons` (`firstname`, `lastname`, `email`) VALUES
('Alice', 'Johnson', 'alice.johnson@example.com'),
('Bob', 'Smith', 'bob.smith@example.com'),
('Charlie', 'Brown', 'charlie.brown@example.com'),
('Diana', 'Prince', 'diana.prince@example.com'),
('Evan', 'Davis', 'evan.davis@example.com'),
('Fiona', 'Clark', 'fiona.clark@example.com'),
('George', 'Harris', 'george.harris@example.com'),
('Hannah', 'Lee', 'hannah.lee@example.com'),
('Ian', 'White', 'ian.white@example.com'),
('Jane', 'Adams', 'jane.adams@example.com'),
('Kevin', 'Scott', 'kevin.scott@example.com'),
('Laura', 'Mitchell', 'laura.mitchell@example.com'),
('Michael', 'Brown', 'michael.brown@example.com'),
('Nina', 'Taylor', 'nina.taylor@example.com'),
('Oliver', 'King', 'oliver.king@example.com'),
('Anna', 'Wilson', 'anna.wilson@example.com'),
('Brian', 'Moore', 'brian.moore@example.com'),
('Clara', 'Johnson', 'clara.johnson@example.com'),
('David', 'Roberts', 'david.roberts@example.com'),
('Emma', 'Evans', 'emma.evans@example.com'),
('Frank', 'Thompson', 'frank.thompson@example.com'),
('Grace', 'Walker', 'grace.walker@example.com'),
('Henry', 'Hall', 'henry.hall@example.com'),
('Isla', 'Allen', 'isla.allen@example.com'),
('Jack', 'Young', 'jack.young@example.com'),
('Katie', 'Harris', 'katie.harris@example.com'),
('Leo', 'Martin', 'leo.martin@example.com'),
('Mia', 'Wright', 'mia.wright@example.com'),
('Noah', 'King', 'noah.king@example.com'),
('Olivia', 'Baker', 'olivia.baker@example.com'),
('Paul', 'Carter', 'paul.carter@example.com'),
('Quinn', 'Mitchell', 'quinn.mitchell@example.com'),
('Ruby', 'Parker', 'ruby.parker@example.com'),
('Sam', 'Stewart', 'sam.stewart@example.com'),
('Tina', 'Hughes', 'tina.hughes@example.com'),
('Victor', 'Green', 'victor.green@example.com'),
('Wendy', 'Foster', 'wendy.foster@example.com'),
('Xavier', 'Morgan', 'xavier.morgan@example.com'),
('Yara', 'Gray', 'yara.gray@example.com'),
('Zoe', 'Bell', 'zoe.bell@example.com'),
('Adam', 'Dunn', 'adam.dunn@example.com'),
('Eve', 'Blake', 'eve.blake@example.com'),
('Liam', 'Ross', 'liam.ross@example.com'),
('Sophia', 'James', 'sophia.james@example.com'),
('Aaron', 'Clark', 'aaron.clark@example.com'),
('Bella', 'Sanders', 'bella.sanders@example.com'),
('Cody', 'Hill', 'cody.hill@example.com'),
('Daisy', 'Myers', 'daisy.myers@example.com'),
('Ethan', 'Cruz', 'ethan.cruz@example.com'),
('Freya', 'Long', 'freya.long@example.com');


INSERT INTO `university.db`.`students` (`yearOfReceipt`, `major`, `persons_id`) VALUES
('2020-09-01', 'Computer Science', 6),
('2021-09-01', 'Engineering', 7),
('2023-09-01', 'Literature', 8),
('2022-09-01', 'Physics', 9),
('2020-09-01', 'Economics', 10),
('2020-09-01', 'Computer Science', 16),
('2020-09-01', 'Computer Science', 17),
('2020-09-01', 'Computer Science', 18),
('2021-09-01', 'Engineering', 19),
('2021-09-01', 'Engineering', 20),
('2021-09-01', 'Engineering', 21),
('2023-09-01', 'Literature', 22),
('2023-09-01', 'Literature', 23),
('2023-09-01', 'Literature', 24),
('2022-09-01', 'Physics', 25),
('2022-09-01', 'Physics', 26),
('2022-09-01', 'Physics', 27),
('2020-09-01', 'Economics', 28),
('2020-09-01', 'Economics', 29),
('2020-09-01', 'Economics', 30),
('2019-09-01', 'Computer Science', 31),
('2021-09-01', 'Engineering', 50),
('2023-09-01', 'Literature', 49),
('2022-09-01', 'Physics', 48),
('2020-09-01', 'Economics', 35),
('2019-09-01', 'Computer Science', 32),
('2019-09-01', 'Computer Science', 33),
('2019-09-01', 'Computer Science', 34),
('2021-09-01', 'Engineering', 47),
('2021-09-01', 'Engineering', 46),
('2021-09-01', 'Engineering', 45),
('2023-09-01', 'Literature', 44),
('2023-09-01', 'Literature', 43),
('2023-09-01', 'Literature', 42),
('2022-09-01', 'Physics', 41),
('2022-09-01', 'Physics', 40),
('2022-09-01', 'Physics', 39),
('2020-09-01', 'Economics', 36),
('2020-09-01', 'Economics', 37),
('2020-09-01', 'Economics', 38);



INSERT INTO `university.db`.`instructors` (`persons_id`, `departments_id`, `qualification`) VALUES
(1, 1, 'PhD'),
(2, 2, 'MSc'),
(3, 3, 'PhD'),
(4, 4, 'MSc'),
(5, 5, 'PhD'),
(31, 1, 'PhD'),
(32, 2, 'PhD'),
(33, 3, 'MSc'),
(34, 4, 'PhD'),
(35, 5, 'PhD');


INSERT INTO `university.db`.`administrators` (`position`, `persons_id`, `faculties_id`, `qualification`) VALUES
('Vice Dean', 11, 1, 'PhD'),
('Dean', 12, 2, 'MSc'),
('Dean', 13, 3, 'MBA'),
('Dean', 14, 4, 'PhD'),
('Dean', 15, 5, 'MSc');


INSERT INTO `university.db`.`grades` (`value`) VALUES
(85), (90), (95), (88), (92);


INSERT INTO `university.db`.`grades_courses` (`grades_id`, `courses_id`) VALUES
(1, 1), (2, 2), (3, 3), (4, 4), (5, 5);


INSERT INTO `university.db`.`schedules` (`date`, `time`, `courses_id`, `students_id`, `instructors_id`, `weekday`) VALUES
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