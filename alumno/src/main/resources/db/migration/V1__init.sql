CREATE TABLE IF NOT EXISTS Estudiante (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    edad INT NOT NULL
    );

CREATE TABLE IF NOT EXISTS Libros (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    autor VARCHAR(50) NOT NULL,
    fecha DATE NOT NULL,
    estudiante_id INT REFERENCES Estudiante(id)
    );