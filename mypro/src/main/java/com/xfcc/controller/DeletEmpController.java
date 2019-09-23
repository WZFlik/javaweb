package com.xfcc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xfcc.entity.Employee;
import com.xfcc.service.EmpService;

//ɾ������Ա��������
@WebServlet(urlPatterns = "/deleteemployeeservlet")
public class DeletEmpController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int eid = Integer.parseInt(req.getParameter("eid"));
		EmpService es = new EmpService();
		int count = es.deleteEmpById(eid);
		//ɾ��������һ�ȡ������Ϣ ��ʾ��ҳ����
		List<Employee> empList = es.findAllEmp();
		req.setAttribute("employees",empList);
		req.getRequestDispatcher("employeelist.jsp").forward(req, resp);
		
	}

}
