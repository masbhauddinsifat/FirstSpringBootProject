package com.firstboot.employee;

import java.util.ArrayList;
import java.util.Arrays;


import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	private ArrayList<Employee> empList = new ArrayList<>(
			Arrays.asList(
			new Employee("001","masbha","full stack"),
			new Employee("002","samiul","full stack"),
			new Employee("003","ridoy","front stack"))
			);

	public ArrayList<Employee> getEmployees(){
		return empList;
	}
	public Employee getEmployee(String id) {
		Employee employee = null;
		for (Employee emp : empList) {
			if (emp.getId().equalsIgnoreCase(id)) {
				employee = emp;
				break;
			}

		}
		return employee;
	}

	public Employee addEmployee(Employee employee) {
		empList.add(employee);
		return employee;

	}

	public void updateEmployee(String id, Employee employee) {
		for (int i = 0; i < empList.size(); i++) {
			if (empList.get(i).getId().equalsIgnoreCase(id)) {
				empList.set(i, employee);
				break;
			}
		}

	}

	public void deleteEmployee(String id, Employee employee) {
		for (int i = 0; i < empList.size(); i++) {
			if (empList.get(i).getId().equalsIgnoreCase(id)) {
				empList.remove(i);
				break;
			}
		}

	}
}
