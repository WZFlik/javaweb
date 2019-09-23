package com.xfcc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xfcc.entity.Information;
import com.xfcc.entity.PageBean;
import com.xfcc.entity.Policy;
import com.xfcc.service.InformationService;
import com.xfcc.service.PolicyService;

//查询政策分页

@WebServlet(urlPatterns= "/searchpolicyservlet")
public class SearchPolicyController  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		//接收请求查询参数 ，标题
		String title = request.getParameter("title");

		// 获得请求的页面数,第一次请求默认设置为第一页
		String s = request.getParameter("pc");
		if (s == null || s.trim().isEmpty()) {
			s = "1";
		}
		int pc = Integer.valueOf(s);
		
		// 给定ps的值，每页显示的行数
		int ps = 5;

		PageBean<Policy> pb = null;
		if (title == null) {// 查询所有政策
			pb = new PolicyService().getPolPageByParam(pc, ps,null);
		}else{
			String titleParam = "%"+title+"%";
			pb = new PolicyService().getPolPageByParam(pc, ps, titleParam);
			//转发到页面
			request.setAttribute("title", title);
		}
		request.setAttribute("pb", pb);
		request.getRequestDispatcher("searchpolicy.jsp").forward(request, response);
	}
	
	

}



