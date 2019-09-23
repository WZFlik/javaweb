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


@WebServlet(name = "updateuser" , urlPatterns = "/updateuserservlet")
public class UpdateUserController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String realname = request.getParameter("realname");
		Users users = new Users();
		users.setId(id);
		users.setUsername(username);
		users.setPassword(password);
		users.setRealname(realname);
		
		UserService us  =new UserService();
		int counter = us.updateUserByUser(users);
		
		if(counter>0){
			//�޸ĳɹ�����Ҫ��ȡ���µ����ݣ�showusers.jsp��ʾ
			List<Users> listusers = us.findAllUsers();
			request.setAttribute("listusers", listusers);
			System.out.println("�޸ĳɹ�");

			request.getRequestDispatcher("showusers.jsp").forward(request, response);
		}else{
			//�޸�ʧ�ܺ󣬻ص�updateuser.jsp ��ʾ��Ϣ
			System.out.println("�޸�ʧ��");
			request.setAttribute("updateinfo", "�޸�ʧ��");
			request.setAttribute("users", users);
			request.getRequestDispatcher("updateuser.jsp").forward(request, response);
		}
		
	}
	

}
