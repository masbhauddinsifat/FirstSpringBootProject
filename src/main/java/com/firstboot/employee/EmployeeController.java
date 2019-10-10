package com.firstboot.employee;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@RequestMapping("/employees")
	public ArrayList<Employee> getEmployees() {
		return empService.getEmployees();
	}

	@RequestMapping("employees/{id}")
	public Employee getEmployeeById(@PathVariable String id) {
		return empService.getEmployeeById(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/employees")
	public void addEmployee(@RequestBody Employee employee) {
		empService.addEmployee(employee);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/employees/{id}")
	public void updateEmployeeById(@RequestBody Employee employee) {
		empService.updateEmployeeById(employee);
	}

	
	@RequestMapping(method = RequestMethod.DELETE, value = "/employees/{id}")
	public void deleteEmployeeById( @PathVariable String id) {
		empService.deleteEmployeeById(id);
	}
//	@RequestBody Employee employee,, employee
	
	
}
