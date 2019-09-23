package com.xfcc.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.xfcc.service.UserService;
//实现注册的控制器
@WebServlet (name = "rigister" ,urlPatterns="/registservlet")
public class RegistController  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request	.setCharacterEncoding("utf-8");
	String username = request.getParameter("username");
	String realname = request.getParameter("realname");
	String password = request.getParameter("password");
	
	System.out.println("=username:"+username +"=realname:" +realname+"realname"+"==p:"+password);
	//访问业务层
	UserService user = new UserService();
	//受影响的行数
	int counter = user.rigeter(username, password, realname);
	
	if(counter!=0){
		request.setAttribute("errorInfo", "注册成功");
		request.getRequestDispatcher("register.jsp").forward(request, response);
		
	}else{
		request.setAttribute("errorInfo", "注册失败");
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}
	
	}
}
