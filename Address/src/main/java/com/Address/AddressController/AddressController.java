package com.Address.AddressController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.Address.addressResponse.addressResponse;
import com.Address.addressService.addressService;

@RestController
@RequestMapping("Address")
public class AddressController {
	
	@Autowired
	private addressService addServ; 
	
//	@GetMapping("/getAddress")
//	public String getAdress()
//	{
//		
//		
//		return "mahendra world city";
//	}

	@GetMapping("/addressByid/{id}")
	public ResponseEntity<addressResponse> getEmployeeAddress(@PathVariable("id") int id)
	{
//		return "id returned"+id;
		System.out.print("getEmployeeadress is called");
		addressResponse addRes= addServ.getAddressByEmployeeId(id);
		return ResponseEntity.status(HttpStatus.OK).body(addRes);
	}
	

}
