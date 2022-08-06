SELECT * FROM model;


INSERT INTO customer (full_name , email ,password, create_at, url_image)
VALUES
('Leon Felipe Rivera', 'leonriv2@gmail.com', 'leon12345', '2010-12-31 01:15:00', 'https://storageaccleonrv.blob.core.windows.net/user-images/roberto.jpg');

INSERT INTO seller (full_name , email ,password, create_at, url_image)
VALUES
('Aline Garcia Ramirez', 'aline@gmail.com', 'aline12345', '2022-12-31 01:15:00' ,'https://storageaccleonrv.blob.core.windows.net/user-images/aline.jpg');


INSERT INTO product(sku, name, description, price, create_at, quantity, url_image, seller_id)
VALUES 
('CHE12345','Alebrije', 'Alebrije hecho por manos mexicanas', 125.50,'2022-12-31 01:15:00', 20, 'https://i.pinimg.com/originals/68/e4/97/68e4974b285fbf294e0736178790741a.png', 1);
INSERT INTO product(sku, name, description, price, create_at, quantity, url_image, seller_id)
VALUES 
('CHE12345','Sarape', 'Sarape de michoachan', 300,'2022-12-31 01:15:00', 20, 'https://http2.mlstatic.com/D_NQ_NP_764052-MLM46341854254_062021-O.jpg', 1);
INSERT INTO product(sku, name, description, price, create_at, quantity, url_image, seller_id)
VALUES 
('CHE12345','Talavera Poblana', 'Talavera de puebla', 80,'2022-12-31 01:15:00', 20, 'https://www.infoceramica.com/wp-content/uploads/2013/11/Foto_6.jpg', 1);
INSERT INTO product(sku, name, description, price, create_at, quantity, url_image, seller_id)
VALUES 
('CHE12345','Sombrero de charro', 'Un sombrero de charro de michoacan', 500,'2022-12-31 01:15:00', 20, 'https://m.media-amazon.com/images/I/A12Cyo9b7tL._AC_SL1500_.jpg', 1);
INSERT INTO product(sku, name, description, price, create_at, quantity, url_image, seller_id)
VALUES 
('CHE12345','Articulo de Fiesta', 'Articulo de fiesta artesanal', 142.99,'2022-12-31 01:15:00', 20, 'https://m.media-amazon.com/images/I/81IwISO791L._AC_SX425_.jpg', 1);
INSERT INTO product(sku, name, description, price, create_at, quantity, url_image, seller_id)
VALUES 
('CHE12345','Cuadro de arte huichol', 'arte huichol hecha por huicholes', 4500,'2022-12-31 01:15:00', 20, 'https://etnias.mx/wp-content/uploads/2018/04/Tablas-de-estambre-Huicholh-1280x720.jpg', 1);