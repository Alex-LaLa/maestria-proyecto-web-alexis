INSERT INTO inventario
(producto_id, unidades_disponibles, nivel_reorden, ultima_actualizacion)
VALUES

-- Bebidas
(1, 8, 20, NOW()),
(2, 25, 10, NOW()),
(3, 15, 15, NOW()),
(4, 40, 20, NOW()),
(5, 12, 10, NOW()),
(6, 6, 8, NOW()),

-- Lácteos
(7, 18, 10, NOW()),
(8, 5, 8, NOW()),
(9, 22, 10, NOW()),
(10, 4, 5, NOW()),
(11, 7, 8, NOW()),

-- Abarrotes
(12, 35, 15, NOW()),
(13, 28, 12, NOW()),
(14, 20, 10, NOW()),
(15, 14, 8, NOW()),
(16, 50, 20, NOW()),
(17, 45, 20, NOW()),
(18, 30, 15, NOW()),
(19, 10, 8, NOW()),

-- Botanas
(20, 12, 10, NOW()),
(21, 18, 10, NOW()),
(22, 25, 12, NOW()),
(23, 9, 8, NOW()),

-- Limpieza
(24, 15, 8, NOW()),
(25, 10, 8, NOW()),
(26, 20, 10, NOW()),
(27, 12, 8, NOW()),
(28, 18, 10, NOW()),

-- Higiene personal
(29, 16, 8, NOW()),
(30, 6, 8, NOW()),
(31, 14, 8, NOW()),
(32, 25, 10, NOW()),

-- Congelados
(33, 8, 10, NOW()),
(34, 5, 8, NOW()),
(35, 12, 10, NOW()),

-- Panadería
(36, 20, 10, NOW()),
(37, 15, 10, NOW()),
(38, 8, 8, NOW());