CREATE TABLE country (
    country_id INT AUTO_INCREMENT PRIMARY KEY,
    country_name VARCHAR(255) NOT NULL,
    continent_name VARCHAR(255),
    population INT,
    capital VARCHAR(255)
);

INSERT INTO country (country_name, continent_name, population, capital)
VALUES ('País1', 'Continente1', 1000000, 'Capital1'),
       ('País2', 'Continente2', 2000000, 'Capital2'),
       ('País3', 'Continente3', 3000000, 'Capital3');

DESCRIBE country;

SELECT CONCAT(REPEAT('-', 80)) AS OJO_SEPARADOR;

SELECT * FROM country;

SELECT CONCAT(REPEAT('-', 80)) AS OJO_SEPARADOR;

SELECT country_name FROM country;

SELECT CONCAT(REPEAT('-', 80)) AS OJO_SEPARADOR;

SELECT country_name, continent_name, population
FROM country;

SELECT CONCAT(REPEAT('-', 80)) AS OJO_SEPARADOR;

SELECT country_name AS nombre_del_pais, continent_name AS nombre_del_continente, population AS poblacion
FROM country;

SELECT CONCAT(REPEAT('-', 80)) AS OJO_SEPARADOR;

CREATE TABLE country_independences (
    country_id INT AUTO_INCREMENT PRIMARY KEY,
    country_name VARCHAR(255) NOT NULL,
    IndepYear INT
);

INSERT INTO country_independences (country_name, IndepYear)
VALUES 
    ('País1', 1800),
    ('País2', 1825),
    ('País3', 1850),
    ('País4', 1875),
    ('País5', 1900),
    ('País6', 1925),
    ('País7', 1950),
    ('País8', 1975),
    ('País9', 2000),
    ('País10', 2020);

SELECT country_name,
       2024 - IndepYear AS "Años Transcurridos"
FROM country_independences;

SELECT CONCAT(REPEAT('-', 80)) AS OJO_SEPARADOR;

SELECT DISTINCT country_name
FROM country_independences;

SELECT CONCAT(REPEAT('-', 80)) AS OJO_SEPARADOR;

SELECT country_name
FROM country_independences
LIMIT 5;

SELECT CONCAT(REPEAT('-', 80)) AS OJO_SEPARADOR;

SELECT country_name
FROM country_independences
LIMIT 5 OFFSET 4;


