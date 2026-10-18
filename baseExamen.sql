-- ==========================================================
-- PARTE 1: Base de Datos SQL - Examen Fitzone
-- ==========================================================

-- 1. Creación de Tabla (10 Pts)
CREATE TABLE socios (
    id_socio INT PRIMARY KEY,
    nombres VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    edad INT NOT NULL,
    fecha_registro VARCHAR(10) NOT NULL,
    activo BOOLEAN NOT NULL
);

-- 2. Inserción de Datos (10 Pts)
-- (5 registros variados: mayores/menores de edad, fechas en 2026, activos y inactivos)
INSERT INTO socios (id_socio, nombres, apellidos, edad, fecha_registro, activo) VALUES
(1, 'Carlos Alberto', 'Pérez Gómez', 22, '2026-01-15', TRUE),
(2, 'María Fernanda', 'López Ruiz', 16, '2026-02-10', TRUE),
(3, 'Juan Carlos', 'Mora Vaca', 35, '2026-03-05', FALSE),
(4, 'Ana Lucía', 'Torres Silva', 19, '2026-04-20', TRUE),
(5, 'Pedro José', 'Andrade Castro', 15, '2026-05-01', FALSE);

-- 3. Consultas SQL 

-- Consulta 1: Mostrar únicamente nombres, apellidos y edad de los socios que tengan activo true y sean mayores a 18 años.
SELECT nombres, apellidos, edad FROM socios WHERE activo = TRUE AND edad > 18;

-- Consulta 2: Mostrar los socios registrados después de '2026-02-01' utilizando comparación sobre el campo fecha_registro.
SELECT * FROM socios WHERE fecha_registro > '2026-02-01';

-- Consulta 3: Mostrar todos los socios ordenados por edad de mayor a menor (ORDER BY DESC).
SELECT * FROM socios ORDER BY edad DESC;

-- 4. Modificación de Tabla y Actualización 

-- 4.1 Agregar una nueva columna llamada email tipo VARCHAR(100) usando ALTER TABLE.
ALTER TABLE socios ADD COLUMN email VARCHAR(100);

-- 4.2 Realizar un UPDATE asignando correo a un socio mediante su id_socio.
UPDATE socios SET email = 'carlos.perez@fitzone.com' WHERE id_socio = 1;