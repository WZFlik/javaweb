package com.xfcc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xfcc.entity.Employee;
import com.xfcc.service.EmpService;

@WebServlet(urlPatterns = "/employeelistservlet")
public class ListEempController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		EmpService es = new EmpService();
		List<Employee>  empList = es.findAllEmp();
		req.setAttribute("employees",empList);
		req.getRequestDispatcher("employeelist.jsp").forward(req, resp);
		
		
	}
	
	

}
