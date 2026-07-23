INSERT INTO devoluciones
(detalle_orden_id,cantidad_devuelta,monto_reembolsado,motivo,estado,fecha_creacion)
VALUES

(2,1,15.00,'Producto dañado al momento de la entrega','APROBADA',NOW()-INTERVAL '10 days'),

(13,1,38.00,'Empaque roto','APROBADA',NOW()-INTERVAL '8 days'),

(23,1,85.00,'Producto descongelado','APROBADA',NOW()-INTERVAL '6 days'),

(30,1,48.00,'Cliente recibió producto equivocado','APROBADA',NOW()-INTERVAL '4 days'),

(45,2,36.00,'Cliente cambió de opinión','PENDIENTE',NOW()-INTERVAL '2 days'),

(51,1,35.00,'Producto con defecto de empaque','APROBADA',NOW()-INTERVAL '1 day');

--Validacion
SELECT COUNT(*) FROM categorias;
SELECT COUNT(*) FROM productos;
SELECT COUNT(*) FROM inventario;
SELECT COUNT(*) FROM clientes;
SELECT COUNT(*) FROM ordenes;
SELECT COUNT(*) FROM detalle_orden;
SELECT COUNT(*) FROM pagos;
SELECT COUNT(*) FROM devoluciones;