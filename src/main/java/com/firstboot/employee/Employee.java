package com.firstboot.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author Masbha Uddin Sifat
 * @since 2019-10-10
 */

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(name = "dept")
	private String department;

	public Employee() {

	}

	public Employee(int id, String name, String department) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setId(int id) {
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
