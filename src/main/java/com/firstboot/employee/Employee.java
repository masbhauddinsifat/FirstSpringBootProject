package com.firstboot.employee;

public class Employee {
	private String id;
	private String name;
	private String department;

	public Employee() {

	}

	public Employee(String id, String name, String department) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [roll=" + id + ", name=" + name + ", department=" + department + "]";
	}


}
