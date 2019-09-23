package com.xfcc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xfcc.entity.Policy;
import com.xfcc.entity.Project;
import com.xfcc.service.PolicyService;
import com.xfcc.service.ProjectService;

@WebServlet(urlPatterns = "/deleteprojectservlet")
public class DeleteProjectController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		ProjectService ps = new ProjectService();
		int id = Integer.parseInt(req.getParameter("id"));
		int proId = ps.getProById(id).getId();
		//count==0�޸�ʧ��
		int count = ps.deleteProById(proId);
		if(count == 0){
			System.out.println("ɾ��ʧ��");
		}
		//���»�ȡ�������� ��ʾ��listpolicy.jsp
		List<Project> pros = ps.findAllPros();
		req.setAttribute("pros", pros);
		req.getRequestDispatcher("listproject.jsp").forward(req, resp);
	}
	
	}