-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.27-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.3.0.6589
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para sistemadeportivo
CREATE DATABASE IF NOT EXISTS `sistemadeportivo` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `sistemadeportivo`;

-- Volcando estructura para tabla sistemadeportivo.rol
CREATE TABLE IF NOT EXISTS `rol` (
  `id_rol` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_rol`),
  KEY `fk_rol_usuario` (`id_usuario`),
  CONSTRAINT `fk_rol_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla sistemadeportivo.rol: ~1 rows (aproximadamente)
INSERT INTO `rol` (`id_rol`, `nombre`, `id_usuario`) VALUES
	(20, 'ROLE_ADMIN', 14);

-- Volcando estructura para tabla sistemadeportivo.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(512) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellidos` varchar(30) NOT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `direccion` varchar(1024) DEFAULT NULL,
  `direccion2` varchar(1024) DEFAULT NULL,
  `provincia` varchar(50) DEFAULT NULL,
  `canton` varchar(50) DEFAULT NULL,
  `distrito` varchar(50) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `ruta_imagen` varchar(4086) DEFAULT NULL,
  `activo` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla sistemadeportivo.usuario: ~1 rows (aproximadamente)
INSERT INTO `usuario` (`id_usuario`, `username`, `password`, `nombre`, `apellidos`, `correo`, `direccion`, `direccion2`, `provincia`, `canton`, `distrito`, `telefono`, `ruta_imagen`, `activo`) VALUES
	(14, 'admin', '$2a$10$uvXo9LicQy8bp8YHXLUuo.CWVgVCSuLZYr6k7gD6gTAghcx9tSqya', 'Maria', 'Sanchez ffff', 'doohansol@gmail.com', 'asdasd dd', 'dasd', 'dasdas', 'asdas', 'asd', '62764366', NULL, 1),
	(16, 'as', '', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
