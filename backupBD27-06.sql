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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- Copiando dados para a tabela companhiaaerea.aeronave: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `aeronave` DISABLE KEYS */;
INSERT INTO `aeronave` (`codAeronave`, `nomeAviao`, `qtdAssento`, `autonomia`, `capacidadeCarga`) VALUES
	(1, 'Boeing 777', 345, 7000, 10000);
/*!40000 ALTER TABLE `aeronave` ENABLE KEYS */;

-- Copiando estrutura para tabela companhiaaerea.aeroporto
DROP TABLE IF EXISTS `aeroporto`;
CREATE TABLE IF NOT EXISTS `aeroporto` (
  `codAeroporto` int(11) NOT NULL AUTO_INCREMENT,
  `nomeAeroporto` varchar(255) NOT NULL,
  PRIMARY KEY (`codAeroporto`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- Copiando dados para a tabela companhiaaerea.aeroporto: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `aeroporto` DISABLE KEYS */;
INSERT INTO `aeroporto` (`codAeroporto`, `nomeAeroporto`) VALUES
	(1, 'Congonhas');
/*!40000 ALTER TABLE `aeroporto` ENABLE KEYS */;

-- Copiando estrutura para tabela companhiaaerea.passageiro
DROP TABLE IF EXISTS `passageiro`;
CREATE TABLE IF NOT EXISTS `passageiro` (
  `codPassageiro` int(11) NOT NULL AUTO_INCREMENT,
  `nomePassageiro` varchar(200) NOT NULL,
  `cpf` int(11) NOT NULL,
  `dataNascimento` date NOT NULL,
  PRIMARY KEY (`codPassageiro`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- Copiando dados para a tabela companhiaaerea.passageiro: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `passageiro` DISABLE KEYS */;
INSERT INTO `passageiro` (`codPassageiro`, `nomePassageiro`, `cpf`, `dataNascimento`) VALUES
	(1, 'teste', 12121, '2023-06-10'),
	(2, 'aak', 121212, '1111-11-11'),
	(3, 'teste passageiro', 1201200, '2001-10-12');
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- Copiando dados para a tabela companhiaaerea.passagem: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `passagem` DISABLE KEYS */;
INSERT INTO `passagem` (`codPassagem`, `VOO_codVoo`, `numeroPoltrona`, `pesoBagagem`, `valorPassagem`) VALUES
	(1, 2, 0, 0, 0);
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

-- Copiando dados para a tabela companhiaaerea.piloto: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `piloto` DISABLE KEYS */;
INSERT INTO `piloto` (`codPiloto`, `salario`, `dataAdmissao`, `nomePiloto`, `cpf`, `dataNascimento`) VALUES
	(1, 1250, '2023-02-12', '4111', 111, '2023-02-12'),
	(3, 0, '1111-11-11', '444', 0, '1111-11-11'),
	(4, 0, '1111-11-11', '1', 34, '1111-11-11');
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- Copiando dados para a tabela companhiaaerea.venda: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
INSERT INTO `venda` (`codvenda`, `metodoPagamento`, `data`, `PASSAGEIRO_codPassageiro`) VALUES
	(1, 'Pix', '2023-06-27', 2),
	(2, 'Pix', '2023-06-27', 3),
	(3, 'Pix', '2023-06-27', 3),
	(4, 'Pix', '2023-06-27', 3),
	(5, 'Pix', '2023-06-27', 2),
	(6, 'Pix', '2023-06-27', 1);
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
  CONSTRAINT `fk_venda_has_passagem_passagem1` FOREIGN KEY (`PASSAGEM_codPassagem`) REFERENCES `passagem` (`codPassagem`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_venda_has_passagem_venda1` FOREIGN KEY (`VENDA_codVenda`) REFERENCES `venda` (`codvenda`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- Copiando dados para a tabela companhiaaerea.vendapassagem: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `vendapassagem` DISABLE KEYS */;
INSERT INTO `vendapassagem` (`codVendaPassagem`, `VENDA_codVenda`, `PASSAGEM_codPassagem`) VALUES
	(8, 5, 1),
	(9, 6, 1);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- Copiando dados para a tabela companhiaaerea.voo: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `voo` DISABLE KEYS */;
INSERT INTO `voo` (`codVoo`, `PILOTO_codPiloto`, `AEROPORTO_codAeroporto`, `AERONAVE_codAeronave`, `origem`, `destino`) VALUES
	(1, 1, 1, 1, 'São Paulo', 'Rio de Janeiro'),
	(2, 1, 1, 1, 'Belo Horizonte', 'Rio de Janeiro'),
	(3, 1, 1, 1, 'asd', 'asd');
/*!40000 ALTER TABLE `voo` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
