package com.employee.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancedRetryFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.employee.entity.employeeEntity;
import com.employee.repo.employeeRepository;
import com.employee.response.addressResponse;
import com.employee.response.employeeResponse;

@Service
public class employeeService {
  
	
	@Autowired
	private employeeRepository empRepo;
   
	@Autowired
	private WebClient webcli;
	@Autowired
	private RestTemplate restTemp;
//	
//	@Autowired
//	private DiscoveryClient discoveryClient;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	
	@Value("${addressService.base.url}")
	private String baseUrl;
	
	@LoadBalanced
	public employeeResponse getEmployee(int id)
	{
		employeeEntity entity= empRepo.findById(id).get();
		employeeResponse empRes= new employeeResponse();
		
		BeanUtils.copyProperties(entity, empRes);
		
		  addressResponse addr = callingUsingRestTemplate(id);
		  empRes.setAddrespose(addr);
//		BeanUtils is used to copy all obj from one to another
//
//	
//	empRes.setId(entity.getId());
//	empRes.setEmail(entity.getEmail());
//	empRes.setName(entity.getName());
//	empRes.setBloodGroup(entity.getBloodGroup());
	
	return empRes;
	}

	private addressResponse callingUsingRestTemplate(int id) {
		
		/// here we used the discovery client method for instances
		// it is going to get all the instances from the eureka server
//		List<ServiceInstance> instances= discoveryClient.getInstances("Address-service");
//		ServiceInstance  serviceInstance=instances.get(0); //1 in this case always the url hit the only one port and host. so the load balancing is not yet came into the picture
//		String uri=serviceInstance.getUri().toString();// to implement the load balance instead of dicovery client we can use 
//		System.out.println("uri>>>>>>>>>>>>>"+uri);
//		System.out.println(instances);
		
		
		//now we are going to use the loadbalancer client for the load balancer
//		ServiceInstance instances= loadBalancerClient.choose("Address-service");
//		String uri=instances.getUri().toString();
//		String configPath= instances.getMetadata().get("configPath");
//		String name= instances.getMetadata().get("name");
//		System.out.println(name);
//		return restTemp.getForObject(uri+configPath+"/Address/addressByid/{id}", addressResponse.class, id);
		return restTemp.getForObject("http://Address-service/address-api/Address/addressByid/{id}", addressResponse.class, id);
	}
// to 
	private addressResponse callingUsingWebClient(int id) {
		return webcli
				  .get()
				  .uri(baseUrl+"/Address/addressByid/"+id)
				  .retrieve()
				  .bodyToMono(addressResponse.class)
				  .block();
	}
}
