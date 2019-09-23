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


//员工信息修改页面

@WebServlet(urlPatterns = "/updateempservlet")
public class UpdateEmpController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int eid = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String realName = req.getParameter("realname");
		
		//封装在emp中 在dao层修改
		Employee emp = new Employee();
		emp.setId(eid);
		emp.setName(name);
		emp.setPassword(password);
		emp.setRealname(realName);
		
		EmpService es = new EmpService();
		int counter  = es.updateEmpByid(emp);
		if(counter > 0){
			//修改成功后需要获取最新的数据，在employelist.jsp显示
			List<Employee> emplist = es.findAllEmp();
			req.setAttribute("employees", emplist);
			//System.out.println("修改成功");
			req.getRequestDispatcher("employeelist.jsp").forward(req, resp);
		}else{
			//修改失败后，回到updateuser.jsp 提示信息
			//System.out.println("修改失败");
			//req.setAttribute("updateinfo", "修改失败");
			req.setAttribute("emp", emp);
			req.getRequestDispatcher("updateuser.jsp").forward(req, resp);
		}
		
		
	}

}
