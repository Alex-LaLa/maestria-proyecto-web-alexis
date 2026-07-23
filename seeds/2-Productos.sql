INSERT INTO productos (nombre, categoria_id, precio, activo) VALUES

('Coca Cola 600ml', 1, 15.00, true),
('Coca Cola 2.5L', 1, 42.00, true),
('Pepsi 600ml', 1, 14.00, true),
('Agua Bonafont 1.5L', 1, 18.00, true),
('Jugo Jumex Durazno 1L', 1, 28.00, true),
('Café Nescafé 200g', 1, 75.00, true),

('Leche Lala Entera 1L', 2, 28.00, true),
('Leche Alpura Deslactosada 1L', 2, 32.00, true),
('Yogurt Danone Fresa 220g', 2, 14.00, true),
('Queso Oaxaca 400g', 2, 65.00, true),
('Crema Lala 450ml', 2, 32.00, true),

('Arroz Verde Valle 1kg', 3, 32.00, true),
('Frijol La Sierra 900g', 3, 38.00, true),
('Atún Dolores 140g', 3, 22.00, true),
('Aceite Nutrioli 1L', 3, 48.00, true),
('Azúcar estándar 1kg', 3, 26.00, true),
('Sal La Fina 1kg', 3, 18.00, true),
('Sopa Maruchan Pollo', 3, 16.00, true),
('Mayonesa McCormick 390g', 3, 45.00, true),

('Sabritas Original 45g', 4, 18.00, true),
('Doritos Nacho 62g', 4, 18.00, true),
('Cacahuates japoneses 100g', 4, 22.00, true),
('Galletas Emperador Chocolate', 4, 20.00, true),

('Cloralex Cloro 1L', 5, 25.00, true),
('Pinol Limpiador 1L', 5, 35.00, true),
('Fabuloso Lavanda 1L', 5, 32.00, true),
('Jabón Roma 1kg', 5, 38.00, true),
('Esponja Scotch Brite', 5, 18.00, true),

('Jabón Dove Barra', 6, 28.00, true),
('Shampoo Pantene 400ml', 6, 75.00, true),
('Pasta Colgate 100ml', 6, 35.00, true),
('Papel Higiénico Regio 4 rollos', 6, 45.00, true),

('Nuggets Bachoco 500g', 7, 85.00, true),
('Helado Holanda 1L', 7, 70.00, true),
('Papas congeladas 500g', 7, 55.00, true),

('Pan Bimbo Blanco Grande', 8, 42.00, true),
('Pan Bimbo Integral', 8, 48.00, true),
('Donas Bimbo 6 piezas', 8, 38.00, true);

--validacion 
SELECT COUNT(*) FROM productos;