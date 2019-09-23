package com.xfcc.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xfcc.entity.Information;
import com.xfcc.service.InformationService;

@WebServlet("/addinfomationservlet")
public class AddInformationController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//处理请求的正文乱码
		req.setCharacterEncoding("utf-8");
		//获取参数
		String title = req.getParameter("title");
		String context = req.getParameter("context");
		//时间获取当前的时间的字符串
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
		String time = formatDate.format(new Date());
		//封装数据
		InformationService is = new InformationService();
		//完成添加
		is.addInfo(title, time, context);
		// 获取最新的数据，查询所有的数据，创建查询所有的数据的方法
		List<Information> informations = is.getAllInfomation();
		req.setAttribute("informations", informations);
		req.getRequestDispatcher("listinfomation.jsp").forward(req, resp);
		
		
		
	}

}

