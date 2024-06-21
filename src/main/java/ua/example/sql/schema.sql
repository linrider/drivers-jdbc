CREATE DATABASE IF NOT EXISTS drivers;
USE drivers;

CREATE TABLE drivers (
	driver_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	first_name VARCHAR(30) NOT NULL,
	last_name VARCHAR(30) NOT NULL,
	age INT NOT NULL,
	qualification ENUM('TRAINY', 'PRO', 'EXPERT')
);

CREATE TABLE trucks (
	truck_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	model VARCHAR(30) NOT NULL,
	model_year INT NOT NULL,
	fk_driver_id INT,
	FOREIGN KEY (fk_driver_id) REFERENCES drivers(driver_id)
);