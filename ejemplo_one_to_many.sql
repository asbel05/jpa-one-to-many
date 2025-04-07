create database ejemplo_one_to_many;
use ejemplo_one_to_many;

CREATE TABLE idioma (
	id_idioma BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE libro (
	id_libro BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    id_idioma BIGINT,
    CONSTRAINT fk_idioma_libro FOREIGN KEY (id_idioma) REFERENCES idioma(id_idioma)
);

INSERT INTO idioma (nombre) VALUES ('Español'), ('English');

INSERT INTO libro VALUES
(1, 'Cien años de soledad', 1),
(2, 'La sombra del viento', 1),
(3, 'The Great Gatsby', 2),
(4, 'Don Quijote de la Mancha', 1),
(5, 'To Kill a Mockingbird', 2);