package com.xfcc.service;

import java.util.List;

import com.xfcc.dao.ProjectDao;
import com.xfcc.entity.PageBean;
import com.xfcc.entity.Policy;
import com.xfcc.entity.Project;

public class ProjectService {
	ProjectDao dao = new ProjectDao(); 
	
	//获取所有的项目
	public List<Project> findAllPros() {
		return dao.findAllpros();
	}
	//根据id获取项目
	public Project getProById(int id) {
		return dao.getProById(id);
	}
	//根据id删除项目
	public int deleteProById(int proId) {
		return dao.deleteProById(proId);
	}
	//根据pro参数修改项目
	public int updatePro(Project pro) {
		return dao.updatePro(pro);
		
	}
	public int addPor(String title, String timeFormat, String context) {
		return dao.addPor(title,timeFormat,context);
	}
	public PageBean<Project> getProPageByParam(int pc, int ps, String title) {
		return dao.getProBypage(pc, ps, title);
		
	}
	//获取前五个项目
	public List<Project> findFiveProject() {
		return dao.findFiveProject();
	}

}
