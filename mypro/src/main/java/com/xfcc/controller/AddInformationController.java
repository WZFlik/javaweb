package com.xfcc.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xfcc.entity.Information;
import com.xfcc.service.InformationService;

@WebServlet("/addinfomationservlet")
public class AddInformationController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//�����������������
		req.setCharacterEncoding("utf-8");
		//��ȡ����
		String title = req.getParameter("title");
		String context = req.getParameter("context");
		//ʱ���ȡ��ǰ��ʱ����ַ���
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
		String time = formatDate.format(new Date());
		//��װ����
		InformationService is = new InformationService();
		//������
		is.addInfo(title, time, context);
		// ��ȡ���µ����ݣ���ѯ���е����ݣ�������ѯ���е����ݵķ���
		List<Information> informations = is.getAllInfomation();
		req.setAttribute("informations", informations);
		req.getRequestDispatcher("listinfomation.jsp").forward(req, resp);
		
		
		
	}

}

