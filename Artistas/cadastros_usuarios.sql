-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: cadastros
-- ------------------------------------------------------
-- Server version	8.0.42

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
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `CPF` varchar(11) NOT NULL DEFAULT '',
  `sexo` enum('M','F') NOT NULL,
  `nascimento` date NOT NULL,
  `email` varchar(60) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `biografia` varchar(500) DEFAULT NULL,
  `contato_artista` varchar(20) DEFAULT NULL,
  `local_exposicao` varchar(100) NOT NULL,
  `tipo_arte` varchar(255) DEFAULT NULL,
  `nome` varchar(60) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_cpf` (`CPF`),
  UNIQUE KEY `uk_email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'33344455566','F','1990-11-05','ana.naif@artista.com','123456','Artista independente do interior do Piauí.','(86) 91234-5678','Feira de Artesanato de Piripiri','Pintura Naïf','Ana Souza'),(2,'11122233344','F','1985-03-15','maria.cordel@artista.com','senha1234','Mestre cordelista e xilogravurista de Teresina, transformando histórias do sertão em arte.','(86) 99999-1111','Feira do Livro de Teresina','Cordel Ilustrado','Maria Silva'),(3,'22233344455','M','1978-07-22','ze.barro@artista.com','barro1234','Ceramista de Oeiras, criando peças que contam a história do Piauí através do barro.','(89) 98888-2222','Mercado Velho de Teresina','Cerâmica Artesanal','José Oliveira'),(4,'44455566677','M','1995-02-18','carlos.digital@artista.com','digital123','Artista visual de Floriano, misturando cultura piauiense com arte digital.','(89) 96666-4444','Festival Pixel Nordeste','Arte Digital','Carlos Rocha'),(5,'55566677788','M','1982-09-30','chico.barroco@artista.com','barroco123','Escultor de Amarante, trazendo o barroco europeu para o sertão nordestino.','(86) 95555-5555','Museu do Piauí','Barroco Nordestino','Francisco Lima');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-07 18:44:09
