//package com.employee.openFeignClient;
//
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
//import org.springframework.context.annotation.Bean;
//
//import feign.Feign;
//
//@LoadBalancerClient(name="ADDRESS-SERVICE",configuration = MyCustomLoadBalancer.class)
//public class AddressServiceLoadBalancer {
//	
//	@LoadBalanced
//	@Bean
//	public Feign.Builder feiBuilder()
//	{
//		 return Feign.builder();
//	}
//
//}
