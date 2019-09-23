package com.xfcc.service;

import java.util.List;

import com.xfcc.dao.InformationDao;
import com.xfcc.entity.Information;
import com.xfcc.entity.PageBean;

public class InformationService {
	InformationDao dao = new InformationDao();

	public int addInfo(String title, String time, String context) {
		
		
		return dao.addInfo(title, time, context);
		
	}

	public List<Information> getAllInfomation() {
		
		return dao.selectInfos();
	}

	public Information getInformationById(int id) {
		// TODO Auto-generated method stub
		return dao.getInfoById(id);
	}

	public int updateInfo(Information info) {
		
		return dao.updateInfo(info);
	}

	public int deleteInfoById(int id) {
		
		return dao.deleteInfo(id);
		
	}

	public PageBean<Information> getInfoPageByParam(int pc, int ps, Object object) {
		return dao.getInfoBypage(pc, ps, null);
	}

	public List<Information> getFiveInfo() {
		return dao.getFiveInfos();
		
		
		
	}

	


}
