package com.xfcc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xfcc.dao.EmpDao;
import com.xfcc.entity.Employee;
import com.xfcc.entity.Users;
import com.xfcc.service.EmpService;
import com.xfcc.service.UserService;

@WebServlet(name = "preupdate", urlPatterns = "/preupdateuserservlet")
public class PreUpdateUserController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int uid = Integer.parseInt(request.getParameter("uid"));
		UserService us = new UserService();
		Users user = us.getUserByid(uid);
		request.setAttribute("user", user);
		request.getRequestDispatcher("updateuser.jsp").forward(request, response);
		
		
	}

}