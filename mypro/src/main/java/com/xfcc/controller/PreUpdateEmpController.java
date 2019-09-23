package com.xfcc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xfcc.entity.Employee;
import com.xfcc.entity.Users;
import com.xfcc.service.EmpService;
import com.xfcc.service.UserService;



@WebServlet( urlPatterns = "/preupdateemployeeservlet")
public class PreUpdateEmpController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int eid = Integer.parseInt(request.getParameter("eid"));
		EmpService es = new EmpService();
		Employee emp  = es.getEmpByid(eid);
		request.setAttribute("emp", emp);
		request.getRequestDispatcher("updateemp.jsp").forward(request, response);
		
		
	}

}
