package com.xfcc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xfcc.entity.Employee;
import com.xfcc.entity.Users;
import com.xfcc.service.EmpService;


//Ա����Ϣ�޸�ҳ��

@WebServlet(urlPatterns = "/updateempservlet")
public class UpdateEmpController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int eid = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String realName = req.getParameter("realname");
		
		//��װ��emp�� ��dao���޸�
		Employee emp = new Employee();
		emp.setId(eid);
		emp.setName(name);
		emp.setPassword(password);
		emp.setRealname(realName);
		
		EmpService es = new EmpService();
		int counter  = es.updateEmpByid(emp);
		if(counter > 0){
			//�޸ĳɹ�����Ҫ��ȡ���µ����ݣ���employelist.jsp��ʾ
			List<Employee> emplist = es.findAllEmp();
			req.setAttribute("employees", emplist);
			//System.out.println("�޸ĳɹ�");
			req.getRequestDispatcher("employeelist.jsp").forward(req, resp);
		}else{
			//�޸�ʧ�ܺ󣬻ص�updateuser.jsp ��ʾ��Ϣ
			//System.out.println("�޸�ʧ��");
			//req.setAttribute("updateinfo", "�޸�ʧ��");
			req.setAttribute("emp", emp);
			req.getRequestDispatcher("updateuser.jsp").forward(req, resp);
		}
		
		
	}

}
