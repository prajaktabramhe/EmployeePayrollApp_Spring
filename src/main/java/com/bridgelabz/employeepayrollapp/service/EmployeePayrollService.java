package com.bridgelabz.employeepayrollapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService
{
	@Autowired
	private EmployeePayrollRepository employeeRepository;
	private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
	
	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() 
	{
     		return employeePayrollList;
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
		return employeePayrollList.stream().filter(empData -> empData.getEmployeeId() == empId).findFirst()
				.orElseThrow(() -> new EmployeePayrollException("Employee Not Found"));
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) 
	{
		EmployeePayrollData payrollData=null;
		payrollData = new EmployeePayrollData(employeePayrollDTO);
		log.debug("Emp Data: " + payrollData.toString());
		employeePayrollList.add(payrollData);
		return employeeRepository.save(payrollData);
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId,EmployeePayrollDTO employeePayrollDTO) 
	{
		EmployeePayrollData payrollData=this.getEmployeePayrollDataById(empId);
		payrollData.setName(employeePayrollDTO.name);
		payrollData.setSalary(employeePayrollDTO.salary);
		employeePayrollList.set(empId-1, payrollData);
		return payrollData;
	}
	
	@Override
	public void deleteEmployeePayrollData(int empId)
	{
		employeePayrollList.remove(empId-1);
		
	}
	

}
