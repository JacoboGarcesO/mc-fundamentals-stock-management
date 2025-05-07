CREATE TABLE IF NOT EXISTS products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(200) NOT NULL,
    stock INT NOT NULL
);

INSERT INTO products(name, description, stock) VALUES ('Mouse ergonomico', 'x', 10);
INSERT INTO products(name, description, stock)
VALUES ('Teclado mecánico', 'Teclado gaming con switches Cherry MX Red', 15);
INSERT INTO products(name, description, stock)
VALUES ('Monitor 27"', 'Monitor LED IPS 2K con 144Hz', 8);
INSERT INTO products(name, description, stock)
VALUES ('Webcam HD', 'Cámara web 1080p con micrófono incorporado', 20);
INSERT INTO products(name, description, stock)
VALUES ('SSD 1TB', 'Disco de estado sólido NVME de alta velocidad', 12);
INSERT INTO products(name, description, stock)
VALUES ('Tarjeta gráfica', 'GPU gaming de última generación 12GB VRAM', 5);
INSERT INTO products(name, description, stock)
VALUES ('Auriculares', 'Auriculares gaming con sonido envolvente 7.1', 25);
INSERT INTO products(name, description, stock)
VALUES ('RAM 16GB', 'Memoria RAM DDR4 3200MHz', 30);
INSERT INTO products(name, description, stock)
VALUES ('Placa base', 'Placa base ATX compatible con procesadores última gen', 7);
INSERT INTO products(name, description, stock)
VALUES ('Ventilador CPU', 'Disipador de CPU con RGB y alto rendimiento', 18);