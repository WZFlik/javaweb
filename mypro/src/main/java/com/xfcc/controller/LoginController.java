package com.xfcc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xfcc.entity.Users;
import com.xfcc.service.UserService;


@WebServlet(name = "login" ,urlPatterns = "/loginservlet")
public class LoginController extends  HttpServlet{
	//创建sevelet 控制器 和注解
	protected void doPost(HttpServletRequest reqest, HttpServletResponse response) throws ServletException, IOException {
		//处理乱码
		reqest.setCharacterEncoding("utf-8");
		//获取页面login.jsp的传输参数
		String username = reqest.getParameter("username");
		String password = reqest.getParameter("password");
		System.out.println("参数测试");
		
		//控制访问业务层
		UserService us = new UserService();
		Users u = us.login(username,password);
		System.out.println(username+password);
		if(u != null){
			//该方式不能访问WEB-INF目录
			//response.sendRedirect("main.jsp");
			reqest.getSession().setAttribute("u", u);
			System.out.println("用户"+u.getUsername()+"登录成功");
			reqest.getRequestDispatcher("index.jsp").forward(reqest, response);
			}else{
				//登录失败,设置request属性
				reqest.setAttribute("errorInfo", "账号或密码错误");
				//返回login.jsp
				reqest.getRequestDispatcher("login.jsp").forward(reqest, response);
				//response.sendRedirect("index.jsp");
				System.out.println("登录失败");
				
			}
		
		
		
	}

}
