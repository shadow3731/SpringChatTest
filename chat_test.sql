-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Feb 21, 2023 at 11:33 PM
-- Server version: 8.0.19
-- PHP Version: 7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `chat_test`
--

-- --------------------------------------------------------

--
-- Table structure for table `authorities`
--

CREATE TABLE `authorities` (
  `id` int NOT NULL,
  `codename` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `authorities`
--

INSERT INTO `authorities` (`id`, `codename`, `name`) VALUES
(1, 'REGULAR', 'User'),
(2, 'ADMIN', 'Administrator');

-- --------------------------------------------------------

--
-- Table structure for table `logs`
--

CREATE TABLE `logs` (
  `id` bigint NOT NULL,
  `user_id` int NOT NULL,
  `timestamp` datetime DEFAULT NULL,
  `action` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `logs`
--

INSERT INTO `logs` (`id`, `user_id`, `timestamp`, `action`, `description`) VALUES
(1, 1, '2023-02-20 13:20:00', 'Enter to a page', 'Enter to page with url GET:/'),
(2, 1, '2023-02-20 13:20:00', 'Enter to a page', 'Enter to page with url GET:/'),
(3, 1, '2023-02-20 13:20:00', 'Enter to a page', 'Enter to page with url GET:/'),
(4, 1, '2023-02-20 13:20:00', 'Enter to a page', 'Enter to page with url GET:/'),
(5, 1, '2023-02-20 15:15:15', 'Enter to a page', 'Enter to page with url GET:/'),
(6, 1, '2023-02-20 15:15:17', 'Enter to a page', 'Enter to page with url GET:/rooms/1/messages'),
(7, 1, '2023-02-20 15:21:25', 'Enter to a page', 'Enter to page with url GET:/rooms/1/messages'),
(8, 1, '2023-02-20 15:21:30', 'Enter to a page', 'Enter to page with url GET:/'),
(9, 1, '2023-02-20 15:21:31', 'Enter to a page', 'Enter to page with url GET:/admin'),
(10, 1, '2023-02-20 15:21:32', 'Enter to a page', 'Enter to page with url GET:/admin/logs?id=null&nickname=null&from=null&till=null'),
(11, 4, '2023-02-20 15:51:42', 'Enter to a page', 'Enter to page with url GET:/'),
(12, 4, '2023-02-20 15:51:44', 'Enter to a page', 'Enter to page with url GET:/rooms/2/messages'),
(13, 4, '2023-02-20 15:51:52', 'Add a message', 'Add message [test4] with url POST:/rooms/2/messages'),
(14, 4, '2023-02-20 15:51:52', 'Enter to a page', 'Enter to page with url GET:/rooms/2/messages'),
(15, 4, '2023-02-20 15:51:55', 'Enter to a page', 'Enter to page with url GET:/logout'),
(16, 1, '2023-02-20 15:51:56', 'Enter to a page', 'Enter to page with url GET:/'),
(17, 1, '2023-02-20 15:51:58', 'Enter to a page', 'Enter to page with url GET:/admin'),
(18, 1, '2023-02-20 15:51:58', 'Enter to a page', 'Enter to page with url GET:/admin/logs?id=null&nickname=null&from=null&till=null'),
(19, 1, '2023-02-20 15:56:27', 'Enter to a page', 'Enter to page with url GET:/admin/logs?id=null&nickname=null&from=null&till=null'),
(20, 1, '2023-02-20 15:57:03', 'Enter to a page', 'Enter to page with url GET:/admin/logs?id=&nickname=Sam&from=&till='),
(21, 5, '2023-02-20 15:58:22', 'Enter to a page', 'Enter to page with url GET:/'),
(22, 5, '2023-02-20 15:58:24', 'Enter to a page', 'Enter to page with url GET:/rooms/1/messages'),
(23, 5, '2023-02-20 15:58:47', 'Add a message', 'Add message [Advice you gyus to listen the song \"Young\"] with url POST:/rooms/1/messages'),
(24, 5, '2023-02-20 15:58:47', 'Enter to a page', 'Enter to page with url GET:/rooms/1/messages'),
(25, 5, '2023-02-20 15:58:50', 'Enter to a page', 'Enter to page with url GET:/logout'),
(26, 1, '2023-02-20 15:58:51', 'Enter to a page', 'Enter to page with url GET:/'),
(27, 1, '2023-02-20 15:58:52', 'Enter to a page', 'Enter to page with url GET:/admin'),
(28, 1, '2023-02-20 15:58:53', 'Enter to a page', 'Enter to page with url GET:/admin/logs?id=null&nickname=null&from=null&till=null'),
(29, 1, '2023-02-20 16:03:37', 'Enter to a page', 'Enter to page with url GET:/'),
(30, 1, '2023-02-20 16:03:39', 'Enter to a page', 'Enter to page with url GET:/admin'),
(31, 1, '2023-02-20 16:03:40', 'Enter to a page', 'Enter to page with url GET:/admin/logs?id=null&nickname=null&from=null&till=null'),
(32, 1, '2023-02-20 16:18:32', 'Enter to a page', 'Enter to page with url GET:/'),
(33, 1, '2023-02-20 16:18:44', 'Enter to a page', 'Enter to page with url GET:/admin'),
(34, 1, '2023-02-20 16:18:45', 'Enter to a page', 'Enter to page with url GET:/admin/logs?id=null&nickname=null&from=null&till=null'),
(35, 1, '2023-02-20 18:50:13', 'Enter to a page', 'Enter to page with url GET:/'),
(36, 1, '2023-02-20 18:50:17', 'Enter to a page', 'Enter to page with url GET:/rooms/1/messages'),
(37, 1, '2023-02-20 18:50:18', 'Enter to a page', 'Enter to page with url GET:/'),
(38, 1, '2023-02-20 18:50:22', 'Enter to a page', 'Enter to page with url GET:/users'),
(39, 1, '2023-02-20 18:50:23', 'Enter to a page', 'Enter to page with url GET:/logout'),
(40, 1, '2023-02-20 18:54:38', 'Enter to a page', 'Enter to page with url GET:/'),
(41, 1, '2023-02-20 18:54:44', 'Enter to a page', 'Enter to page with url GET:/admin'),
(42, 1, '2023-02-20 18:54:46', 'Enter to a page', 'Enter to page with url GET:/logout'),
(43, 4, '2023-02-20 18:54:50', 'Enter to a page', 'Enter to page with url GET:/'),
(44, 4, '2023-02-20 18:55:05', 'Enter to a page', 'Enter to page with url GET:/admin'),
(45, 4, '2023-02-20 18:56:04', 'Enter to a page', 'Enter to page with url GET:/'),
(46, 4, '2023-02-20 18:56:08', 'Enter to a page', 'Enter to page with url GET:/admin'),
(47, 4, '2023-02-20 18:56:08', 'Redirect from an inaccessible page', 'Redirect to default page'),
(48, 4, '2023-02-20 18:56:08', 'Enter to a page', 'Enter to page with url GET:/'),
(49, 4, '2023-02-20 18:56:28', 'Enter to a page', 'Enter to page with url GET:/admin'),
(50, 4, '2023-02-20 18:56:28', 'Redirect from an inaccessible page', 'Redirect to default page'),
(51, 4, '2023-02-20 18:56:28', 'Enter to a page', 'Enter to page with url GET:/'),
(52, 4, '2023-02-20 18:57:13', 'Enter to a page', 'Enter to page with url GET:/logout'),
(53, 1, '2023-02-20 18:57:15', 'Enter to a page', 'Enter to page with url GET:/'),
(54, 1, '2023-02-20 18:57:17', 'Enter to a page', 'Enter to page with url GET:/admin'),
(55, 1, '2023-02-20 18:57:18', 'Enter to a page', 'Enter to page with url GET:/admin/logs?id=null&nickname=null&from=null&till=null'),
(56, 4, '2023-02-20 19:03:23', 'Enter to a page', 'Enter to page with url GET:/'),
(57, 4, '2023-02-20 19:03:30', 'Enter to a page', 'Enter to page with url GET:/admin'),
(58, 4, '2023-02-20 19:03:30', 'Redirect from an inaccessible page', 'Redirect to default page'),
(59, 4, '2023-02-20 19:03:30', 'Enter to a page', 'Enter to page with url GET:/'),
(60, 4, '2023-02-20 19:05:10', 'Enter to a page', 'Enter to page with url GET:/logout'),
(61, 1, '2023-02-20 19:05:11', 'Enter to a page', 'Enter to page with url GET:/'),
(62, 1, '2023-02-20 19:05:28', 'Enter to a page', 'Enter to page with url GET:/'),
(63, 4, '2023-02-20 19:11:50', 'Enter to a page', 'Enter to page with url GET:/'),
(64, 4, '2023-02-20 19:11:56', 'Enter to a page', 'Enter to page with url GET:/admin'),
(65, 4, '2023-02-20 19:11:56', 'Redirect from an inaccessible page', 'Redirect to default page'),
(66, 4, '2023-02-20 19:11:56', 'Enter to a page', 'Enter to page with url GET:/'),
(67, 4, '2023-02-20 19:13:27', 'Enter to a page', 'Enter to page with url GET:/logout'),
(68, 1, '2023-02-20 19:13:29', 'Enter to a page', 'Enter to page with url GET:/'),
(69, 1, '2023-02-20 19:13:30', 'Enter to a page', 'Enter to page with url GET:/admin'),
(70, 1, '2023-02-20 19:13:31', 'Enter to a page', 'Enter to page with url GET:/admin/logs?id=null&nickname=null&from=null&till=null'),
(71, 1, '2023-02-20 19:15:48', 'Enter to a page', 'Enter to page with url GET:/admin/logs?id=null&nickname=null&from=null&till=null'),
(72, 1, '2023-02-20 19:47:41', 'Enter to a page', 'Enter to page with url GET:/'),
(73, 1, '2023-02-20 19:47:43', 'Enter to a page', 'Enter to page with url GET:/admin'),
(74, 1, '2023-02-20 19:47:43', 'Enter to a page', 'Enter to page with url GET:/admin/logs?id=null&nickname=null&from=null&till=null'),
(75, 1, '2023-02-20 19:50:51', 'Enter to a page', 'Enter to page with url GET:/admin/logs?id=1&nickname=null&from=null&till=null'),
(76, 1, '2023-02-20 19:54:20', 'Enter to a page', 'Enter to page with url GET:/'),
(77, 1, '2023-02-20 19:54:22', 'Enter to a page', 'Enter to page with url GET:/admin'),
(78, 1, '2023-02-20 19:54:23', 'Enter to a page', 'Enter to page with url GET:/admin/logs?id=null&nickname=null&from=null&till=null'),
(79, 1, '2023-02-20 19:55:39', 'Enter to a page', 'Enter to page with url GET:/'),
(80, 1, '2023-02-20 19:55:41', 'Enter to a page', 'Enter to page with url GET:/admin'),
(81, 1, '2023-02-20 19:55:42', 'Enter to a page', 'Enter to page with url GET:/admin/logs?id=null&nickname=null&from=null&till=null'),
(82, 1, '2023-02-21 14:49:48', 'Enter to a page', 'Enter to page with url GET:/'),
(83, 1, '2023-02-21 14:49:51', 'Enter to a page', 'Enter to page with url GET:/admin'),
(84, 1, '2023-02-21 14:49:52', 'Enter to a page', 'Enter to page with url GET:/admin/logs?id=null&nickname=null&from=null&till=null'),
(85, 1, '2023-02-21 14:49:58', 'Enter to a page', 'Enter to page with url GET:/'),
(86, 1, '2023-02-21 14:49:59', 'Enter to a page', 'Enter to page with url GET:/rooms/1/messages'),
(87, 1, '2023-02-21 14:50:03', 'Enter to a page', 'Enter to page with url GET:/rooms/1/messages/1'),
(88, 1, '2023-02-21 14:50:08', 'Edit a message', 'Edit message [qwerty] to [qwerty2] with url POST:/rooms/1/messages/1'),
(89, 1, '2023-02-21 14:50:08', 'Enter to a page', 'Enter to page with url GET:/rooms/1/messages'),
(90, 1, '2023-02-21 14:50:11', 'Enter to a page', 'Enter to page with url GET:/'),
(91, 1, '2023-02-21 14:50:12', 'Enter to a page', 'Enter to page with url GET:/admin'),
(92, 1, '2023-02-21 14:50:13', 'Enter to a page', 'Enter to page with url GET:/admin/logs?id=null&nickname=null&from=null&till=null'),
(93, 1, '2023-02-21 14:55:46', 'Enter to a page', 'Enter to page with url GET:/'),
(94, 1, '2023-02-21 14:55:48', 'Enter to a page', 'Enter to page with url GET:/rooms/1/messages'),
(95, 1, '2023-02-21 15:03:43', 'Enter to a page', 'Enter to page with url GET:/'),
(96, 1, '2023-02-21 15:03:45', 'Enter to a page', 'Enter to page with url GET:/rooms/1/messages'),
(97, 1, '2023-02-21 15:03:47', 'Enter to a page', 'Enter to page with url GET:/rooms/1/messages/1'),
(98, 1, '2023-02-21 15:03:51', 'Edit a message', 'Edit message [qwerty2] to [qwerty4] with url POST:/rooms/1/messages/1'),
(99, 1, '2023-02-21 15:03:51', 'Enter to a page', 'Enter to page with url GET:/rooms/1/messages'),
(100, 1, '2023-02-21 15:13:45', 'Enter to a page', 'Enter to page with url GET:/'),
(101, 1, '2023-02-21 15:13:48', 'Enter to a page', 'Enter to page with url GET:/rooms/1/messages'),
(102, 1, '2023-02-21 15:16:21', 'Enter to a page', 'Enter to page with url GET:/'),
(103, 1, '2023-02-21 15:16:23', 'Enter to a page', 'Enter to page with url GET:/rooms/1/messages'),
(104, 1, '2023-02-21 15:22:37', 'Enter to a page', 'Enter to page with url GET:/'),
(105, 1, '2023-02-21 15:22:41', 'Enter to a page', 'Enter to page with url GET:/rooms/1/messages'),
(106, 1, '2023-02-21 15:23:13', 'Enter to a page', 'Enter to page with url GET:/'),
(107, 1, '2023-02-21 15:23:15', 'Enter to a page', 'Enter to page with url GET:/rooms/1/messages'),
(108, 1, '2023-02-21 15:27:13', 'Enter to a page', 'Enter to page with url GET:/'),
(109, 1, '2023-02-21 15:27:15', 'Enter to a page', 'Enter to page with url GET:/rooms/1/messages'),
(110, 1, '2023-02-21 15:35:57', 'Enter to a page', 'Enter to page with url GET:/'),
(111, 1, '2023-02-21 15:35:59', 'Enter to a page', 'Enter to page with url GET:/rooms/1/messages'),
(112, 1, '2023-02-21 15:36:31', 'Enter to a page', 'Enter to page with url GET:/'),
(113, 1, '2023-02-21 15:36:34', 'Enter to a page', 'Enter to page with url GET:/rooms/1/messages'),
(114, 1, '2023-02-21 15:37:02', 'Add a message', 'Add message [I made edit function with only 120 seconds for edditing] with url POST:/rooms/1/messages'),
(115, 1, '2023-02-21 15:37:03', 'Enter to a page', 'Enter to page with url GET:/rooms/1/messages'),
(116, 1, '2023-02-21 15:38:05', 'Enter to a page', 'Enter to page with url GET:/rooms/1/messages'),
(117, 1, '2023-02-21 15:38:45', 'Enter to a page', 'Enter to page with url GET:/'),
(118, 1, '2023-02-21 15:38:47', 'Enter to a page', 'Enter to page with url GET:/rooms/1/messages'),
(119, 1, '2023-02-21 15:39:28', 'Enter to a page', 'Enter to page with url GET:/'),
(120, 1, '2023-02-21 15:39:30', 'Enter to a page', 'Enter to page with url GET:/rooms/1/messages'),
(121, 1, '2023-02-21 15:45:27', 'Enter to a page', 'Enter to page with url GET:/'),
(122, 1, '2023-02-21 15:45:29', 'Enter to a page', 'Enter to page with url GET:/rooms/1/messages'),
(123, 1, '2023-02-21 15:47:24', 'Enter to a page', 'Enter to page with url GET:/'),
(124, 1, '2023-02-21 15:47:26', 'Enter to a page', 'Enter to page with url GET:/rooms/1/messages'),
(125, 1, '2023-02-21 16:07:35', 'Enter to a page', 'Enter to page with url GET:/'),
(126, 1, '2023-02-21 16:07:38', 'Enter to a page', 'Enter to page with url GET:/rooms/1/messages'),
(127, 1, '2023-02-21 16:10:19', 'Enter to a page', 'Enter to page with url GET:/'),
(128, 1, '2023-02-21 16:10:22', 'Enter to a page', 'Enter to page with url GET:/rooms/1/messages'),
(129, 1, '2023-02-21 16:14:55', 'Enter to a page', 'Enter to page with url GET:/'),
(130, 1, '2023-02-21 16:14:57', 'Enter to a page', 'Enter to page with url GET:/rooms/1/messages'),
(131, 1, '2023-02-21 16:17:07', 'Enter to a page', 'Enter to page with url GET:/'),
(132, 1, '2023-02-21 16:17:10', 'Enter to a page', 'Enter to page with url GET:/rooms/1/messages'),
(133, 1, '2023-02-21 16:28:57', 'Enter to a page', 'Enter to page with url GET:/'),
(134, 1, '2023-02-21 16:29:00', 'Enter to a page', 'Enter to page with url GET:/rooms/1/messages'),
(135, 1, '2023-02-21 16:29:34', 'Enter to a page', 'Enter to page with url GET:/'),
(136, 1, '2023-02-21 16:29:37', 'Enter to a page', 'Enter to page with url GET:/rooms/1/messages'),
(137, 1, '2023-02-21 16:29:40', 'Add a message', 'Add message [test] with url POST:/rooms/1/messages'),
(138, 1, '2023-02-21 16:29:40', 'Enter to a page', 'Enter to page with url GET:/rooms/1/messages'),
(139, 1, '2023-02-21 16:44:34', 'Enter to a page', 'Enter to page with url GET:/'),
(140, 1, '2023-02-21 16:44:36', 'Enter to a page', 'Enter to page with url GET:/rooms/1/messages'),
(141, 1, '2023-02-21 16:44:41', 'Add a message', 'Add message [null] with url POST:/rooms/1/messages'),
(142, 1, '2023-02-21 16:44:41', 'Enter to a page', 'Enter to page with url GET:/rooms/1/messages'),
(143, 1, '2023-02-21 16:48:03', 'Enter to a page', 'Enter to page with url GET:/'),
(144, 1, '2023-02-21 16:48:05', 'Enter to a page', 'Enter to page with url GET:/rooms/1/messages'),
(145, 1, '2023-02-21 16:48:08', 'Add a message', 'Add message [null] with url POST:/rooms/1/messages'),
(146, 1, '2023-02-21 16:48:08', 'Enter to a page', 'Enter to page with url GET:/rooms/1/messages'),
(147, 1, '2023-02-21 16:52:30', 'Enter to a page', 'Enter to page with url GET:/'),
(148, 1, '2023-02-21 16:52:32', 'Enter to a page', 'Enter to page with url GET:/rooms/1/messages'),
(149, 1, '2023-02-21 16:53:03', 'Enter to a page', 'Enter to page with url GET:/'),
(150, 1, '2023-02-21 16:53:05', 'Enter to a page', 'Enter to page with url GET:/rooms/1/messages'),
(151, 1, '2023-02-21 16:53:07', 'Enter to a page', 'Enter to page with url GET:/rooms/1/messages'),
(152, 1, '2023-02-21 16:53:10', 'Enter to a page', 'Enter to page with url GET:/'),
(153, 1, '2023-02-21 16:53:12', 'Enter to a page', 'Enter to page with url GET:/admin'),
(154, 1, '2023-02-21 16:53:13', 'Enter to a page', 'Enter to page with url GET:/admin/logs?id=null&nickname=null&from=null&till=null'),
(155, 9, '2023-02-21 19:51:22', 'Enter to a page', 'Enter to page with url GET:/'),
(156, 1, '2023-02-21 20:10:52', 'Enter to a page', 'Enter to page with url GET:/');

-- --------------------------------------------------------

--
-- Table structure for table `messages`
--

CREATE TABLE `messages` (
  `id` int NOT NULL,
  `room_id` int DEFAULT NULL,
  `user_id` int NOT NULL,
  `timestamp` datetime DEFAULT NULL,
  `message` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  `is_deleted` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `messages`
--

INSERT INTO `messages` (`id`, `room_id`, `user_id`, `timestamp`, `message`, `is_deleted`) VALUES
(1, 1, 1, '2023-02-18 20:17:17', 'qwerty4', 0),
(2, 1, 1, '2023-02-18 20:17:41', 'Feel free to chat here)', 0),
(3, 2, 1, '2023-02-18 20:17:59', 'This room is also opened)', 0),
(4, 2, 5, '2023-02-18 20:18:17', 'yeah!!!!!!!!!!', 0),
(5, 1, 4, '2023-02-18 20:18:50', 'Yes, we will)', 0),
(6, 2, 3, '2023-02-20 15:41:33', 'Testing logging', 0),
(7, 2, 4, '2023-02-20 15:45:40', 'Testing2', 0),
(8, 2, 1, '2023-02-20 15:51:04', 'test3', 0),
(9, 2, 4, '2023-02-20 15:51:52', 'test4', 0),
(10, 1, 5, '2023-02-20 15:58:47', 'Advice you gyus to listen the song \"Young\"', 0),
(11, 1, 1, '2023-02-21 15:37:03', 'I made edit function with only 120 seconds for edditing', 0),
(12, 1, 1, '2023-02-21 16:29:40', 'test', 1);

-- --------------------------------------------------------

--
-- Table structure for table `messages_seq`
--

CREATE TABLE `messages_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `messages_seq`
--

INSERT INTO `messages_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int NOT NULL,
  `nickname` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `password` varbinary(1024) DEFAULT NULL,
  `authority_id` int NOT NULL,
  `user_details_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `nickname`, `password`, `authority_id`, `user_details_id`) VALUES
(1, 'admin', 0x1cb043f7309c5ca64aec6a5e71a3a0d6, 2, 1),
(2, 'System', 0xa49a61547f2bb1d1ce9f2115414cb6a66221ca8e2a93c7789bca9fa4a972973895c9f78cecb47413db0048ab9c81e054, 2, 2),
(3, 'Java Developer', 0x1cb043f7309c5ca64aec6a5e71a3a0d6, 1, 3),
(4, 'Sam', 0x1cb043f7309c5ca64aec6a5e71a3a0d6, 1, 4),
(5, 'Hollywood Undead', 0x1cb043f7309c5ca64aec6a5e71a3a0d6, 1, 5),
(9, 'Desert Eagle', 0x1cb043f7309c5ca64aec6a5e71a3a0d6, 1, 9);

-- --------------------------------------------------------

--
-- Table structure for table `users_details`
--

CREATE TABLE `users_details` (
  `user_id` int NOT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `country` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `age` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users_details`
--

INSERT INTO `users_details` (`user_id`, `email`, `country`, `age`) VALUES
(1, 'god@gmail.com', 'Belarus', 23),
(2, NULL, NULL, NULL),
(3, NULL, 'Germany', 20),
(4, 'sam@mail.ru', NULL, 28),
(5, 'smth@yahoo.com', 'USA', NULL),
(9, 'smth2@gmail.com', 'Belarus', 23);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `authorities`
--
ALTER TABLE `authorities`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `logs`
--
ALTER TABLE `logs`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `messages`
--
ALTER TABLE `messages`
  ADD PRIMARY KEY (`id`),
  ADD KEY `nickname_id` (`user_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `user_details_id` (`user_details_id`),
  ADD KEY `authority_id` (`authority_id`);

--
-- Indexes for table `users_details`
--
ALTER TABLE `users_details`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `authorities`
--
ALTER TABLE `authorities`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `logs`
--
ALTER TABLE `logs`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=157;

--
-- AUTO_INCREMENT for table `messages`
--
ALTER TABLE `messages`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `logs`
--
ALTER TABLE `logs`
  ADD CONSTRAINT `logs_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `messages`
--
ALTER TABLE `messages`
  ADD CONSTRAINT `messages_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`authority_id`) REFERENCES `authorities` (`id`),
  ADD CONSTRAINT `users_ibfk_2` FOREIGN KEY (`user_details_id`) REFERENCES `users_details` (`user_id`);

--
-- Constraints for table `users_details`
--
ALTER TABLE `users_details`
  ADD CONSTRAINT `users_details_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
