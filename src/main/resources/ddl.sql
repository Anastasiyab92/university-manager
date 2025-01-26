DROP SCHEMA IF EXISTS `university.db`;
CREATE SCHEMA IF NOT EXISTS `university.db`;
USE `university.db` ;


CREATE TABLE IF NOT EXISTS `university.db`.`universities` (
  `id` SMALLINT(32) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `address` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE
);


CREATE TABLE IF NOT EXISTS `university.db`.`faculties` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `university_id` SMALLINT UNSIGNED NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_faculty_university_idx` (`university_id` ASC) VISIBLE,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  CONSTRAINT `fk_faculty_university`
    FOREIGN KEY (`university_id`)
    REFERENCES `university.db`.`universities` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE
);


CREATE TABLE IF NOT EXISTS `university.db`.`departments` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `faculty_id` INT UNSIGNED NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_department_faculty1_idx` (`faculty_id` ASC) VISIBLE,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  CONSTRAINT `fk_department_faculty1`
    FOREIGN KEY (`faculty_id`)
    REFERENCES `university.db`.`faculties` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE
);


CREATE TABLE IF NOT EXISTS `university.db`.`courses` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `code` INT UNSIGNED NOT NULL,
  `department_id` INT UNSIGNED NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `code_UNIQUE` (`code` ASC) VISIBLE,
  INDEX `fk_course_department1_idx` (`department_id` ASC) VISIBLE,
  CONSTRAINT `fk_course_department1`
    FOREIGN KEY (`department_id`)
    REFERENCES `university.db`.`departments` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE
);


CREATE TABLE IF NOT EXISTS `university.db`.`persons` (
  `id` BIGINT(32) UNSIGNED NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE
);


CREATE TABLE IF NOT EXISTS `university.db`.`instructors` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `persons_id` BIGINT(32) UNSIGNED NOT NULL,
  `departments_id` INT UNSIGNED NOT NULL,
  `qualification` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_instructors_departments1_idx` (`departments_id` ASC) VISIBLE,
  INDEX `fk_instructors_persons1_idx` (`persons_id` ASC) VISIBLE,
  CONSTRAINT `fk_instructors_persons1`
    FOREIGN KEY (`persons_id`)
    REFERENCES `university.db`.`persons` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_instructors_departments1`
    FOREIGN KEY (`departments_id`)
    REFERENCES `university.db`.`departments` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);


CREATE TABLE IF NOT EXISTS `university.db`.`students` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `yearOfReceipt` DATE NOT NULL,
  `major` VARCHAR(45) NOT NULL,
  `persons_id` BIGINT(32) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_students_persons1_idx` (`persons_id` ASC) VISIBLE,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  CONSTRAINT `fk_students_persons1`
    FOREIGN KEY (`persons_id`)
    REFERENCES `university.db`.`persons` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);


CREATE TABLE IF NOT EXISTS `university.db`.`administrators` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `position` VARCHAR(45) NOT NULL,
  `persons_id` BIGINT(32) UNSIGNED NOT NULL,
  `faculties_id` INT UNSIGNED NOT NULL,
  `qualification` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_administrators_persons1_idx` (`persons_id` ASC) VISIBLE,
  INDEX `fk_administrators_faculties1_idx` (`faculties_id` ASC) VISIBLE,
  CONSTRAINT `fk_administrators_persons1`
    FOREIGN KEY (`persons_id`)
    REFERENCES `university.db`.`persons` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_administrators_faculties1`
    FOREIGN KEY (`faculties_id`)
    REFERENCES `university.db`.`faculties` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);


CREATE TABLE IF NOT EXISTS `university.db`.`grades` (
  `id` BIGINT(32) UNSIGNED NOT NULL AUTO_INCREMENT,
  `value` SMALLINT(32) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE IF NOT EXISTS `university.db`.`schedules` (
  `id` BIGINT(32) UNSIGNED NOT NULL AUTO_INCREMENT,
  `date` DATE NOT NULL,
  `time` TIME NOT NULL,
  `courses_id` INT UNSIGNED NOT NULL,
  `students_id` INT UNSIGNED NOT NULL,
  `instructors_id` INT UNSIGNED NOT NULL,
  `weekday` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`, `students_id`, `instructors_id`),
  INDEX `fk_schedules_courses1_idx` (`courses_id` ASC) VISIBLE,
  INDEX `fk_schedules_students1_idx` (`students_id` ASC) VISIBLE,
  INDEX `fk_schedules_instructors1_idx` (`instructors_id` ASC) VISIBLE,
  CONSTRAINT `fk_schedules_courses1`
    FOREIGN KEY (`courses_id`)
    REFERENCES `university.db`.`courses` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_schedules_students1`
    FOREIGN KEY (`students_id`)
    REFERENCES `university.db`.`students` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_schedules_instructors1`
    FOREIGN KEY (`instructors_id`)
    REFERENCES `university.db`.`instructors` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);


CREATE TABLE IF NOT EXISTS `university.db`.`student_courses` (
  `students_id` INT UNSIGNED NOT NULL,
  `courses_id` INT UNSIGNED NOT NULL,
  INDEX `fk_students_has_courses_courses1_idx` (`courses_id` ASC) VISIBLE,
  INDEX `fk_students_has_courses_students1_idx` (`students_id` ASC) VISIBLE,
  CONSTRAINT `fk_students_has_courses_students1`
    FOREIGN KEY (`students_id`)
    REFERENCES `university.db`.`students` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_students_has_courses_courses1`
    FOREIGN KEY (`courses_id`)
    REFERENCES `university.db`.`courses` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);


CREATE TABLE IF NOT EXISTS `university.db`.`instructors_courses` (
  `instructors_id` INT UNSIGNED NOT NULL,
  `courses_id` INT UNSIGNED NOT NULL,
  INDEX `fk_instructors_has_courses_courses1_idx` (`courses_id` ASC) VISIBLE,
  INDEX `fk_instructors_has_courses_instructors1_idx` (`instructors_id` ASC) VISIBLE,
  CONSTRAINT `fk_instructors_has_courses_instructors1`
    FOREIGN KEY (`instructors_id`)
    REFERENCES `university.db`.`instructors` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_instructors_has_courses_courses1`
    FOREIGN KEY (`courses_id`)
    REFERENCES `university.db`.`courses` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);


CREATE TABLE IF NOT EXISTS `university.db`.`grades_courses` (
  `grades_id` BIGINT(32) UNSIGNED NOT NULL,
  `courses_id` INT UNSIGNED NOT NULL,
  INDEX `fk_grades_has_courses_courses1_idx` (`courses_id` ASC) VISIBLE,
  INDEX `fk_grades_has_courses_grades1_idx` (`grades_id` ASC) VISIBLE,
  CONSTRAINT `fk_grades_has_courses_grades1`
    FOREIGN KEY (`grades_id`)
    REFERENCES `university.db`.`grades` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_grades_has_courses_courses1`
    FOREIGN KEY (`courses_id`)
    REFERENCES `university.db`.`courses` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);
