-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: oms
-- ------------------------------------------------------
-- Server version	5.7.24

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
-- Table structure for table `orders`
--
use heroku_3df6df86eecc364;

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `ORDER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CUSTOMER_NAME` varchar(55) NOT NULL,
  `ORDER` varchar(55) NOT NULL,
  `DELIVERY_DATE` varchar(55) NOT NULL,
  `DELIVERY_PRICE` float NOT NULL,
  `PAYMENT` varchar(45) NOT NULL,
  `DELIVERY_STATUS` varchar(20) NOT NULL,
  PRIMARY KEY (`ORDER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'George Silve','Nike','12/12/2020',200,'PayPal','SHIPPED'),(2,'Olivia Canales','Adidas','2/12/2021',2506,'Bank Transfer','IN_PROGRESS'),(3,'Jonathan Oscarvarian','Skate Warehouse','10/15/2021',31,'PayPal','COMPLETE'),(4,'Jose Ramierez','Zumiez','1/13/2022',654,'Credit Card','PENDING_PAYMENT'),(5,'Slyvia Tilly','Shoe Me','6/10/2021',11,'Check','CANCELED'),(6,'Jeffrey Daumer','Sharper Knives','1/01/1970',1,'Cash','COMPLETE'),(7,'Jessica Shoestrings','Laces Out','5/30/2022',254,'PayPal','IN_PROGRESS');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pictures`
--

DROP TABLE IF EXISTS `pictures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `pictures` (
  `PICTURE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `PICTURE_LABEL` varchar(45) CHARACTER SET utf8 NOT NULL,
  `PICTURE_URL` varchar(500) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`PICTURE_ID`),
  CONSTRAINT `USER_ID` FOREIGN KEY (`PICTURE_ID`) REFERENCES `user` (`USER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pictures`
--

LOCK TABLES `pictures` WRITE;
/*!40000 ALTER TABLE `pictures` DISABLE KEYS */;
INSERT INTO `pictures` VALUES (1,'Warren\'s Cover Photo','https://scontent.fhio2-2.fna.fbcdn.net/v/t31.18172-8/21125545_10155061507233668_1883906338078193273_o.jpg?_nc_cat=104&ccb=1-5&_nc_sid=09cbfe&_nc_ohc=8eGcQyYXkxoAX_x-uRW&_nc_ht=scontent.fhio2-2.fna&oh=00_AT9Ks0pcLNyYRm1iKZQMd4_20UiThZ2R2cyZtuTkxr1PPg&oe=621BABE6');
/*!40000 ALTER TABLE `pictures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productimage`
--

DROP TABLE IF EXISTS `productimage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `productimage` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PRODUCT_IMAGE_NAME` varchar(45) NOT NULL,
  `PRODUCT_IMAGE_URL` varchar(555) NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `PRODUCT_ID` FOREIGN KEY (`ID`) REFERENCES `products` (`PRODUCT_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productimage`
--

LOCK TABLES `productimage` WRITE;
/*!40000 ALTER TABLE `productimage` DISABLE KEYS */;
/*!40000 ALTER TABLE `productimage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `PRODUCT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `PRODUCT_NAME` varchar(45) NOT NULL,
  `BRAND` varchar(45) NOT NULL,
  `DETAILS` varchar(500) NOT NULL,
  `PRODUCT_PRICE` float NOT NULL,
  `COLOR` varchar(25) NOT NULL,
  PRIMARY KEY (`PRODUCT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Air Jordan 1','Nike','1985',22300,'red'),(2,'Air Force 1','Nike','1982',9900,'white'),(3,'Chuck Taylor All Star','Converse','1923',100000,'black'),(4,'Dunk','Nike','1986',5491,'blue'),(5,'Superstar/Pro Model','Adidas','1965',129,'white'),(6,'Tiger Corsair','Onitsuka','1969',690,'white'),(7,'Air Max 1','Nike','1987',3000,'white'),(8,'Suede/Clyde','Puma','1973',200,'blue'),(9,'Air Jordan 3','Nike','1988',800,'white'),(10,'Stan Smith','Adidas','1971',1390,'white'),(11,'Tennis 84','Gucci','1984',1500,'white'),(12,'Samba','Adidas','1950',975,'white'),(13,'Half Cab','Vans','1992',600,'black'),(14,'Air Trainer 1','Nike','1987',350,'gray'),(15,'Ex-O-Fit','Reebok','1983',90,'white'),(16,'Pump','Reebok','1989',800,'white'),(17,'Air Huarache','Nike','1991',450,'white'),(18,'Lava Dome','Nike','1981',130,'white'),(19,'576','New Balance','1988',894,'blue'),(20,'BapeSTA','A Bathing Ape','2002',861,'black'),(21,'Air Jordan 5','Nike','1990',5000,'white'),(22,'Air Jordan 11','Nike','1995',10000,'black'),(23,'Air Jordan 4','Nike','1989',4500,'black'),(24,'D3','Osiris','2001',325,'yellow'),(25,'Air Foamposite','Nike','1997',350,'blue');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(60) NOT NULL,
  `FIRST_NAME` varchar(60) NOT NULL,
  `LAST_NAME` varchar(60) NOT NULL,
  `ADDRESS` varchar(255) NOT NULL,
  `CITY` varchar(45) NOT NULL,
  `STATE` varchar(25) NOT NULL,
  `ZIP` varchar(10) NOT NULL,
  `EMAIL` varchar(255) NOT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  `BUSINESS_NAME` varchar(255) NOT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'WarrenGSlice','Warren','Peterson','2146 NW Hoyt St','Portland','OR','97210','WarrenPeterson141414@Gmail.com','Techn9ne','Nike');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-11 14:06:57
