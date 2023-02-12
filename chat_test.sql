-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Feb 12, 2023 at 05:32 PM
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
-- Table structure for table `site_configuration_background_colors`
--

CREATE TABLE `site_configuration_background_colors` (
  `id` int NOT NULL,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `code` varchar(7) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `site_configuration_languages`
--

CREATE TABLE `site_configuration_languages` (
  `id` int NOT NULL,
  `language` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `site_configuration_languages`
--

INSERT INTO `site_configuration_languages` (`id`, `language`) VALUES
(1, 'Русский'),
(2, 'English');

-- --------------------------------------------------------

--
-- Table structure for table `site_configuration_languages_texts`
--

CREATE TABLE `site_configuration_languages_texts` (
  `id` int NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `russian` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  `english` text CHARACTER SET utf8 COLLATE utf8_general_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `site_configuration_languages_texts`
--

INSERT INTO `site_configuration_languages_texts` (`id`, `name`, `russian`, `english`) VALUES
(1, 'Welcome title', 'Добро пожаловать в чат!', 'Welcome to the chat!'),
(2, 'Settings', 'Настройки', 'Settings');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `site_configuration_background_colors`
--
ALTER TABLE `site_configuration_background_colors`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `site_configuration_languages`
--
ALTER TABLE `site_configuration_languages`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `site_configuration_languages_texts`
--
ALTER TABLE `site_configuration_languages_texts`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `site_configuration_background_colors`
--
ALTER TABLE `site_configuration_background_colors`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `site_configuration_languages`
--
ALTER TABLE `site_configuration_languages`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `site_configuration_languages_texts`
--
ALTER TABLE `site_configuration_languages_texts`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
