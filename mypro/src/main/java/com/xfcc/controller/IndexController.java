package com.xfcc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.xfcc.entity.Information;
import com.xfcc.entity.Policy;
import com.xfcc.entity.Project;
import com.xfcc.service.InformationService;
import com.xfcc.service.PolicyService;
import com.xfcc.service.ProjectService;

//ȡ����������ݷŵ�index��
@WebServlet(urlPatterns = "/indexservlet")
public class IndexController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
				//��ȡ��ҵ��̬������
				//��ȡ������Ŀ������
		
				
			//��ʾPolicy ��ҵ���ߵ�ǰ�������ʾ
				
		
		req.getSession().invalidate();
		
		//��ȡ������Ϣ��ǰ5������
		PolicyService ps = new PolicyService();
		List<Policy> polList = ps.findFivePolicy();
		
		//��ȡ��ҵ��Ϣ��ǰ5������
		InformationService is = new InformationService();
		List<Information> informations =  is.getFiveInfo();
		
		//��ȡ������Ŀǰ�������
		ProjectService pros = new ProjectService();
		List<Project> proList = pros.findFiveProject();
		
		
		req.getSession().setAttribute("infos", informations);
		req.getSession().setAttribute("polList", polList);
		req.getSession().setAttribute("proList", proList);

		req.getRequestDispatcher("index.jsp").forward(req, resp);
		
		
	}
	
	

}
