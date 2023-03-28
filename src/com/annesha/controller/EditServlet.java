package com.annesha.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.annesha.service.Employee;
import com.annesha.service.EmployeeService;

public class EditServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("EditServlet doGet...");
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("EditServlet doPost...");
		processRequest(req, resp);
	}

	private void processRequest(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<a href='index.html'>Employee Entry</a>");	
		out.println("<h1>Update Employee Details Entry <h1>");
		String id =req.getParameter("id");
		int empId=Integer.parseInt(id);
		System.out.println("Emp ID:"+empId);
		
		EmployeeService employeeService = new EmployeeService();
		Employee e = employeeService.getEmployeeById(empId);
		System.out.println("retrived empID : "+e.getEmpId());
		
		out.print("<form action='editservlet2' method='post'>");  
		out.print("<table>");  
		out.print("<tr><td></td><td><input type='hidden' name='empiD' value='"+e.getEmpId()+"'/></td></tr>");  
		out.print("<tr><td>Employee Name:</td><td><input type='text' name='empName' value='"+e.getEmpName()+"'/></td></tr>");  

		out.print("<tr><td>Designation:</td><td><input type='text' name='desig' value='"+e.getDesig()+"'/></td></tr>");  
		out.print("<tr><td>Salary:</td><td><input type='text' name='salary' value='"+e.getSalary()+"'/></td></tr>");  
		out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
		out.print("</table>");  
		out.print("</form>");  

		out.close();  
	}
}
