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

	@RequestMapping("/testing")
	public String test() {
		return "test successful server is working";
	}

	@RequestMapping("/employees")
	public ArrayList<Employee> getEmployees() {
		return empService.getEmployees();
	}

	@RequestMapping("employees/{id}")
	public Employee getEmployee(@PathVariable String id) {
		return empService.getEmployee(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		return empService.addEmployee(employee);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/employees/{id}")
	public void updateEmployee(@PathVariable String id, @RequestBody Employee employee) {
		empService.updateEmployee(id, employee);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/employees/{id}")
	public void deleteEmployee(@RequestBody Employee employee, @PathVariable String id) {
		empService.deleteEmployee(id, employee);
	}
}
