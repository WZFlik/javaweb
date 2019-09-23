package com.xfcc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xfcc.entity.Project;
import com.xfcc.service.ProjectService;

@WebServlet("/preupdatprojectservlet")
public class PreUpdateProjectController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡ����deleteprojectservlet?id=${project.id }
		int id = Integer.parseInt(req.getParameter("id"));
		//����ҵ���
		ProjectService is = new ProjectService(); 
		//��ȡ��ǰ�ļ�¼
		Project pro = is.getProById(id);
		//�����޸ĵ�ҳ�沢����ʾ����
		req.setAttribute("info", pro);
		req.getRequestDispatcher("updateproject.jsp").forward(req, resp);
		
		
	}

}
