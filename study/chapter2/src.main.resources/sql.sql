DROP DATABASE IF EXIT sampledb;
CREATE DATABASE sampledb DEFAULT CHARACTER SET utf8;
USE sampledb;
##�����û���
CREATE TABLE t_user(
 user_id INT auto_increment PRIMARY KEY,
 user_name VARCHAR(30),
 credits INT,
 password VARCHAR(32),
 last_visit datetime,
 last_ip VARCHAR(23)
)ENGINE=InnoDB; 
##�����û���½��־��
CREATE TABLE t_login_log(
 login_log_id INT auto_increment PRIMARY key,
 user_id int,
 ip VARCHAR(23),
 login_datetime datetime
)ENGINE=InnoDB;

INSERT INTO t_user(user_name, password) VALUES ('admin', '123456');
