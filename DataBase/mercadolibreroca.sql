-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-11-2018 a las 03:48:14
-- Versión del servidor: 10.1.36-MariaDB
-- Versión de PHP: 7.2.11

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `mercadolibreroca`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulo`
--

CREATE TABLE `articulo` (
  `id_articulo` int(10) NOT NULL,
  `nombre_articulo` varchar(30) COLLATE utf8mb4_spanish_ci NOT NULL,
  `marca_articulo` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL,
  `categoria_articulo` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL,
  `cantidad_articulo` int(10) NOT NULL,
  `precio_articulo` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `articulo`
--

INSERT INTO `articulo` (`id_articulo`, `nombre_articulo`, `marca_articulo`, `categoria_articulo`, `cantidad_articulo`, `precio_articulo`) VALUES
(111, 'Iphone X', 'Apple', 'Tecnologia', 30, 2500000),
(112, 'P 20 pro', 'Huawei', 'Tecnologia', 30, 2100000),
(121, 'Laptop 14Ls', 'Asus', 'Tecnologia', 30, 1800000),
(122, 'Laptop 1000', 'Hp', 'Tecnologia', 30, 1750000),
(131, 'Televisor Smart Tv', 'Lg', 'Tecnologia', 31, 3000000),
(132, 'Televisor Smart Tv', 'Samsung', 'Tecnologia', 30, 2500000),
(211, 'Carro Tiida', 'Nissan', 'Vehiculos', 30, 70000000),
(212, 'Carro Swift', 'Suzuki', 'Vehiculos', 30, 62000000),
(221, 'Cicla Hightower', 'SantaCruz', 'Vehiculos', 30, 20000000),
(222, 'Cicla Spark 700 plus', 'Scott', 'Vehiculos', 30, 17020000),
(231, 'Motocicleta CRF 250R', 'Honda', 'Vehiculos', 30, 60000000),
(232, 'Motocicleta XTZ 125', 'Yamaha', 'Vehiculos', 30, 7000000),
(311, 'Estufa gas natural', 'Koblenz', 'Hogar', 30, 4200000),
(312, 'Estufa de empotrar', 'Abba', 'Hogar', 30, 5500000),
(321, 'Lavadora Smart 16kg', 'Lg', 'Hogar', 30, 1200000),
(322, 'Lavadora silver 8kg', 'Whirlpool', 'Hogar', 30, 1950000),
(331, 'Nevera silver 437lts', 'Lg', 'Hogar', 30, 3400000),
(332, 'Nevera French door  582lts', 'Samsung', 'Hogar', 30, 8900000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_factura`
--

CREATE TABLE `detalle_factura` (
  `id_detallefactura` int(15) NOT NULL DEFAULT '0',
  `id_articulo` int(15) NOT NULL,
  `id_factura` int(15) NOT NULL,
  `cantidad_detalle` int(15) NOT NULL,
  `totalcomproducto_detalle` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE `factura` (
  `id_factura` int(10) NOT NULL,
  `id_usuario` int(15) NOT NULL,
  `fecha_factura` date DEFAULT NULL,
  `total_factura` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(15) NOT NULL,
  `nombres_usuario` varchar(30) COLLATE utf8mb4_spanish_ci NOT NULL,
  `apellidos_usuario` varchar(30) COLLATE utf8mb4_spanish_ci NOT NULL,
  `fechaN_usuario` varchar(30) COLLATE utf8mb4_spanish_ci NOT NULL,
  `sexo_usuario` varchar(10) COLLATE utf8mb4_spanish_ci NOT NULL,
  `correo_usuario` varchar(30) COLLATE utf8mb4_spanish_ci NOT NULL,
  `celular_usuario` varchar(255) COLLATE utf8mb4_spanish_ci NOT NULL,
  `ciudad_usuario` varchar(30) COLLATE utf8mb4_spanish_ci NOT NULL,
  `direccion_usuario` varchar(30) COLLATE utf8mb4_spanish_ci NOT NULL,
  `password_usuario` varchar(30) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `nombres_usuario`, `apellidos_usuario`, `fechaN_usuario`, `sexo_usuario`, `correo_usuario`, `celular_usuario`, `ciudad_usuario`, `direccion_usuario`, `password_usuario`) VALUES
(1090498628, 'miguel angel', 'gomez casas', '18/08/1996', 'Hombre', 'admin@correo.com', '3215712960', 'cucuta', 'cll 11 # 21-41 valle esther', '17131024');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `articulo`
--
ALTER TABLE `articulo`
  ADD PRIMARY KEY (`id_articulo`);

--
-- Indices de la tabla `detalle_factura`
--
ALTER TABLE `detalle_factura`
  ADD PRIMARY KEY (`id_detallefactura`),
  ADD KEY `k_id_articulo` (`id_articulo`),
  ADD KEY `k_id_factura` (`id_factura`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`id_factura`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `factura`
--
ALTER TABLE `factura`
  MODIFY `id_factura` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1135;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle_factura`
--
ALTER TABLE `detalle_factura`
  ADD CONSTRAINT `id_detallefactura_ibfk_1` FOREIGN KEY (`id_articulo`) REFERENCES `articulo` (`id_articulo`),
  ADD CONSTRAINT `id_detallefactura_ibfk_2` FOREIGN KEY (`id_factura`) REFERENCES `factura` (`id_factura`);

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `factura_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`);
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
