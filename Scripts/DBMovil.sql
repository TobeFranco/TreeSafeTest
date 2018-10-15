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
  `Answers_Paper_IDANSWERS_PAPER` int(11) NOT NULL,
  PRIMARY KEY (`IDANSWER`),
  KEY `fk_Answers_Questions1_idx` (`Questions_IDQUESTION`),
  KEY `fk_Answers_Answers_Paper1_idx` (`Answers_Paper_IDANSWERS_PAPER`),
  CONSTRAINT `fk_Answers_Answers_Paper1` FOREIGN KEY (`Answers_Paper_IDANSWERS_PAPER`) REFERENCES `answers_paper` (`idanswers_paper`),
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
-- Table structure for table `answers_paper`
--

DROP TABLE IF EXISTS `answers_paper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `answers_paper` (
  `IDANSWERS_PAPER` int(11) NOT NULL,
  `START` datetime NOT NULL,
  `END` datetime NOT NULL,
  `CALIFICATION` float NOT NULL,
  `Students_MATRICULA` char(9) NOT NULL,
  PRIMARY KEY (`IDANSWERS_PAPER`),
  KEY `fk_Answers_Paper_Students1_idx` (`Students_MATRICULA`),
  CONSTRAINT `fk_Answers_Paper_Students1` FOREIGN KEY (`Students_MATRICULA`) REFERENCES `students` (`matricula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answers_paper`
--

LOCK TABLES `answers_paper` WRITE;
/*!40000 ALTER TABLE `answers_paper` DISABLE KEYS */;
/*!40000 ALTER TABLE `answers_paper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam`
--

DROP TABLE IF EXISTS `exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `exam` (
  `IDEXAM` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(45) DEFAULT NULL,
  `START_DATE` datetime DEFAULT NULL,
  `END_DATE` datetime DEFAULT NULL,
  `TOTAL_TIME` time DEFAULT NULL,
  `Teachers_IDTEACHER` int(11) NOT NULL,
  `Answers_Paper_IDANSWERS_PAPER` int(11) NOT NULL,
  PRIMARY KEY (`IDEXAM`),
  KEY `fk_Exam_Teachers1_idx` (`Teachers_IDTEACHER`),
  KEY `fk_Exam_Answers_Paper1_idx` (`Answers_Paper_IDANSWERS_PAPER`),
  CONSTRAINT `fk_Exam_Answers_Paper1` FOREIGN KEY (`Answers_Paper_IDANSWERS_PAPER`) REFERENCES `answers_paper` (`idanswers_paper`),
  CONSTRAINT `fk_Exam_Teachers1` FOREIGN KEY (`Teachers_IDTEACHER`) REFERENCES `teachers` (`idteacher`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam`
--

LOCK TABLES `exam` WRITE;
/*!40000 ALTER TABLE `exam` DISABLE KEYS */;
/*!40000 ALTER TABLE `exam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam_has_questions`
--

DROP TABLE IF EXISTS `exam_has_questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `exam_has_questions` (
  `Exam_IDEXAM` int(11) NOT NULL,
  `Questions_IDQUESTION` int(11) NOT NULL,
  `QUANTITY` int(11) DEFAULT NULL,
  PRIMARY KEY (`Exam_IDEXAM`,`Questions_IDQUESTION`),
  KEY `fk_Exam_has_Questions_Questions1_idx` (`Questions_IDQUESTION`),
  KEY `fk_Exam_has_Questions_Exam1_idx` (`Exam_IDEXAM`),
  CONSTRAINT `fk_Exam_has_Questions_Exam1` FOREIGN KEY (`Exam_IDEXAM`) REFERENCES `exam` (`idexam`),
  CONSTRAINT `fk_Exam_has_Questions_Questions1` FOREIGN KEY (`Questions_IDQUESTION`) REFERENCES `questions` (`idquestion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam_has_questions`
--

LOCK TABLES `exam_has_questions` WRITE;
/*!40000 ALTER TABLE `exam_has_questions` DISABLE KEYS */;
/*!40000 ALTER TABLE `exam_has_questions` ENABLE KEYS */;
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
  `Students_MATRICULA` char(9) NOT NULL,
  PRIMARY KEY (`Groups_IDGROUP`,`Students_MATRICULA`),
  KEY `fk_Groups_has_Students_Students1_idx` (`Students_MATRICULA`),
  KEY `fk_Groups_has_Students_Groups1_idx` (`Groups_IDGROUP`),
  CONSTRAINT `fk_Groups_has_Students_Groups1` FOREIGN KEY (`Groups_IDGROUP`) REFERENCES `groups` (`idgroup`),
  CONSTRAINT `fk_Groups_has_Students_Students1` FOREIGN KEY (`Students_MATRICULA`) REFERENCES `students` (`matricula`)
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
  `MATRICULA` char(9) NOT NULL,
  `USERS` varchar(10) NOT NULL,
  `PASS` varchar(8) NOT NULL,
  `EMAIL` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`MATRICULA`)
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-14 19:08:30
