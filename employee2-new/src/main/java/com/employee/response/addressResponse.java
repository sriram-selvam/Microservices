package com.employee.response;

public class addressResponse {

	private int id;
	

	private String lane1;
	
	private String lane2;
	
	private String State;
	
	private String zip;

	public String getLane1() {
		return lane1;
	}

	public void setLane1(String lane1) {
		this.lane1 = lane1;
	}

	public String getLane2() {
		return lane2;
	}

	public void setLane2(String lane2) {
		this.lane2 = lane2;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
