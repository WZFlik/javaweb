package com.xfcc.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xfcc.service.ProjectService;
@WebServlet(urlPatterns = "/addprojectservlet")
public class AddProjectController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//�����������������
		req.setCharacterEncoding("utf-8");
		//��ȡ����
		String title = req.getParameter("title");
		String time1 = req.getParameter("time");
		String context = req.getParameter("context");
		//ʱ���ȡ��ǰ��ʱ����ַ���
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
		String timeFormat = formatDate.format(new Date());
		//��װ����
		ProjectService ps = new ProjectService();
		//������
			int count =ps.addPor(title, timeFormat, context);
			if(count != 0){
				req.setAttribute("addInfo", "��ӳɹ���");
				
				}else{
					req.setAttribute("addInfo", "���ʧ�ܣ�");
					
				}
			
			req.getRequestDispatcher("addproject.jsp").forward(req, resp);

			}
		
		// ��ȡ���µ����ݣ���ѯ���е����ݣ�������ѯ���е����ݵķ���
		//List<Policy> policies = is.getAllPolicy();
		//req.setAttribute("policies", policies);

}
