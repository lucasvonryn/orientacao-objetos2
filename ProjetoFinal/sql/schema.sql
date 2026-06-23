CREATE DATABASE IF NOT EXISTS hoteldb
  DEFAULT CHARACTER SET utf8mb4
  DEFAULT COLLATE utf8mb4_unicode_ci;

USE hoteldb;

CREATE TABLE IF NOT EXISTS cliente (
  codigo INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(150) NOT NULL,
  cpf VARCHAR(14) NOT NULL,
  telefone VARCHAR(20) NOT NULL,
  email VARCHAR(100) NOT NULL,
  data_nascimento DATE NOT NULL,
  PRIMARY KEY (codigo),
  UNIQUE KEY uk_cliente_cpf (cpf)
);

CREATE TABLE IF NOT EXISTS quarto (
  codigo INT NOT NULL AUTO_INCREMENT,
  numero INT NOT NULL,
  tipo VARCHAR(30) NOT NULL,
  capacidade_maxima INT NOT NULL,
  valor_diaria DECIMAL(10, 2) NOT NULL,
  status VARCHAR(20) NOT NULL DEFAULT 'DISPONIVEL',
  PRIMARY KEY (codigo),
  UNIQUE KEY uk_quarto_numero (numero)
);

CREATE TABLE IF NOT EXISTS reserva (
  codigo INT NOT NULL AUTO_INCREMENT,
  codigo_cliente INT NOT NULL,
  codigo_quarto INT NOT NULL,
  data_checkin DATE NOT NULL,
  data_checkout DATE NOT NULL,
  qtd_hospedes INT NOT NULL,
  status VARCHAR(20) NOT NULL DEFAULT 'ATIVA',
  PRIMARY KEY (codigo),
  KEY fk_reserva_cliente (codigo_cliente),
  KEY fk_reserva_quarto (codigo_quarto),
  CONSTRAINT fk_reserva_cliente FOREIGN KEY (codigo_cliente) REFERENCES cliente (codigo),
  CONSTRAINT fk_reserva_quarto FOREIGN KEY (codigo_quarto) REFERENCES quarto (codigo)
);

CREATE TABLE IF NOT EXISTS hospedagem (
  codigo INT NOT NULL AUTO_INCREMENT,
  codigo_reserva INT NOT NULL,
  data_hora_checkin DATETIME NOT NULL,
  data_hora_checkout DATETIME NULL,
  qtd_diarias INT NOT NULL DEFAULT 0,
  valor_total DECIMAL(10, 2) NOT NULL DEFAULT 0.00,
  status VARCHAR(20) NOT NULL DEFAULT 'EM_ANDAMENTO',
  PRIMARY KEY (codigo),
  UNIQUE KEY uk_hospedagem_reserva (codigo_reserva),
  CONSTRAINT fk_hospedagem_reserva FOREIGN KEY (codigo_reserva) REFERENCES reserva (codigo)
);

CREATE TABLE IF NOT EXISTS pagamento (
  codigo INT NOT NULL AUTO_INCREMENT,
  codigo_hospedagem INT NOT NULL,
  valor DECIMAL(10, 2) NOT NULL,
  data DATE NOT NULL,
  forma_pagamento VARCHAR(30) NOT NULL,
  PRIMARY KEY (codigo),
  KEY fk_pagamento_hospedagem (codigo_hospedagem),
  CONSTRAINT fk_pagamento_hospedagem FOREIGN KEY (codigo_hospedagem) REFERENCES hospedagem (codigo)
);
