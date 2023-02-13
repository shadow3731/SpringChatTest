-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: chat_test
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `site_configuration_background_colors`
--

DROP TABLE IF EXISTS `site_configuration_background_colors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `site_configuration_background_colors` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `code` varchar(7) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `site_configuration_background_colors`
--

LOCK TABLES `site_configuration_background_colors` WRITE;
/*!40000 ALTER TABLE `site_configuration_background_colors` DISABLE KEYS */;
/*!40000 ALTER TABLE `site_configuration_background_colors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `site_configuration_languages`
--

DROP TABLE IF EXISTS `site_configuration_languages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `site_configuration_languages` (
  `id` int NOT NULL AUTO_INCREMENT,
  `language` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `code` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `site_configuration_languages`
--

LOCK TABLES `site_configuration_languages` WRITE;
/*!40000 ALTER TABLE `site_configuration_languages` DISABLE KEYS */;
INSERT INTO `site_configuration_languages` VALUES (1,'Русский','ru'),(2,'English','en');
/*!40000 ALTER TABLE `site_configuration_languages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `site_configuration_languages_texts`
--

DROP TABLE IF EXISTS `site_configuration_languages_texts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `site_configuration_languages_texts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ru` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  `en` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `site_configuration_languages_texts`
--

LOCK TABLES `site_configuration_languages_texts` WRITE;
/*!40000 ALTER TABLE `site_configuration_languages_texts` DISABLE KEYS */;
INSERT INTO `site_configuration_languages_texts` VALUES (1,'Welcome title','Добро пожаловать в чат!','Welcome to the chat!'),(2,'Settings','Настройки','Settings'),(3,'Room 1','Чат комната 1','Chat room 1'),(4,'Room 2','Чат комната 2','Chat room 2'),(5,'Admin room','Системные настройки чата','System settings of chat');
/*!40000 ALTER TABLE `site_configuration_languages_texts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nickname` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `authority` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `registration_at` datetime DEFAULT NULL,
  `last_online_at` datetime DEFAULT NULL,
  `configuration_site_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `configuration_site_id` (`configuration_site_id`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`configuration_site_id`) REFERENCES `users_site_configuration` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin',NULL,NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_site_configuration`
--

DROP TABLE IF EXISTS `users_site_configuration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_site_configuration` (
  `id` int NOT NULL AUTO_INCREMENT,
  `language_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `language_id` (`language_id`),
  CONSTRAINT `users_site_configuration_ibfk_1` FOREIGN KEY (`language_id`) REFERENCES `site_configuration_languages` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_site_configuration`
--

LOCK TABLES `users_site_configuration` WRITE;
/*!40000 ALTER TABLE `users_site_configuration` DISABLE KEYS */;
INSERT INTO `users_site_configuration` VALUES (1,1);
/*!40000 ALTER TABLE `users_site_configuration` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-13 11:25:26
