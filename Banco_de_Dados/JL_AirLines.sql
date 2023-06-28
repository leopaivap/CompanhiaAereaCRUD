-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.4.20-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para companhiaaerea
DROP DATABASE IF EXISTS `companhiaaerea`;
CREATE DATABASE IF NOT EXISTS `companhiaaerea` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `companhiaaerea`;

-- Copiando estrutura para tabela companhiaaerea.aeronave
DROP TABLE IF EXISTS `aeronave`;
CREATE TABLE IF NOT EXISTS `aeronave` (
  `codAeronave` int(11) NOT NULL AUTO_INCREMENT,
  `nomeAviao` varchar(255) NOT NULL,
  `qtdAssento` int(11) NOT NULL,
  `autonomia` double NOT NULL,
  `capacidadeCarga` double NOT NULL,
  PRIMARY KEY (`codAeronave`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- Copiando dados para a tabela companhiaaerea.aeronave: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `aeronave` DISABLE KEYS */;
INSERT INTO `aeronave` (`codAeronave`, `nomeAviao`, `qtdAssento`, `autonomia`, `capacidadeCarga`) VALUES
	(1, 'Boeing 777', 345, 7000, 10000),
	(2, 'Antonov', 200, 3500, 2000),
	(3, 'Jato Particular', 5, 1500, 250),
	(4, 'aeronave', 10, 1000, 50000);
/*!40000 ALTER TABLE `aeronave` ENABLE KEYS */;

-- Copiando estrutura para tabela companhiaaerea.aeroporto
DROP TABLE IF EXISTS `aeroporto`;
CREATE TABLE IF NOT EXISTS `aeroporto` (
  `codAeroporto` int(11) NOT NULL AUTO_INCREMENT,
  `nomeAeroporto` varchar(255) NOT NULL,
  PRIMARY KEY (`codAeroporto`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- Copiando dados para a tabela companhiaaerea.aeroporto: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `aeroporto` DISABLE KEYS */;
INSERT INTO `aeroporto` (`codAeroporto`, `nomeAeroporto`) VALUES
	(1, 'Congonhas'),
	(3, 'ViraCopos'),
	(4, 'Cofins'),
	(5, 'Guarulhos');
/*!40000 ALTER TABLE `aeroporto` ENABLE KEYS */;

-- Copiando estrutura para tabela companhiaaerea.passageiro
DROP TABLE IF EXISTS `passageiro`;
CREATE TABLE IF NOT EXISTS `passageiro` (
  `codPassageiro` int(11) NOT NULL AUTO_INCREMENT,
  `nomePassageiro` varchar(200) NOT NULL,
  `cpf` int(11) NOT NULL,
  `dataNascimento` date NOT NULL,
  PRIMARY KEY (`codPassageiro`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- Copiando dados para a tabela companhiaaerea.passageiro: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `passageiro` DISABLE KEYS */;
INSERT INTO `passageiro` (`codPassageiro`, `nomePassageiro`, `cpf`, `dataNascimento`) VALUES
	(1, 'Leonardo', 2147483647, '2002-11-12'),
	(2, 'João Luís', 2147483647, '2002-03-12'),
	(3, 'Maria', 2147483647, '2001-10-12'),
	(4, 'Lucas', 2147483647, '2005-01-20');
/*!40000 ALTER TABLE `passageiro` ENABLE KEYS */;

-- Copiando estrutura para tabela companhiaaerea.passagem
DROP TABLE IF EXISTS `passagem`;
CREATE TABLE IF NOT EXISTS `passagem` (
  `codPassagem` int(11) NOT NULL AUTO_INCREMENT,
  `VOO_codVoo` int(11) NOT NULL,
  `numeroPoltrona` int(11) NOT NULL DEFAULT 0,
  `pesoBagagem` int(11) NOT NULL DEFAULT 0,
  `valorPassagem` int(11) NOT NULL,
  PRIMARY KEY (`codPassagem`),
  KEY `FK_passagem_voo` (`VOO_codVoo`),
  CONSTRAINT `FK_passagem_voo` FOREIGN KEY (`VOO_codVoo`) REFERENCES `voo` (`codVoo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- Copiando dados para a tabela companhiaaerea.passagem: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `passagem` DISABLE KEYS */;
INSERT INTO `passagem` (`codPassagem`, `VOO_codVoo`, `numeroPoltrona`, `pesoBagagem`, `valorPassagem`) VALUES
	(1, 2, 10, 23, 1750),
	(2, 3, 15, 15, 200),
	(3, 1, 234, 22, 23),
	(4, 2, 123, 1233, 1233),
	(5, 4, 10, 0, 0);
/*!40000 ALTER TABLE `passagem` ENABLE KEYS */;

-- Copiando estrutura para tabela companhiaaerea.piloto
DROP TABLE IF EXISTS `piloto`;
CREATE TABLE IF NOT EXISTS `piloto` (
  `codPiloto` int(11) NOT NULL AUTO_INCREMENT,
  `salario` double NOT NULL,
  `dataAdmissao` date NOT NULL,
  `nomePiloto` varchar(200) NOT NULL,
  `cpf` int(11) NOT NULL,
  `dataNascimento` date NOT NULL,
  PRIMARY KEY (`codPiloto`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- Copiando dados para a tabela companhiaaerea.piloto: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `piloto` DISABLE KEYS */;
INSERT INTO `piloto` (`codPiloto`, `salario`, `dataAdmissao`, `nomePiloto`, `cpf`, `dataNascimento`) VALUES
	(1, 10200, '2023-02-12', 'Jorge', 111111111, '1970-05-15'),
	(3, 7500, '1111-11-11', 'Rodrigo', 2147483647, '1985-02-21'),
	(4, 11500, '1111-11-11', 'Sofia', 33333333, '1990-10-01');
/*!40000 ALTER TABLE `piloto` ENABLE KEYS */;

-- Copiando estrutura para tabela companhiaaerea.venda
DROP TABLE IF EXISTS `venda`;
CREATE TABLE IF NOT EXISTS `venda` (
  `codvenda` int(11) NOT NULL AUTO_INCREMENT,
  `metodoPagamento` enum('Dinheiro','Pix','Cartão Crédito','Cartão Débito') NOT NULL,
  `data` date NOT NULL,
  `PASSAGEIRO_codPassageiro` int(11) NOT NULL,
  PRIMARY KEY (`codvenda`,`PASSAGEIRO_codPassageiro`) USING BTREE,
  KEY `fk_venda_passageiro1_idx` (`PASSAGEIRO_codPassageiro`),
  CONSTRAINT `fk_venda_passageiro1` FOREIGN KEY (`PASSAGEIRO_codPassageiro`) REFERENCES `passageiro` (`codPassageiro`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4;

-- Copiando dados para a tabela companhiaaerea.venda: ~42 rows (aproximadamente)
/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
INSERT INTO `venda` (`codvenda`, `metodoPagamento`, `data`, `PASSAGEIRO_codPassageiro`) VALUES
	(1, 'Pix', '2023-06-27', 2),
	(2, 'Pix', '2023-06-27', 3),
	(3, 'Pix', '2023-06-27', 3),
	(4, 'Pix', '2023-06-27', 3),
	(5, 'Pix', '2023-06-27', 2),
	(6, 'Pix', '2023-06-27', 1),
	(7, 'Cartão Crédito', '2023-06-27', 2),
	(8, 'Dinheiro', '2023-06-27', 3),
	(9, 'Dinheiro', '2023-06-27', 1),
	(10, 'Cartão Crédito', '2023-06-27', 3),
	(11, 'Cartão Débito', '2023-06-27', 2),
	(12, 'Cartão Crédito', '2023-06-27', 2),
	(13, 'Pix', '2023-06-27', 3),
	(14, 'Pix', '2023-06-27', 3),
	(15, 'Cartão Crédito', '2023-06-27', 2),
	(16, 'Pix', '2023-06-27', 1),
	(17, 'Cartão Crédito', '2023-06-27', 2),
	(18, 'Cartão Crédito', '2023-06-27', 2),
	(19, 'Cartão Crédito', '2023-06-27', 2),
	(20, 'Pix', '2023-06-27', 2),
	(21, 'Cartão Crédito', '2023-06-27', 3),
	(22, 'Cartão Crédito', '2023-06-27', 2),
	(23, 'Pix', '2023-06-27', 1),
	(24, 'Cartão Crédito', '2023-06-27', 2),
	(25, 'Cartão Crédito', '2023-06-27', 2),
	(26, 'Pix', '2023-06-27', 1),
	(27, 'Pix', '2023-06-27', 1),
	(28, 'Pix', '2023-06-27', 2),
	(29, 'Cartão Crédito', '2023-06-27', 2),
	(30, 'Cartão Crédito', '2023-06-27', 3),
	(31, 'Pix', '2023-06-27', 2),
	(33, 'Cartão Crédito', '2023-06-27', 1),
	(34, 'Cartão Crédito', '2023-06-27', 1),
	(35, 'Cartão Crédito', '2023-06-27', 2),
	(36, 'Dinheiro', '2023-06-27', 1),
	(37, 'Pix', '2023-06-27', 3),
	(38, 'Cartão Crédito', '2023-06-27', 2),
	(39, 'Cartão Crédito', '2023-06-27', 2),
	(40, 'Pix', '2023-06-27', 2),
	(41, 'Pix', '2023-06-27', 2),
	(42, 'Cartão Crédito', '2023-06-27', 2),
	(43, 'Dinheiro', '2023-06-28', 1),
	(46, 'Cartão Crédito', '2023-06-28', 3);
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;

-- Copiando estrutura para tabela companhiaaerea.vendapassagem
DROP TABLE IF EXISTS `vendapassagem`;
CREATE TABLE IF NOT EXISTS `vendapassagem` (
  `codVendaPassagem` int(11) NOT NULL AUTO_INCREMENT,
  `VENDA_codVenda` int(11) NOT NULL,
  `PASSAGEM_codPassagem` int(11) NOT NULL,
  PRIMARY KEY (`codVendaPassagem`),
  KEY `fk_venda_has_passagem_passagem1_idx` (`PASSAGEM_codPassagem`),
  KEY `fk_venda_has_passagem_venda1_idx` (`VENDA_codVenda`),
  CONSTRAINT `fk_venda_has_passagem_passagem1` FOREIGN KEY (`PASSAGEM_codPassagem`) REFERENCES `passagem` (`codPassagem`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_venda_has_passagem_venda1` FOREIGN KEY (`VENDA_codVenda`) REFERENCES `venda` (`codvenda`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb4;

-- Copiando dados para a tabela companhiaaerea.vendapassagem: ~12 rows (aproximadamente)
/*!40000 ALTER TABLE `vendapassagem` DISABLE KEYS */;
INSERT INTO `vendapassagem` (`codVendaPassagem`, `VENDA_codVenda`, `PASSAGEM_codPassagem`) VALUES
	(8, 5, 1),
	(9, 6, 1),
	(10, 8, 1),
	(11, 9, 1),
	(12, 10, 1),
	(13, 11, 1),
	(14, 12, 1),
	(15, 13, 1),
	(16, 13, 1),
	(17, 14, 1),
	(18, 15, 1),
	(19, 16, 1),
	(21, 18, 1),
	(22, 19, 1),
	(23, 20, 1),
	(24, 20, 1),
	(25, 20, 1),
	(26, 21, 1),
	(27, 22, 1),
	(28, 23, 1),
	(29, 24, 1),
	(30, 25, 2),
	(33, 27, 1),
	(34, 28, 1),
	(35, 29, 2),
	(36, 30, 2),
	(37, 31, 1),
	(39, 33, 1),
	(40, 34, 2),
	(41, 35, 2),
	(42, 36, 1),
	(43, 37, 2),
	(44, 37, 1),
	(45, 38, 1),
	(46, 39, 3),
	(47, 40, 3),
	(48, 41, 1),
	(49, 41, 3),
	(50, 42, 3),
	(51, 42, 2);
/*!40000 ALTER TABLE `vendapassagem` ENABLE KEYS */;

-- Copiando estrutura para tabela companhiaaerea.voo
DROP TABLE IF EXISTS `voo`;
CREATE TABLE IF NOT EXISTS `voo` (
  `codVoo` int(11) NOT NULL AUTO_INCREMENT,
  `PILOTO_codPiloto` int(11) NOT NULL,
  `AEROPORTO_codAeroporto` int(11) NOT NULL,
  `AERONAVE_codAeronave` int(11) NOT NULL,
  `origem` varchar(50) NOT NULL,
  `destino` varchar(50) NOT NULL,
  PRIMARY KEY (`codVoo`),
  KEY `FK_voo_piloto` (`PILOTO_codPiloto`),
  KEY `FK_voo_aeroporto` (`AEROPORTO_codAeroporto`),
  KEY `FK_voo_aeronave` (`AERONAVE_codAeronave`),
  CONSTRAINT `FK_voo_aeronave` FOREIGN KEY (`AERONAVE_codAeronave`) REFERENCES `aeronave` (`codAeronave`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_voo_aeroporto` FOREIGN KEY (`AEROPORTO_codAeroporto`) REFERENCES `aeroporto` (`codAeroporto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_voo_piloto` FOREIGN KEY (`PILOTO_codPiloto`) REFERENCES `piloto` (`codPiloto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- Copiando dados para a tabela companhiaaerea.voo: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `voo` DISABLE KEYS */;
INSERT INTO `voo` (`codVoo`, `PILOTO_codPiloto`, `AEROPORTO_codAeroporto`, `AERONAVE_codAeronave`, `origem`, `destino`) VALUES
	(1, 1, 5, 1, 'São Paulo', 'Rio de Janeiro'),
	(2, 3, 4, 2, 'Belo Horizonte', 'Goiânia'),
	(3, 1, 3, 1, 'Campinas', 'Salvador'),
	(4, 4, 3, 3, 'Rio Branco', 'Curitiba');
/*!40000 ALTER TABLE `voo` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
