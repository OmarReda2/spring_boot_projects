-- ------------------------- <1.create user> ------------------------- 
-- CREATE USER 'resumeapp'@'localhost' IDENTIFIED BY 'resumeapp';

-- GRANT ALL PRIVILEGES ON * . * TO 'resumeapp'@'localhost';

-- #
-- # Starting with MySQL 8.0.4, the MySQL team changed the 
-- # default authentication plugin for MySQL server 
-- # from mysql_native_password to caching_sha2_password.
-- #
-- # The command below will make the appropriate updates for your user account.
-- #
-- # See the MySQL Reference Manual for details: 
-- # https://dev.mysql.com/doc/refman/8.0/en/caching-sha2-pluggable-authentication.html
-- #
-- ALTER USER 'resumeapp'@'localhost' IDENTIFIED WITH mysql_native_password BY 'resumeapp';
-- ------------------------- </create user> ------------------------- 




-- ------------------------- <2.Create Schema resume-app> -------------------------
DROP SCHEMA IF EXISTS `resume-app`;
CREATE SCHEMA `resume-app`;
-- ------------------------- </Create Schema resume-app> -------------------------




-- ------------------------- <3.Create Tables> -------------------------
-- Prep work
USE `resume-app`;
SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `course`;
DROP TABLE IF EXISTS `education`;
DROP TABLE IF EXISTS `link`;
SET FOREIGN_KEY_CHECKS=1;


-- Table structure for table `user`
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `intro` text DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- Table structure for table `course`
CREATE TABLE `course` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `K_course_user_id` (`user_id`),
  CONSTRAINT `FK_course_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- Table structure for table `eduction`
CREATE TABLE `education` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  `gpa` decimal(19,2) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `K_eduction_user_id` (`user_id`),
  CONSTRAINT `FK_eduction_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- Table structure for table `link`
CREATE TABLE `link` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `K_link_user_id` (`user_id`),
  CONSTRAINT `FK_link_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



-- insert some data to test
INSERT INTO user (first_name, last_name, country, city, image_url,age, intro)
VALUES ('Omar', 'Reda Elsayed', 'Egypt', 'Cairo', 'assets/images/user1.jpg', 24 ,
'A motivated junior software developer with a passion for creating efficient code and a good understanding of clean code and 
OOP concepts. I am interested in data analysis, AI, machine & deep learning, and web Development. Eager to enhance my 
skills and tackle real-world challenges.');

INSERT INTO user (first_name, last_name, country, city, image_url,age, intro)
VALUES ('Khaled', 'Reda Elsayed', 'Egypt', 'Cairo', 'assets/images/user1.jpg', 17 ,'...');


INSERT INTO course (name, description, location, start_date, end_date, user_id)
VALUES ('Problem Solving Training', 
'Covering techniques for attacking and solving challenging computational problems. Fundamental 
algorithmic solving techniques covered include complete search, divide/reduce/transform conquer, 
greedy and mathematics.', 
'COACH ACADEMY',
('2022-11-1'),
('2023-5-1'),
1);

INSERT INTO course (name, description, location, start_date, end_date, user_id)
VALUES ('Data Science Internship', 
'Working on real-life projects and applies Different ML and analysis techniques.', 
'TECHNOCOLABS',
('2023-7-1'),
('2023-5-1'),
1);


INSERT INTO education (name, grade, gpa, location, start_date, end_date, user_id)
VALUES ('Computer Science and Artificial intelligence - Medical Informatics Department', 
'very good with honor',
'3.2', 
'Helwan University',
('2019-10-1'),
('2023-6-1'),
1);
INSERT INTO education (name, grade, gpa, location, start_date, end_date, user_id)
VALUES ('Computer Science and Artificial intelligence - Medical Informatics Department', 
'very good with honor',
'3.2', 
'Helwan University',
('2019-10-1'),
('2023-6-1'),
1);

INSERT INTO link(name, url, user_id)
VALUES ('LinkedIn',
'https://www.linkedIn.user1.com',
1);

INSERT INTO link(name, url, user_id)
VALUES ('github',
'https://www.github.user1.com',
1);

INSERT INTO link(name, url, user_id)
VALUES ('gmail',
'omarreda@gmail.com',
1);

INSERT INTO link(name, url, user_id)
VALUES ('phone number',
'+201027563659',
1);

