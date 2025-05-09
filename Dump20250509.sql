-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: shoppingdb
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `items` (
  `id` int NOT NULL,
  `pname` varchar(100) DEFAULT NULL,
  `price` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES (1,'tomato',30),(2,'carrot',20),(3,'potato',20),(4,'beetroot',20),(5,'ladies finger',25),(6,'cabbage',15),(7,'califlower',25),(8,'pumpkin',30),(9,'drum stick',7),(10,'raddish',27),(11,'apple',10),(12,'banana',5),(13,'sweet corn',25),(14,'pine apple',40),(15,'dragon fruit',106),(16,'strawberry',86),(17,'cherry',55),(18,'orange',7),(19,'custard apple',45),(23,'mobile',25000),(78,'soap',30),(90,'laptop',100000),(100,'coconut',10),(121,'Laptop',100000);
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` int DEFAULT NULL,
  `pname` varchar(100) DEFAULT NULL,
  `qty` int DEFAULT NULL,
  `price` int DEFAULT NULL,
  `totalPrice` int DEFAULT NULL,
  `purchaseDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'tomato',2,30,60,'2024-11-19'),(19,'custard apple',5,45,225,'2024-11-19'),(1,'tomato',2,30,60,'2024-11-19'),(1,'tomato',2,30,60,'2024-11-19'),(2,'carrot',3,20,60,'2024-11-19'),(1,'tomato',2,30,60,'2024-11-19'),(9,'drum stick',2,7,14,'2024-11-19'),(3,'potato',5,20,100,'2024-11-19'),(10,'raddish',4,27,108,'2024-11-19'),(11,'apple',5,10,50,'2024-11-19'),(100,'coconut',2,10,20,'2024-11-19'),(11,'apple',20,10,200,'2024-11-29'),(78,'soap',2,30,60,'2024-11-29'),(1,'tomato',10,30,300,'2024-11-29'),(2,'carrot',5,20,100,'2024-11-29'),(12,'banana',6,5,30,'2024-11-29'),(9,'drum stick',5,7,35,'2024-11-29'),(18,'orange',10,7,70,'2024-11-29'),(1,'tomato',5,30,150,'2024-11-30'),(8,'pumpkin',2,30,60,'2024-11-30'),(4,'beetroot',3,20,60,'2024-11-30'),(90,'laptop',1,100000,100000,'2024-11-30'),(23,'mobile',1,25000,25000,'2024-11-30'),(1,'tomato',12,30,360,'2024-12-17'),(2,'carrot',6,20,120,'2024-12-17'),(18,'orange',3,7,21,'2024-12-17'),(78,'soap',3,30,90,'2024-12-17'),(121,'Laptop',1,100000,100000,'2024-12-17');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-09 18:33:50
