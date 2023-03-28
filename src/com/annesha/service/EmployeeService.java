package com.annesha.service;

import java.util.List;

import com.annesha.dao.EmployeeDao;

/**
 * @author Annesha  Nayak
 * This class is used as service class for Employee Management System
 *
 */
public class EmployeeService {
	
	/**
	 * This service method is used to insert the new employee by using DAO method
	 * @param emp
	 * @return
	 */
	public int insertRecord(Employee emp) {
		EmployeeDao empDao = new EmployeeDao();
		//any bussiness logic may come here.
		//for example if Employee details to be updated before sending it to DAO layer.
		return empDao.insertRecord(emp);
	}
	
	
	/**
	 * This service method is used to get list of all employees from DAO method.
	 * @return
	 */
	public  List<Employee> getAllEmployeeDetails() {
		EmployeeDao empDao = new EmployeeDao();
		//any bussiness logic may come here.
		//for example if Employee details to be updated before sending it to DAO layer.
		return empDao.getAllEmployeeDetails();
	}
	
	/**
	 * This service method is used to edit/update the existing employee by using DAO method.
	 * @param emp
	 * @return
	 */
	public int update(Employee emp) {
		EmployeeDao empDao = new EmployeeDao();
		//any bussiness logic may come here.
				//for example if Employee details to be updated before sending it to DAO layer.
		return empDao.update(emp);
	}
	
	
	/**
	 * This method is used to get employee from DAO method.
	 * @param empId
	 * @return
	 */
	public Employee getEmployeeById(int empId) {
		EmployeeDao empDao = new EmployeeDao();
		//any bussiness logic may come here.
		//for example if Employee details to be updated before sending it to DAO layer.
		return empDao.getEmployeeById(empId);
	}
	
	
	/**
	 * This method is used to delete the employee by using DAO method.
	 * @param empID
	 * @return
	 */
	public boolean  removeById(int empID ) {
		EmployeeDao empDao = new EmployeeDao();
		return empDao.removeById(empID);
		
	}
}
