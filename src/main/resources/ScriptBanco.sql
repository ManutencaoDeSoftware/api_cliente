-- Apagar o banco de dados
drop database banco;
-- Criar o banco de dados
create database banco;
-- Atribuir os privilégios de acesso aos objetos do banco
-- para o usuário root
GRANT ALL PRIVILEGES ON banco.* TO 'root' @'localhost';
-- Acesar o banco de dados: banco
USE banco;
-- Criar a tabela: cliente
-- Criar a tabela: endereco
CREATE TABLE endereco(
    id int AUTO_INCREMENT,
    cep varchar(8) NOT NULL,
    rua varchar(50) NOT NULL,
    bairro varchar(50) NOT NULL,
    numero int NOT NULL,
    cidade varchar(50) NOT NULL,
    uf varchar(2) NOT NULL,
    PRIMARY KEY (id)
);

USE banco;
CREATE TABLE cliente(
    id int AUTO_INCREMENT,
    cpf varchar(11) NOT NULL,
    nome varchar(50) NOT NULL,
    sexo varchar(1) NOT NULL,
    dataNascimento DATE NOT NULL DEFAULT CURRENT_TIME,
    endereco int,
    PRIMARY KEY (id),
    FOREIGN KEY (endereco) REFERENCES endereco(id)
);