CREATE DATABASE IF NOT EXISTS dbarticulos;
USE dbarticulos;


DROP TABLE IF EXISTS `articulos`;
CREATE TABLE `articulos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(200) NOT NULL,
  `paginainicio` int(3) NOT NULL,
  `paginafin` int(3) NOT NULL,
  `idrevista` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idrevista` (`idrevista`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

INSERT INTO `articulos` (`id`,`titulo`,`paginainicio`,`paginafin`,`idrevista`) VALUES 
 (1,'Articulo 1',10,25,1),
 (2,'Articulo 2',2,9,1);

DROP TABLE IF EXISTS `autores`;
CREATE TABLE `autores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `adscripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `escribe`;
CREATE TABLE `escribe` (
  `idautor` int(11) NOT NULL,
  `idarticulo` int(11) NOT NULL,
  `posicion` int(2) NOT NULL,
  KEY `idautor` (`idautor`,`idarticulo`),
  KEY `idarticulo` (`idarticulo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;



DROP TABLE IF EXISTS `revistas`;
CREATE TABLE `revistas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) NOT NULL,
  `issn` varchar(50) NOT NULL,
  `numero` int(11) DEFAULT NULL,
  `anio` year(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;



INSERT INTO `revistas` (`id`,`titulo`,`issn`,`numero`,`anio`) VALUES 
 (1,'Revista 1','198798BHJ-LLKIU',NULL,NULL),
 (2,'Revista 2','122y176HJGJGGJ',NULL,NULL),
 (3,'Revista 3','UUYYYUY787787',NULL,NULL);




