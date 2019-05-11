CREATE DATABASE  IF NOT EXISTS `uetcourse` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `uetcourse`;
-- MySQL dump 10.13  Distrib 8.0.16, for Linux (x86_64)
--
-- Host: localhost    Database: uetcourse
-- ------------------------------------------------------
-- Server version	8.0.16

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
-- Table structure for table `Lecturers`
--

DROP TABLE IF EXISTS `Lecturers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Lecturers` (
  `lecturerId` varchar(50) NOT NULL,
  `lecturerName` varchar(50) NOT NULL,
  `degree` varchar(50) NOT NULL,
  `phoneNumber` varchar(30) NOT NULL,
  PRIMARY KEY (`lecturerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Subjects`
--

DROP TABLE IF EXISTS `Subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Subjects` (
  `subjectId` varchar(50) NOT NULL,
  `subjectName` varchar(50) NOT NULL,
  `creditsNum` int(10) NOT NULL,
  PRIMARY KEY (`subjectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `account` (
  `username` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(55) NOT NULL,
  `password` varchar(16) NOT NULL,
  `profession` varchar(55) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `classes`
--

DROP TABLE IF EXISTS `classes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `classes` (
  `classId` varchar(50) NOT NULL,
  `lecturerId` varchar(50) NOT NULL,
  `subjectId` varchar(50) DEFAULT NULL,
  `semester` varchar(9) NOT NULL,
  PRIMARY KEY (`classId`),
  KEY `fk_classes_1_idx` (`lecturerId`),
  KEY `fk_classes_2` (`subjectId`),
  CONSTRAINT `fk_classes_1` FOREIGN KEY (`lecturerId`) REFERENCES `Lecturers` (`lecturerId`) ON UPDATE CASCADE,
  CONSTRAINT `fk_classes_2` FOREIGN KEY (`subjectId`) REFERENCES `Subjects` (`subjectId`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `studentsInfo`
--

DROP TABLE IF EXISTS `studentsInfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `studentsInfo` (
  `studentId` varchar(50) NOT NULL,
  `studentName` varchar(50) NOT NULL,
  `sex` varchar(50) NOT NULL,
  `birthDate` date DEFAULT NULL,
  PRIMARY KEY (`studentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `students_subjects`
--

DROP TABLE IF EXISTS `students_subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `students_subjects` (
  `studentsId` varchar(50) NOT NULL,
  `classId` varchar(50) NOT NULL,
  `midterm` double(11,1) DEFAULT NULL,
  `final` double(11,1) DEFAULT NULL,
  `attendance` int(11) DEFAULT NULL,
  PRIMARY KEY (`studentsId`,`classId`),
  KEY `students_subjects_ibfk_2` (`classId`),
  CONSTRAINT `students_subjects_ibfk_1` FOREIGN KEY (`studentsId`) REFERENCES `studentsInfo` (`studentId`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `students_subjects_ibfk_2` FOREIGN KEY (`classId`) REFERENCES `classes` (`classId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `subject_content`
--

DROP TABLE IF EXISTS `subject_content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `subject_content` (
  `week` int(10) NOT NULL,
  `nameDoc` varchar(60) DEFAULT NULL,
  `content` longblob,
  `subjectId` varchar(50) NOT NULL,
  PRIMARY KEY (`week`,`subjectId`),
  KEY `fk_subject_content_1_idx` (`subjectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-11 21:57:56
