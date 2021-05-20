package com.bridgelabz.employeepayrollapp.dto;

public class EmployeePayrollDTO 
{

	private String name;
	private long salary;

	public EmployeePayrollDTO(String name, long salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeePayrollDTO [name=" + name + ", salary=" + salary + "]";
	}
	

}
