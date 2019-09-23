package com.xfcc.service;

import java.util.List;

import com.xfcc.dao.EmpDao;
import com.xfcc.entity.Employee;

//实现employee的服务
public class EmpService {
	EmpDao ed = new EmpDao();
	
	//实现员工后台登录
	public Employee backLogin(String empName,String empPassword){
		
		
		return ed.backLogin(empName,empPassword);
		
		
	}

	//查找所有员工
	public List<Employee> findAllEmp() {
		return ed.findAllemp();
	}

	//用ID删除员工
	public int deleteEmpById(int eid) {

	return ed.deleteEmpById(eid);
	}

	//获取要修改的员工的数据
	public Employee getEmpByid(int uid) {
		return ed.getEmpById(uid);
	}
	//修改员工信息 
	public int updateEmpByid(Employee emp) {
		return ed.updateEmpByid(emp);
	}
	

}
