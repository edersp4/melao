
-- MySQL dump 10.13  Distrib 5.6.19, for osx10.7 (i386)
--
-- Host: 127.0.0.1    Database: test
-- ------------------------------------------------------
-- Server version	5.1.37

--
-- Table structure for table `cia_seguro`
--


/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cia_seguro` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `segurado`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `segurado` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cep` varchar(255) DEFAULT NULL,
  `cpf` varchar(255) NOT NULL,
  `data_de_nascimento` datetime NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `bairro` varchar(255) DEFAULT NULL,
  `cidade` varchar(255) DEFAULT NULL,
  `complemento` varchar(255) DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `rua` varchar(255) DEFAULT NULL,
  `nome` varchar(255) NOT NULL,
  `telefone` varchar(255) NOT NULL,
  `celular` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `telefone_trab` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;



--
-- Table structure for table `item_seguro`
--


/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_seguro` (
  `tipo_seguro` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cia_seguradora` varchar(255) DEFAULT NULL,
  `data_fim_vigencia` datetime DEFAULT NULL,
  `data_inicio_vigencia` datetime DEFAULT NULL,
  `observacao` varchar(255) DEFAULT NULL,
  `porcentagem_comissao` varchar(255) DEFAULT NULL,
  `premio_liquido` varchar(255) DEFAULT NULL,
  `quantidade_parcela` varchar(255) DEFAULT NULL,
  `susep` varchar(255) DEFAULT NULL,
  `valor_comissao` varchar(255) DEFAULT NULL,
  `capital_segurado` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `chassi` varchar(255) DEFAULT NULL,
  `data_fabricacao` varchar(255) DEFAULT NULL,
  `modelo` varchar(255) DEFAULT NULL,
  `placa` varchar(255) DEFAULT NULL,
  `bairro` varchar(255) DEFAULT NULL,
  `cep` varchar(255) DEFAULT NULL,
  `cidade` varchar(255) DEFAULT NULL,
  `complemento` varchar(255) DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `rua` varchar(255) DEFAULT NULL,
  `cobertura_basica` varchar(255) DEFAULT NULL,
  `tipo_empresa` varchar(255) DEFAULT NULL,
  `valor_aluguel` varchar(255) DEFAULT NULL,
  `id_segurado` bigint(20) DEFAULT NULL,
  `operadora` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7w9q9uy1vv5d8ulu9a0kx8jnr` (`id_segurado`),
  CONSTRAINT `FK7w9q9uy1vv5d8ulu9a0kx8jnr` FOREIGN KEY (`id_segurado`) REFERENCES `segurado` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `usuario`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;


