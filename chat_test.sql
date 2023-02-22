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
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authorities` (
  `id` int NOT NULL AUTO_INCREMENT,
  `codename` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` VALUES (1,'REGULAR','User'),(2,'ADMIN','Administrator');
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logs`
--

DROP TABLE IF EXISTS `logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `logs` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `timestamp` datetime DEFAULT NULL,
  `action` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `logs_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=177 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logs`
--

LOCK TABLES `logs` WRITE;
/*!40000 ALTER TABLE `logs` DISABLE KEYS */;
INSERT INTO `logs` VALUES (1,1,'2023-02-20 13:20:00','Enter to a page','Enter to page with url GET:/'),(2,1,'2023-02-20 13:20:00','Enter to a page','Enter to page with url GET:/'),(3,1,'2023-02-20 13:20:00','Enter to a page','Enter to page with url GET:/'),(4,1,'2023-02-20 13:20:00','Enter to a page','Enter to page with url GET:/'),(5,1,'2023-02-20 15:15:15','Enter to a page','Enter to page with url GET:/'),(6,1,'2023-02-20 15:15:17','Enter to a page','Enter to page with url GET:/rooms/1/messages'),(7,1,'2023-02-20 15:21:25','Enter to a page','Enter to page with url GET:/rooms/1/messages'),(8,1,'2023-02-20 15:21:30','Enter to a page','Enter to page with url GET:/'),(9,1,'2023-02-20 15:21:31','Enter to a page','Enter to page with url GET:/admin'),(10,1,'2023-02-20 15:21:32','Enter to a page','Enter to page with url GET:/admin/logs?id=null&nickname=null&from=null&till=null'),(11,4,'2023-02-20 15:51:42','Enter to a page','Enter to page with url GET:/'),(12,4,'2023-02-20 15:51:44','Enter to a page','Enter to page with url GET:/rooms/2/messages'),(13,4,'2023-02-20 15:51:52','Add a message','Add message [test4] with url POST:/rooms/2/messages'),(14,4,'2023-02-20 15:51:52','Enter to a page','Enter to page with url GET:/rooms/2/messages'),(15,4,'2023-02-20 15:51:55','Enter to a page','Enter to page with url GET:/logout'),(16,1,'2023-02-20 15:51:56','Enter to a page','Enter to page with url GET:/'),(17,1,'2023-02-20 15:51:58','Enter to a page','Enter to page with url GET:/admin'),(18,1,'2023-02-20 15:51:58','Enter to a page','Enter to page with url GET:/admin/logs?id=null&nickname=null&from=null&till=null'),(19,1,'2023-02-20 15:56:27','Enter to a page','Enter to page with url GET:/admin/logs?id=null&nickname=null&from=null&till=null'),(20,1,'2023-02-20 15:57:03','Enter to a page','Enter to page with url GET:/admin/logs?id=&nickname=Sam&from=&till='),(21,5,'2023-02-20 15:58:22','Enter to a page','Enter to page with url GET:/'),(22,5,'2023-02-20 15:58:24','Enter to a page','Enter to page with url GET:/rooms/1/messages'),(23,5,'2023-02-20 15:58:47','Add a message','Add message [Advice you gyus to listen the song \"Young\"] with url POST:/rooms/1/messages'),(24,5,'2023-02-20 15:58:47','Enter to a page','Enter to page with url GET:/rooms/1/messages'),(25,5,'2023-02-20 15:58:50','Enter to a page','Enter to page with url GET:/logout'),(26,1,'2023-02-20 15:58:51','Enter to a page','Enter to page with url GET:/'),(27,1,'2023-02-20 15:58:52','Enter to a page','Enter to page with url GET:/admin'),(28,1,'2023-02-20 15:58:53','Enter to a page','Enter to page with url GET:/admin/logs?id=null&nickname=null&from=null&till=null'),(29,1,'2023-02-20 16:03:37','Enter to a page','Enter to page with url GET:/'),(30,1,'2023-02-20 16:03:39','Enter to a page','Enter to page with url GET:/admin'),(31,1,'2023-02-20 16:03:40','Enter to a page','Enter to page with url GET:/admin/logs?id=null&nickname=null&from=null&till=null'),(32,1,'2023-02-20 16:18:32','Enter to a page','Enter to page with url GET:/'),(33,1,'2023-02-20 16:18:44','Enter to a page','Enter to page with url GET:/admin'),(34,1,'2023-02-20 16:18:45','Enter to a page','Enter to page with url GET:/admin/logs?id=null&nickname=null&from=null&till=null'),(35,1,'2023-02-20 18:50:13','Enter to a page','Enter to page with url GET:/'),(36,1,'2023-02-20 18:50:17','Enter to a page','Enter to page with url GET:/rooms/1/messages'),(37,1,'2023-02-20 18:50:18','Enter to a page','Enter to page with url GET:/'),(38,1,'2023-02-20 18:50:22','Enter to a page','Enter to page with url GET:/users'),(39,1,'2023-02-20 18:50:23','Enter to a page','Enter to page with url GET:/logout'),(40,1,'2023-02-20 18:54:38','Enter to a page','Enter to page with url GET:/'),(41,1,'2023-02-20 18:54:44','Enter to a page','Enter to page with url GET:/admin'),(42,1,'2023-02-20 18:54:46','Enter to a page','Enter to page with url GET:/logout'),(43,4,'2023-02-20 18:54:50','Enter to a page','Enter to page with url GET:/'),(44,4,'2023-02-20 18:55:05','Enter to a page','Enter to page with url GET:/admin'),(45,4,'2023-02-20 18:56:04','Enter to a page','Enter to page with url GET:/'),(46,4,'2023-02-20 18:56:08','Enter to a page','Enter to page with url GET:/admin'),(47,4,'2023-02-20 18:56:08','Redirect from an inaccessible page','Redirect to default page'),(48,4,'2023-02-20 18:56:08','Enter to a page','Enter to page with url GET:/'),(49,4,'2023-02-20 18:56:28','Enter to a page','Enter to page with url GET:/admin'),(50,4,'2023-02-20 18:56:28','Redirect from an inaccessible page','Redirect to default page'),(51,4,'2023-02-20 18:56:28','Enter to a page','Enter to page with url GET:/'),(52,4,'2023-02-20 18:57:13','Enter to a page','Enter to page with url GET:/logout'),(53,1,'2023-02-20 18:57:15','Enter to a page','Enter to page with url GET:/'),(54,1,'2023-02-20 18:57:17','Enter to a page','Enter to page with url GET:/admin'),(55,1,'2023-02-20 18:57:18','Enter to a page','Enter to page with url GET:/admin/logs?id=null&nickname=null&from=null&till=null'),(56,4,'2023-02-20 19:03:23','Enter to a page','Enter to page with url GET:/'),(57,4,'2023-02-20 19:03:30','Enter to a page','Enter to page with url GET:/admin'),(58,4,'2023-02-20 19:03:30','Redirect from an inaccessible page','Redirect to default page'),(59,4,'2023-02-20 19:03:30','Enter to a page','Enter to page with url GET:/'),(60,4,'2023-02-20 19:05:10','Enter to a page','Enter to page with url GET:/logout'),(61,1,'2023-02-20 19:05:11','Enter to a page','Enter to page with url GET:/'),(62,1,'2023-02-20 19:05:28','Enter to a page','Enter to page with url GET:/'),(63,4,'2023-02-20 19:11:50','Enter to a page','Enter to page with url GET:/'),(64,4,'2023-02-20 19:11:56','Enter to a page','Enter to page with url GET:/admin'),(65,4,'2023-02-20 19:11:56','Redirect from an inaccessible page','Redirect to default page'),(66,4,'2023-02-20 19:11:56','Enter to a page','Enter to page with url GET:/'),(67,4,'2023-02-20 19:13:27','Enter to a page','Enter to page with url GET:/logout'),(68,1,'2023-02-20 19:13:29','Enter to a page','Enter to page with url GET:/'),(69,1,'2023-02-20 19:13:30','Enter to a page','Enter to page with url GET:/admin'),(70,1,'2023-02-20 19:13:31','Enter to a page','Enter to page with url GET:/admin/logs?id=null&nickname=null&from=null&till=null'),(71,1,'2023-02-20 19:15:48','Enter to a page','Enter to page with url GET:/admin/logs?id=null&nickname=null&from=null&till=null'),(72,1,'2023-02-20 19:47:41','Enter to a page','Enter to page with url GET:/'),(73,1,'2023-02-20 19:47:43','Enter to a page','Enter to page with url GET:/admin'),(74,1,'2023-02-20 19:47:43','Enter to a page','Enter to page with url GET:/admin/logs?id=null&nickname=null&from=null&till=null'),(75,1,'2023-02-20 19:50:51','Enter to a page','Enter to page with url GET:/admin/logs?id=1&nickname=null&from=null&till=null'),(76,1,'2023-02-20 19:54:20','Enter to a page','Enter to page with url GET:/'),(77,1,'2023-02-20 19:54:22','Enter to a page','Enter to page with url GET:/admin'),(78,1,'2023-02-20 19:54:23','Enter to a page','Enter to page with url GET:/admin/logs?id=null&nickname=null&from=null&till=null'),(79,1,'2023-02-20 19:55:39','Enter to a page','Enter to page with url GET:/'),(80,1,'2023-02-20 19:55:41','Enter to a page','Enter to page with url GET:/admin'),(81,1,'2023-02-20 19:55:42','Enter to a page','Enter to page with url GET:/admin/logs?id=null&nickname=null&from=null&till=null'),(82,1,'2023-02-21 14:49:48','Enter to a page','Enter to page with url GET:/'),(83,1,'2023-02-21 14:49:51','Enter to a page','Enter to page with url GET:/admin'),(84,1,'2023-02-21 14:49:52','Enter to a page','Enter to page with url GET:/admin/logs?id=null&nickname=null&from=null&till=null'),(85,1,'2023-02-21 14:49:58','Enter to a page','Enter to page with url GET:/'),(86,1,'2023-02-21 14:49:59','Enter to a page','Enter to page with url GET:/rooms/1/messages'),(87,1,'2023-02-21 14:50:03','Enter to a page','Enter to page with url GET:/rooms/1/messages/1'),(88,1,'2023-02-21 14:50:08','Edit a message','Edit message [qwerty] to [qwerty2] with url POST:/rooms/1/messages/1'),(89,1,'2023-02-21 14:50:08','Enter to a page','Enter to page with url GET:/rooms/1/messages'),(90,1,'2023-02-21 14:50:11','Enter to a page','Enter to page with url GET:/'),(91,1,'2023-02-21 14:50:12','Enter to a page','Enter to page with url GET:/admin'),(92,1,'2023-02-21 14:50:13','Enter to a page','Enter to page with url GET:/admin/logs?id=null&nickname=null&from=null&till=null'),(93,1,'2023-02-21 14:55:46','Enter to a page','Enter to page with url GET:/'),(94,1,'2023-02-21 14:55:48','Enter to a page','Enter to page with url GET:/rooms/1/messages'),(95,1,'2023-02-21 15:03:43','Enter to a page','Enter to page with url GET:/'),(96,1,'2023-02-21 15:03:45','Enter to a page','Enter to page with url GET:/rooms/1/messages'),(97,1,'2023-02-21 15:03:47','Enter to a page','Enter to page with url GET:/rooms/1/messages/1'),(98,1,'2023-02-21 15:03:51','Edit a message','Edit message [qwerty2] to [qwerty4] with url POST:/rooms/1/messages/1'),(99,1,'2023-02-21 15:03:51','Enter to a page','Enter to page with url GET:/rooms/1/messages'),(100,1,'2023-02-21 15:13:45','Enter to a page','Enter to page with url GET:/'),(101,1,'2023-02-21 15:13:48','Enter to a page','Enter to page with url GET:/rooms/1/messages'),(102,1,'2023-02-21 15:16:21','Enter to a page','Enter to page with url GET:/'),(103,1,'2023-02-21 15:16:23','Enter to a page','Enter to page with url GET:/rooms/1/messages'),(104,1,'2023-02-21 15:22:37','Enter to a page','Enter to page with url GET:/'),(105,1,'2023-02-21 15:22:41','Enter to a page','Enter to page with url GET:/rooms/1/messages'),(106,1,'2023-02-21 15:23:13','Enter to a page','Enter to page with url GET:/'),(107,1,'2023-02-21 15:23:15','Enter to a page','Enter to page with url GET:/rooms/1/messages'),(108,1,'2023-02-21 15:27:13','Enter to a page','Enter to page with url GET:/'),(109,1,'2023-02-21 15:27:15','Enter to a page','Enter to page with url GET:/rooms/1/messages'),(110,1,'2023-02-21 15:35:57','Enter to a page','Enter to page with url GET:/'),(111,1,'2023-02-21 15:35:59','Enter to a page','Enter to page with url GET:/rooms/1/messages'),(112,1,'2023-02-21 15:36:31','Enter to a page','Enter to page with url GET:/'),(113,1,'2023-02-21 15:36:34','Enter to a page','Enter to page with url GET:/rooms/1/messages'),(114,1,'2023-02-21 15:37:02','Add a message','Add message [I made edit function with only 120 seconds for edditing] with url POST:/rooms/1/messages'),(115,1,'2023-02-21 15:37:03','Enter to a page','Enter to page with url GET:/rooms/1/messages'),(116,1,'2023-02-21 15:38:05','Enter to a page','Enter to page with url GET:/rooms/1/messages'),(117,1,'2023-02-21 15:38:45','Enter to a page','Enter to page with url GET:/'),(118,1,'2023-02-21 15:38:47','Enter to a page','Enter to page with url GET:/rooms/1/messages'),(119,1,'2023-02-21 15:39:28','Enter to a page','Enter to page with url GET:/'),(120,1,'2023-02-21 15:39:30','Enter to a page','Enter to page with url GET:/rooms/1/messages'),(121,1,'2023-02-21 15:45:27','Enter to a page','Enter to page with url GET:/'),(122,1,'2023-02-21 15:45:29','Enter to a page','Enter to page with url GET:/rooms/1/messages'),(123,1,'2023-02-21 15:47:24','Enter to a page','Enter to page with url GET:/'),(124,1,'2023-02-21 15:47:26','Enter to a page','Enter to page with url GET:/rooms/1/messages'),(125,1,'2023-02-21 16:07:35','Enter to a page','Enter to page with url GET:/'),(126,1,'2023-02-21 16:07:38','Enter to a page','Enter to page with url GET:/rooms/1/messages'),(127,1,'2023-02-21 16:10:19','Enter to a page','Enter to page with url GET:/'),(128,1,'2023-02-21 16:10:22','Enter to a page','Enter to page with url GET:/rooms/1/messages'),(129,1,'2023-02-21 16:14:55','Enter to a page','Enter to page with url GET:/'),(130,1,'2023-02-21 16:14:57','Enter to a page','Enter to page with url GET:/rooms/1/messages'),(131,1,'2023-02-21 16:17:07','Enter to a page','Enter to page with url GET:/'),(132,1,'2023-02-21 16:17:10','Enter to a page','Enter to page with url GET:/rooms/1/messages'),(133,1,'2023-02-21 16:28:57','Enter to a page','Enter to page with url GET:/'),(134,1,'2023-02-21 16:29:00','Enter to a page','Enter to page with url GET:/rooms/1/messages'),(135,1,'2023-02-21 16:29:34','Enter to a page','Enter to page with url GET:/'),(136,1,'2023-02-21 16:29:37','Enter to a page','Enter to page with url GET:/rooms/1/messages'),(137,1,'2023-02-21 16:29:40','Add a message','Add message [test] with url POST:/rooms/1/messages'),(138,1,'2023-02-21 16:29:40','Enter to a page','Enter to page with url GET:/rooms/1/messages'),(139,1,'2023-02-21 16:44:34','Enter to a page','Enter to page with url GET:/'),(140,1,'2023-02-21 16:44:36','Enter to a page','Enter to page with url GET:/rooms/1/messages'),(141,1,'2023-02-21 16:44:41','Add a message','Add message [null] with url POST:/rooms/1/messages'),(142,1,'2023-02-21 16:44:41','Enter to a page','Enter to page with url GET:/rooms/1/messages'),(143,1,'2023-02-21 16:48:03','Enter to a page','Enter to page with url GET:/'),(144,1,'2023-02-21 16:48:05','Enter to a page','Enter to page with url GET:/rooms/1/messages'),(145,1,'2023-02-21 16:48:08','Add a message','Add message [null] with url POST:/rooms/1/messages'),(146,1,'2023-02-21 16:48:08','Enter to a page','Enter to page with url GET:/rooms/1/messages'),(147,1,'2023-02-21 16:52:30','Enter to a page','Enter to page with url GET:/'),(148,1,'2023-02-21 16:52:32','Enter to a page','Enter to page with url GET:/rooms/1/messages'),(149,1,'2023-02-21 16:53:03','Enter to a page','Enter to page with url GET:/'),(150,1,'2023-02-21 16:53:05','Enter to a page','Enter to page with url GET:/rooms/1/messages'),(151,1,'2023-02-21 16:53:07','Enter to a page','Enter to page with url GET:/rooms/1/messages'),(152,1,'2023-02-21 16:53:10','Enter to a page','Enter to page with url GET:/'),(153,1,'2023-02-21 16:53:12','Enter to a page','Enter to page with url GET:/admin'),(154,1,'2023-02-21 16:53:13','Enter to a page','Enter to page with url GET:/admin/logs?id=null&nickname=null&from=null&till=null'),(155,9,'2023-02-21 19:51:22','Enter to a page','Enter to page with url GET:/'),(156,1,'2023-02-21 20:10:52','Enter to a page','Enter to page with url GET:/'),(157,1,'2023-02-22 10:12:51','Enter to a page','Enter to page with url GET:/'),(158,1,'2023-02-22 10:12:53','Enter to a page','Enter to page with url GET:/rooms/1/messages'),(159,1,'2023-02-22 10:12:56','Enter to a page','Enter to page with url GET:/'),(160,1,'2023-02-22 10:12:57','Enter to a page','Enter to page with url GET:/rooms/2/messages'),(161,1,'2023-02-22 10:13:03','Enter to a page','Enter to page with url GET:/'),(162,1,'2023-02-22 10:13:05','Enter to a page','Enter to page with url GET:/admin'),(163,1,'2023-02-22 10:13:06','Enter to a page','Enter to page with url GET:/admin/logs?id=null&nickname=null&from=null&till=null'),(164,1,'2023-02-22 10:53:46','Enter to a page','Enter to page with url GET:/'),(165,1,'2023-02-22 10:53:47','Enter to a page','Enter to page with url GET:/admin'),(166,1,'2023-02-22 10:57:56','Enter to a page','Enter to page with url GET:/'),(167,1,'2023-02-22 10:57:57','Enter to a page','Enter to page with url GET:/admin'),(168,1,'2023-02-22 10:57:58','Enter to a page','Enter to page with url GET:/admin/logs?pageId=1&userId=null&userNickname=null&from=null&till=null'),(169,1,'2023-02-22 11:00:02','Enter to a page','Enter to page with url GET:/'),(170,1,'2023-02-22 11:00:03','Enter to a page','Enter to page with url GET:/admin'),(171,1,'2023-02-22 11:00:04','Enter to a page','Enter to page with url GET:/admin/logs?pageId=1&userId=null&userNickname=null&from=null&till=null'),(172,1,'2023-02-22 11:00:32','Enter to a page','Enter to page with url GET:/admin/logs?pageId=1&userId=null&userNickname=null&from=null&till=null'),(173,1,'2023-02-22 11:01:47','Enter to a page','Enter to page with url GET:/'),(174,1,'2023-02-22 11:01:48','Enter to a page','Enter to page with url GET:/admin'),(175,1,'2023-02-22 11:01:49','Enter to a page','Enter to page with url GET:/admin/logs?pageId=1&userId=null&userNickname=null&from=null&till=null'),(176,1,'2023-02-22 11:02:04','Enter to a page','Enter to page with url GET:/admin/logs?pageId=2&userId=null&userNickname=null&from=null&till=null');
/*!40000 ALTER TABLE `logs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `messages`
--

DROP TABLE IF EXISTS `messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `messages` (
  `id` int NOT NULL AUTO_INCREMENT,
  `room_id` int DEFAULT NULL,
  `user_id` int NOT NULL,
  `timestamp` datetime DEFAULT NULL,
  `message` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  `is_deleted` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `nickname_id` (`user_id`),
  CONSTRAINT `messages_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messages`
--

LOCK TABLES `messages` WRITE;
/*!40000 ALTER TABLE `messages` DISABLE KEYS */;
INSERT INTO `messages` VALUES (1,1,1,'2023-02-18 20:17:17','qwerty4',0),(2,1,1,'2023-02-18 20:17:41','Feel free to chat here)',0),(3,2,1,'2023-02-18 20:17:59','This room is also opened)',0),(4,2,5,'2023-02-18 20:18:17','yeah!!!!!!!!!!',0),(5,1,4,'2023-02-18 20:18:50','Yes, we will)',0),(6,2,3,'2023-02-20 15:41:33','Testing logging',0),(7,2,4,'2023-02-20 15:45:40','Testing2',0),(8,2,1,'2023-02-20 15:51:04','test3',0),(9,2,4,'2023-02-20 15:51:52','test4',0),(10,1,5,'2023-02-20 15:58:47','Advice you gyus to listen the song \"Young\"',0),(11,1,1,'2023-02-21 15:37:03','I made edit function with only 120 seconds for edditing',0),(12,1,1,'2023-02-21 16:29:40','test',1);
/*!40000 ALTER TABLE `messages` ENABLE KEYS */;
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
  `password` varbinary(1024) DEFAULT NULL,
  `authority_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `authority_id` (`authority_id`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`authority_id`) REFERENCES `authorities` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin',_binary '∞C˜0ú\\¶J\Ïj^q£†\÷',2),(2,'System',_binary '§öaT+±\—Œü!AL∂¶b! é*ì\«xõ ü§©ró8ï\…˜å\Ï¥t\€\0H´úÅ\‡T',2),(3,'Java Developer',_binary '∞C˜0ú\\¶J\Ïj^q£†\÷',1),(4,'Sam',_binary '∞C˜0ú\\¶J\Ïj^q£†\÷',1),(5,'Hollywood Undead',_binary '∞C˜0ú\\¶J\Ïj^q£†\÷',1),(9,'Desert Eagle',_binary '∞C˜0ú\\¶J\Ïj^q£†\÷',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-22 14:36:20
