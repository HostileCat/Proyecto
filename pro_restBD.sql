-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-07-2024 a las 23:33:31
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
(1, 'Entradas'),
(2, 'Platos Principales'),
(3, 'Postres'),
(4, 'Bebidas'),
(5, 'Menú Infantil'),
(10, 'gsdg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mesa`
--

CREATE TABLE `mesa` (
  `numero_mesa` int(11) NOT NULL,
  `descripcion_mesa` varchar(255) DEFAULT NULL,
  `capacidad_mesa` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `mesa`
--

INSERT INTO `mesa` (`numero_mesa`, `descripcion_mesa`, `capacidad_mesa`) VALUES
(1, 'Mesa junto a la ventana', 4),
(2, 'Mesa en el patio', 6),
(3, 'Mesa VIP', 2),
(4, 'Mesa en la esquina', 3),
(5, 'Mesa para grupos grandes', 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `id_pedido` int(11) NOT NULL,
  `id_usuario_fk` int(11) DEFAULT NULL,
  `fechaInicio_pedido` datetime DEFAULT NULL,
  `fechaFin_pedido` datetime DEFAULT NULL,
  `numero_mesa_fk` int(11) DEFAULT NULL,
  `estado_pedido` enum('espera','entregado','cancelado') NOT NULL,
  `detalle_pedido` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`id_pedido`, `id_usuario_fk`, `fechaInicio_pedido`, `fechaFin_pedido`, `numero_mesa_fk`, `estado_pedido`, `detalle_pedido`) VALUES
(1, 1, '2023-11-01 18:00:00', '2023-11-01 19:30:00', NULL, 'espera', NULL),
(2, 1, '2023-11-02 19:30:00', '2023-11-02 20:45:00', NULL, 'espera', NULL),
(3, 3, '2023-11-03 20:00:00', '2023-11-03 21:15:00', NULL, 'espera', NULL),
(4, 3, '2023-11-04 18:30:00', '2023-11-04 19:45:00', NULL, 'espera', NULL),
(5, 5, '2023-11-05 17:45:00', '2023-11-05 18:30:00', NULL, 'espera', NULL);

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
  `imagen_plato` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `platos`
--

INSERT INTO `platos` (`id_plato`, `nombre_plato`, `descripcion_plato`, `precio_plato`, `id_categoria_fk`, `imagen_plato`) VALUES
(1, 'sopa', 'sopa rica', 100000, 2, 'Captura de pantalla 2024-05-25 115754.png'),
(2, 'patacones', 'asdasdas', 12331, 1, 'Captura de pantalla 2024-05-25 115754.png'),
(3, 'cajita feliz', 'asdasdas', 12331, 5, 'Captura de pantalla 2024-05-25 115754.png'),
(4, 'cajita feliz', 'asdasdas', 12331, 5, 'Captura de pantalla 2024-05-25 115754.png'),
(5, 'cajita feliz', 'asdasdas', 12331, 1, ''),
(6, 'cajita feliz', 'asdasdas', 12331, 10, 'Captura de pantalla 2024-05-25 115754.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `id_reserva` int(11) NOT NULL,
  `id_cliente_fk` int(11) NOT NULL,
  `fecha_reserva` datetime NOT NULL,
  `estado_reserva` enum('confirmada','cancelada') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `id_rol` int(11) NOT NULL,
  `nombre_rol` varchar(255) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`id_rol`, `nombre_rol`, `descripcion`) VALUES
(1, 'superadministrador', 'Tiene acceso total y control sobre todas las funcionalidades del sistema.'),
(2, 'administrador', 'Encargado de la gestión y administración del sistema, pero con ciertas restricciones comparado con el superadministrador.'),
(3, 'empleado', 'Persona encargada de las tareas operativas del restaurante, como tomar pedidos'),
(4, 'cliente', 'Usuario final que realiza pedidos y reserva mesas en el restaurante.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `nombre_usuario` varchar(255) NOT NULL,
  `correo_usuario` varchar(255) DEFAULT NULL,
  `contrasena_usuario` varchar(255) NOT NULL,
  `id_rol_fk` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nombre_usuario`, `correo_usuario`, `contrasena_usuario`, `id_rol_fk`) VALUES
(1, 'Juan Pérez', 'juan@example.com', 'hashed_password1', NULL),
(2, 'Ana García', 'ana@example.com', 'hashed_password2', NULL),
(3, 'María López', 'maria@example.com', 'hashed_password3', NULL),
(4, 'Pedro Rodriguez', 'pedro@example.com', 'hashed_password4', NULL),
(5, 'Sofía Martínez', 'sofia@example.com', 'hashed_password5', NULL),
(7, 'qwer', 'qwer@gmail.com', '1234', 4),
(8, 'juan', 'juan@gmail.com', '1234', 4),
(9, 'Jhon CarreÃ±o', 'Jfcarreo5@soy.sena.edu.co', 'juanitoperez', 4),
(10, 'Carreño', 'jcarre5@soy.sena.edu.co', '', 4),
(11, 'abel', 'abel@gmail.com', 'abel1234', 4),
(12, 'marquez', 'diosmarquez@gmail.com', '1234', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id_categoria`);

--
-- Indices de la tabla `mesa`
--
ALTER TABLE `mesa`
  ADD PRIMARY KEY (`numero_mesa`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id_pedido`),
  ADD KEY `id_usuario_fk` (`id_usuario_fk`),
  ADD KEY `numero_mesa_fk` (`numero_mesa_fk`);

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
  ADD KEY `id_cliente_fk` (`id_cliente_fk`);

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
  ADD KEY `fk_usuario_rol` (`id_rol_fk`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id_categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `mesa`
--
ALTER TABLE `mesa`
  MODIFY `numero_mesa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `id_pedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `platos`
--
ALTER TABLE `platos`
  MODIFY `id_plato` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `id_rol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`id_usuario_fk`) REFERENCES `usuario` (`id_usuario`),
  ADD CONSTRAINT `pedido_ibfk_2` FOREIGN KEY (`numero_mesa_fk`) REFERENCES `mesa` (`numero_mesa`);

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
  ADD CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`id_cliente_fk`) REFERENCES `usuario` (`id_usuario`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_usuario_rol` FOREIGN KEY (`id_rol_fk`) REFERENCES `roles` (`id_rol`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
