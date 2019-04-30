CREATE DATABASE test_governing;
USE test_governing;

DROP TABlE IF EXISTS table_user;
CREATE TABLE table_user (
  userId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  userName VARCHAR(255) NOT NULL ,
  password VARCHAR(255) NOT NULL ,
  phone VARCHAR(255) NOT NULL
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

INSERT INTO table_user (userName, password, phone) VALUES
("莱昂纳多·小沈阳", "123456", "11111111111"),
("约翰尼·宋小宝", "123456", "22222222222"),
("克里斯蒂安·刘能", "123456", "33333333333"),
("尼古拉斯·赵四", "123456", "33333333333");


DROP TABLE IF EXISTS table_application_info;
CREATE TABLE table_application_info (
  app VARCHAR(64) PRIMARY KEY,
  registryUrl VARCHAR(64) NOT NULL,
  status VARCHAR (8) DEFAULT "disabled"
)ENGINE=INNODB DEFAULT CHARSET=utf8;