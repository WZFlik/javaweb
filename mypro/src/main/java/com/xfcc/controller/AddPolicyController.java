package com.xfcc.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xfcc.service.PolicyService;

@WebServlet(urlPatterns = "/addpolicyservlet")
public class AddPolicyController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//处理请求的正文乱码
		req.setCharacterEncoding("utf-8");
		//获取参数
		String title = req.getParameter("title");
		String time1 = req.getParameter("time");
		String context = req.getParameter("context");
		//时间获取当前的时间的字符串
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
		String timeFormat = formatDate.format(new Date());
		//封装数据
		PolicyService is = new PolicyService();
		//完成添加
			int count =is.addPoly(title, timeFormat, context);
			if(count != 0){
				req.setAttribute("addInfo", "添加成功！");
				
				}else{
					req.setAttribute("addInfo", "添加失败！");
					
				}
			
			req.getRequestDispatcher("addpolicy.jsp").forward(req, resp);

			}
		
		// 获取最新的数据，查询所有的数据，创建查询所有的数据的方法
		//List<Policy> policies = is.getAllPolicy();
		//req.setAttribute("policies", policies);

}
