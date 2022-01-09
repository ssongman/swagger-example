package com.ssongman.resource.model;

import io.swagger.annotations.ApiModelProperty;

public class User {
	
	@ApiModelProperty(notes = "name of the User")
	private String userName;
	
	@ApiModelProperty(notes = "salary of the User")
	private Long Salary;

	public User(String userName, Long salary) {
		super();
		this.userName = userName;
		Salary = salary;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getSalary() {
		return Salary;
	}
	public void setSalary(Long salary) {
		Salary = salary;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", Salary=" + Salary + "]";
	}
	

}
