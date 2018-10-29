-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-10-2018 a las 17:58:12
-- Versión del servidor: 10.1.30-MariaDB
-- Versión de PHP: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `elgranhotel`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habitacion`
--

CREATE TABLE `habitacion` (
  `id_habitacion` int(11) NOT NULL,
  `id_tipoHabitacion` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `piso` int(11) NOT NULL,
  `estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `habitacion`
--

INSERT INTO `habitacion` (`id_habitacion`, `id_tipoHabitacion`, `numero`, `piso`, `estado`) VALUES
(1, 1, 1, 1, 1),
(2, 1, 2, 1, 0),
(3, 1, 3, 1, 0),
(4, 1, 4, 1, 0),
(5, 1, 5, 1, 0),
(6, 1, 6, 1, 0),
(7, 1, 7, 1, 0),
(8, 1, 8, 1, 0),
(9, 1, 9, 1, 0),
(10, 1, 10, 1, 0),
(11, 1, 11, 1, 0),
(12, 1, 12, 1, 0),
(13, 1, 13, 1, 0),
(14, 1, 14, 1, 0),
(15, 1, 15, 1, 0),
(16, 1, 16, 1, 0),
(17, 1, 17, 1, 0),
(18, 1, 18, 1, 0),
(19, 1, 19, 1, 0),
(20, 1, 20, 1, 0),
(21, 1, 21, 1, 0),
(22, 1, 22, 1, 0),
(23, 1, 23, 1, 0),
(24, 1, 24, 1, 0),
(25, 1, 25, 1, 0),
(26, 1, 26, 1, 0),
(27, 1, 27, 1, 0),
(28, 1, 28, 1, 0),
(29, 1, 29, 1, 0),
(30, 1, 30, 1, 0),
(31, 1, 31, 1, 0),
(32, 1, 32, 1, 0),
(33, 1, 33, 1, 0),
(34, 1, 34, 1, 0),
(35, 1, 35, 1, 0),
(36, 1, 36, 1, 0),
(37, 1, 37, 1, 0),
(38, 1, 38, 1, 0),
(39, 1, 39, 1, 0),
(40, 1, 40, 1, 0),
(41, 1, 41, 2, 0),
(42, 1, 42, 2, 0),
(43, 1, 43, 2, 0),
(44, 1, 44, 2, 0),
(45, 1, 45, 2, 0),
(46, 1, 46, 2, 0),
(47, 1, 47, 2, 0),
(48, 1, 48, 2, 0),
(49, 1, 49, 2, 0),
(50, 1, 50, 2, 0),
(51, 2, 51, 2, 0),
(52, 2, 52, 2, 0),
(53, 2, 53, 2, 0),
(54, 2, 54, 2, 0),
(55, 2, 55, 2, 0),
(56, 2, 56, 2, 0),
(57, 2, 57, 2, 0),
(58, 2, 58, 2, 0),
(59, 2, 59, 2, 0),
(60, 2, 60, 2, 0),
(61, 2, 61, 2, 0),
(62, 2, 62, 2, 0),
(63, 2, 63, 2, 0),
(64, 2, 64, 2, 0),
(65, 2, 65, 2, 0),
(66, 2, 66, 2, 0),
(67, 2, 67, 2, 0),
(68, 2, 68, 2, 0),
(69, 2, 69, 2, 0),
(70, 2, 70, 2, 0),
(71, 2, 71, 2, 0),
(72, 2, 72, 2, 0),
(73, 2, 73, 2, 0),
(74, 2, 74, 2, 0),
(75, 2, 75, 2, 0),
(76, 3, 76, 2, 0),
(77, 3, 77, 2, 0),
(78, 3, 78, 2, 0),
(79, 3, 79, 2, 0),
(80, 3, 80, 2, 0),
(81, 3, 81, 3, 0),
(82, 3, 82, 3, 0),
(83, 3, 83, 3, 0),
(84, 3, 84, 3, 0),
(85, 3, 85, 3, 0),
(86, 3, 86, 3, 0),
(87, 3, 87, 3, 0),
(88, 3, 88, 3, 0),
(89, 3, 89, 3, 0),
(90, 3, 90, 3, 0),
(91, 3, 91, 3, 0),
(92, 3, 92, 3, 0),
(93, 3, 93, 3, 0),
(94, 3, 94, 3, 0),
(95, 3, 95, 3, 0),
(96, 3, 96, 3, 0),
(97, 3, 97, 3, 0),
(98, 3, 98, 3, 0),
(99, 3, 99, 3, 0),
(100, 3, 100, 3, 0),
(101, 4, 101, 3, 0),
(102, 4, 102, 3, 0),
(103, 4, 103, 3, 0),
(104, 4, 104, 3, 0),
(105, 4, 105, 3, 1),
(106, 4, 106, 3, 0),
(107, 4, 107, 3, 0),
(108, 4, 108, 3, 0),
(109, 4, 109, 3, 0),
(110, 4, 110, 3, 0),
(111, 4, 111, 3, 0),
(112, 4, 112, 3, 0),
(113, 4, 113, 3, 0),
(114, 4, 114, 3, 0),
(115, 4, 115, 3, 0),
(116, 4, 116, 3, 0),
(117, 4, 117, 3, 0),
(118, 4, 118, 3, 0),
(119, 4, 119, 3, 0),
(120, 4, 120, 3, 0),
(121, 4, 121, 4, 1),
(122, 4, 122, 4, 1),
(123, 4, 123, 4, 0),
(124, 4, 124, 4, 0),
(125, 4, 125, 4, 0),
(126, 5, 126, 4, 0),
(127, 5, 127, 4, 0),
(128, 5, 128, 4, 0),
(129, 5, 129, 4, 0),
(130, 5, 130, 4, 0),
(131, 5, 131, 4, 0),
(132, 5, 132, 4, 0),
(133, 5, 133, 4, 0),
(134, 5, 134, 4, 0),
(135, 5, 135, 4, 0),
(136, 5, 136, 4, 0),
(137, 5, 137, 4, 0),
(138, 5, 138, 4, 0),
(139, 5, 139, 4, 0),
(140, 5, 140, 4, 0),
(141, 5, 141, 4, 0),
(142, 5, 142, 4, 0),
(143, 5, 143, 4, 0),
(144, 5, 144, 4, 0),
(145, 5, 145, 4, 0),
(146, 5, 146, 4, 0),
(147, 5, 147, 4, 0),
(148, 5, 148, 4, 0),
(149, 5, 149, 4, 0),
(150, 5, 150, 4, 0),
(151, 6, 151, 4, 0),
(152, 6, 152, 4, 0),
(153, 6, 153, 4, 0),
(154, 6, 154, 4, 1),
(155, 6, 155, 4, 0),
(156, 6, 156, 4, 0),
(157, 6, 157, 4, 0),
(158, 6, 158, 4, 0),
(159, 6, 159, 4, 0),
(160, 6, 160, 4, 0),
(161, 6, 161, 5, 0),
(162, 6, 162, 5, 0),
(163, 6, 163, 5, 0),
(164, 6, 164, 5, 0),
(165, 6, 165, 5, 0),
(166, 6, 166, 5, 0),
(167, 6, 167, 5, 0),
(168, 6, 168, 5, 0),
(169, 6, 169, 5, 0),
(170, 6, 170, 5, 0),
(171, 6, 171, 5, 0),
(172, 6, 172, 5, 0),
(173, 6, 173, 5, 0),
(174, 6, 174, 5, 0),
(175, 6, 175, 5, 0),
(176, 6, 176, 5, 0),
(177, 6, 177, 5, 0),
(178, 6, 178, 5, 0),
(179, 6, 179, 5, 0),
(180, 6, 180, 5, 0),
(181, 6, 181, 5, 0),
(182, 6, 182, 5, 0),
(183, 6, 183, 5, 0),
(184, 6, 184, 5, 0),
(185, 6, 185, 5, 0),
(186, 6, 186, 5, 0),
(187, 6, 187, 5, 0),
(188, 6, 188, 5, 0),
(189, 6, 189, 5, 0),
(190, 6, 190, 5, 0),
(191, 6, 191, 5, 0),
(192, 6, 192, 5, 0),
(193, 6, 193, 5, 0),
(194, 6, 194, 5, 0),
(195, 6, 195, 5, 0),
(196, 6, 196, 5, 0),
(197, 6, 197, 5, 0),
(198, 6, 198, 5, 0),
(199, 6, 199, 5, 1),
(200, 6, 200, 5, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `huesped`
--

CREATE TABLE `huesped` (
  `id_huesped` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `dni` varchar(20) NOT NULL,
  `domicilio` varchar(100) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `telefono` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `huesped`
--

INSERT INTO `huesped` (`id_huesped`, `nombre`, `apellido`, `dni`, `domicilio`, `correo`, `telefono`) VALUES
(3, 'Daniel', 'Bustos', '34182784', 'El volcán san luis', 'daniel@gmail.com', '2664741423'),
(23, 'Pedro', 'Perez', '12345678', 'B° 274', 'pedroperez@gmail.com', '2664123456'),
(24, 'Alonso', 'Suarez', '33121290', 'Juana Koslay', 'salonso@hotmail.com', '2665345454');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `id_reserva` int(11) NOT NULL,
  `id_huesped` int(11) NOT NULL,
  `id_habitacion` int(11) NOT NULL,
  `fecha_entrada` date NOT NULL,
  `fecha_salida` date NOT NULL,
  `cantidad_personas` int(11) NOT NULL,
  `importe` decimal(10,0) NOT NULL,
  `estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `reserva`
--

INSERT INTO `reserva` (`id_reserva`, `id_huesped`, `id_habitacion`, `fecha_entrada`, `fecha_salida`, `cantidad_personas`, `importe`, `estado`) VALUES
(15, 23, 105, '2018-10-29', '2018-11-07', 2, '19200', 1),
(16, 24, 154, '2018-10-30', '2018-11-07', 4, '24500', 1),
(17, 23, 1, '2018-10-29', '2018-10-31', 1, '1400', 1),
(19, 23, 122, '2018-10-29', '2018-10-30', 2, '2400', 1),
(20, 3, 121, '2018-10-29', '2018-10-31', 2, '4800', 1),
(21, 23, 199, '2018-10-29', '2018-10-31', 2, '7000', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipos_de_habitacion`
--

CREATE TABLE `tipos_de_habitacion` (
  `id_tipoHabitacion` int(11) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `capacidad` int(11) NOT NULL,
  `cantidad_camas` int(11) NOT NULL,
  `tipo_cama` varchar(50) NOT NULL,
  `precio_noche` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipos_de_habitacion`
--

INSERT INTO `tipos_de_habitacion` (`id_tipoHabitacion`, `tipo`, `capacidad`, `cantidad_camas`, `tipo_cama`, `precio_noche`) VALUES
(1, 'suite Lujo', 1, 1, 'Queen', '700'),
(2, 'Estándar Doble Matrimonial ', 2, 1, 'Queen', '1700'),
(3, 'Estándar Doble', 2, 2, 'Simples', '1800'),
(4, 'Estándar Triple Matrimonial', 3, 2, 'Simple, Queen', '2400'),
(5, 'Estándar Triple', 3, 3, 'Simples', '2400'),
(6, 'Suite Lujo', 4, 3, 'King Sinze', '3500');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  ADD PRIMARY KEY (`id_habitacion`);

--
-- Indices de la tabla `huesped`
--
ALTER TABLE `huesped`
  ADD PRIMARY KEY (`id_huesped`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`id_reserva`);

--
-- Indices de la tabla `tipos_de_habitacion`
--
ALTER TABLE `tipos_de_habitacion`
  ADD PRIMARY KEY (`id_tipoHabitacion`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  MODIFY `id_habitacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=201;

--
-- AUTO_INCREMENT de la tabla `huesped`
--
ALTER TABLE `huesped`
  MODIFY `id_huesped` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `id_reserva` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `tipos_de_habitacion`
--
ALTER TABLE `tipos_de_habitacion`
  MODIFY `id_tipoHabitacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
