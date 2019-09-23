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

//取出把相关数据放到index中
@WebServlet(urlPatterns = "/indexservlet")
public class IndexController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
				//获取创业动态的数据
				//获取优秀项目的数据
		
				
			//显示Policy 创业政策的前五个并显示
				
		
		req.getSession().invalidate();
		
		//获取政策信息的前5个数据
		PolicyService ps = new PolicyService();
		List<Policy> polList = ps.findFivePolicy();
		
		//获取创业信息的前5个数据
		InformationService is = new InformationService();
		List<Information> informations =  is.getFiveInfo();
		
		//获取优秀项目前五个数据
		ProjectService pros = new ProjectService();
		List<Project> proList = pros.findFiveProject();
		
		
		req.getSession().setAttribute("infos", informations);
		req.getSession().setAttribute("polList", polList);
		req.getSession().setAttribute("proList", proList);

		req.getRequestDispatcher("index.jsp").forward(req, resp);
		
		
	}
	
	

}
