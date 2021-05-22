package com.bridgelabz.employeepayrollapp.service;

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
	
	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() 
	{
		return employeeRepository.findAll();
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) 
	{
		return employeeRepository.findById(empId).orElseThrow(
				() -> new EmployeePayrollException("Employee with employee id : " + empId + " does not exists "));
	}
	
	@Override
	public List<EmployeePayrollData> getEmployeesByDepartment(String department) {
		return employeeRepository.findEmployeesById(department);
	}
	
	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) 
	{
		EmployeePayrollData payrollData=null;
		payrollData = new EmployeePayrollData(employeePayrollDTO);
		log.debug("Emp Data: " + payrollData.toString());
		return employeeRepository.save(payrollData);
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) 
	{
		EmployeePayrollData payrollData = this.getEmployeePayrollDataById(empId);
		payrollData.updateEmployeePayrollData(employeePayrollDTO);
		return employeeRepository.save(payrollData);
	}

	@Override
	public void deleteEmployeePayrollData(int empId) 
	{
		EmployeePayrollData payrollData = this.getEmployeePayrollDataById(empId);
		employeeRepository.delete(payrollData);

	}


}
