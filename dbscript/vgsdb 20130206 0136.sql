-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.28-rc-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema vgsdb
--

CREATE DATABASE IF NOT EXISTS vgsdb;
USE vgsdb;

--
-- Definition of table `addresstbl`
--

DROP TABLE IF EXISTS `addresstbl`;
CREATE TABLE `addresstbl` (
  `addressId` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `line1` varchar(45) DEFAULT NULL,
  `line2` varchar(45) DEFAULT NULL,
  `area` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `pincode` varchar(45) DEFAULT NULL,
  `contactNo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`addressId`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `addresstbl`
--

/*!40000 ALTER TABLE `addresstbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `addresstbl` ENABLE KEYS */;


--
-- Definition of table `membertbl`
--

DROP TABLE IF EXISTS `membertbl`;
CREATE TABLE `membertbl` (
  `personId` bigint(20) unsigned NOT NULL,
  `parentId` bigint(20) unsigned NOT NULL,
  `relationshipId` bigint(20) unsigned NOT NULL,
  KEY `relationId_idx` (`relationshipId`),
  KEY `secondP` (`parentId`) USING BTREE,
  KEY `personId_idx` (`personId`),
  CONSTRAINT `FK_membertbl_parent` FOREIGN KEY (`parentId`) REFERENCES `persontbl` (`personId`) ON DELETE CASCADE,
  CONSTRAINT `FK_membertbl_person` FOREIGN KEY (`personId`) REFERENCES `persontbl` (`personId`) ON DELETE CASCADE,
  CONSTRAINT `FK_membertbl_relation` FOREIGN KEY (`relationshipId`) REFERENCES `relationshiptbl` (`relationshipId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `membertbl`
--

/*!40000 ALTER TABLE `membertbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `membertbl` ENABLE KEYS */;


--
-- Definition of table `persontbl`
--

DROP TABLE IF EXISTS `persontbl`;
CREATE TABLE `persontbl` (
  `personId` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `fname` varchar(45) NOT NULL,
  `mname` varchar(45) DEFAULT NULL,
  `lname` varchar(45) NOT NULL,
  `voterid` varchar(45) DEFAULT NULL,
  `gender` varchar(45) NOT NULL,
  `dob` datetime DEFAULT NULL,
  `bloodgroup` varchar(45) DEFAULT NULL,
  `localAdd` bigint(20) unsigned DEFAULT NULL,
  `perAdd` bigint(20) unsigned DEFAULT NULL,
  `education` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `occupation` varchar(45) DEFAULT NULL,
  `orgname` varchar(45) DEFAULT NULL,
  `pancard` varchar(45) DEFAULT NULL,
  `rationcard` varchar(45) DEFAULT NULL,
  `seniorcitizen` tinyint(1) unsigned DEFAULT NULL,
  `adharcard` varchar(45) DEFAULT NULL,
  `onrent` tinyint(1) unsigned DEFAULT NULL,
  `ownerfname` varchar(45) DEFAULT NULL,
  `ownerlname` varchar(45) DEFAULT NULL,
  `ownercontact` bigint(20) unsigned DEFAULT NULL,
  `owneroccupation` varchar(45) DEFAULT NULL,
  `chairperson` tinyint(1) DEFAULT NULL,
  `formno` varchar(45) DEFAULT NULL,
  `byUser` bigint(20) unsigned DEFAULT NULL,
  `contact` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`personId`),
  KEY `localAdd_idx` (`localAdd`,`perAdd`,`byUser`),
  KEY `byUser_idx` (`byUser`),
  KEY `FK_persontbl_perAdd` (`perAdd`),
  CONSTRAINT `FK_persontbl_usertbl` FOREIGN KEY (`byUser`) REFERENCES `usertbl` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_persontbl_localAdd` FOREIGN KEY (`localAdd`) REFERENCES `addresstbl` (`addressId`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_persontbl_perAdd` FOREIGN KEY (`perAdd`) REFERENCES `addresstbl` (`addressId`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `persontbl`
--

/*!40000 ALTER TABLE `persontbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `persontbl` ENABLE KEYS */;


--
-- Definition of table `relationshiptbl`
--

DROP TABLE IF EXISTS `relationshiptbl`;
CREATE TABLE `relationshiptbl` (
  `relationshipId` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `relation` varchar(45) NOT NULL,
  PRIMARY KEY (`relationshipId`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `relationshiptbl`
--

/*!40000 ALTER TABLE `relationshiptbl` DISABLE KEYS */;
INSERT INTO `relationshiptbl` (`relationshipId`,`relation`) VALUES 
 (1,'Father'),
 (2,'Mother'),
 (3,'Husband '),
 (4,'Wife'),
 (5,'Brother'),
 (6,'Sister'),
 (7,'Son'),
 (8,'Daughter'),
 (9,'Grandfather'),
 (10,'Grandmother'),
 (11,'Grandson'),
 (12,'Granddaughter'),
 (13,'Aunty'),
 (14,'Uncle '),
 (15,'Nephew'),
 (16,'Niece '),
 (17,'Father-In-Law'),
 (18,'Mother-In-Law'),
 (19,'Son-In-Law'),
 (20,'Daughter-In-Law'),
 (21,'Sister-In-Law'),
 (22,'Brother-In-Law');
/*!40000 ALTER TABLE `relationshiptbl` ENABLE KEYS */;


--
-- Definition of table `usertbl`
--

DROP TABLE IF EXISTS `usertbl`;
CREATE TABLE `usertbl` (
  `userId` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usertbl`
--

/*!40000 ALTER TABLE `usertbl` DISABLE KEYS */;
INSERT INTO `usertbl` (`userId`,`username`,`password`,`role`) VALUES 
 (2,'editor','editor','editor');
/*!40000 ALTER TABLE `usertbl` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
