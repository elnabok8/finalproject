DROP DATABASE IF EXISTS bikeshop;
CREATE DATABASE bikeshop;
USE bikeshop;
DROP TABLE IF EXISTS bike_service;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS services;

CREATE TABLE customer (
  customer_pk int unsigned NOT NULL AUTO_INCREMENT,
  first_name varchar(45) NOT NULL, 
  last_name varchar(45) NOT NULL,
  phone varchar(20),
  PRIMARY KEY (customer_pk)
);

CREATE TABLE services (
  services_pk int unsigned NOT NULL AUTO_INCREMENT,
  customer_fk int unsigned NOT NULL,
  service_description varchar(40) NOT NULL,
  cost int NOT NULL,
  PRIMARY KEY (services_pk),
  FOREIGN KEY (customer_fk) REFERENCES customer(customer_pk)
);

CREATE TABLE bike_service (
bike_service_pk int unsigned NOT NULL AUTO_INCREMENT,
first_name varchar(45) NOT NULL, 
last_name varchar(45) NOT NULL,
service_fk varchar (45) NOT NULL,
PRIMARY KEY (bike_service_pk)
);