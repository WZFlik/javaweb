package com.xfcc.service;

import java.util.List;

import com.xfcc.dao.PolicyDao;
import com.xfcc.entity.PageBean;
import com.xfcc.entity.Policy;
import com.xfcc.entity.Project;

public class PolicyService {
	PolicyDao dao = new PolicyDao();
	//�������е�policy ������list����
	public List<Policy> findFivePolicy() {
		
		//��ȡǰ��������
		return dao.findFivePolicy();
	}
	//���е�����
	public List<Policy> findAllPolicy() {
		return dao.findAllpolicy();
	}
	//����id��ȡ����
	public Policy getPolById(int id) {
		// TODO Auto-generated method stub
		return dao.getPolById( id);
	}
	
	//��������
	public int updatePol(Policy pol) {
		
		return dao.updatePol(pol);
		
	}
	//ɾ������
	public int deletePolById(int polId) {
		return dao.deletePolById(polId);
	}
	
	//�������
	public int addPoly(String title, String timeFormat, String context) {
		
		
		return dao.addPoly(title,timeFormat,context);
	}
	public PageBean<Policy> getPolPageByParam(int pc, int ps, String title) {
		return dao.getPolBypage(pc,ps,title);
	}
	

}
