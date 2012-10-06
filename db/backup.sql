-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.24 - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL version:             7.0.0.4053
-- Date/time:                    2012-10-06 15:21:42
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;

-- Dumping database structure for test
DROP DATABASE IF EXISTS `test`;
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `test`;


-- Dumping structure for table test.personaje
DROP TABLE IF EXISTS `personaje`;
CREATE TABLE IF NOT EXISTS `personaje` (
  `per_id` int(11) NOT NULL AUTO_INCREMENT,
  `per_value` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`per_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table test.personaje: ~2 rows (approximately)
/*!40000 ALTER TABLE `personaje` DISABLE KEYS */;
INSERT INTO `personaje` (`per_id`, `per_value`) VALUES
	(1, 'Erza'),
	(2, 'Lissana');
/*!40000 ALTER TABLE `personaje` ENABLE KEYS */;
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
