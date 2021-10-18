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
depart_time VARCHAR(50),
depart_date VARCHAR(50),
arrive_time VARCHAR(50),
arrive_date VARCHAR(50),
available BOOLEAN, #True if there are still tickets available and False if the flight has sold out
take_off BOOLEAN, #True if the flight has taken off and False if it has not taken off
max_number_of_tickets INT,
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

INSERT INTO customers(customer_id,username, password, email, first_name, last_name) VALUES (1,"TCON", "password", "tyler.conner@revature.net", "Tyler", "Conner");
INSERT INTO customers(customer_id,username, password, email, first_name, last_name) VALUES (2,"Britt", "password", "brittany.lowell@revature.net", "Brittany", "Lowell");
INSERT INTO admins(admin_id,username, password, email, first_name, last_name) VALUES (1,"Britt","password", "brittany.lowell@revature.net", "Brittany", "Lowell");
INSERT INTO tickets(flight_id,customer_id,passenger_first_name,passenger_last_name,passenger_age,checked_in) VALUES (1, 1, "Tyler", "Conner", 30, true);
INSERT INTO tickets(flight_id,customer_id,passenger_first_name,passenger_last_name,passenger_age,checked_in) VALUES (1, 2, "Brittany", "Lowell", 26, false);


INSERT INTO flights (flight_id, pilot_id, depart, arrive, depart_time, depart_date, arrive_time, arrive_date, take_off, max_number_of_tickets) VALUES (846754,1,"ATL","LAX","8:00AM", "10/27/2021", "10:00AM", "10/27/2021", false, 155);
INSERT INTO flights (flight_id, pilot_id, depart, arrive, depart_time, depart_date, arrive_time, arrive_date, take_off, max_number_of_tickets) VALUES (846755,2,"DEN","NYY","8:00AM", "10/27/2021", "12:00PM", "10/27/2021", false, 155);
INSERT INTO flights (flight_id, pilot_id, depart, arrive, depart_time, depart_date, arrive_time, arrive_date, take_off, max_number_of_tickets) VALUES (846756,3,"ATL","LAX","8:00AM", "10/27/2021", "11:00AM", "10/27/2021", false, 155);
INSERT INTO flights (flight_id, pilot_id, depart, arrive, depart_time, depart_date, arrive_time, arrive_date, take_off, max_number_of_tickets) VALUES (846757,4,"ATL","DEN","8:00AM", "10/27/2021", "9:00AM", "10/27/2021", false, 155);
INSERT INTO flights (flight_id, pilot_id, depart, arrive, depart_time, depart_date, arrive_time, arrive_date, take_off, max_number_of_tickets) VALUES (846758,5,"ATL","LAX","12:00PM", "10/27/2021", "3:00PM", "10/27/2021", false, 155);
INSERT INTO flights (flight_id, pilot_id, depart, arrive, depart_time, depart_date, arrive_time, arrive_date, take_off, max_number_of_tickets) VALUES (846759,6,"ATL","DEN","8:00AM", "10/27/2021", "10:00AM", "10/27/2021", false, 155);
INSERT INTO flights (flight_id, pilot_id, depart, arrive, depart_time, depart_date, arrive_time, arrive_date, take_off, max_number_of_tickets) VALUES (846760,7,"NYY","LAX","11:00AM", "10/27/2021", "1:00PM", "10/27/2021", false, 155);
INSERT INTO flights (flight_id, pilot_id, depart, arrive, depart_time, depart_date, arrive_time, arrive_date, take_off, max_number_of_tickets) VALUES (846761,8,"ATL","LAX","8:00AM", "10/27/2021", "10:00AM", "10/27/2021", false, 155);
INSERT INTO flights (flight_id, pilot_id, depart, arrive, depart_time, depart_date, arrive_time, arrive_date, take_off, max_number_of_tickets) VALUES (846765,9,"MOB","LAX","8:00AM", "10/27/2021", "1:00PM", "10/27/2021", false, 155);
INSERT INTO flights (flight_id, pilot_id, depart, arrive, depart_time, depart_date, arrive_time, arrive_date, take_off, max_number_of_tickets) VALUES (846764,10,"LAX","MOB","10:00AM", "10/27/2021", "10:00AM", "10/27/2021", false, 155);

SELECT * FROM customers;
SELECT * FROM admins;
SELECT * FROM pilots;
SELECT * FROM flights;
SELECT * FROM tickets;

