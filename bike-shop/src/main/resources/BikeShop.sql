DROP DATABASE IF EXISTS bikeshop;
CREATE DATABASE bikeshop;
USE bikeshop;
DROP TABLE IF EXISTS work_order;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS services;

CREATE TABLE customer (
  customer_id int unsigned NOT NULL AUTO_INCREMENT,
  first_name varchar(45) NOT NULL, 
  last_name varchar(45) NOT NULL,
  phone varchar(20),
  PRIMARY KEY (customer_id)
);

CREATE TABLE services (
  service_id int unsigned NOT NULL AUTO_INCREMENT,
  customer_id int unsigned NOT NULL,
  service_description varchar(40) NOT NULL,
  cost float NOT NULL,
  PRIMARY KEY (service_id),
  FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);

CREATE TABLE work_order (
work_order_id int unsigned NOT NULL AUTO_INCREMENT,
first_name varchar(45) NOT NULL, 
last_name varchar(45) NOT NULL,
service_id varchar (45) NOT NULL,
PRIMARY KEY (work_order_id)
);