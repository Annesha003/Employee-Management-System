package com.annesha.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.annesha.service.Employee;
import com.annesha.service.EmployeeService;

public class ViewServlet extends HttpServlet {

	private EmployeeService empService=null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Processing doGet..");
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Processing doPost..");
		processRequest(req, resp);
	}

	private void processRequest(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("processing preocessRequest..");
		response.setContentType("text/jsp");
		PrintWriter out=response.getWriter();
		out.println("<h1>EmployeeDetailsEntryList</h1>");

		empService = new EmployeeService();

		List<Employee> list = empService.getAllEmployeeDetails();

		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Employee ID</th><th>Employee Name</th><th>Designation</th><th>Salary</th><th></th><th>");
		for(Employee e:list){
			out.print("<tr><td>"+e.getEmpId()+"</td><td>"+e.getEmpName()+"</td><td>"+e.getDesig()+"</td><td>"+e.getSalary()+"</td>"
					+ "<td><a href='editservlet?id="+e.getEmpId()+"'>edit</a></td><td><a href='removeservlet?id="+e.getEmpId()+"'>remove</a></td></tr>");
		}
		out.print("</table>");

		out.close();

	}
}
