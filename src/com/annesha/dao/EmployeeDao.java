package com.annesha.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.annesha.service.Employee;

/**
 * This class is used as DAO class for Employee management System.
 * @author Annesha  Nayak
 *
 */
public class EmployeeDao {
	Connection con = null;
	
	/**
	 * This method is used to get database connection.
	 * @return
	 */
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3305/empsystem", "root", "root");
			System.out.println("connected to database..");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * This method is used to insert employee in database table.
	 * @param emp
	 * @return
	 */
	public int insertRecord(Employee emp) {
		int status=0;
		try {
			con = getConnection();
			String insertQuery = "insert into employee(empId,empName,desig,salary) values (?,?,?,?)";
			PreparedStatement ps = con
					.prepareStatement(insertQuery);
			ps.setInt(1,emp.getEmpId());
			ps.setString(2,emp.getEmpName());
			ps.setString(3,emp.getDesig());
			ps.setInt(4, emp.getSalary());

			status = ps.executeUpdate();
			System.out.println("Insertion is completed with status :"+status);
			

		}catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	/**
	 * This method is used fete list of employees from database table
	 * @return
	 */
	public  List<Employee> getAllEmployeeDetails() {
		List<Employee> list = new ArrayList<Employee>();
		System.out.println("retriving employee details..");
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from employee ORDER BY empId");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employee emp =new Employee();
				emp.setEmpId(rs.getInt(1)); 
				emp.setEmpName(rs.getString(2));
				emp.setDesig(rs.getString(3));
				emp.setSalary(rs.getInt(4));
				list.add(emp);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	/**
	 * This method is used update employee in database table
	 * @param e
	 * @return
	 */
	public int update(Employee e) {
		int status = 0;
		try {
			Connection con = getConnection();
			//empId,empName,desig,salary
			PreparedStatement ps = con
					.prepareStatement("update employee set empName=?,desig=?,salary=? where empId=?");
			//ps.setInt(1, e.getId());
			//ps.setInt(1, e.getEmpId());
			ps.setString(1, e.getEmpName());
			ps.setString(2, e.getDesig());
			ps.setInt(3, e.getSalary());
			ps.setInt(4, e.getEmpId());
			status = ps.executeUpdate();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	/**
	 * This method is used to get employee from database table
	 * @param empId
	 * @return
	 */
	public Employee getEmployeeById(int empId) {
		Employee e=new Employee();

		try {
			Connection con = getConnection();
			Statement st = con.createStatement();
			//ps.execute(("select * from employee where empId="+empId)
			//ps.setString(1, "'"+empId+"'");
			ResultSet rs = st.executeQuery("select * from employee where empId='"+empId+"'");
			if (rs.next()) {
				e.setEmpId(rs.getInt(1));
				e.setEmpName(rs.getString(2));
				e.setDesig(rs.getString(3));
				e.setSalary(rs.getInt(4));
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return e;
	}

	/**
	 * This method is used delete emplyee in database table
	 * @param empID
	 * @return
	 */
	public boolean  removeById(int empID ) {
		boolean result=false;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("Delete from employee where empId=?");
			ps.setInt(1,empID);
			ps.executeUpdate();
			result=true;
			con.close();
		} catch (Exception e) {
			result=false;
			e.printStackTrace();
		} 
		return result;
	}
}
