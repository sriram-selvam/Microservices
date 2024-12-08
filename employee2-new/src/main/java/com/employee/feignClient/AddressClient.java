package com.employee.feignClient;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.employee.response.addressResponse;


//http://localhost:8081/address-api/Address/addressByid/3
@FeignClient(name="address-service")
@RibbonClient(name="address-service")
public interface AddressClient {
 
	@GetMapping("/address-api/Address/addressByid/{id}")
	public addressResponse getEmployeeAddress(@PathVariable("id") int id);

}

//http://localhost:8082/address-api/Address/addressByid/1
//http://localhost:8081/address-api/Address/addressByid/1
