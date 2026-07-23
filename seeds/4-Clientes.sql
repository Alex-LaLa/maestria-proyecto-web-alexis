INSERT INTO clientes
(nombre_completo, email, ciudad, fecha_creacion)
VALUES

('Juan Pérez Hernández', 'juan.perez@gmail.com', 'Orizaba', NOW()),
('María González López', 'maria.gonzalez@gmail.com', 'Córdoba', NOW()),
('Carlos Ramírez Torres', 'carlos.ramirez@gmail.com', 'Xalapa', NOW()),
('Ana Martínez Sánchez', 'ana.martinez@gmail.com', 'Veracruz', NOW()),
('Luis Hernández García', 'luis.hernandez@gmail.com', 'Puebla', NOW()),

('Sofía Castillo Morales', 'sofia.castillo@gmail.com', 'Orizaba', NOW()),
('Miguel Ángel Rodríguez', 'miguel.rodriguez@gmail.com', 'Córdoba', NOW()),
('Laura Sánchez Romero', 'laura.sanchez@gmail.com', 'Fortín', NOW()),
('José Antonio Flores', 'jose.flores@gmail.com', 'Ixtaczoquitlán', NOW()),
('Patricia Mendoza Ruiz', 'patricia.mendoza@gmail.com', 'Río Blanco', NOW()),

('Ricardo Vargas López', 'ricardo.vargas@gmail.com', 'Nogales', NOW()),
('Daniela Cruz Hernández', 'daniela.cruz@gmail.com', 'Orizaba', NOW()),
('Fernando Ortega Díaz', 'fernando.ortega@gmail.com', 'Córdoba', NOW()),
('Alejandra Torres Silva', 'alejandra.torres@gmail.com', 'Xalapa', NOW()),
('Roberto Méndez Pérez', 'roberto.mendez@gmail.com', 'Veracruz', NOW()),

('Gabriela Navarro Ruiz', 'gabriela.navarro@gmail.com', 'Puebla', NOW()),
('Eduardo Herrera Gómez', 'eduardo.herrera@gmail.com', 'Orizaba', NOW()),
('Karina López Vargas', 'karina.lopez@gmail.com', 'Fortín', NOW()),
('Jorge Castillo Pérez', 'jorge.castillo@gmail.com', 'Córdoba', NOW()),
('Natalia Flores Martínez', 'natalia.flores@gmail.com', 'Xalapa', NOW());

--Validacion
SELECT COUNT(*) FROM inventario;
SELECT COUNT(*) FROM clientes;