package com.Address.addressService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Address.addressEntity.addressEntity;
import com.Address.addressRepository.addressRepo;
import com.Address.addressResponse.addressResponse;

@Service
public class addressService {

	@Autowired
	private addressRepo addressRep;

    
    public addressResponse getAddressByEmployeeId(int id)
    {
    	 
    	System.out.println("getting address of employee "+id);
    	addressEntity addEn= addressRep.findAddressByEMployeeId(id);
    	
        addressResponse addResp= new addressResponse();
        BeanUtils.copyProperties(addEn, addResp);
    	
    	return addResp;	
    }

}
