DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `account_id` varchar(50) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `token` varchar(100) DEFAULT NULL,
  `gmt_create` varchar(100) DEFAULT NULL,
  `gmt_modifile` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;