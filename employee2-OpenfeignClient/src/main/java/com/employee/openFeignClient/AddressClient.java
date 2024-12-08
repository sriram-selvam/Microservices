package com.employee.openFeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.employee.response.addressResponse;



@FeignClient(name="ADDRESS-SERVICE",path="/address-api/Address")
public interface AddressClient {
	
	@GetMapping("/addressByid/{id}")
	public addressResponse getEmployeeAddress(@PathVariable("id") int id); 

}
// the addressservice load balancer code is implemented to achieve the custom load balancing technique