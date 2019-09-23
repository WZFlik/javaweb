package com.xfcc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xfcc.entity.Policy;
import com.xfcc.service.PolicyService;
//创建控制器获取当前记录
@WebServlet("/preupdatepolicyservlet")
public class PreUpdatePolicyController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		PolicyService ps = new PolicyService();
		Policy pol = ps.getPolById(id);
		req.setAttribute("pol", pol);
		req.getRequestDispatcher("updatepolicy.jsp").forward(req, resp);
	}
	
}
