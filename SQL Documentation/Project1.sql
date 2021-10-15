###########################################################
################## CREATE FRESH DATABASE ##################
###########################################################
DROP DATABASE IF EXISTS Brittany_DB;
CREATE DATABASE Brittany_DB;

USE Brittany_DB;


DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS pilots;
DROP TABLE IF EXISTS admins;
DROP TABLE IF EXISTS flights;
DROP TABLE IF EXISTS tickets;

CREATE TABLE customers 
(
customer_id 	INT AUTO_INCREMENT,
username	varchar(50) UNIQUE,
password	VARCHAR(50),
email 		VARCHAR(200),
first_name VARCHAR(50),
last_name VARCHAR(50),
CONSTRAINT PRIMARY KEY (customer_id)
);

CREATE TABLE pilots 
(
pilot_id 	INT AUTO_INCREMENT,
username	varchar(50) UNIQUE,
password	VARCHAR(50),
email 		VARCHAR(200),
first_name VARCHAR(50),
last_name VARCHAR(50),
CONSTRAINT PRIMARY KEY (pilot_id)
);

CREATE TABLE admins 
(
admin_id 	INT AUTO_INCREMENT,
username	varchar(50) UNIQUE,
password	VARCHAR(50),
email 		VARCHAR(200),
first_name VARCHAR(50),
last_name VARCHAR(50),
CONSTRAINT PRIMARY KEY (admin_id)
);

CREATE TABLE flights 
(
flight_id INT AUTO_INCREMENT,
pilot_id INT,
depart VARCHAR(50),
arrive VARCHAR(50),
depart_time TIME,
depart_date DATE,
arrive_time TIME,
arrive_date DATE,
CONSTRAINT PRIMARY KEY (flight_id),
CONSTRAINT pilot_to_flight FOREIGN KEY (pilot_id) REFERENCES pilots (pilot_id)
);

CREATE TABLE tickets
(
ticket_id INT AUTO_INCREMENT,
flight_id INT,
customer_id INT,
passenger_first_name VARCHAR(50),
passenger_last_name VARCHAR(50),
passenger_age INT,
CONSTRAINT pk PRIMARY KEY (ticket_id),
CONSTRAINT ticket_to_flight FOREIGN KEY (flight_id) REFERENCES flights (flight_id),
CONSTRAINT ticket_to_customer FOREIGN KEY (customer_id) REFERENCES customers (customer_id)
);





###########################################################
################## TEST CREATING A USER ##################
###########################################################

INSERT INTO customers (username, password, email, first_name, last_name) VALUES ("TCON", "password", "tyler.conner@revature.net", "Tyler", "Conner");
INSERT INTO customers (username, password, email, first_name, last_name) VALUES ("Britt", "password", "brittany.lowell@revature.net", "Brittany", "Lowell");
INSERT INTO admins (username, password, email, first_name, last_name) VALUES ("Britt","password", "brittany.lowell@revature.net", "Brittany", "Lowell");
SELECT * FROM customers;
SELECT * FROM admins;

