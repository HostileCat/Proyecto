-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-08-2024 a las 18:03:43
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
(2, 'Platos Principales'),
(3, 'Postres'),
(4, 'Bebidas'),
(5, 'Menú Infantil'),
(12, 'jamon');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `id_pedido` int(11) NOT NULL,
  `id_usuario_fk` int(11) DEFAULT NULL,
  `fecha_pedido` datetime DEFAULT NULL,
  `detalle_pedido` varchar(255) NOT NULL,
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`id_pedido`, `id_usuario_fk`, `fecha_pedido`, `detalle_pedido`, `total`) VALUES
(1, 1, '2023-11-01 18:00:00', '', 0),
(2, 1, '2023-11-02 19:30:00', '', 0),
(3, 3, '2023-11-03 20:00:00', '', 0),
(4, 3, '2023-11-04 18:30:00', '', 0),
(5, 5, '2023-11-05 17:45:00', '', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido_platos`
--

CREATE TABLE `pedido_platos` (
  `id_pedido_fk` int(11) DEFAULT NULL,
  `cantidad_plato` int(11) DEFAULT NULL,
  `id_plato_fk` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pedido_platos`
--

INSERT INTO `pedido_platos` (`id_pedido_fk`, `cantidad_plato`, `id_plato_fk`) VALUES
(1, NULL, NULL),
(1, NULL, NULL),
(2, NULL, NULL),
(3, NULL, NULL),
(4, NULL, NULL);

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
(1, 'sopa', 'sopa rica', 100000, 2, 'Captura de pantalla 2024-05-25 115754.png', 1),
(2, 'patacones', 'asdasdas', 12331, 1, 'Captura de pantalla 2024-05-25 115754.png', 1),
(3, 'cajita feliz', 'asdasdas', 12331, 5, 'Captura de pantalla 2024-05-25 115754.png', 1),
(4, 'cajita feliz', 'asdasdas', 12331, 5, 'Captura de pantalla 2024-05-25 115754.png', 1),
(6, 'cajita feliz', 'asdasdas', 12331, 1, 'Captura de pantalla 2024-05-25 115754.png', 1),
(7, 'plato', 'platillo', 12345, 3, 'pngtree-wolf-animals-images-wallpaper-for-pc-384x480-image_2916211.jpg', 1),
(8, 'plato', 'platillo', 12345, 3, 'C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\Proyecto\\proRest\\target\\proRest-1.0-SNAPSHOT\\\\uploads', 1),
(9, 'plato', 'platillo', 12345, 3, 'C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\Proyecto\\proRest\\uploads', 1),
(10, 'plato', 'platillo', 12345, 3, 'C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\Proyecto\\proRest\\uploads', 1),
(11, 'plato', 'platillo', 12345, 3, 'pngtree-wolf-animals-images-wallpaper-for-pc-384x480-image_2916211.jpg', 1),
(12, 'plato', 'platillo', 12345, 2, 'pngtree-wolf-animals-images-wallpaper-for-pc-384x480-image_2916211.jpg', 1),
(13, 'hola', 'hello', 54321, 4, '1f1d408dddce4984a689afc06d9f42d8.webp', 1),
(14, 'hola', 'hello', 54321, 1, 'pngtree-wolf-animals-images-wallpaper-for-pc-384x480-image_2916211.jpg', 1),
(15, 'hola', 'hola hola', 123456, 1, 'Captura de pantalla 2024-05-25 115754.png', 1),
(16, 'platoss', 'platilloss', 1234567, 4, 'Captura de pantalla (5).png', 1),
(17, 'platos', 'platillos', 1234567, 1, 'RobloxScreenShot20240627_135446031.png', 1);

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
(11, 12, '1970-01-01', 3, '00:00:00', '1970-01-01', '00:00:00', 0),
(12, 12, '2024-08-04', 2, '17:22:00', '2024-08-04', '17:22:00', 0),
(13, 11, '2024-08-04', 1, '19:00:00', '2024-08-05', '15:42:00', 1),
(14, 12, '2024-08-04', 4, '14:50:00', '1970-01-01', '00:00:00', 0),
(15, 12, '2024-08-07', 4, '15:25:00', '2024-08-05', '15:26:00', 0),
(16, 12, '2024-08-07', 3, '17:07:00', '2024-08-07', '17:07:00', 0),
(17, 12, '2024-08-06', 3, '17:43:00', '2024-08-06', '17:43:00', 0);

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
  `id_estado_fk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nombre_usuario`, `correo_usuario`, `contrasena_usuario`, `id_rol_fk`, `id_estado_fk`) VALUES
(1, 'Juan Pérez', 'juan@example.com', 'hashed_password1', NULL, 1),
(2, 'Ana García', 'ana@example.com', 'hashed_password2', NULL, 1),
(3, 'María López', 'maria@example.com', 'hashed_password3', NULL, 1),
(4, 'Pedro Rodriguez', 'pedro@example.com', 'hashed_password4', NULL, 1),
(5, 'Sofía Martínez', 'sofia@example.com', 'hashed_password5', NULL, 1),
(7, 'qwer', 'qwer@gmail.com', '1234', 3, 1),
(8, 'juan', 'juan@gmail.com', '1234', 4, 1),
(11, 'abel', 'abel@gmail.com', 'abel1234', 2, 1),
(12, 'marquez', 'marquez@gmail.com', '1234', 1, 1),
(13, 'daniel', 'daniel@gmail.com', '1234Daniel', 4, 1);

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
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id_pedido`),
  ADD KEY `id_usuario_fk` (`id_usuario_fk`);

--
-- Indices de la tabla `pedido_platos`
--
ALTER TABLE `pedido_platos`
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
  MODIFY `id_categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `id_pedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `platos`
--
ALTER TABLE `platos`
  MODIFY `id_plato` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `id_reserva` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

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
