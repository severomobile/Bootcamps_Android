CREATE TABLE address (
    address_id INT AUTO_INCREMENT PRIMARY KEY,
    address VARCHAR(255) NOT NULL,
    district VARCHAR(255) NOT NULL
);

INSERT INTO address (address, district) VALUES
('123 Main Street', 'Texas'),
('456 Elm Street', 'California'),
('789 Oak Street', 'Texas'),
('101 Pine Street', 'New York');

SELECT address, district
FROM address
WHERE district = 'Texas';

SELECT CONCAT(REPEAT('-', 80)) AS OJO_SEPARADOR;

CREATE TABLE payment (
    payment_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    amount DECIMAL(10, 2) NOT NULL
);

INSERT INTO payment (customer_id, amount) VALUES
(1, 10.50),
(2, 12.75),
(3, 15.00),
(4, 9.99);

SELECT *
FROM payment
WHERE amount > 11;

SELECT CONCAT(REPEAT('-', 80)) AS OJO_SEPARADOR;

CREATE TABLE actor (
    actor_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL
);

INSERT INTO actor (first_name, last_name) VALUES
('Penelope', 'Cruz'),
('penelope', 'Garcia'),
('PENELOPE', 'Johnson');

SELECT *
FROM actor
WHERE first_name = 'Penelope';

SELECT CONCAT(REPEAT('-', 80)) AS OJO_SEPARADOR;

SELECT *
FROM actor
WHERE BINARY first_name = 'Penelope';

SELECT CONCAT(REPEAT('-', 80)) AS OJO_SEPARADOR;

CREATE TABLE customer (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    active TINYINT(1) DEFAULT 1
);

INSERT INTO customer (first_name, last_name, active) VALUES
('John', 'Doe', 1),
('Jane', 'Smith', 0),
('Alice', 'Johnson', 1),
('Bob', 'Brown', 0);

SELECT first_name, last_name
FROM customer
WHERE active = 0;

SELECT CONCAT(REPEAT('-', 80)) AS OJO_SEPARADOR;

CREATE TABLE customer_False (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    active TINYINT(1) DEFAULT 1
);

INSERT INTO customer_False (first_name, last_name, active) VALUES
('John', 'Doe', 1),
('Jane', 'Smith', False),
('Alice', 'Johnson', 1),
('Bob', 'Brown', False);

SELECT first_name, last_name
FROM customer_False
WHERE active = 0;

SELECT CONCAT(REPEAT('-', 80)) AS OJO_SEPARADOR;

CREATE TABLE customer_Active (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    active TINYINT(1) DEFAULT 1
);

INSERT INTO customer_Active (first_name, last_name, active) VALUES
('John', 'Doe', 1),
('Jane', 'Smith', 0),
('Alice', 'Johnson', 1),
('Bob', 'Brown', 0);

SELECT first_name, last_name, active
FROM customer_Active
WHERE active;

SELECT CONCAT(REPEAT('-', 80)) AS OJO_SEPARADOR;

SELECT first_name, last_name, active
FROM customer_Active
WHERE !active;

SELECT CONCAT(REPEAT('-', 80)) AS OJO_SEPARADOR;
