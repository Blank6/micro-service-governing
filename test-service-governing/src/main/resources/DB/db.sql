CREATE DATABASE db_micro_service_governing;
USE db_micro_service_governing;

DROP TABlE IF EXISTS table_user;
CREATE TABLE table_user (
  user_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  user_name VARCHAR(255) NOT NULL ,
  user_password VARCHAR(255) NOT NULL ,
  user_phone VARCHAR(255) NOT NULL
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

INSERT INTO table_user (user_name, user_password, user_phone) VALUES
("莱昂纳多·小沈阳", "123456", "11111111111"),
("约翰尼·宋小宝", "123456", "22222222222"),
("克里斯蒂安·刘能", "123456", "33333333333"),
("尼古拉斯·赵四", "123456", "33333333333");


DROP TABLE IF EXISTS table_micro_service_info;
CREATE TABLE table_micro_service_info (
  service_id INT NOT NULL  PRIMARY KEY AUTO_INCREMENT,
  service_name VARCHAR(64),
  service_secret VARCHAR(64),
  service_registry_url VARCHAR(64) NOT NULL,
  service_status VARCHAR (8) DEFAULT "disabled",
  service_description VARCHAR(255),
  team_members VARCHAR(255),
  team_introduction VARCHAR(255)
)ENGINE=INNODB DEFAULT CHARSET=utf8;