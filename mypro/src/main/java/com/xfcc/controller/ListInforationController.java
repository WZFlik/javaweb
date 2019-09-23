package com.xfcc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xfcc.entity.Information;
import com.xfcc.entity.Users;
import com.xfcc.service.InformationService;
import com.xfcc.service.UserService;

@WebServlet(urlPatterns = "/listinfoservlet")
public class ListInforationController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		InformationService is = new InformationService();
		List<Information> informations = is.getAllInfomation();
		req.setAttribute("informations", informations);
		//µ˜ ‘œ‘ æÀ‰”–user
		req.getRequestDispatcher("listinfomation.jsp").forward(req, resp);
		
		
	}
	
	
}
