package com.xfcc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xfcc.entity.Employee;
import com.xfcc.service.EmpService;

@WebServlet(name = "backlogin" , urlPatterns = "/backloginservlet")
public class BackLoginController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String empName = req.getParameter("name");
		String empPassword = req.getParameter("password");
		EmpService es = new EmpService();
		Employee emp = es.backLogin(empName, empPassword);
		//�ж��Ƿ��¼�ɹ�
//		if(emp!=null){
//			//��½�ɹ�
//			req.setAttribute("emp", emp);
//			req.getRequestDispatcher("backframe.jsp").forward(req, resp);
//			
//		}else{
//			
//			req.getRequestDispatcher("backlogin.jsp").forward(req, resp);
//		}
		if(emp!=null){
			req.getSession().setAttribute("emp", emp);
			req.getRequestDispatcher("backframe.jsp").forward(req, resp);

		}else{
			req.setAttribute("info", "Ա���˺Ż��������");
			req.getRequestDispatcher("backlogin.jsp").forward(req, resp);
		}
		
		
		
	}
	

}
