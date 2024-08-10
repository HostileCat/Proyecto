-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-08-2024 a las 04:34:21
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pro_rest`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id_categoria` int(11) NOT NULL,
  `nombre_categoria` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id_categoria`, `nombre_categoria`) VALUES
(1, 'No tiene categoría'),
(2, 'Entradas'),
(3, 'Platos Principales'),
(4, 'Postres'),
(5, 'Bebidas'),
(6, 'Hamburguesas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_historial`
--

CREATE TABLE `detalle_historial` (
  `id_detalle` int(11) NOT NULL,
  `nombrePlato_detalle` varchar(255) NOT NULL,
  `precioPlato_detalle` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `detalle_historial`
--

INSERT INTO `detalle_historial` (`id_detalle`, `nombrePlato_detalle`, `precioPlato_detalle`) VALUES
(4, 'Chicharrón', 20000),
(5, 'Sancocho', 30000),
(6, 'Crème Brûlée', 20000),
(7, 'Jugos Naturales', 8000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `id_pedido` int(11) NOT NULL,
  `id_usuario_fk` int(11) DEFAULT NULL,
  `fecha_pedido` timestamp NULL DEFAULT NULL,
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`id_pedido`, `id_usuario_fk`, `fecha_pedido`, `total`) VALUES
(5, 5, '2024-08-07 22:51:37', 78000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido_platos`
--

CREATE TABLE `pedido_platos` (
  `id_pedido_fk` int(11) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `id_plato_fk` int(11) DEFAULT NULL,
  `detalle` varchar(255) NOT NULL,
  `id_pedidoPlato` int(11) NOT NULL,
  `id_detalleHistorial_fk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pedido_platos`
--

INSERT INTO `pedido_platos` (`id_pedido_fk`, `cantidad`, `id_plato_fk`, `detalle`, `id_pedidoPlato`, `id_detalleHistorial_fk`) VALUES
(5, 1, 3, '', 19, 4),
(5, 1, 6, 'sin mazorca', 20, 5),
(5, 1, 9, '', 21, 6),
(5, 1, 10, '', 22, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `platos`
--

CREATE TABLE `platos` (
  `id_plato` int(11) NOT NULL,
  `nombre_plato` varchar(255) NOT NULL,
  `descripcion_plato` varchar(255) DEFAULT NULL,
  `precio_plato` int(11) NOT NULL,
  `id_categoria_fk` int(11) DEFAULT NULL,
  `imagen_plato` varchar(255) NOT NULL,
  `estado` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `platos`
--

INSERT INTO `platos` (`id_plato`, `nombre_plato`, `descripcion_plato`, `precio_plato`, `id_categoria_fk`, `imagen_plato`, `estado`) VALUES
(1, 'Ceviche de Camarón', 'Camarones marinados en jugo de limón con cebolla, cilantro, y tomate', 25000, 2, 'cevicheDeCamarones.jpg', 1),
(2, 'Patacones con Hogao', 'Patacones, acompañadas con una salsa de cebolla, tomate, ajo y cilantro.', 12000, 2, 'pataconesConHogao.jpg', 1),
(3, 'Chicharrón', 'Chicharrón de cerdo acompañado de salsa picante y limón', 20000, 2, 'chicharron.jpg', 1),
(4, 'Bandeja Paisa', 'Arepa, carne molida, chicharrón, arepa, arroz, frijoles, plátano maduro, huevo frito, y aguacate', 40000, 3, 'bandejaPaisa.jpg', 1),
(5, 'Posta Negra', 'Carne de res en una salsa oscura a base de panela, cebolla, y especias, arroz, patacones y aguacate.', 35000, 3, 'postaNegra.jpg', 1),
(6, 'Sancocho', 'Sancocho de gallina con yuca, plátano, papa, y mazorca, acompañado de arroz y aguacate.', 30000, 3, 'sancocho.jpg', 1),
(7, 'Postre de Natas', 'Postre a base de nata de leche cocida con azúcar, canela, y clavos, acompañada de frutos secos', 15000, 4, 'postreDeNatas.jpg', 1),
(8, 'Torta de Tres Leches', 'Pastel empapado en una mezcla de tres tipos de leche (leche evaporada, leche condensada, y crema de leche)', 20000, 4, 'tortaTresLeches.jpg', 1),
(9, 'Crème Brûlée', 'Postre con una capa de azúcar caramelizada por encima de una crema de vainilla.', 20000, 4, 'cremeBrulee.jpg', 1),
(10, 'Jugos Naturales', 'Jugos de maracuyá, guanábana, lulo', 8000, 5, 'jugosNaturales.jpg', 1),
(11, 'Hamburguesa Sencilla', 'carne, cebolla, queso, lechuga, tomate, salsa de tomate', 12000, 6, 'hamburguesaClasica.jpg', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `id_reserva` int(11) NOT NULL,
  `id_cliente_fk` int(11) NOT NULL,
  `fecha_reserva` date NOT NULL,
  `id_estadoR_fk` int(11) DEFAULT NULL,
  `hora_reserva` time NOT NULL,
  `fecha_sugerida` date NOT NULL DEFAULT '1970-01-01',
  `hora_sugerida` time NOT NULL DEFAULT '00:00:00',
  `estado_sugerencia` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `reserva`
--

INSERT INTO `reserva` (`id_reserva`, `id_cliente_fk`, `fecha_reserva`, `id_estadoR_fk`, `hora_reserva`, `fecha_sugerida`, `hora_sugerida`, `estado_sugerencia`) VALUES
(1, 10, '2024-08-09', 1, '13:30:00', '1970-01-01', '00:00:00', 0),
(2, 8, '2024-08-12', 3, '17:15:00', '2024-08-12', '17:15:00', 0),
(3, 11, '2024-08-07', 4, '15:58:00', '1970-01-01', '00:00:00', 0),
(4, 12, '2024-08-13', 3, '12:17:00', '2024-08-13', '12:17:00', 0),
(5, 12, '2024-08-07', 4, '14:16:00', '2024-08-11', '13:17:00', 0),
(6, 13, '2024-08-13', 4, '21:20:00', '2024-08-13', '21:20:00', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva_estado`
--

CREATE TABLE `reserva_estado` (
  `id_reserva` int(11) NOT NULL,
  `estado` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `reserva_estado`
--

INSERT INTO `reserva_estado` (`id_reserva`, `estado`) VALUES
(1, 'En espera'),
(2, 'Confirmada'),
(3, 'Terminada'),
(4, 'Cancelada');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `id_rol` int(11) NOT NULL,
  `nombre_rol` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`id_rol`, `nombre_rol`) VALUES
(1, 'superadministrador'),
(2, 'administrador'),
(3, 'empleado'),
(4, 'cliente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `nombre_usuario` varchar(255) NOT NULL,
  `correo_usuario` varchar(255) DEFAULT NULL,
  `contrasena_usuario` varchar(255) NOT NULL,
  `id_rol_fk` int(11) DEFAULT NULL,
  `id_estado_fk` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nombre_usuario`, `correo_usuario`, `contrasena_usuario`, `id_rol_fk`, `id_estado_fk`) VALUES
(1, 'Superadmin', 'sadmin@gmail.com', '1234Sadmin', 1, 1),
(2, 'Omar Fuentes', 'omar@gmail.com', '1234Omar', 2, 1),
(3, 'Angela Diaz', 'angela@gmail.com', '1234Angela', 2, 1),
(4, 'Oscar Rios', 'oscar@gmail.com', '1234Oscar', 2, 1),
(5, 'Juan Camacho', 'juan@gmail.com', '1234Juan', 3, 1),
(6, 'Karol Gimenez', 'karol@gmail.com', '1234Karol', 3, 1),
(7, 'Vladimir Torres', 'vladimir@gmail.com', '1234Vladimir', 3, 1),
(8, 'Maria Amador', 'maria@gmail.com', '1234maria', 4, 1),
(9, 'Paula Ortega', 'paula@gmail.com', '1234Paula', 4, 2),
(10, 'David Gomez', 'david@gmail.com', '1234David', 4, 1),
(11, 'johan hernandez', 'johan@gmail.com', '1234Johan', 4, 1),
(12, 'pablo fuentes', 'pablo@gmail.com', '1234Pablo', 4, 1),
(13, 'abel', 'abel@gmail.com', '1234Abel', 4, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_estado`
--

CREATE TABLE `usuario_estado` (
  `id_estado` int(11) NOT NULL,
  `estado` varchar(255) NOT NULL DEFAULT 'Habilitado'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario_estado`
--

INSERT INTO `usuario_estado` (`id_estado`, `estado`) VALUES
(1, 'Habilitado'),
(2, 'Inhabilitado');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id_categoria`);

--
-- Indices de la tabla `detalle_historial`
--
ALTER TABLE `detalle_historial`
  ADD PRIMARY KEY (`id_detalle`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id_pedido`),
  ADD KEY `id_usuario_fk` (`id_usuario_fk`);

--
-- Indices de la tabla `pedido_platos`
--
ALTER TABLE `pedido_platos`
  ADD PRIMARY KEY (`id_pedidoPlato`),
  ADD KEY `id_pedido_fk` (`id_pedido_fk`),
  ADD KEY `id_plato_fk` (`id_plato_fk`);

--
-- Indices de la tabla `platos`
--
ALTER TABLE `platos`
  ADD PRIMARY KEY (`id_plato`),
  ADD KEY `id_categoria_fk` (`id_categoria_fk`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`id_reserva`),
  ADD KEY `id_cliente_fk` (`id_cliente_fk`),
  ADD KEY `id_estado_fk` (`id_estadoR_fk`);

--
-- Indices de la tabla `reserva_estado`
--
ALTER TABLE `reserva_estado`
  ADD PRIMARY KEY (`id_reserva`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id_rol`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`),
  ADD KEY `fk_usuario_rol` (`id_rol_fk`),
  ADD KEY `fk_estado_usuario` (`id_estado_fk`);

--
-- Indices de la tabla `usuario_estado`
--
ALTER TABLE `usuario_estado`
  ADD PRIMARY KEY (`id_estado`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id_categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `detalle_historial`
--
ALTER TABLE `detalle_historial`
  MODIFY `id_detalle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `id_pedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `pedido_platos`
--
ALTER TABLE `pedido_platos`
  MODIFY `id_pedidoPlato` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `platos`
--
ALTER TABLE `platos`
  MODIFY `id_plato` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `id_reserva` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `reserva_estado`
--
ALTER TABLE `reserva_estado`
  MODIFY `id_reserva` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `id_rol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `usuario_estado`
--
ALTER TABLE `usuario_estado`
  MODIFY `id_estado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`id_usuario_fk`) REFERENCES `usuario` (`id_usuario`);

--
-- Filtros para la tabla `pedido_platos`
--
ALTER TABLE `pedido_platos`
  ADD CONSTRAINT `pedido_platos_ibfk_1` FOREIGN KEY (`id_pedido_fk`) REFERENCES `pedido` (`id_pedido`),
  ADD CONSTRAINT `pedido_platos_ibfk_2` FOREIGN KEY (`id_plato_fk`) REFERENCES `platos` (`id_plato`);

--
-- Filtros para la tabla `platos`
--
ALTER TABLE `platos`
  ADD CONSTRAINT `platos_ibfk_1` FOREIGN KEY (`id_categoria_fk`) REFERENCES `categoria` (`id_categoria`);

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`id_cliente_fk`) REFERENCES `usuario` (`id_usuario`),
  ADD CONSTRAINT `reserva_ibfk_2` FOREIGN KEY (`id_estadoR_fk`) REFERENCES `reserva_estado` (`id_reserva`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_estado_usuario` FOREIGN KEY (`id_estado_fk`) REFERENCES `usuario_estado` (`id_estado`),
  ADD CONSTRAINT `fk_usuario_rol` FOREIGN KEY (`id_rol_fk`) REFERENCES `roles` (`id_rol`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
