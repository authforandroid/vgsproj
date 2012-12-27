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
  `addressId` int(20) NOT NULL AUTO_INCREMENT,
  `line1` varchar(45) DEFAULT NULL,
  `line2` varchar(45) DEFAULT NULL,
  `area` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `pincode` varchar(45) DEFAULT NULL,
  `contactNo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`addressId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `personId` int(20) unsigned NOT NULL,
  `parentId` int(20) unsigned NOT NULL,
  `relationshipId` int(20) unsigned NOT NULL,
  KEY `relationId_idx` (`relationshipId`),
  KEY `secondP` (`parentId`) USING BTREE,
  KEY `personId_idx` (`personId`),
  CONSTRAINT `parentId` FOREIGN KEY (`parentId`) REFERENCES `persontbl` (`personId`) ON DELETE CASCADE,
  CONSTRAINT `personId` FOREIGN KEY (`personId`) REFERENCES `persontbl` (`personId`) ON DELETE CASCADE,
  CONSTRAINT `relationId` FOREIGN KEY (`relationshipId`) REFERENCES `relationshiptbl` (`relationshipId`) ON DELETE CASCADE
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
  `personId` int(20) unsigned NOT NULL,
  `fname` varchar(45) NOT NULL,
  `mname` varchar(45) DEFAULT NULL,
  `lname` varchar(45) NOT NULL,
  `voterid` varchar(45) DEFAULT NULL,
  `gender` varchar(45) NOT NULL,
  `dob` datetime DEFAULT NULL,
  `bloodgroup` varchar(45) DEFAULT NULL,
  `localAdd` int(20) DEFAULT NULL,
  `perAdd` int(20) DEFAULT NULL,
  `education` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `occupation` varchar(45) DEFAULT NULL,
  `orgname` varchar(45) DEFAULT NULL,
  `pancard` varchar(45) DEFAULT NULL,
  `rationcard` varchar(45) DEFAULT NULL,
  `seniorcitizen` tinyint(4) DEFAULT NULL,
  `adharcard` varchar(45) DEFAULT NULL,
  `onrent` tinyint(1) DEFAULT NULL,
  `ownerfname` varchar(45) DEFAULT NULL,
  `ownerlname` varchar(45) DEFAULT NULL,
  `ownercontact` int(20) DEFAULT NULL,
  `owneroccupation` varchar(45) DEFAULT NULL,
  `chairperson` tinyint(1) DEFAULT NULL,
  `formno` varchar(45) DEFAULT NULL,
  `byUser` int(20) DEFAULT NULL,
  `contact` int(20) DEFAULT NULL,
  PRIMARY KEY (`personId`),
  KEY `localAdd_idx` (`localAdd`,`perAdd`,`byUser`),
  KEY `byUser_idx` (`byUser`),
  KEY `perAdd` (`perAdd`),
  CONSTRAINT `byUser` FOREIGN KEY (`byUser`) REFERENCES `usertbl` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `localAdd` FOREIGN KEY (`localAdd`) REFERENCES `addresstbl` (`addressId`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `perAdd` FOREIGN KEY (`perAdd`) REFERENCES `addresstbl` (`addressId`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `relationshipId` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `relation` varchar(45) NOT NULL,
  PRIMARY KEY (`relationshipId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `relationshiptbl`
--

/*!40000 ALTER TABLE `relationshiptbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `relationshiptbl` ENABLE KEYS */;


--
-- Definition of table `usertbl`
--

DROP TABLE IF EXISTS `usertbl`;
CREATE TABLE `usertbl` (
  `userId` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usertbl`
--

/*!40000 ALTER TABLE `usertbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `usertbl` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
