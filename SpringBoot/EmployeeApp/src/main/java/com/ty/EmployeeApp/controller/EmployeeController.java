package com.ty.EmployeeApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.EmployeeApp.dto.EmployeeRequest;
import com.ty.EmployeeApp.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeRequest saveEmp(@RequestBody EmployeeRequest employeeRequest) {
		System.out.println(employeeRequest.getName());
		System.out.println(employeeRequest.getEmail());
		System.out.println(employeeRequest.getSalary());
		return employeeRequest;
	}

	
	@PostMapping(value = "/get", 
							consumes = { 
									MediaType.APPLICATION_XML_VALUE, 
									MediaType.APPLICATION_JSON_VALUE },
							produces = { 
									MediaType.APPLICATION_XML_VALUE, 
//									MediaType.APPLICATION_JSON_VALUE 
									})
	public EmployeeRequest getEmp(@RequestBody EmployeeRequest employeeRequest) {
		System.out.println(employeeRequest.getName());
		System.out.println(employeeRequest.getEmail());
		System.out.println(employeeRequest.getSalary());
		return employeeRequest;
	}
}
