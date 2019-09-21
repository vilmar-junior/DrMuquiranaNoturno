SET SQL_SAFE_UPDATES = 0;

DROP DATABASE IF EXISTS DBCONTROLEGASTOS;
CREATE DATABASE DBCONTROLEGASTOS;

USE DBCONTROLEGASTOS;

-- DDLs
CREATE TABLE USUARIO (
IDUSUARIO INT NOT NULL PRIMARY KEY AUTO_INCREMENT
, NOME VARCHAR(255)
, CPF CHAR(11)
, TELEFONE CHAR(14)
, LOGIN VARCHAR(255)
, SENHA VARCHAR(255)
);

CREATE TABLE RECEITA (
IDRECEITA INT NOT NULL PRIMARY KEY AUTO_INCREMENT
, IDUSUARIO INT
, DESCRICAO VARCHAR(255)
, VALOR DECIMAL(10,2)
, DATARECEITA DATE
,  FOREIGN KEY (IDUSUARIO) REFERENCES USUARIO (IDUSUARIO)
);

CREATE TABLE DESPESA (
IDDESPESA INT NOT NULL PRIMARY KEY AUTO_INCREMENT
, IDUSUARIO INT
, DESCRICAO VARCHAR(255)
, VALOR DECIMAL(10,2)
, DATAVENCIMENTO DATE
, DATAPAGAMENTO DATE
, CATEGORIA VARCHAR(255)
, FOREIGN KEY (IDUSUARIO) REFERENCES USUARIO (IDUSUARIO)
);

-- DMLs
INSERT INTO USUARIO (nome, cpf, telefone, login, senha) VALUES ('Chaves', '01234567890', '11111-1111', 'chaves', '1234');
INSERT INTO USUARIO (nome, cpf, telefone, login, senha) VALUES ('Kiko', '09876543210', '22222-2222', 'kiko', '4321');
INSERT INTO USUARIO (nome, cpf, telefone, login, senha) VALUES ('Chiquinha', '56789001234', '33333-3333', 'chiquinha', '3412');
INSERT INTO USUARIO (nome, cpf, telefone, login, senha) VALUES ('Sr. Madruga', '54321067890', '44444-4444', 'madruga', '2134');


INSERT INTO RECEITA (idusuario, descricao, valor, datareceita) VALUES (1, 'SALARIO', 5000, '2019-06-05');
INSERT INTO RECEITA (idusuario, descricao, valor, datareceita) VALUES (1, 'ADIANTAMENTO 13°', 5000, '2019-06-20');
INSERT INTO RECEITA (idusuario, descricao, valor, datareceita) VALUES (1, 'VALE', 2000, '2019-06-27');
INSERT INTO RECEITA (idusuario, descricao, valor, datareceita) VALUES (1, 'SALARIO', 5000, '2019-07-05');
INSERT INTO RECEITA (idusuario, descricao, valor, datareceita) VALUES (1, 'SALARIO', 5000, '2019-08-05');

INSERT INTO RECEITA (idusuario, descricao, valor, datareceita) VALUES (2, 'SALARIO', 3000, '2019-06-05');
INSERT INTO RECEITA (idusuario, descricao, valor, datareceita) VALUES (2, 'ADIANTAMENTO 13°', 3000, '2019-06-20');
INSERT INTO RECEITA (idusuario, descricao, valor, datareceita) VALUES (2, 'SALARIO', 3000, '2019-07-05');
INSERT INTO RECEITA (idusuario, descricao, valor, datareceita) VALUES (2, 'SALARIO', 3000, '2019-08-05');

INSERT INTO RECEITA (idusuario, descricao, valor, datareceita) VALUES (3, 'SALARIO', 7000, '2019-06-05');
INSERT INTO RECEITA (idusuario, descricao, valor, datareceita) VALUES (3, 'ADIANTAMENTO 13°', 7000, '2019-06-20');
INSERT INTO RECEITA (idusuario, descricao, valor, datareceita) VALUES (3, 'SALARIO', 7000, '2019-07-05');
INSERT INTO RECEITA (idusuario, descricao, valor, datareceita) VALUES (3, 'SALARIO', 7000, '2019-08-05');

INSERT INTO RECEITA (idusuario, descricao, valor, datareceita) VALUES (4, 'SALARIO', 4000, '2019-06-05');
INSERT INTO RECEITA (idusuario, descricao, valor, datareceita) VALUES (4, 'ADIANTAMENTO 13°', 4000, '2019-06-20');
INSERT INTO RECEITA (idusuario, descricao, valor, datareceita) VALUES (4, 'VALE', 1000, '2019-06-27');
INSERT INTO RECEITA (idusuario, descricao, valor, datareceita) VALUES (4, 'SALARIO', 4000, '2019-07-05');
INSERT INTO RECEITA (idusuario, descricao, valor, datareceita) VALUES (4, 'SALARIO', 4000, '2019-08-05');


INSERT INTO DESPESA (idusuario, descricao, valor, datavencimento, datapagamento, categoria) VALUES (1, 'ALUGUEL', 1400, '2019-06-10', '2019-06-10', 'HABITAÇÃO');
INSERT INTO DESPESA (idusuario, descricao, valor, datavencimento, datapagamento, categoria) VALUES (1, 'CONDOMINIO', 600, '2019-06-10', '2019-06-10', 'HABITAÇÃO');
INSERT INTO DESPESA (idusuario, descricao, valor, datavencimento, datapagamento, categoria) VALUES (1, 'SUPERMERCADO', 1500, '2019-06-15', '2019-06-15', 'ALIMENTACAO');
INSERT INTO DESPESA (idusuario, descricao, valor, datavencimento, datapagamento, categoria) VALUES (1, 'CINEMA', 150, '2019-06-18', '2019-06-18', 'ENTRETENIMENTO');
INSERT INTO DESPESA (idusuario, descricao, valor, datavencimento, datapagamento, categoria) VALUES (1, 'GASOLINA', 200, '2019-06-20', '2019-06-20', 'HABITAÇÃO');
INSERT INTO DESPESA (idusuario, descricao, valor, datavencimento, datapagamento, categoria) VALUES (1, 'ALUGUEL', 1400, '2019-07-10', null, 'HABITAÇÃO');
INSERT INTO DESPESA (idusuario, descricao, valor, datavencimento, datapagamento, categoria) VALUES (1, 'CONDOMINIO', 600, '2019-07-10', null, 'HABITAÇÃO');
INSERT INTO DESPESA (idusuario, descricao, valor, datavencimento, datapagamento, categoria) VALUES (1, 'ALUGUEL', 1400, '2019-08-10', null, 'HABITAÇÃO');
INSERT INTO DESPESA (idusuario, descricao, valor, datavencimento, datapagamento, categoria) VALUES (1, 'CONDOMINIO', 600, '2019-08-10', null, 'HABITAÇÃO');

INSERT INTO DESPESA (idusuario, descricao, valor, datavencimento, datapagamento, categoria) VALUES (2, 'ALUGUEL', 2000, '2019-06-10', '2019-06-10', 'HABITAÇÃO');
INSERT INTO DESPESA (idusuario, descricao, valor, datavencimento, datapagamento, categoria) VALUES (2, 'CONDOMINIO', 1000, '2019-06-10', '2019-06-10', 'HABITAÇÃO');
INSERT INTO DESPESA (idusuario, descricao, valor, datavencimento, datapagamento, categoria) VALUES (2, 'SUPERMERCADO', 2500, '2019-06-12', '2019-06-12', 'ALIMENTACAO');
INSERT INTO DESPESA (idusuario, descricao, valor, datavencimento, datapagamento, categoria) VALUES (2, 'SHOW IRON MAIDEN', 300, '2019-06-14', '2019-06-14', 'ENTRETENIMENTO');
INSERT INTO DESPESA (idusuario, descricao, valor, datavencimento, datapagamento, categoria) VALUES (2, 'GASOLINA', 400, '2019-06-23', '2019-06-23', 'HABITAÇÃO');
INSERT INTO DESPESA (idusuario, descricao, valor, datavencimento, datapagamento, categoria) VALUES (2, 'ALUGUEL', 2000, '2019-07-10', null, 'HABITAÇÃO');
INSERT INTO DESPESA (idusuario, descricao, valor, datavencimento, datapagamento, categoria) VALUES (2, 'CONDOMINIO', 1000, '2019-07-10', null, 'HABITAÇÃO');
INSERT INTO DESPESA (idusuario, descricao, valor, datavencimento, datapagamento, categoria) VALUES (2, 'ALUGUEL', 2000, '2019-08-10', null, 'HABITAÇÃO');
INSERT INTO DESPESA (idusuario, descricao, valor, datavencimento, datapagamento, categoria) VALUES (2, 'CONDOMINIO', 1000, '2019-08-10', null, 'HABITAÇÃO');

INSERT INTO DESPESA (idusuario, descricao, valor, datavencimento, datapagamento, categoria) VALUES (3, 'ALUGUEL', 1600, '2019-06-10', '2019-06-10', 'HABITAÇÃO');
INSERT INTO DESPESA (idusuario, descricao, valor, datavencimento, datapagamento, categoria) VALUES (3, 'CONDOMINIO', 800, '2019-06-10', '2019-06-10', 'HABITAÇÃO');
INSERT INTO DESPESA (idusuario, descricao, valor, datavencimento, datapagamento, categoria) VALUES (3, 'SUPERMERCADO', 1000, '2019-06-10', '2019-06-10', 'ALIMENTACAO');
INSERT INTO DESPESA (idusuario, descricao, valor, datavencimento, datapagamento, categoria) VALUES (3, 'CARMERATA FLORIANÓPOLIS', 100, '2019-06-19', '2019-06-19', 'ENTRETENIMENTO');
INSERT INTO DESPESA (idusuario, descricao, valor, datavencimento, datapagamento, categoria) VALUES (3, 'GASOLINA', 200, '2019-06-22', '2019-06-22', 'HABITAÇÃO');
INSERT INTO DESPESA (idusuario, descricao, valor, datavencimento, datapagamento, categoria) VALUES (3, 'ALUGUEL', 1600, '2019-07-10', null, 'HABITAÇÃO');
INSERT INTO DESPESA (idusuario, descricao, valor, datavencimento, datapagamento, categoria) VALUES (3, 'CONDOMINIO', 800, '2019-07-10', null, 'HABITAÇÃO');
INSERT INTO DESPESA (idusuario, descricao, valor, datavencimento, datapagamento, categoria) VALUES (3, 'ALUGUEL', 1600, '2019-08-10', null, 'HABITAÇÃO');
INSERT INTO DESPESA (idusuario, descricao, valor, datavencimento, datapagamento, categoria) VALUES (3, 'CONDOMINIO', 800, '2019-08-10', null, 'HABITAÇÃO');

INSERT INTO DESPESA (idusuario, descricao, valor, datavencimento, datapagamento, categoria) VALUES (4, 'ALUGUEL', 1700, '2019-06-10', '2019-06-10', 'HABITAÇÃO');
INSERT INTO DESPESA (idusuario, descricao, valor, datavencimento, datapagamento, categoria) VALUES (4, 'CONDOMINIO', 900, '2019-06-10', '2019-06-10', 'HABITAÇÃO');
INSERT INTO DESPESA (idusuario, descricao, valor, datavencimento, datapagamento, categoria) VALUES (4, 'SUPERMERCADO', 1900, '2019-06-11', '2019-06-11', 'ALIMENTACAO');
INSERT INTO DESPESA (idusuario, descricao, valor, datavencimento, datapagamento, categoria) VALUES (4, 'CINEMA', 120, '2019-06-25', '2019-06-25', 'ENTRETENIMENTO');
INSERT INTO DESPESA (idusuario, descricao, valor, datavencimento, datapagamento, categoria) VALUES (4, 'GASOLINA', 300, '2019-06-25', '2019-06-25', 'HABITAÇÃO');
INSERT INTO DESPESA (idusuario, descricao, valor, datavencimento, datapagamento, categoria) VALUES (4, 'ALUGUEL', 1700, '2019-07-10', null, 'HABITAÇÃO');
INSERT INTO DESPESA (idusuario, descricao, valor, datavencimento, datapagamento, categoria) VALUES (4, 'CONDOMINIO', 900, '2019-07-10', null, 'HABITAÇÃO');
INSERT INTO DESPESA (idusuario, descricao, valor, datavencimento, datapagamento, categoria) VALUES (4, 'ALUGUEL', 1700, '2019-08-10', null, 'HABITAÇÃO');
INSERT INTO DESPESA (idusuario, descricao, valor, datavencimento, datapagamento, categoria) VALUES (4, 'CONDOMINIO', 900, '2019-08-10', null, 'HABITAÇÃO');