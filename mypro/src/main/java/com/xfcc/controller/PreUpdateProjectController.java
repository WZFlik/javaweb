package com.xfcc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xfcc.entity.Project;
import com.xfcc.service.ProjectService;

@WebServlet("/preupdatprojectservlet")
public class PreUpdateProjectController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取参数deleteprojectservlet?id=${project.id }
		int id = Integer.parseInt(req.getParameter("id"));
		//调用业务层
		ProjectService is = new ProjectService(); 
		//获取当前的记录
		Project pro = is.getProById(id);
		//进入修改的页面并且显示数据
		req.setAttribute("info", pro);
		req.getRequestDispatcher("updateproject.jsp").forward(req, resp);
		
		
	}

}
