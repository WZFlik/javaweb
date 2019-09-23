package com.xfcc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xfcc.entity.Information;
import com.xfcc.service.InformationService;

@WebServlet("/updateInfoServlet")
public class UpdateInformationController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		//获取页面的参数
		int id = Integer.parseInt(req.getParameter("id"));
		String title =req.getParameter("title");
		String time =req.getParameter("time");
		String context =req.getParameter("context");
		Information info  = new Information();
		info.setId(id);
		info.setTitle(title);
		info.setTime(time);
		info.setContext(context);
		//修改创业动态
		InformationService is = new InformationService();
		is.updateInfo(info);
		//获取最新的数据，显示
		List<Information> informations = is.getAllInfomation();
		req.setAttribute("informations",informations );
		req.getRequestDispatcher("listinfomation.jsp").forward(req, resp);
		
		
	}

}
