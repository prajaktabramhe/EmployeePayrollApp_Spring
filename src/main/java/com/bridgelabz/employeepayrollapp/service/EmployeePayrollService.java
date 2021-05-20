package com.bridgelabz.employeepayrollapp.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

@Service
public class EmployeePayrollService implements IEmployeePayrollService
{

	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		List<EmployeePayrollData> employeePayrollList=new ArrayList<>();
		employeePayrollList.add(new EmployeePayrollData(1, new EmployeePayrollDTO("Prajakta", 40000000)));
		return employeePayrollList;
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
		EmployeePayrollData payrollData=null;
		payrollData=new EmployeePayrollData(2,new EmployeePayrollDTO("Arun", 450000));
		return payrollData;
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData payrollData=null;
		payrollData=new EmployeePayrollData(3, employeePayrollDTO);
		return payrollData;
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData payrollData=null;
		payrollData=new EmployeePayrollData(3, employeePayrollDTO);
		return payrollData;
	}

	@Override
	public void deleteEmployeePayrollData(int empId) {
		// TODO Auto-generated method stub
		
	}
	

}
