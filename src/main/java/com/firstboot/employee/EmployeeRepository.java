package com.firstboot.employee;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Mashba Uddin Sifat
 * @since 2020-04-14
 */

@Repository
public class EmployeeRepository {

	private static final Logger log = LoggerFactory.getLogger(EmployeeRepository.class);

	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.username}")
	private String user;

	@Value("${spring.datasource.password}")
	private String pass;
	
	/**
	 * 
	 * @return  {@code List} of All {@code Employee}
	 */
	public ArrayList<Employee> getEmployees() {
		
		ArrayList<Employee> empList = new ArrayList<>();

		try {
			Connection con = DriverManager.getConnection(url, user, pass);

			CallableStatement stmt = con.prepareCall("{call getEmployees}");
			boolean isReturn = stmt.execute();

			if (isReturn) {
				ResultSet rs = stmt.getResultSet();
				while (rs.next()) {
//					log.info("Id is " + rs.getInt("id") + ", Name is " + rs.getString("name") + ", Depertment is "
//							+ rs.getString("dept"));
					
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String dept = rs.getString("dept");
					
					Employee emp = new Employee(id, name, dept);
					empList.add(emp);
					
				}
			}
			stmt.close();
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return empList;
	}

	
	/**
	 * 
	 * @param empId As a {@code int}
	 * @return A Single Employee
	 */
	public Employee getEmployeeById(int empId) {

		Employee emp = null;
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			CallableStatement stmt = con.prepareCall("{call getEmployeeById(?)}");

			stmt.setInt(1, empId);

			boolean isReturn = stmt.execute();

			if (isReturn) {
				ResultSet rs = stmt.getResultSet();

				while (rs.next()) {

					int id = rs.getInt("id");
					String name = rs.getString("name");
					String dept = rs.getString("dept");

					emp = new Employee(id, name, dept);
				}
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return emp;
	}

	/**
	 * 
	 * @param emp As a {@code Employee} Object
	 */
	public void addEmployee(Employee emp) {
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			CallableStatement stmt = con.prepareCall("{call addEmployee(?,?)}");

			stmt.setString(1, emp.getName());
			stmt.setString(2, emp.getDepartment());

			stmt.execute();
			log.info("Insert successfull");

			stmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param emp As a {@code Employee} Object
	 */
	public void updateEmployee(Employee emp) {
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			CallableStatement stmt = con.prepareCall("{call updateEmployee(?,?,?)}");

			stmt.setInt(1, emp.getId());
			stmt.setString(2, emp.getName());
			stmt.setString(3, emp.getDepartment());

			stmt.execute();
			log.info("Employee id = " + emp.getId() + " update successfully");

			stmt.close();
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param empId As {@code int}
	 */
	public void deleteEmployee(int empId) {
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			CallableStatement stmt = con.prepareCall("{call deleteEmployee(?)}");

			stmt.setInt(1, empId);

			stmt.execute();
			log.info("Employee " + empId + " delete Successfully");

			stmt.close();
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	
}