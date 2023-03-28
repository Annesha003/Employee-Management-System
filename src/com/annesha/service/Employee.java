package com.annesha.service;

public class Employee {
	int empId;
	String empName=null;
	String desig=null;
	int salary;
	
	public Employee() {
		
	}
	
	public Employee(int empId, String empName, String desig, int salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.desig = desig;
		this.salary = salary;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDesig() {
		return desig;
	}
	public void setDesig(String desig) {
		this.desig = desig;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
}
