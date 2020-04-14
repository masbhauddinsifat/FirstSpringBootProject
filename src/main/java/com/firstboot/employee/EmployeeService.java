package com.firstboot.employee;

import java.util.ArrayList;
//import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Masbha Uddin Sifat
 * @since 2019-10-10
 *
 */

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	

	public ArrayList<Employee> getEmployees() {
		return employeeRepository.getEmployees();
	}
	
	public Employee getEmployeeById(int empId) {
		return employeeRepository.getEmployeeById(empId);
	}
	
	public void addEmployee(Employee emp) {
		employeeRepository.addEmployee(emp);
	}
	
	public void updateEmployeeById(Employee emp) {
		employeeRepository.updateEmployee(emp);
	}
	
	public void deleteEmployeeById(int empId) {
		employeeRepository.deleteEmployee(empId);
	}
}
