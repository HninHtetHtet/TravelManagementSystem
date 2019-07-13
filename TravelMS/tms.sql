-- phpMyAdmin SQL Dump
-- version 4.0.9
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 04, 2018 at 09:50 AM
-- Server version: 5.6.14
-- PHP Version: 5.5.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `tms`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `aname` varchar(50) NOT NULL,
  `apassword` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`aname`, `apassword`) VALUES
('Chimpzs', 7777777);

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE IF NOT EXISTS `booking` (
  `number` int(11) NOT NULL AUTO_INCREMENT,
  `car1` int(11) NOT NULL,
  `car2` int(11) NOT NULL,
  `car3` int(11) NOT NULL,
  `car4` int(11) NOT NULL,
  PRIMARY KEY (`number`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=46 ;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`number`, `car1`, `car2`, `car3`, `car4`) VALUES
(1, 0, 0, 0, 0),
(2, 0, 0, 0, 0),
(3, 0, 0, 0, 0),
(4, 1, 0, 0, 0),
(5, 0, 0, 0, 0),
(6, 0, 0, 0, 0),
(7, 0, 0, 0, 0),
(8, 1, 0, 0, 0),
(9, 0, 0, 0, 0),
(10, 0, 0, 0, 0),
(11, 0, 0, 0, 0),
(12, 1, 0, 0, 0),
(13, 0, 0, 0, 0),
(14, 0, 0, 0, 0),
(15, 0, 0, 0, 0),
(16, 1, 0, 0, 0),
(17, 0, 0, 0, 0),
(18, 0, 0, 0, 0),
(19, 0, 0, 0, 0),
(20, 0, 0, 0, 0),
(21, 0, 0, 0, 0),
(22, 0, 0, 0, 0),
(23, 0, 0, 0, 0),
(24, 0, 0, 0, 0),
(25, 0, 0, 0, 0),
(26, 0, 0, 0, 0),
(27, 0, 0, 0, 0),
(28, 0, 0, 0, 0),
(29, 0, 0, 0, 0),
(30, 0, 0, 0, 0),
(31, 0, 0, 0, 0),
(32, 0, 0, 0, 0),
(33, 0, 0, 0, 0),
(34, 0, 0, 0, 0),
(35, 0, 0, 0, 0),
(36, 0, 0, 0, 0),
(37, 0, 0, 0, 0),
(38, 0, 0, 0, 0),
(39, 0, 0, 0, 0),
(40, 0, 0, 0, 0),
(41, 0, 0, 0, 0),
(42, 0, 0, 0, 0),
(43, 0, 0, 0, 0),
(44, 0, 0, 0, 0),
(45, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `calender`
--

CREATE TABLE IF NOT EXISTS `calender` (
  `Place` varchar(100) NOT NULL,
  `Year` int(5) NOT NULL,
  `Month` varchar(15) NOT NULL,
  `Day` int(5) NOT NULL,
  `car1` varchar(50) NOT NULL,
  `car2` varchar(50) NOT NULL,
  `Seat_num` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `calender`
--

INSERT INTO `calender` (`Place`, `Year`, `Month`, `Day`, `car1`, `car2`, `Seat_num`) VALUES
('null', 2018, 'August', 1, '0', '102', 0);

-- --------------------------------------------------------

--
-- Table structure for table `expenses`
--

CREATE TABLE IF NOT EXISTS `expenses` (
  `Single` int(11) NOT NULL,
  `Double` int(11) NOT NULL,
  `Family` int(11) NOT NULL,
  `VIP` int(11) NOT NULL,
  `Total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `expenses`
--

INSERT INTO `expenses` (`Single`, `Double`, `Family`, `VIP`, `Total`) VALUES
(0, 55000, 0, 0, 55000),
(45000, 220000, 140000, 510000, 915000),
(0, 55000, 280000, 0, 335000),
(270000, 0, 0, 0, 270000),
(0, 220000, 0, 0, 220000),
(0, 0, 0, 425000, 425000),
(0, 0, 0, 0, 0),
(0, 0, 0, 0, 0),
(0, 0, 0, 0, 0),
(0, 0, 0, 0, 0),
(0, 0, 0, 0, 0),
(0, 0, 0, 0, 0),
(0, 0, 0, 0, 0),
(0, 0, 0, 0, 0),
(0, 0, 0, 0, 0),
(0, 0, 0, 0, 0),
(0, 275000, 0, 0, 275000),
(270000, 0, 0, 0, 270000),
(135000, 0, 0, 0, 135000),
(0, 0, 0, 0, 0),
(0, 0, 0, 0, 0),
(0, 0, 0, 0, 0),
(0, 0, 0, 0, 0),
(0, 0, 0, 0, 0),
(45000, 0, 0, 0, 45000),
(0, 0, 0, 0, 0),
(0, 0, 0, 0, 0),
(0, 0, 0, 0, 0),
(0, 0, 0, 0, 0),
(0, 0, 0, 0, 0),
(90000, 0, 0, 0, 90000),
(90000, 0, 0, 0, 90000),
(45000, 0, 0, 0, 45000),
(90000, 0, 0, 0, 90000),
(45000, 0, 0, 0, 45000),
(0, 275000, 0, 0, 275000),
(0, 110000, 0, 0, 110000),
(0, 110000, 0, 0, 110000),
(0, 165000, 0, 0, 165000),
(90000, 0, 0, 0, 90000),
(0, 165000, 0, 0, 165000),
(180000, 0, 0, 0, 180000),
(45000, 0, 0, 0, 45000),
(45000, 0, 0, 0, 45000),
(45000, 0, 0, 0, 45000),
(45000, 0, 0, 0, 45000),
(0, 165000, 0, 0, 165000),
(0, 165000, 0, 0, 165000),
(45000, 0, 0, 0, 45000),
(0, 55000, 0, 0, 55000),
(0, 0, 140000, 0, 140000),
(45000, 0, 0, 0, 45000),
(45000, 0, 0, 0, 45000),
(45000, 0, 0, 0, 45000),
(45000, 0, 0, 0, 45000),
(0, 0, 420000, 0, 420000),
(0, 275000, 0, 0, 275000),
(0, 330000, 0, 0, 330000),
(0, 275000, 0, 0, 275000),
(0, 110000, 0, 0, 110000),
(90000, 0, 0, 0, 90000),
(45000, 0, 0, 0, 45000),
(45000, 0, 0, 0, 45000),
(45000, 0, 0, 0, 45000),
(45000, 0, 0, 0, 45000),
(0, 275000, 0, 0, 275000),
(0, 275000, 0, 0, 275000),
(0, 220000, 0, 0, 220000),
(90000, 0, 0, 0, 90000),
(0, 330000, 0, 0, 330000),
(0, 165000, 0, 0, 165000),
(0, 220000, 0, 0, 220000),
(0, 275000, 0, 0, 275000),
(0, 330000, 0, 0, 330000),
(0, 110000, 0, 0, 110000),
(135000, 0, 0, 0, 135000),
(0, 110000, 0, 0, 110000),
(0, 275000, 0, 0, 275000),
(225000, 0, 0, 0, 225000),
(90000, 0, 0, 0, 90000),
(0, 220000, 0, 0, 220000),
(45000, 0, 0, 0, 45000),
(45000, 0, 0, 0, 45000),
(0, 55000, 0, 0, 55000),
(0, 110000, 0, 0, 110000),
(0, 110000, 0, 0, 110000);

-- --------------------------------------------------------

--
-- Table structure for table `message`
--

CREATE TABLE IF NOT EXISTS `message` (
  `msg` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `message`
--

INSERT INTO `message` (`msg`) VALUES
(' wow'),
(' Awsome'),
(' Great'),
(' Wow');

-- --------------------------------------------------------

--
-- Table structure for table `real`
--

CREATE TABLE IF NOT EXISTS `real` (
  `name` varchar(50) NOT NULL,
  `password` varchar(30) NOT NULL,
  `phone` int(11) NOT NULL,
  `address` varchar(100) NOT NULL,
  `gender` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `real`
--

INSERT INTO `real` (`name`, `password`, `phone`, `address`, `gender`) VALUES
('Yu', '999', 111, 'addffaa', 'Female');

-- --------------------------------------------------------

--
-- Table structure for table `up`
--

CREATE TABLE IF NOT EXISTS `up` (
  `name` varchar(20) DEFAULT NULL,
  `msg` varchar(1000) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `phone` int(15) DEFAULT NULL,
  `address` varchar(40) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `Place` varchar(50) DEFAULT NULL,
  `Year` int(50) DEFAULT NULL,
  `Month` varchar(50) DEFAULT NULL,
  `Day` int(50) DEFAULT NULL,
  `car1` int(100) DEFAULT NULL,
  `car2` int(100) DEFAULT NULL,
  `Seat_num` int(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `up`
--

INSERT INTO `up` (`name`, `msg`, `password`, `phone`, `address`, `gender`, `Place`, `Year`, `Month`, `Day`, `car1`, `car2`, `Seat_num`) VALUES
('Zayar', NULL, '123', 9123, 'TKT', 'Male', 'Bagan', 2018, 'April', 13, 18, 0, 1),
('Hnin', NULL, '333', 92343334, 'Yangon', 'Male', 'Bagan', 2018, 'April', 13, 206, 0, 2),
('Phyo', NULL, '555', 9344534, 'Yangon', 'Male', 'Taunggyi', 2018, 'May', 1, 31314, 0, 3),
('Yuya', NULL, '111', 46666, 'Yangon', 'Female', 'Bagan', 2018, 'May', 1, 4081216, 0, 4);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
