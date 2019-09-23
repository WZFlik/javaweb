package com.xfcc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xfcc.entity.Project;
import com.xfcc.service.ProjectService;

@WebServlet(urlPatterns = "/projectdetailservlet")
public class ProjectDetailController  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//优秀项目的id
		int id = Integer.parseInt(req.getParameter("id")); 
		ProjectService ps = new ProjectService();
		Project pro = ps.getProById(id);
		
		//传在allinfo里面去显示
		req.getSession().setAttribute("item", pro);
		req.getRequestDispatcher("allinfo.jsp").forward(req, resp);
		
		
		
		
	}

}
