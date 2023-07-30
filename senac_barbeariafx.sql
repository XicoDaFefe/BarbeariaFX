create database senac_barbeariafx;
USE senac_barbeariafx;
CREATE TABLE barbearia (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cliente VARCHAR(255),
    corte VARCHAR(255),
    horario VARCHAR(255),
    dia DATE
);