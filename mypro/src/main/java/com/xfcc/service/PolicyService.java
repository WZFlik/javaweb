package com.xfcc.service;

import java.util.List;

import com.xfcc.dao.PolicyDao;
import com.xfcc.entity.PageBean;
import com.xfcc.entity.Policy;
import com.xfcc.entity.Project;

public class PolicyService {
	PolicyDao dao = new PolicyDao();
	//查找所有的policy 并返回list集合
	public List<Policy> findFivePolicy() {
		
		//获取前五条政策
		return dao.findFivePolicy();
	}
	//所有的政策
	public List<Policy> findAllPolicy() {
		return dao.findAllpolicy();
	}
	//利用id获取政策
	public Policy getPolById(int id) {
		// TODO Auto-generated method stub
		return dao.getPolById( id);
	}
	
	//更新政策
	public int updatePol(Policy pol) {
		
		return dao.updatePol(pol);
		
	}
	//删除政策
	public int deletePolById(int polId) {
		return dao.deletePolById(polId);
	}
	
	//添加政策
	public int addPoly(String title, String timeFormat, String context) {
		
		
		return dao.addPoly(title,timeFormat,context);
	}
	public PageBean<Policy> getPolPageByParam(int pc, int ps, String title) {
		return dao.getPolBypage(pc,ps,title);
	}
	

}
