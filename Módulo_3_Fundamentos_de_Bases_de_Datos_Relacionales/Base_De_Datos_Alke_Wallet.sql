-- Crear tabla Usuario

CREATE TABLE Usuario (
    user_id INT PRIMARY KEY,
    nombre VARCHAR(100),
    correo_electronico VARCHAR(100) UNIQUE, -- Asegurar que cada correo sea único
    contrasena VARCHAR(50),
    saldo DECIMAL(10, 2) DEFAULT 0 -- Por defecto saldo en 0
);

-- Crear tabla Transaccion

CREATE TABLE Transaccion (
    transaction_id INT PRIMARY KEY,
    sender_user_id INT,
    receiver_user_id INT,
    importe DECIMAL(10, 2),
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Fecha y hora actual por defecto
    FOREIGN KEY (sender_user_id) REFERENCES Usuario(user_id),
    FOREIGN KEY (receiver_user_id) REFERENCES Usuario(user_id),
    CHECK (sender_user_id <> receiver_user_id) -- Evita transacciones entre el mismo usuario
);

-- Crear tabla Moneda

CREATE TABLE Moneda (
    currency_id INT PRIMARY KEY,
    currency_name VARCHAR(100) UNIQUE, -- Asegurar que cada nombre de moneda sea único
    currency_symbol VARCHAR(10)
);

-- Insertar datos en la tabla Usuario

INSERT INTO Usuario (user_id, nombre, correo_electronico, contrasena, saldo) VALUES
(1, 'Juan Pérez', 'juan@gmail.com', 'contraseña123', 10000.00),
(2, 'María García', 'maria@gmail.com', 'clave123', 500000.00),
(3, 'Carlos López', 'carlos@gmail.com', '123456', 15000.00),
(4, 'Ana Martínez', 'ana@gmail.com', 'qwerty', 20000.00),
(5, 'Luis Rodríguez', 'luis@gmail.com', 'abcdef', 300000.00);

-- Insertar datos en la tabla Transaccion

INSERT INTO Transaccion (transaction_id, sender_user_id, receiver_user_id, importe) VALUES
(1, 1, 2, 20000.00),
(2, 3, 1, 10000.00),
(3, 2, 4, 50000.00),
(4, 5, 3, 150000.00),
(5, 4, 5, 1000000.00);

-- Insertar datos en la tabla Moneda

INSERT INTO Moneda (currency_id, currency_name, currency_symbol) VALUES
(1, 'Dólar estadounidense', 'USD'),
(2, 'Euro', 'EUR'),
(3, 'Libra esterlina', 'GBP');

SELECT CONCAT(REPEAT('-', 80)) AS OJO_SEPARADOR;

-- Consulta para obtener el nombre de la moneda elegida por un usuario con ID 1

SELECT m.currency_name
FROM Moneda m
JOIN Transaccion t ON m.currency_id = currency_id
WHERE t.sender_user_id = 1
   OR t.receiver_user_id = 1
LIMIT 1;

SELECT CONCAT(REPEAT('-', 80)) AS OJO_SEPARADOR;

-- Consulta para obtener todas las transacciones del usuario con ID 1

SELECT *
FROM Transaccion
WHERE sender_user_id = 1
    OR receiver_user_id = 1;

SELECT CONCAT(REPEAT('-', 80)) AS OJO_SEPARADOR;

-- Consulta para obtener todos los usuarios registrados

SELECT *
FROM Usuario;

SELECT CONCAT(REPEAT('-', 80)) AS OJO_SEPARADOR;

-- Consulta para obtener todas las monedas registradas

SELECT *
FROM Moneda;

SELECT CONCAT(REPEAT('-', 80)) AS OJO_SEPARADOR;

-- Consulta para obtener todas las transacciones registradas

SELECT *
FROM Transaccion;

SELECT CONCAT(REPEAT('-', 80)) AS OJO_SEPARADOR;

-- Consulta para obtener todas las transacciones realizadas por un usuario con ID 1

SELECT *
FROM Transaccion
WHERE sender_user_id = 1 OR receiver_user_id = 1;

SELECT CONCAT(REPEAT('-', 80)) AS OJO_SEPARADOR;

-- Mostrar el correo electrónico actual del usuario con ID 1

SELECT correo_electronico
FROM Usuario
WHERE user_id = 1;

SELECT CONCAT(REPEAT('-', 80)) AS OJO_SEPARADOR;

-- Modificar el correo electrónico del usuario con ID 1

UPDATE Usuario
SET correo_electronico = 'nuevo_correo@gmail.com'
WHERE user_id = 1;

-- Mostrar el correo electrónico actualizado del usuario con ID 1

SELECT correo_electronico
FROM Usuario
WHERE user_id = 1;

SELECT CONCAT(REPEAT('-', 80)) AS OJO_SEPARADOR;

-- Mostrar la transacción antes de eliminarla

SELECT *
FROM Transaccion
WHERE transaction_id = 1;

SELECT CONCAT(REPEAT('-', 80)) AS OJO_SEPARADOR;

-- Eliminar la transacción

DELETE FROM Transaccion
WHERE transaction_id = 1;

-- Verificar que la transacción haya sido eliminada

SELECT *
FROM Transaccion
WHERE transaction_id = 1;

SELECT CONCAT(REPEAT('-', 80)) AS OJO_SEPARADOR;

-- Mostrar la estructura de la tabla antes de la modificación

DESCRIBE Usuario;

SELECT CONCAT(REPEAT('-', 80)) AS OJO_SEPARADOR;

-- Modificar el nombre de la columna correo_electronico a email

ALTER TABLE Usuario
CHANGE COLUMN correo_electronico email VARCHAR(100);

-- Mostrar la estructura de la tabla después de la modificación

DESCRIBE Usuario;
