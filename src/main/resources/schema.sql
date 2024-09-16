CREATE TABLE Player
(
    ID INTEGER NOT NULL,
    Nombre VARCHAR(255) NOT NULL,
    Nacionalidad VARCHAR(255),
    Fecha_nacimiento TIMESTAMP,
    Titulos_ganados INTEGER,
    PRIMARY KEY (ID)
);
