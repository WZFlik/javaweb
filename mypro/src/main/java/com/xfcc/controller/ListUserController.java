package com.xfcc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xfcc.entity.Users;
import com.xfcc.service.UserService;
@WebServlet(name = "listuser",urlPatterns = "/listuserservlet")
public class ListUserController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		UserService us = new UserService();
		List<Users> listusers = us.findAllUsers();
		request.setAttribute("listusers", listusers);
		//调试显示虽有user
		for (Users users : listusers) {
			System.out.println(users.getRealname());
			
		}
		//进入显示数据的页面showusers.jsp
		request.getRequestDispatcher("showusers.jsp").forward(request, response);
		
	}
	
	
	

}
