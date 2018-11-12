-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: examenes
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE TESTS;
USE TESTS;
--
-- Table structure for table `answers`
--

DROP TABLE IF EXISTS `answers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `answers` (
  `IDANSWER` int(11) NOT NULL,
  `ANSWER` text NOT NULL,
  `EVALUATION` float NOT NULL,
  `Questions_IDQUESTION` int(11) NOT NULL,
  `Answers_Sheet_IDANSWERS_SHEET` int(11) NOT NULL,
  PRIMARY KEY (`IDANSWER`),
  KEY `fk_Answers_Questions1_idx` (`Questions_IDQUESTION`),
  KEY `fk_Answers_Answers_Sheet1_idx` (`Answers_Sheet_IDANSWERS_SHEET`),
  CONSTRAINT `fk_Answers_Answers_Sheet1` FOREIGN KEY (`Answers_Sheet_IDANSWERS_SHEET`) REFERENCES `answers_sheet` (`idanswers_sheet`),
  CONSTRAINT `fk_Answers_Questions1` FOREIGN KEY (`Questions_IDQUESTION`) REFERENCES `questions` (`idquestion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answers`
--

LOCK TABLES `answers` WRITE;
/*!40000 ALTER TABLE `answers` DISABLE KEYS */;
/*!40000 ALTER TABLE `answers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `answers_sheet`
--

DROP TABLE IF EXISTS `answers_sheet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `answers_sheet` (
  `IDANSWERS_SHEET` int(11) NOT NULL,
  `START_DATE` datetime NOT NULL,
  `END_DATE` datetime NOT NULL,
  `EVALUATION` float NOT NULL,
  `Students_IDSTUDENT` char(9) NOT NULL,
  `Test_IDTEST` int(11) NOT NULL,
  PRIMARY KEY (`IDANSWERS_SHEET`),
  KEY `fk_Answers_Sheet_Students1_idx` (`Students_IDSTUDENT`),
  KEY `fk_Answers_Sheet_Test1_idx` (`Test_IDTEST`),
  CONSTRAINT `fk_Answers_Sheet_Students1` FOREIGN KEY (`Students_IDSTUDENT`) REFERENCES `students` (`idstudent`),
  CONSTRAINT `fk_Answers_Sheet_Test1` FOREIGN KEY (`Test_IDTEST`) REFERENCES `test` (`idtest`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answers_sheet`
--

LOCK TABLES `answers_sheet` WRITE;
/*!40000 ALTER TABLE `answers_sheet` DISABLE KEYS */;
/*!40000 ALTER TABLE `answers_sheet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groups`
--

DROP TABLE IF EXISTS `groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `groups` (
  `IDGROUP` char(5) NOT NULL,
  `Subjects_IDSUBJECTS` varchar(5) NOT NULL,
  `Teachers_IDTEACHER` int(11) NOT NULL,
  PRIMARY KEY (`IDGROUP`),
  KEY `fk_Groups_Subjects1_idx` (`Subjects_IDSUBJECTS`),
  KEY `fk_Groups_Teachers1_idx` (`Teachers_IDTEACHER`),
  CONSTRAINT `fk_Groups_Subjects1` FOREIGN KEY (`Subjects_IDSUBJECTS`) REFERENCES `subjects` (`idsubjects`),
  CONSTRAINT `fk_Groups_Teachers1` FOREIGN KEY (`Teachers_IDTEACHER`) REFERENCES `teachers` (`idteacher`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups`
--

LOCK TABLES `groups` WRITE;
/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
/*!40000 ALTER TABLE `groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groups_has_students`
--

DROP TABLE IF EXISTS `groups_has_students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `groups_has_students` (
  `Groups_IDGROUP` char(5) NOT NULL,
  `Students_IDSTUDENT` char(9) NOT NULL,
  PRIMARY KEY (`Groups_IDGROUP`,`Students_IDSTUDENT`),
  KEY `fk_Groups_has_Students_Students1_idx` (`Students_IDSTUDENT`),
  KEY `fk_Groups_has_Students_Groups1_idx` (`Groups_IDGROUP`),
  CONSTRAINT `fk_Groups_has_Students_Groups1` FOREIGN KEY (`Groups_IDGROUP`) REFERENCES `groups` (`idgroup`),
  CONSTRAINT `fk_Groups_has_Students_Students1` FOREIGN KEY (`Students_IDSTUDENT`) REFERENCES `students` (`idstudent`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups_has_students`
--

LOCK TABLES `groups_has_students` WRITE;
/*!40000 ALTER TABLE `groups_has_students` DISABLE KEYS */;
/*!40000 ALTER TABLE `groups_has_students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `questions` (
  `IDQUESTION` int(11) NOT NULL AUTO_INCREMENT,
  `TYPE` enum('Abierta','Opcion Multiple','Opcion Unica','Verdadero/Falso','Relacionar Columnas') NOT NULL,
  `STATEMENT` text NOT NULL,
  `ANSWERS` text NOT NULL,
  `CORRECT` text NOT NULL,
  PRIMARY KEY (`IDQUESTION`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `students` (
  `IDSTUDENT` char(9) NOT NULL,
  `USERS` varchar(10) NOT NULL,
  `PASS` varchar(8) NOT NULL,
  `EMAIL` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`IDSTUDENT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjects`
--

DROP TABLE IF EXISTS `subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `subjects` (
  `IDSUBJECTS` varchar(5) NOT NULL,
  `NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`IDSUBJECTS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjects`
--

LOCK TABLES `subjects` WRITE;
/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teachers`
--

DROP TABLE IF EXISTS `teachers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `teachers` (
  `IDTEACHER` int(11) NOT NULL,
  `NAME` varchar(20) NOT NULL,
  `LAST_NAME` varchar(12) NOT NULL,
  `EMAIL` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`IDTEACHER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachers`
--

LOCK TABLES `teachers` WRITE;
/*!40000 ALTER TABLE `teachers` DISABLE KEYS */;
/*!40000 ALTER TABLE `teachers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `test` (
  `IDTEST` int(11) NOT NULL,
  `DESCRIPTION` varchar(45) NOT NULL,
  `START_DATE` datetime NOT NULL,
  `END_DATE` datetime NOT NULL,
  `TOTAL_TIME` time NOT NULL,
  `Teachers_IDTEACHER` int(11) NOT NULL,
  PRIMARY KEY (`IDTEST`),
  KEY `fk_Exam_Teachers1_idx` (`Teachers_IDTEACHER`),
  CONSTRAINT `fk_Exam_Teachers1` FOREIGN KEY (`Teachers_IDTEACHER`) REFERENCES `teachers` (`idteacher`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test_has_questions`
--

DROP TABLE IF EXISTS `test_has_questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `test_has_questions` (
  `Test_IDTEST` int(11) NOT NULL,
  `Questions_IDQUESTION` int(11) NOT NULL,
  PRIMARY KEY (`Test_IDTEST`,`Questions_IDQUESTION`),
  KEY `fk_Test_has_Questions_Questions1_idx` (`Questions_IDQUESTION`),
  KEY `fk_Test_has_Questions_Test1_idx` (`Test_IDTEST`),
  CONSTRAINT `fk_Test_has_Questions_Questions1` FOREIGN KEY (`Questions_IDQUESTION`) REFERENCES `questions` (`idquestion`),
  CONSTRAINT `fk_Test_has_Questions_Test1` FOREIGN KEY (`Test_IDTEST`) REFERENCES `test` (`idtest`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test_has_questions`
--

LOCK TABLES `test_has_questions` WRITE;
/*!40000 ALTER TABLE `test_has_questions` DISABLE KEYS */;
/*!40000 ALTER TABLE `test_has_questions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-12 16:49:04
