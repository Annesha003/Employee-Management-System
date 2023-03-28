package com.annesha.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.annesha.service.EmployeeService;

public class RemoveServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("RemoveServlet doGet...");
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("RemoveServlet doPost...");
		processRequest(req, resp);
	}

	private void processRequest(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		EmployeeService empService=new EmployeeService();
		Boolean status=empService.removeById(id);
		if(status)
			response.sendRedirect("viewservlet");
		else
			response.getWriter().println("Unable to delete");
	}
}
