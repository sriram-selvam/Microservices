package com.employee.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.employee.entity.employeeEntity;
import com.employee.feignClient.AddressClient;
import com.employee.repo.employeeRepository;
import com.employee.response.addressResponse;
import com.employee.response.employeeResponse;

@Service
public class employeeService {
  
	
	@Autowired
	private employeeRepository empRepo;
   
	@Autowired
	private AddressClient addrscli;
	
	
	@Value("${addressService.base.url}")
	private String baseUrl;
	
	public employeeResponse getEmployee(int id)
	{
		employeeEntity entity= empRepo.findById(id).get();
		employeeResponse empRes= new employeeResponse();
		
		BeanUtils.copyProperties(entity, empRes);
		
		  addressResponse addr =addrscli.getEmployeeAddress(id);

		  empRes.setAddrespose(addr);
	
	return empRes;
	}
}
