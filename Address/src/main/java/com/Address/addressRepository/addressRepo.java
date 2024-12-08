package com.Address.addressRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Address.addressEntity.addressEntity;

public interface addressRepo extends JpaRepository<addressEntity, Integer>{

	
	@Query(nativeQuery = true,value="select ea.id,ea.lane1,ea.lane2,ea.state,ea.zip from application.address ea "
			+ "join application.employee e on e.id=ea.employee_id where ea.employee_id=:id")
	addressEntity findAddressByEMployeeId(@Param("id") int id);
	
}
