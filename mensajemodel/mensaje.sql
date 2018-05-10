-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 10-05-2018 a las 15:54:06
-- Versión del servidor: 5.7.19
-- Versión de PHP: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `mensaje`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `campana`
--

DROP TABLE IF EXISTS `campana`;
CREATE TABLE IF NOT EXISTS `campana` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `descripcion` varchar(500) DEFAULT NULL,
  `plantilla` text,
  `usuario` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IXFK_campana_usuario` (`usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `campana`
--

INSERT INTO `campana` (`id`, `nombre`, `descripcion`, `plantilla`, `usuario`) VALUES
(1, 'Prueba', 'Campaña de Prueba', '0', 'crangarita'),
(2, 'Campana 2', 'Campana de prueba 2', '0', 'crangarita'),
(3, 'PP', 'pp', 'pp', 'crangarita'),
(4, 'Prueba de ', 'Prueba de ', 'Bienvenido al curso de programacion de la Universidad Francisco de Paula Santander', 'crangarita'),
(5, 'Prueba de la campaña', 'dd', 'dd', 'crangarita'),
(6, 'Error en los datos de concepción', 'Guardando los datos en la base de datos', 'Este es un mensaje que se autodestruira en varios segundos despues', 'crangarita');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contacto`
--

DROP TABLE IF EXISTS `contacto`;
CREATE TABLE IF NOT EXISTS `contacto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `usuario` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IXFK_contacto_usuario` (`usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `contacto`
--

INSERT INTO `contacto` (`id`, `nombre`, `apellido`, `email`, `usuario`) VALUES
(15, 'Carlos Rene', 'Angarita Sanguino', 'crangarita@gmail.com', NULL),
(18, 'Pedro Gomez', '', 'elchacho@gmail.com', 'crangarita'),
(19, 'Camilo Caceres', '', 'cami@gmail.com', 'cygomez'),
(20, 'Carlos', 'Angarita', 'carlosreneas@ufps.edu.co', 'crangarita'),
(21, 'Juan', 'Ortega', 'juan@gmail.com', 'crangarita'),
(22, 'Juliana', 'Ortega', 'julianaandreaoc@ufps.edu.co', 'crangarita');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mensaje`
--

DROP TABLE IF EXISTS `mensaje`;
CREATE TABLE IF NOT EXISTS `mensaje` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `campana` int(11) DEFAULT NULL,
  `contacto` int(11) DEFAULT NULL,
  `fechaenvio` date DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `fechaapertura` date DEFAULT NULL,
  `ip` varchar(20) DEFAULT NULL,
  `navegador` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IXFK_mensaje_campana` (`campana`),
  KEY `IXFK_mensaje_contacto` (`contacto`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `mensaje`
--

INSERT INTO `mensaje` (`id`, `campana`, `contacto`, `fechaenvio`, `email`, `fechaapertura`, `ip`, `navegador`) VALUES
(1, 1, 15, NULL, 'crangarita@gmail.com', NULL, NULL, NULL),
(2, 2, 18, NULL, 'elchacho@gmail.com', NULL, NULL, NULL),
(3, 2, 19, NULL, 'cami@gmail.com', NULL, NULL, NULL),
(4, 1, 15, NULL, 'crangarita@gmail.com', NULL, NULL, NULL),
(5, 6, 20, '2018-05-10', 'carlosreneas@ufps.edu.co', NULL, NULL, NULL),
(6, 5, 20, '2018-05-10', 'carlosreneas@ufps.edu.co', NULL, NULL, NULL),
(7, 6, 22, '2018-05-10', 'julianaandreaoc@ufps.edu.co', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

DROP TABLE IF EXISTS `rol`;
CREATE TABLE IF NOT EXISTS `rol` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id`, `descripcion`) VALUES
(1, 'Usuarios');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `usuario` varchar(20) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `clave` varchar(50) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`usuario`, `email`, `clave`, `nombre`) VALUES
('crangarita', 'crangarita@gmail.com', '1234', 'Carlos Rene Angarita Sanguino'),
('cygomez', 'claudiayamilegomez@gmail.com', '1234', 'Claudia Yamile Gomez L');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuariorol`
--

DROP TABLE IF EXISTS `usuariorol`;
CREATE TABLE IF NOT EXISTS `usuariorol` (
  `rol` int(11) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  PRIMARY KEY (`rol`,`usuario`),
  KEY `IXFK_usuariorol_rol` (`rol`),
  KEY `IXFK_usuariorol_usuario` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuariorol`
--

INSERT INTO `usuariorol` (`rol`, `usuario`) VALUES
(1, 'crangarita');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `campana`
--
ALTER TABLE `campana`
  ADD CONSTRAINT `FK_campana_usuario` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `contacto`
--
ALTER TABLE `contacto`
  ADD CONSTRAINT `FK_contacto_usuario` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `mensaje`
--
ALTER TABLE `mensaje`
  ADD CONSTRAINT `FK_mensaje_campana` FOREIGN KEY (`campana`) REFERENCES `campana` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `mensaje_ibfk_1` FOREIGN KEY (`contacto`) REFERENCES `contacto` (`id`);

--
-- Filtros para la tabla `usuariorol`
--
ALTER TABLE `usuariorol`
  ADD CONSTRAINT `usuariorol_ibfk_1` FOREIGN KEY (`rol`) REFERENCES `rol` (`id`),
  ADD CONSTRAINT `usuariorol_ibfk_2` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`usuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
