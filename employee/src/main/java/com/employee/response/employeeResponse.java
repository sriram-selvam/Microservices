package com.employee.response;

public class employeeResponse {

	
	private int id;

	private String name;
	
	private String email;
	
	private String bloodGroup;

	private addressResponse addrespose;
	
	public addressResponse getAddrespose() {
		return addrespose;
	}

	public void setAddrespose(addressResponse addrespose) {
		this.addrespose = addrespose;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
}
