-- Estos comentarios con la notacion '--' los ignora perfecto
DROP DATABASE IF EXISTS `springsp`;
CREATE DATABASE `springsp`;
-- Garantizando privilegios sobre el esquema
GRANT ALL PRIVILEGES ON springsp.* TO 'root'@'%' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON springsp.* TO 'root'@'localhost' IDENTIFIED BY '1234';
USE `springsp`;
-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: springsp
-- ------------------------------------------------------
-- Server version	8.0.17



--
-- Table structure for table `dummies`
--

DROP TABLE IF EXISTS `dummies`;
CREATE TABLE `dummies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dummy` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


--
-- Dumping data for table `dummies`
--

LOCK TABLES `dummies` WRITE;
INSERT INTO `dummies` VALUES (1,'dummy 1');
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) DEFAULT NULL,
  `apellido` varchar(40) DEFAULT NULL,
  `telefono` varchar(40) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(40) DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
INSERT INTO `usuarios` VALUES (19,'jese','chavez',NULL,'jesexxtesting@gmail.com','$argon2id$v=19$m=1024,t=1,p=1$PKlCIRhLfoh82Z0sIpG3Jg$oj4vxkuLQGLCSfFtqsyTUbfs8F79FcLeoUlUwUDFnso','ROLE_ADMIN',1),(20,'Luis','Gonzalez',NULL,'adipezzat9@gmail.com','$argon2id$v=19$m=1024,t=1,p=1$TNA15iJATwZwcRpl/BoPLQ$JmfYjqSq5i2BWDWxjObAKO0NFSIJBpk2/YwYarNhn1M','ROLE_SADMIN,ROLE_ADMIN',1),(21,'Testing','Test',NULL,'testing@gmail.com','$argon2id$v=19$m=1024,t=1,p=1$1hKT2DmdznSGHPD3rbBZ6A$16KcV1HgVG/odMcsUN0BXDgtUllPPCLnsJZ9KMQ20Yc','ROLE_USER',1);
UNLOCK TABLES;

--
-- Dumping events for database 'springsp'
--

--
-- Dumping routines for database 'springsp'
--


-- Dump completed on 2021-09-22  0:09:52
