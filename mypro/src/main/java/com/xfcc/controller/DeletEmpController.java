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

//删除单个员工控制器
@WebServlet(urlPatterns = "/deleteemployeeservlet")
public class DeletEmpController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int eid = Integer.parseInt(req.getParameter("eid"));
		EmpService es = new EmpService();
		int count = es.deleteEmpById(eid);
		//删除过后宠幸获取所有信息 显示在页面上
		List<Employee> empList = es.findAllEmp();
		req.setAttribute("employees",empList);
		req.getRequestDispatcher("employeelist.jsp").forward(req, resp);
		
	}

}
