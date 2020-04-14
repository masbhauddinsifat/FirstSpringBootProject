package com.firstboot.employee;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Masbha Uddin Sifat
 * @since 2019-10-10
 *
 */

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empService;


	@RequestMapping(method=RequestMethod.GET, value="/employees")
	public ArrayList<Employee> getEmployees() {
		return empService.getEmployees();
	}

	@RequestMapping(method=RequestMethod.GET, value="/employees/{empId}")
	public Employee getEmployeeById(@PathVariable int empId) {
		return empService.getEmployeeById(empId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/employees")
	public void addEmployee(@RequestBody Employee employee) {
		empService.addEmployee(employee);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/employees/{empId}")
	public void updateEmployeeById(@RequestBody Employee employee) {
		empService.updateEmployeeById(employee);
	}

	
	@RequestMapping(method = RequestMethod.DELETE, value = "/employees/{empId}")
	public void deleteEmployeeById( @PathVariable int empId) {
		empService.deleteEmployeeById(empId);
	}

	
}
