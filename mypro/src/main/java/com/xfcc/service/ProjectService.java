package com.xfcc.service;

import java.util.List;

import com.xfcc.dao.ProjectDao;
import com.xfcc.entity.PageBean;
import com.xfcc.entity.Policy;
import com.xfcc.entity.Project;

public class ProjectService {
	ProjectDao dao = new ProjectDao(); 
	
	//��ȡ���е���Ŀ
	public List<Project> findAllPros() {
		return dao.findAllpros();
	}
	//����id��ȡ��Ŀ
	public Project getProById(int id) {
		return dao.getProById(id);
	}
	//����idɾ����Ŀ
	public int deleteProById(int proId) {
		return dao.deleteProById(proId);
	}
	//����pro�����޸���Ŀ
	public int updatePro(Project pro) {
		return dao.updatePro(pro);
		
	}
	public int addPor(String title, String timeFormat, String context) {
		return dao.addPor(title,timeFormat,context);
	}
	public PageBean<Project> getProPageByParam(int pc, int ps, String title) {
		return dao.getProBypage(pc, ps, title);
		
	}
	//��ȡǰ�����Ŀ
	public List<Project> findFiveProject() {
		return dao.findFiveProject();
	}

}
