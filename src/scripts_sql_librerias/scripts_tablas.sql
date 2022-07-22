/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  hueck
 * Created: 14/07/2022
 */

-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-07-2022 a las 04:12:01
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_elecciones`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_candidatos`
--

CREATE TABLE `tbl_candidatos` (
  `id_candidato` varchar(25) NOT NULL,
  `tipo_documento` varchar(40) NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `partido_politico` varchar(40) NOT NULL,
  `ciudad_origen` varchar(40) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `mensaje_campania` varchar(100) NOT NULL,
  `propuestas` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tbl_candidatos`
--

INSERT INTO `tbl_candidatos` (`id_candidato`, `tipo_documento`, `nombre`, `telefono`, `correo`, `partido_politico`, `ciudad_origen`, `descripcion`, `mensaje_campania`, `propuestas`) VALUES
('1130633378', 'Cedula Ciudadania', 'Jairo Davila', '3166331032', 'hoh@hos.com', 'Conservador', 'Cali', 'Candidato Flojo', 'Pesimo', '[Mejorar Educación, Mejorar Salud, Reducir Iva]');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_elecciones`
--

CREATE TABLE `tbl_elecciones` (
  `id_eleccion` varchar(10) NOT NULL,
  `descripcion` varchar(400) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  `fecha_insert` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_votantes`
--

CREATE TABLE `tbl_votantes` (
  `id_votante` varchar(25) NOT NULL,
  `tipo_documento` varchar(40) NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  `correo` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tbl_votantes`
--

INSERT INTO `tbl_votantes` (`id_votante`, `tipo_documento`, `nombre`, `telefono`, `correo`) VALUES
('1130633378', 'Cedula Ciudadania', 'Jairo Davila', '3166331032', 'hueckham@gmail.com'),
('1130633379', 'Cedula Ciudadania', 'Jairo', '3166331032', 'Hueckham@gmail.com'),
('1130633380', 'Cedula Ciudadania', 'Jairo Davila', '3166331032', 'jose@ho.com'),
('11633002', 'Cedula Ciudadania', 'carlos Mol', '3166331032', 'jose@jose.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_votos`
--

CREATE TABLE `tbl_votos` (
  `id_voto` int(10) NOT NULL,
  `id_eleccion` varchar(25) NOT NULL,
  `id_candidato` varchar(25) NOT NULL,
  `id_votante` varchar(25) NOT NULL,
  `fecha_voto` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tbl_candidatos`
--
ALTER TABLE `tbl_candidatos`
  ADD PRIMARY KEY (`id_candidato`);

--
-- Indices de la tabla `tbl_elecciones`
--
ALTER TABLE `tbl_elecciones`
  ADD PRIMARY KEY (`id_eleccion`);

--
-- Indices de la tabla `tbl_votantes`
--
ALTER TABLE `tbl_votantes`
  ADD PRIMARY KEY (`id_votante`);

--
-- Indices de la tabla `tbl_votos`
--
ALTER TABLE `tbl_votos`
  ADD PRIMARY KEY (`id_voto`),
  ADD KEY `fk_id_candidato` (`id_candidato`),
  ADD KEY `fk_id_votante` (`id_votante`),
  ADD KEY `fk_id_eleccion` (`id_eleccion`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tbl_votos`
--
ALTER TABLE `tbl_votos`
  MODIFY `id_voto` int(10) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tbl_votos`
--
ALTER TABLE `tbl_votos`
  ADD CONSTRAINT `fk_id_candidato` FOREIGN KEY (`id_candidato`) REFERENCES `tbl_candidatos` (`id_candidato`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_id_eleccion` FOREIGN KEY (`id_eleccion`) REFERENCES `tbl_elecciones` (`id_eleccion`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_id_votante` FOREIGN KEY (`id_votante`) REFERENCES `tbl_votantes` (`id_votante`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
