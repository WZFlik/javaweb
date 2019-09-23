package com.xfcc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xfcc.entity.Policy;
import com.xfcc.service.PolicyService;
@WebServlet("/listpolservlet")
public class ListPolicyController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		PolicyService ps = new PolicyService();
		List<Policy> policies = ps.findAllPolicy();
		
		req.setAttribute("policies", policies);
		
		req.getRequestDispatcher("listpolicy.jsp").forward(req, resp);
	}
	

}
