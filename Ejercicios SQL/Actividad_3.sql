CREATE TABLE cursos (
    cod_curso INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    precio INT NOT NULL
);

CREATE TABLE alumnos (
    cod_alumno INT AUTO_INCREMENT PRIMARY KEY,
    cod_curso INT,
    nombre VARCHAR(255) NOT NULL,
    apellidos VARCHAR(255) NOT NULL,
    correo VARCHAR(255) NOT NULL,
    edad INT,
    FOREIGN KEY (cod_curso) REFERENCES cursos(cod_curso)
);

CREATE TABLE profesores (
    cod_profesor INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellidos VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    edad INT
);

CREATE TABLE asignaturas (
    cod_asignatura INT AUTO_INCREMENT PRIMARY KEY,
    cod_curso INT,
    cod_profesor INT,
    nombre VARCHAR(255) NOT NULL,
    duracion INT,
    FOREIGN KEY (cod_curso) REFERENCES cursos(cod_curso),
    FOREIGN KEY (cod_profesor) REFERENCES profesores(cod_profesor)
);

CREATE TABLE notas_alumnos (
    cod_alumno INT,
    cod_curso INT,
    cod_asignatura INT,
    nota INT,
    PRIMARY KEY (cod_alumno, cod_curso, cod_asignatura),
    FOREIGN KEY (cod_alumno) REFERENCES alumnos(cod_alumno),
    FOREIGN KEY (cod_curso) REFERENCES cursos(cod_curso),
    FOREIGN KEY (cod_asignatura) REFERENCES asignaturas(cod_asignatura)
);

SELECT CONCAT(REPEAT('-', 80)) AS OJO_SEPARADOR;

INSERT INTO cursos (nombre, precio) VALUES
('Matemáticas', 100),
('Ciencias', 120),
('Historia', 90);

INSERT INTO profesores (nombre, apellidos, email, edad) VALUES
('Juan', 'Martínez', 'juan.martinez@gmail.com', 35),
('María', 'García', 'maria.garcia@gmail.com', 40),
('Pedro', 'López', 'pedro.lopez@gmail.com', 45);

INSERT INTO asignaturas (cod_curso, cod_profesor, nombre, duracion) VALUES
(1, 1, 'Álgebra', 60000),
(2, 2, 'Física', 75000),
(3, 3, 'Guerra Mundial', 50000);

INSERT INTO alumnos (cod_curso, nombre, apellidos, correo, edad) VALUES
(1, 'Juan', 'González', 'juan.gonzalez@gmail.com', 25),
(1, 'María', 'López', 'maria.lopez@gmail.com', 22),
(2, 'Pedro', 'Martínez', 'pedro.martinez@gmail.com', 27),
(2, 'Ana', 'Pérez', 'ana.perez@gmail.com', 24),
(3, 'Luisa', 'Sánchez', 'luisa.sanchez@gmail.com', 26),
(1, 'Carlos', 'Hernández', 'carlos.hernandez@gmail.com', 23),
(2, 'Laura', 'Díaz', 'laura.diaz@gmail.com', 25),
(3, 'Miguel', 'Rodríguez', 'miguel.rodriguez@gmail.com', 28),
(1, 'Sofía', 'Gómez', 'sofia.gomez@gmail.com', 21),
(2, 'Daniel', 'Vázquez', 'daniel.vazquez@gmail.com', 29);

INSERT INTO notas_alumnos (cod_alumno, cod_curso, cod_asignatura, nota) VALUES
(1, 1, 1, 60),
(1, 1, 2, 50),
(1, 2, 3, 70),
(2, 2, 1, 65),
(2, 1, 2, 55),
(2, 3, 3, 45),
(3, 1, 1, 55),
(3, 2, 2, 60),
(3, 3, 3, 50),
(4, 2, 1, 65),
(4, 3, 2, 55),
(4, 1, 3, 60),
(5, 3, 1, 50),
(5, 1, 2, 55),
(5, 2, 3, 45),
(6, 2, 1, 55),
(6, 3, 2, 60),
(6, 1, 3, 50),
(7, 1, 1, 65),
(7, 2, 2, 55),
(7, 3, 3, 60),
(8, 3, 1, 55),
(8, 1, 2, 60),
(8, 2, 3, 50),
(9, 2, 1, 50),
(9, 3, 2, 55),
(9, 1, 3, 45),
(10, 1, 1, 55),
(10, 2, 2, 60),
(10, 3, 3, 50);

SELECT CONCAT(REPEAT('-', 80)) AS OJO_SEPARADOR;

SELECT alumnos.nombre AS nombre_alumno, cursos.nombre AS nombre_curso
FROM alumnos
JOIN cursos ON alumnos.cod_curso = cursos.cod_curso
WHERE alumnos.cod_alumno = 10;

SELECT CONCAT(REPEAT('-', 80)) AS OJO_SEPARADOR;

SELECT nombre
FROM asignaturas
WHERE cod_curso = 1;

SELECT CONCAT(REPEAT('-', 80)) AS OJO_SEPARADOR;

SELECT cod_curso, COUNT(*) AS numero_de_asignaturas
FROM asignaturas
GROUP BY cod_curso;

SELECT CONCAT(REPEAT('-', 80)) AS OJO_SEPARADOR;

SELECT asignaturas.nombre AS nombre_asignatura
FROM asignaturas
WHERE cod_profesor = 2;

SELECT CONCAT(REPEAT('-', 80)) AS OJO_SEPARADOR;

SELECT *
FROM notas_alumnos
WHERE cod_alumno = 10;

SELECT CONCAT(REPEAT('-', 80)) AS OJO_SEPARADOR;

SELECT cursos.nombre AS nombre_curso, AVG(notas_alumnos.nota) AS promedio_notas
FROM cursos
JOIN notas_alumnos ON cursos.cod_curso = notas_alumnos.cod_curso
GROUP BY cursos.nombre;

SELECT CONCAT(REPEAT('-', 80)) AS OJO_SEPARADOR;

SELECT asignaturas.nombre AS nombre_asignatura, AVG(notas_alumnos.nota) AS promedio_notas
FROM asignaturas
JOIN notas_alumnos ON asignaturas.cod_asignatura = notas_alumnos.cod_asignatura
GROUP BY asignaturas.nombre;

SELECT CONCAT(REPEAT('-', 80)) AS OJO_SEPARADOR;

INSERT INTO cursos (cod_curso, nombre, precio) VALUES (11, 'curso11', 100);
INSERT INTO cursos (cod_curso, nombre, precio) VALUES (12, 'curso12', 200);

SELECT CONCAT(REPEAT('-', 80)) AS OJO_SEPARADOR;

SELECT cursos.nombre AS nombre_curso, COUNT(alumnos.cod_alumno) AS numero_alumnos
FROM cursos
LEFT JOIN alumnos USING(cod_curso)
GROUP BY cursos.nombre;

SELECT CONCAT(REPEAT('-', 80)) AS OJO_SEPARADOR;

SELECT asignaturas.nombre AS nombre_asignatura, profesores.nombre AS nombre_profesor
FROM asignaturas
RIGHT JOIN profesores ON asignaturas.cod_profesor = profesores.cod_profesor;

SELECT CONCAT(REPEAT('-', 80)) AS OJO_SEPARADOR;