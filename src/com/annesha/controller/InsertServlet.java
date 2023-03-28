package com.annesha.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.annesha.service.Employee;
import com.annesha.service.EmployeeService;

public class InsertServlet extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(req, resp);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(req, resp);
	}


	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int empiD = Integer.valueOf(req.getParameter("empiD"));
		String empName = req.getParameter("empName");
		String desig = req.getParameter("desig");
		int salary = Integer.valueOf(req.getParameter("salary"));

		Employee employee = new Employee(empiD,empName, desig,salary);

		EmployeeService employeeService = new EmployeeService();
		int status = employeeService.insertRecord(employee);

		PrintWriter out=resp.getWriter();  
		resp.setContentType("text/html");  
		if(status>0){  
			out.print("<p>Record saved successfully!</p>");  
			req.getRequestDispatcher("/").include(req, resp);  
		}else
		{  
			out.println("Sorry! unable to save record");  
		}  
		out.close();  
	}
}
