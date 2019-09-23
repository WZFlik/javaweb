package com.xfcc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xfcc.entity.Policy;
import com.xfcc.service.PolicyService;



@WebServlet("/updatePolServlet")
public class UpdatePolicyController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//�������봦��
		req.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(req.getParameter("id"));
		String title =req.getParameter("title");
		String time =req.getParameter("time");
		String context =req.getParameter("context");
		//��װ
		Policy pol  = new Policy();
		pol.setId(id);
		pol.setTitle(title);
		pol.setTime(time);
		pol.setContext(context);
		//�޸Ĵ�ҵ��̬
		PolicyService ps = new PolicyService();
		ps.updatePol(pol);
		//��ȡ���µ����ݣ���ʾ
		List<Policy> policies = ps.findAllPolicy();
		req.setAttribute("policies",policies);
		req.getRequestDispatcher("listpolicy.jsp").forward(req, resp);
		
	}
	

	
}
