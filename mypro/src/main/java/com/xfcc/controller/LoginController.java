package com.xfcc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xfcc.entity.Users;
import com.xfcc.service.UserService;


@WebServlet(name = "login" ,urlPatterns = "/loginservlet")
public class LoginController extends  HttpServlet{
	//����sevelet ������ ��ע��
	protected void doPost(HttpServletRequest reqest, HttpServletResponse response) throws ServletException, IOException {
		//��������
		reqest.setCharacterEncoding("utf-8");
		//��ȡҳ��login.jsp�Ĵ������
		String username = reqest.getParameter("username");
		String password = reqest.getParameter("password");
		System.out.println("��������");
		
		//���Ʒ���ҵ���
		UserService us = new UserService();
		Users u = us.login(username,password);
		System.out.println(username+password);
		if(u != null){
			//�÷�ʽ���ܷ���WEB-INFĿ¼
			//response.sendRedirect("main.jsp");
			reqest.getSession().setAttribute("u", u);
			System.out.println("�û�"+u.getUsername()+"��¼�ɹ�");
			reqest.getRequestDispatcher("index.jsp").forward(reqest, response);
			}else{
				//��¼ʧ��,����request����
				reqest.setAttribute("errorInfo", "�˺Ż��������");
				//����login.jsp
				reqest.getRequestDispatcher("login.jsp").forward(reqest, response);
				//response.sendRedirect("index.jsp");
				System.out.println("��¼ʧ��");
				
			}
		
		
		
	}

}
