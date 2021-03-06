package com.xfcc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xfcc.entity.Information;
import com.xfcc.service.InformationService;

@WebServlet("/preupdateinfomationservlet")
public class PreUpdateInformationController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取参数deleteinfomationservlet?id=${infomation.id }
		int id = Integer.parseInt(req.getParameter("id"));
		//调用业务层
		InformationService is = new InformationService(); 
		//获取当前的记录
		Information info = is.getInformationById(id);
		//进入修改的页面并且显示数据
		req.setAttribute("info", info);
		req.getRequestDispatcher("updateInfomation.jsp").forward(req, resp);
		
		
	}

}
