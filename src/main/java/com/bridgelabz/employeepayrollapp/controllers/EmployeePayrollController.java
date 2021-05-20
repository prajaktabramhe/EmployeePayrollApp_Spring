package com.bridgelabz.employeepayrollapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController 
{
	@Autowired
	private IEmployeePayrollService employeePayrollService;
	
	@RequestMapping(value = {"","/","/get"})
	public ResponseEntity<ResponseDTO> getEmployeePayrollData()
	{
		List<EmployeePayrollData> employeePayrollList=null;
		employeePayrollList=employeePayrollService.getEmployeePayrollData();
		ResponseDTO responseDTO = new ResponseDTO("Get Call Success",employeePayrollList);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
		
	}
	
	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId)
	{
		EmployeePayrollData payrollData=null;
		payrollData=employeePayrollService.getEmployeePayrollDataById(empId);
		ResponseDTO responseDTO = new ResponseDTO("Get Call Success for id:", payrollData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
	
	/**
	 * API to add new employee to DB
	 */
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO)
	{
		EmployeePayrollData payrollData=null;
		payrollData=employeePayrollService.createEmployeePayrollData(employeePayrollDTO);
		ResponseDTO responseDTO = new ResponseDTO("Created Employee payroll data for:", payrollData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO)
	{
		EmployeePayrollData payrollData=null;
		payrollData=employeePayrollService.updateEmployeePayrollData(employeePayrollDTO);
		ResponseDTO responseDTO = new ResponseDTO("Updated Employee payroll Data for: ", payrollData);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId)
	{
		employeePayrollService.deleteEmployeePayrollData(empId);
		ResponseDTO responseDTO = new ResponseDTO("Delete Call Success for id: ", "empId "+empId);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
}
