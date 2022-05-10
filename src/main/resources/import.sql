/* Populate tables */
INSERT INTO clientes (nombre, apellido, nit, create_at, foto) VALUES('Consumidor', 'Final', '88888888', '2017-08-01', '');
INSERT INTO clientes (nombre, apellido, nit, create_at, foto) VALUES('Andres', 'Guzman', '86984521', '2017-08-01', '');
INSERT INTO clientes (nombre, apellido, nit, create_at, foto) VALUES('John', 'Doe', '69874123', '2017-08-02', '');
INSERT INTO clientes (nombre, apellido, nit, create_at, foto) VALUES('Linus', 'Torvalds', '6987453K', '2017-08-03', '');
INSERT INTO clientes (nombre, apellido, nit, create_at, foto) VALUES('Jane', 'Doe', '12358742', '2017-08-04', '');
INSERT INTO clientes (nombre, apellido, nit, create_at, foto) VALUES('Rasmus', 'Lerdorf', '36987458', '2017-08-05', '');
INSERT INTO clientes (nombre, apellido, nit, create_at, foto) VALUES('Erich', 'Gamma', '25143695', '2017-08-06', '');
INSERT INTO clientes (nombre, apellido, nit, create_at, foto) VALUES('Richard', 'Helm', '36125485', '2017-08-07', '');
INSERT INTO clientes (nombre, apellido, nit, create_at, foto) VALUES('Ralph', 'Johnson', '8471569K', '2017-08-08', '');
INSERT INTO clientes (nombre, apellido, nit, create_at, foto) VALUES('John', 'Vlissides', '12547896', '2017-08-09', '');
INSERT INTO clientes (nombre, apellido, nit, create_at, foto) VALUES('James', 'Gosling', '74587896', '2017-08-010', '');
INSERT INTO clientes (nombre, apellido, nit, create_at, foto) VALUES('Bruce', 'Lee', '12345678', '2017-08-11', '');
INSERT INTO clientes (nombre, apellido, nit, create_at, foto) VALUES('Johnny', 'Doe', '63587489', '2017-08-12', '');
INSERT INTO clientes (nombre, apellido, nit, create_at, foto) VALUES('John', 'Roe', '9687524K', '2017-08-13', '');
INSERT INTO clientes (nombre, apellido, nit, create_at, foto) VALUES('Jane', 'Roe', '45871258', '2017-08-14', '');
INSERT INTO clientes (nombre, apellido, nit, create_at, foto) VALUES('Richard', 'Doe', '25478596', '2017-08-15', '');
INSERT INTO clientes (nombre, apellido, nit, create_at, foto) VALUES('Janie', 'Doe', '8521475K', '2017-08-16', '');
INSERT INTO clientes (nombre, apellido, nit, create_at, foto) VALUES('Phillip', 'Webb', '3874589K', '2017-08-17', '');
INSERT INTO clientes (nombre, apellido, nit, create_at, foto) VALUES('Stephane', 'Nicoll', '78542158', '2017-08-18', '');
INSERT INTO clientes (nombre, apellido, nit, create_at, foto) VALUES('Sam', 'Brannen', '45871569', '2017-08-19', '');  
INSERT INTO clientes (nombre, apellido, nit, create_at, foto) VALUES('Juergen', 'Hoeller', '2896478K', '2017-08-20', ''); 
INSERT INTO clientes (nombre, apellido, nit, create_at, foto) VALUES('Janie', 'Roe', '10254785', '2017-08-21', '');
INSERT INTO clientes (nombre, apellido, nit, create_at, foto) VALUES('John', 'Smith', '20158746', '2017-08-22', '');
INSERT INTO clientes (nombre, apellido, nit, create_at, foto) VALUES('Joe', 'Bloggs', '5014856K', '2017-08-23', '');
INSERT INTO clientes (nombre, apellido, nit, create_at, foto) VALUES('John', 'Stiles', '75412568', '2017-08-24', '');
INSERT INTO clientes (nombre, apellido, nit, create_at, foto) VALUES('Richard', 'Roe', '5214578K', '2017-08-25', '');

/* Populate tabla productos */
INSERT INTO productos (nombre, categoria, precio_compra, precio, cantidad_disponible, create_at) VALUES('Detergente Magia Blanca', 'LAVANDERIA', 10, 15, 20, NOW());
INSERT INTO productos (nombre, categoria, precio_compra, precio, cantidad_disponible, create_at) VALUES('Coca-Cola Mini Plastica', 'GASEOSAS', 3, 5, 10, NOW());
INSERT INTO productos (nombre, categoria, precio_compra, precio, cantidad_disponible, create_at) VALUES('Cloro Clorox', 'LAVANDERIA', 2, 3, 5, NOW());
INSERT INTO productos (nombre, categoria, precio_compra, precio, cantidad_disponible, create_at) VALUES('Pepsi Lata', 'GASEOSAS', 27990, 37990, 30, NOW());
INSERT INTO productos (nombre, categoria, precio_compra, precio, cantidad_disponible, create_at) VALUES('Tortrix', 'ABARROTERIA', 0.75, 1, 11, NOW());
INSERT INTO productos (nombre, categoria, precio_compra, precio, cantidad_disponible, create_at) VALUES('Chicles Clorets', 'ABARROTERIA', 0.25, 0.50, 6, NOW());
INSERT INTO productos (nombre, categoria, precio_compra, precio, cantidad_disponible, create_at) VALUES('Jabón Ambar', ´LAVANDERIA´, 4, 7, 8, NOW());

/* Creamos algunas facturas */
INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Consumo Vario', null, 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 1);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(2, 1, 4);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 5);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 7);

INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Consumo Vario', 'Alguna nota importante!', 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(3, 2, 6);

/* Creamos algunos usuarios con sus roles */
INSERT INTO `users` (username, password, enabled) VALUES ('Yasmine','$2a$10$DkJkZUhYUeI3Wp2hYc4nKukZyg4PP8SVMlKamg2b.e7cnZoCOsljm',1);
INSERT INTO `users` (username, password, enabled) VALUES ('Darwin','$2a$10$1WvRDJ.RyqNOcHRxEGgXY.3E5Kt2AdTCFHz0DL53labkMHa2guhQi',1);

INSERT INTO `authorities` (user_id, authority) VALUES (1,'ROLE_USER');
INSERT INTO `authorities` (user_id, authority) VALUES (2,'ROLE_ADMIN');
INSERT INTO `authorities` (user_id, authority) VALUES (2,'ROLE_USER');