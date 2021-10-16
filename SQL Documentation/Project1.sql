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
available BOOLEAN, #True if there are still tickets available and False if the flight has sold out
take_off BOOLEAN, #True if the flight has taken off and False if it has not taken off
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
checked_in BOOLEAN, #True if the passenger has checked in and false if they have not checked in 
CONSTRAINT pk PRIMARY KEY (ticket_id),
CONSTRAINT ticket_to_flight FOREIGN KEY (flight_id) REFERENCES flights (flight_id),
CONSTRAINT ticket_to_customer FOREIGN KEY (customer_id) REFERENCES customers (customer_id)
);





###########################################################
################## TEST CREATING A USER ##################
###########################################################

INSERT INTO pilots(username, password, email, first_name, last_name) VALUES ("Britt","password","brittany.lowell@revature.net", "Brittany", "Lowell");
INSERT INTO flights(pilot_id,depart,arrive,depart_time,depart_date,arrive_time,arrive_date,available,take_off) VALUES (1, "DIA", "LAX","12:30","2021-10-20","11:30","2021-10-20",true,false);
INSERT INTO customers(customer_id,username, password, email, first_name, last_name) VALUES (1,"TCON", "password", "tyler.conner@revature.net", "Tyler", "Conner");
INSERT INTO customers(customer_id,username, password, email, first_name, last_name) VALUES (2,"Britt", "password", "brittany.lowell@revature.net", "Brittany", "Lowell");
INSERT INTO admins(admin_id,username, password, email, first_name, last_name) VALUES (1,"Britt","password", "brittany.lowell@revature.net", "Brittany", "Lowell");
INSERT INTO tickets(flight_id,customer_id,passenger_first_name,passenger_last_name,passenger_age,checked_in) VALUES (1, 1, "Tyler", "Conner", 30, true);
INSERT INTO tickets(flight_id,customer_id,passenger_first_name,passenger_last_name,passenger_age,checked_in) VALUES (1, 2, "Brittany", "Lowell", 26, false);

SELECT * FROM customers;
SELECT * FROM admins;
SELECT * FROM pilots;
SELECT * FROM flights;
SELECT * FROM tickets;

