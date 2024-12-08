package com.employee;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class employeeConfig {

	
	@Bean
	@LoadBalanced
	public RestTemplate rest()
	{
		return new RestTemplate();
	}
	
	
	@Bean
	public WebClient webclient()
	{
		return WebClient.builder().build();
	}
}
// sql queries used
//CREATE TABLE employee (
//	    id INT PRIMARY KEY AUTO_INCREMENT,
//	    name VARCHAR(100) NOT NULL,
//	    email VARCHAR(100) NOT NULL,
//	    bloodgroup VARCHAR(5)
//	);
//
//	desc employee;
//	select * from employee; 
//
//	INSERT INTO employee (name, email, bloodgroup) VALUES
//	('John Doe', 'john.doe@example.com', 'A+'),
//	('Jane Smith', 'jane.smith@example.com', 'B-'),
//	('Alice Johnson', 'alice.johnson@example.com', 'O+'), 
//	('Bob Brown', 'bob.brown@example.com', 'AB+'),
//	('Charlie Davis', 'charlie.davis@example.com', 'O-');CREATE TABLE address (
//	    id INT PRIMARY KEY AUTO_INCREMENT,
//	    lane1 VARCHAR(255) NOT NULL,
//	    lane2 VARCHAR(255),
//	    state VARCHAR(100) NOT NULL,
//	    zip VARCHAR(10) NOT NULL
//	);
//
//	INSERT INTO address (lane1, lane2, state, zip, employee_id) VALUES
//	('123 Main St', 'Apt 4B', 'California', '90001', 1),
//	('456 Oak St', NULL, 'Texas', '73301', 2),
//	('789 Pine St', 'Suite 12', 'New York', '10001', 3),
//	('321 Elm St', NULL, 'Florida', '33101', 4),
//	('654 Cedar St', 'Apt 6C', 'Illinois', '60601', 5);
//
//
//
