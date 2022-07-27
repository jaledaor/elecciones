-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-07-2022 a las 22:11:46
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
  `mensaje_campania` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tbl_candidatos`
--

INSERT INTO `tbl_candidatos` (`id_candidato`, `tipo_documento`, `nombre`, `telefono`, `correo`, `partido_politico`, `ciudad_origen`, `descripcion`, `mensaje_campania`) VALUES
('11010101', 'Cedula Ciudadania', 'Gustavo Pineda', '4442044', 'gustavo@gmail.com', 'Liberal', 'Armenia', 'candidato 1', 'ganaremos! $'),
('11010102', 'Cedula Ciudadania', 'Carlos Moreno', '4442041', 'cmoreno@gmail.com', 'Pacto Historico', 'Manizales', 'Candidato 2	', 'Por el $'),
('11010103', 'Cedula Ciudadania', 'Jose Parra', '6855555', 'jose@aol.com', 'Polo', 'Manizales', 'Hola	', 'Good Bye!'),
('11010104', 'Cedula Ciudadania', 'Jose Pino', '4895555', 'jpino@gmail.com', 'Centro Demoniaco', 'Santa Marta', 'Candidato 3', 'movimiento ciudadano'),
('11010106', 'Cedula Ciudadania', 'Pedro Castillo', '4444444', 'pcas@gmail.com', 'Pacto Historico', 'Bogotá', 'Ganar		', 'ganare'),
('11010107', 'Cedula Ciudadania', 'Jimena Perez', '4895555', 'jime@hotmail.com', 'Liberal', 'Manizales', 'Hola		', 'zzz'),
('11010110', 'Cedula Ciudadania', 'Renato Rangel', '4895555', 'renato@hotmail.com', 'Polo', 'Pereira', 'en vivo!', 'Menos petroleo!'),
('1589669', 'Cedula Ciudadania', 'Carlos Quintero', '4895555', 'cquintero@gmail.com', 'Conservador', 'Barranquilla', 'aa', 'aa');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_candidato_por_eleccion`
--

CREATE TABLE `tbl_candidato_por_eleccion` (
  `id_candidato` varchar(25) NOT NULL,
  `id_eleccion` varchar(100) NOT NULL,
  `fecha_ins` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tbl_candidato_por_eleccion`
--

INSERT INTO `tbl_candidato_por_eleccion` (`id_candidato`, `id_eleccion`, `fecha_ins`) VALUES
('11010101', '2022-Municipal-12A', '2022-07-27'),
('11010102', '2022-Municipal-12A', '2022-07-27');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_elecciones`
--

CREATE TABLE `tbl_elecciones` (
  `id_eleccion` varchar(100) NOT NULL,
  `descripcion` varchar(400) NOT NULL,
  `categoria` varchar(100) NOT NULL,
  `estado` varchar(20) NOT NULL,
  `fecha_inicio` varchar(20) NOT NULL,
  `fecha_fin` varchar(20) NOT NULL,
  `fecha_insert` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tbl_elecciones`
--

INSERT INTO `tbl_elecciones` (`id_eleccion`, `descripcion`, `categoria`, `estado`, `fecha_inicio`, `fecha_fin`, `fecha_insert`) VALUES
('2022-Municipal-12A', '12A', 'Municipal', 'Abierta', '2022-07-01', '2022-07-29', '2022-07-27 13:34:12');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_propuestas`
--

CREATE TABLE `tbl_propuestas` (
  `id_propuesta` varchar(25) NOT NULL,
  `id_candidato` varchar(25) NOT NULL,
  `sector` varchar(100) NOT NULL,
  `descripcion` varchar(400) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_resultados`
--

CREATE TABLE `tbl_resultados` (
  `id_resultado` int(11) NOT NULL,
  `id_eleccion` varchar(40) NOT NULL,
  `descripcion` varchar(400) NOT NULL,
  `fecha_resultado` varchar(20) NOT NULL
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
('11150202', 'Cedula Ciudadania', 'Karen Palau', '6895555', 'notiene@notiene.com'),
('11152001', 'Cedula Ciudadania', 'Aurelio Casas', '4895555', 'no@nomail.com');

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
-- Volcado de datos para la tabla `tbl_votos`
--

INSERT INTO `tbl_votos` (`id_voto`, `id_eleccion`, `id_candidato`, `id_votante`, `fecha_voto`) VALUES
(19, '2022-Municipal-12A', '11010102', '11150202', '2022-07-27'),
(20, '2022-Municipal-12A', '11010101', '11152001', '2022-07-27');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tbl_candidatos`
--
ALTER TABLE `tbl_candidatos`
  ADD PRIMARY KEY (`id_candidato`);

--
-- Indices de la tabla `tbl_candidato_por_eleccion`
--
ALTER TABLE `tbl_candidato_por_eleccion`
  ADD PRIMARY KEY (`id_candidato`,`id_eleccion`);

--
-- Indices de la tabla `tbl_elecciones`
--
ALTER TABLE `tbl_elecciones`
  ADD PRIMARY KEY (`id_eleccion`);

--
-- Indices de la tabla `tbl_resultados`
--
ALTER TABLE `tbl_resultados`
  ADD PRIMARY KEY (`id_resultado`);

--
-- Indices de la tabla `tbl_votantes`
--
ALTER TABLE `tbl_votantes`
  ADD PRIMARY KEY (`id_votante`);

--
-- Indices de la tabla `tbl_votos`
--
ALTER TABLE `tbl_votos`
  ADD PRIMARY KEY (`id_voto`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tbl_resultados`
--
ALTER TABLE `tbl_resultados`
  MODIFY `id_resultado` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbl_votos`
--
ALTER TABLE `tbl_votos`
  MODIFY `id_voto` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
