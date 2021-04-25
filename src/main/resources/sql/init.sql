CREATE DATABASE papelaria;
use papelaria;

CREATE TABLE `produtos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
   `codigo_barra` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
   `descricao` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
    `categoria` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
    `quantidade` int(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_at` datetime default current_timestamp,
  `updated_at` datetime default current_timestamp,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
