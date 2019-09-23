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

@WebServlet("/updateprojectServlet")
public class UpdateProjectController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		//��ȡҳ��Ĳ���
		int id = Integer.parseInt(req.getParameter("id"));
		String title =req.getParameter("title");
		String time =req.getParameter("time");
		String context =req.getParameter("context");
		Project pro  = new Project();
		pro.setId(id);
		pro.setTitle(title);
		pro.setTime(time);
		pro.setContext(context);
		//�޸Ĵ�ҵ��̬
		ProjectService is = new ProjectService();
		is.updatePro(pro);
		//��ȡ���µ����ݣ���ʾ
		List<Project> pros = is.findAllPros();
		req.setAttribute("pros",pros );
		req.getRequestDispatcher("listproject.jsp").forward(req, resp);
		
		
	}

}

