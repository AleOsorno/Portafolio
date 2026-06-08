-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-06-2026 a las 23:53:04
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `t15a_proyecto`
--
CREATE DATABASE IF NOT EXISTS `t15a_proyecto` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `t15a_proyecto`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `academias`
--

CREATE TABLE `academias` (
  `area` int(11) NOT NULL,
  `nombre_area` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `academias`
--

INSERT INTO `academias` (`area`, `nombre_area`) VALUES
(1, 'Ciencias Basicas'),
(2, 'Ciencias de la Ingenieria'),
(3, 'Ciencias de la Ingenieria Aplicada'),
(4, 'Ciencias Sociales y Humanidades'),
(5, 'Ingles');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `calificaciones`
--

CREATE TABLE `calificaciones` (
  `alumno` varchar(20) NOT NULL,
  `grupo` int(11) NOT NULL,
  `u1` decimal(4,2) DEFAULT NULL,
  `u2` decimal(4,2) DEFAULT NULL,
  `u3` decimal(4,2) DEFAULT NULL,
  `uf` decimal(4,2) DEFAULT NULL,
  `Final` decimal(4,2) DEFAULT NULL,
  `ee` decimal(4,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `calificaciones`
--

INSERT INTO `calificaciones` (`alumno`, `grupo`, `u1`, `u2`, `u3`, `uf`, `Final`, `ee`) VALUES
('190001', 1, 10.00, 8.00, NULL, NULL, 3.00, 0.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carreras`
--

CREATE TABLE `carreras` (
  `carrera` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `semestres` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `carreras`
--

INSERT INTO `carreras` (`carrera`, `nombre`, `semestres`) VALUES
(1, 'Ingenieria en Tecnologias de la Informacion', 9),
(2, 'Ingenieria en Telematica', 9),
(3, 'Ingenieria en Tecnologias de Manufactura', 9),
(4, 'Ingenieria en Sistemas y Tecnologias Industriales', 9),
(5, 'Licenciatura en Administracion y Gestion', 9),
(6, 'Licenciatura en Mercadotecnia Internacional', 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grupos`
--

CREATE TABLE `grupos` (
  `grupo` int(11) NOT NULL,
  `clave_grupo` varchar(20) NOT NULL,
  `maestro` varchar(20) DEFAULT NULL,
  `materia` int(11) DEFAULT NULL,
  `horario` int(11) DEFAULT NULL,
  `salon` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `grupos`
--

INSERT INTO `grupos` (`grupo`, `clave_grupo`, `maestro`, `materia`, `horario`, `salon`) VALUES
(1, 'ITI-03A', '220001', 62, 8, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horarios`
--

CREATE TABLE `horarios` (
  `horario` int(11) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `hora_lunes` varchar(30) DEFAULT NULL,
  `hora_martes` varchar(30) DEFAULT NULL,
  `hora_miercoles` varchar(30) DEFAULT NULL,
  `hora_jueves` varchar(30) DEFAULT NULL,
  `hora_viernes` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `horarios`
--

INSERT INTO `horarios` (`horario`, `tipo`, `hora_lunes`, `hora_martes`, `hora_miercoles`, `hora_jueves`, `hora_viernes`) VALUES
(1, 'Diario', '07:00 - 07:55', '07:00 - 07:55', '07:00 - 07:55', '07:00 - 07:55', '07:00 - 07:55'),
(2, 'Diario', '08:00 - 08:55', '08:00 - 08:55', '08:00 - 08:55', '08:00 - 08:55', '08:00 - 08:55'),
(3, 'Diario', '09:00 - 09:55', '09:00 - 09:55', '09:00 - 09:55', '09:00 - 09:55', '09:00 - 09:55'),
(4, 'Diario', '10:00 - 10:55', '10:00 - 10:55', '10:00 - 10:55', '10:00 - 10:55', '10:00 - 10:55'),
(5, 'Diario', '11:00 - 11:55', '11:00 - 11:55', '11:00 - 11:55', '11:00 - 11:55', '11:00 - 11:55'),
(6, 'Diario', '12:00 - 12:55', '12:00 - 12:55', '12:00 - 12:55', '12:00 - 12:55', '12:00 - 12:55'),
(7, 'Diario', '13:00 - 13:55', '13:00 - 13:55', '13:00 - 13:55', '13:00 - 13:55', '13:00 - 13:55'),
(8, 'Diario', '14:00 - 14:55', '14:00 - 14:55', '14:00 - 14:55', '14:00 - 14:55', '14:00 - 14:55');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materias`
--

CREATE TABLE `materias` (
  `materia` int(11) NOT NULL,
  `nombre_materia` varchar(100) NOT NULL,
  `clave_materia` varchar(20) NOT NULL,
  `numero_horas` int(11) DEFAULT NULL,
  `creditos` int(11) DEFAULT NULL,
  `semestre` int(11) DEFAULT NULL,
  `materia_anterior` int(11) DEFAULT NULL,
  `area` int(11) DEFAULT NULL,
  `carrera` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `materias`
--

INSERT INTO `materias` (`materia`, `nombre_materia`, `clave_materia`, `numero_horas`, `creditos`, `semestre`, `materia_anterior`, `area`, `carrera`) VALUES
(1, 'Taller para Certificaci?n Office', '237E', 80, 0, 0, NULL, 3, 1),
(2, 'Introducci?n a las Matem?ticas', '254E', 80, 0, 0, NULL, 1, 1),
(3, 'Introducci?n a la F?sica', '255E', 80, 0, 0, NULL, 1, 1),
(4, 'Ingl?s KET Intro', '', 80, 8, 0, NULL, 5, 1),
(5, 'Matem?ticas I', '110M', 80, 8, 1, NULL, 1, 1),
(6, 'Proyecto Integrador de Matem?ticas', '111M', 80, 7, 1, NULL, 1, 1),
(7, 'F?sica I', '110C', 80, 8, 1, NULL, 1, 1),
(8, 'Introducci?n a la Computaci?n', '110F', 80, 8, 1, NULL, 3, 1),
(9, 'Ingl?s I', '111G', 80, 8, 1, NULL, 5, 1),
(10, 'Curso del N?cleo General I: Desarrollo del Pensamiento Cr?tico', '110G', 80, 7, 1, NULL, 4, 1),
(11, 'Matem?ticas II', '210M', 80, 8, 2, 5, 1, 1),
(12, 'Curso N?cleo Optativo I Programaci?n Web I', '210O', 80, 7, 2, NULL, 3, 1),
(13, 'F?sica II', '210C', 80, 8, 2, 7, 1, 1),
(14, 'Programaci?n I', '210F', 80, 8, 2, 8, 3, 1),
(15, 'Ingl?s II', '211G', 80, 8, 2, 9, 5, 1),
(16, 'Curso del N?cleo General II: Comunicaci?n e Investigaci?n', '210G', 80, 7, 2, NULL, 4, 1),
(17, 'Matem?ticas III', '310M', 80, 9, 3, NULL, 1, 1),
(18, 'Curso N?cleo Optativo II Programaci?n Web II', '310O', 80, 7, 3, NULL, 3, 1),
(19, 'Matem?ticas Discretas', '311M', 80, 7, 3, 11, 2, 1),
(20, 'Programaci?n II', '310F', 80, 8, 3, 14, 3, 1),
(21, 'Ingl?s III', '310G', 80, 8, 3, 15, 5, 1),
(22, 'Qu?mica', '310C', 80, 7, 3, NULL, 2, 1),
(23, 'Probabilidad y Estad?stica', '410M', 80, 7, 4, NULL, 1, 1),
(24, 'Proyecto Integrador y Comprensivo I', '410P', 80, 9, 4, NULL, 3, 1),
(25, 'Circuitos El?ctricos', '410F', 80, 9, 4, 13, 2, 1),
(26, 'Programaci?n III', '411F', 80, 9, 4, 20, 3, 1),
(27, 'Ingl?s IV', '411G', 80, 8, 4, 21, 5, 1),
(28, 'Curso del N?cleo General III: Filosof?a y Valores', '410G', 48, 5, 4, NULL, 4, 1),
(29, 'Matem?ticas IV', '510M', 80, 8, 5, 11, 1, 1),
(30, 'Curso del N?cleo Optativo III', '510O', 48, 7, 5, NULL, 3, 1),
(31, 'An?lisis y Dise?o de Algoritmos', '511P', 80, 7, 5, 26, 3, 1),
(32, 'Sistemas Operativos', '510F', 80, 7, 5, 26, 2, 1),
(33, 'Ingl?s V', '510G', 80, 8, 5, 27, 5, 1),
(34, 'Sistemas Digitales', '510P', 80, 7, 5, 25, 3, 1),
(35, 'Arquitectura de Computadoras', '611F', 48, 7, 6, 34, 3, 1),
(36, 'Proyecto Integrador y Comprensivo II', '611P', 80, 9, 6, 24, 3, 1),
(37, 'Lenguajes de Programaci?n', '610F', 48, 7, 6, 32, 3, 1),
(38, 'Ingenier?a de Software I', '610P', 48, 7, 6, 26, 3, 1),
(39, 'Taller de Desarrollo Empresarial', '611G', 48, 7, 6, NULL, 4, 1),
(40, 'Curso del N?cleo General IV: Creatividad', '610G', 48, 6, 6, NULL, 4, 1),
(41, 'Ingl?s PET II', '', 80, 8, 6, NULL, 5, 1),
(42, 'Organizaci?n Computacional', '712P', 48, 7, 7, 35, 3, 1),
(43, 'Curso del N?cleo Optativo IV', '710O', 48, 7, 7, NULL, 3, 1),
(44, 'Base de Datos', '711P', 48, 7, 7, 37, 3, 1),
(45, 'Ingenier?a de Software II', '71OP', 48, 7, 7, 38, 3, 1),
(46, 'Teor?a Computacional', '710F', 80, 7, 7, NULL, 3, 1),
(47, 'Taller de Creatividad y Emprendedores', '710G', 48, 7, 7, NULL, 4, 1),
(48, 'Ingl?s FCE I', '', 80, 8, 7, NULL, 5, 1),
(49, 'Proyecto Integrador y Comprensivo III', '812P', 48, 7, 8, 36, 3, 1),
(50, 'Curso del N?cleo Optativo V', '810O', 48, 7, 8, NULL, 3, 1),
(51, 'Miner?a de Datos', '810P', 48, 7, 8, 44, 3, 1),
(52, 'Inteligencia Artificial I', '810F', 48, 7, 8, 37, 3, 1),
(53, 'Redes de Computadoras', '811P', 48, 7, 8, 42, 3, 1),
(54, 'Curso del N?cleo General V: Desarrollo de Competencias', '810G', 48, 6, 8, NULL, 4, 1),
(55, 'Compiladores', '910P', 48, 7, 9, 46, 3, 1),
(56, 'Curso del N?cleo Optativo VI', '910O', 48, 7, 9, NULL, 3, 1),
(57, 'Inteligencia Artificial II', '913P', 48, 7, 9, 52, 3, 1),
(58, 'Sistemas Virtuales', '912P', 48, 7, 9, 53, 3, 1),
(59, 'Comercio Electr?nico', '911P', 48, 7, 9, 53, 3, 1),
(60, 'Proyecto Profesional', '914P', 48, 8, 9, 49, 3, 1),
(61, 'Residencia Profesional', '910RP', 480, 10, 9, NULL, 4, 1),
(62, 'Estructura de Datos', 'ITI-ED01', 48, 8, 3, 10, 2, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salones`
--

CREATE TABLE `salones` (
  `salon` int(11) NOT NULL,
  `clave_salon` varchar(20) NOT NULL,
  `nombre_salon` varchar(50) NOT NULL,
  `ubicacion_fisica` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `salones`
--

INSERT INTO `salones` (`salon`, `clave_salon`, `nombre_salon`, `ubicacion_fisica`) VALUES
(1, 'A1', 'Salon A1', 'Unidad Academica de Estudiantes 1'),
(2, 'A2', 'Salon A2', 'Unidad Academica de Estudiantes 1'),
(3, 'B1', 'Salon B1', 'Unidad Academica de Estudiantes 2'),
(4, 'B2', 'Salon B2', 'Unidad Academica de Estudiantes 2'),
(5, 'CC1', 'Laboratorio de Computo 1', 'Centro de Computo'),
(6, 'CADI1', 'Sala de Ingles 1', 'Centro Academico de Ingles'),
(7, 'UAE3-204', 'Aula de Cómputo Avanzado', 'Unidad Academica de Estudiantes 3');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipousuarios`
--

CREATE TABLE `tipousuarios` (
  `tipo` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipousuarios`
--

INSERT INTO `tipousuarios` (`tipo`, `nombre`) VALUES
(0, 'Administrador'),
(1, 'Estudiante'),
(2, 'Docente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `matricula` varchar(20) NOT NULL,
  `nombre_completo` varchar(150) NOT NULL,
  `carrera` int(11) DEFAULT NULL,
  `generacion` varchar(10) DEFAULT NULL,
  `semestre` int(11) DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(32) NOT NULL,
  `tipo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`matricula`, `nombre_completo`, `carrera`, `generacion`, `semestre`, `username`, `password`, `tipo`) VALUES
('000000', 'Alejandro Osorno', NULL, NULL, NULL, 'admin', '81dc9bdb52d04dc20036dbd8313ed055', 0),
('190001', 'Carlos Gómez', 1, '2023', 1, 'alumno', '81dc9bdb52d04dc20036dbd8313ed055', 1),
('220001', 'Juan Pérez', 1, '2023', 6, 'profeJuan', '81dc9bdb52d04dc20036dbd8313ed055', 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `academias`
--
ALTER TABLE `academias`
  ADD PRIMARY KEY (`area`);

--
-- Indices de la tabla `calificaciones`
--
ALTER TABLE `calificaciones`
  ADD PRIMARY KEY (`alumno`,`grupo`),
  ADD KEY `grupo` (`grupo`);

--
-- Indices de la tabla `carreras`
--
ALTER TABLE `carreras`
  ADD PRIMARY KEY (`carrera`);

--
-- Indices de la tabla `grupos`
--
ALTER TABLE `grupos`
  ADD PRIMARY KEY (`grupo`),
  ADD KEY `maestro` (`maestro`),
  ADD KEY `materia` (`materia`),
  ADD KEY `horario` (`horario`),
  ADD KEY `salon` (`salon`);

--
-- Indices de la tabla `horarios`
--
ALTER TABLE `horarios`
  ADD PRIMARY KEY (`horario`);

--
-- Indices de la tabla `materias`
--
ALTER TABLE `materias`
  ADD PRIMARY KEY (`materia`),
  ADD KEY `materia_anterior` (`materia_anterior`),
  ADD KEY `area` (`area`),
  ADD KEY `carrera` (`carrera`);

--
-- Indices de la tabla `salones`
--
ALTER TABLE `salones`
  ADD PRIMARY KEY (`salon`);

--
-- Indices de la tabla `tipousuarios`
--
ALTER TABLE `tipousuarios`
  ADD PRIMARY KEY (`tipo`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`matricula`),
  ADD KEY `carrera` (`carrera`),
  ADD KEY `tipo` (`tipo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `academias`
--
ALTER TABLE `academias`
  MODIFY `area` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `carreras`
--
ALTER TABLE `carreras`
  MODIFY `carrera` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `grupos`
--
ALTER TABLE `grupos`
  MODIFY `grupo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `horarios`
--
ALTER TABLE `horarios`
  MODIFY `horario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `materias`
--
ALTER TABLE `materias`
  MODIFY `materia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;

--
-- AUTO_INCREMENT de la tabla `salones`
--
ALTER TABLE `salones`
  MODIFY `salon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `calificaciones`
--
ALTER TABLE `calificaciones`
  ADD CONSTRAINT `calificaciones_ibfk_1` FOREIGN KEY (`alumno`) REFERENCES `usuarios` (`matricula`),
  ADD CONSTRAINT `calificaciones_ibfk_2` FOREIGN KEY (`grupo`) REFERENCES `grupos` (`grupo`);

--
-- Filtros para la tabla `grupos`
--
ALTER TABLE `grupos`
  ADD CONSTRAINT `grupos_ibfk_1` FOREIGN KEY (`maestro`) REFERENCES `usuarios` (`matricula`),
  ADD CONSTRAINT `grupos_ibfk_2` FOREIGN KEY (`materia`) REFERENCES `materias` (`materia`),
  ADD CONSTRAINT `grupos_ibfk_3` FOREIGN KEY (`horario`) REFERENCES `horarios` (`horario`),
  ADD CONSTRAINT `grupos_ibfk_4` FOREIGN KEY (`salon`) REFERENCES `salones` (`salon`);

--
-- Filtros para la tabla `materias`
--
ALTER TABLE `materias`
  ADD CONSTRAINT `materias_ibfk_1` FOREIGN KEY (`materia_anterior`) REFERENCES `materias` (`materia`),
  ADD CONSTRAINT `materias_ibfk_2` FOREIGN KEY (`area`) REFERENCES `academias` (`area`),
  ADD CONSTRAINT `materias_ibfk_3` FOREIGN KEY (`carrera`) REFERENCES `carreras` (`carrera`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`carrera`) REFERENCES `carreras` (`carrera`),
  ADD CONSTRAINT `usuarios_ibfk_2` FOREIGN KEY (`tipo`) REFERENCES `tipousuarios` (`tipo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
