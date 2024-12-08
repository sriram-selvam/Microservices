package com.employee.employeeController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.employee.response.addressResponse;
import com.employee.response.employeeResponse;
import com.employee.service.employeeService;


@RestController
@RequestMapping("/employee")
public class employeeController {

	@Autowired
	private RestTemplate rest;
 //microservice connetion	
//	@GetMapping("/getEmployee")
//	public String getEmployee() {
//		 String add= rest.getForObject("http://localhost:8081/Address/getAddress", String.class);
//              return  "hi ram"+add;		
//	}

	
	@Autowired
	private employeeService empService;
	
	@Autowired
	private RestTemplate restTemp;
	
	//responseEntity is recommended to use to know the status of our response
	
	@GetMapping("/employees/{id}")
public ResponseEntity<employeeResponse> getEmployees(@PathVariable("id") int id)
	{
//		return "hi ram"+id;
	
	///set data by api call

		employeeResponse emp= empService.getEmployee(id); 
     
		return ResponseEntity.status(HttpStatus.OK).body(emp);
	}
}
