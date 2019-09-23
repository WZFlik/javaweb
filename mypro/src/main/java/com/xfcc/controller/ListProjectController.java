package com.xfcc.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xfcc.entity.Information;
import com.xfcc.entity.Project;
import com.xfcc.service.InformationService;
import com.xfcc.service.ProjectService;

@WebServlet(urlPatterns = "/listprojectservlet")
public class ListProjectController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		ProjectService is = new ProjectService();
		List<Project> pros = is.findAllPros();
		req.setAttribute("pros", pros);
		//µ˜ ‘œ‘ æÀ‰”–user
		req.getRequestDispatcher("listproject.jsp").forward(req, resp);
		
		
	}
	
	
}