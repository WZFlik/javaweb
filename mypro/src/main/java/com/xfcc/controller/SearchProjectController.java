package com.xfcc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xfcc.entity.PageBean;
import com.xfcc.entity.Project;
import com.xfcc.service.ProjectService;

@WebServlet(urlPatterns= "/searchprojectservlet")
public class SearchProjectController  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���������ѯ���� ������
		String title = request.getParameter("title");

		// ��������ҳ����,��һ������Ĭ������Ϊ��һҳ
		String s = request.getParameter("pc");
		if (s == null || s.trim().isEmpty()) {
			s = "1";
		}
		int pc = Integer.valueOf(s);
		
		// ����ps��ֵ��ÿҳ��ʾ������
		int ps = 5;

		PageBean<Project> pb = null;
		if (title == null) {// ��ѯ��������
			pb = new ProjectService().getProPageByParam(pc, ps,null);
		}else{
			String titleParam = "%"+title+"%";
			pb = new ProjectService().getProPageByParam(pc, ps, titleParam);
			//ת����ҳ��
			request.setAttribute("title", title);
		}
		request.setAttribute("pb", pb);
		request.getRequestDispatcher("searchpolicy.jsp").forward(request, response);
	}
	
	

}




