package com.xfcc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xfcc.entity.Users;
import com.xfcc.service.UserService;
@WebServlet(name="deleteuser",urlPatterns="/deleteuserservlet")
public class DeleteUserController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("uid"));
		UserService us = new UserService();
		int counter = us.deleteUser(id);
		//ɾ����ɻ�ȡ��������
		List<Users>  listuser = us.findAllUsers();
		request.setAttribute("deleInfo", "ɾ���ɹ�");
		request.setAttribute("listusers", listuser);
		//��������ҳ��
		request.getRequestDispatcher("showusers.jsp").forward(request, response);
		
	}
	

}
