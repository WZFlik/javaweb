package com.xfcc.service;

import java.util.List;

import com.xfcc.dao.EmpDao;
import com.xfcc.entity.Employee;

//ʵ��employee�ķ���
public class EmpService {
	EmpDao ed = new EmpDao();
	
	//ʵ��Ա����̨��¼
	public Employee backLogin(String empName,String empPassword){
		
		
		return ed.backLogin(empName,empPassword);
		
		
	}

	//��������Ա��
	public List<Employee> findAllEmp() {
		return ed.findAllemp();
	}

	//��IDɾ��Ա��
	public int deleteEmpById(int eid) {

	return ed.deleteEmpById(eid);
	}

	//��ȡҪ�޸ĵ�Ա��������
	public Employee getEmpByid(int uid) {
		return ed.getEmpById(uid);
	}
	//�޸�Ա����Ϣ 
	public int updateEmpByid(Employee emp) {
		return ed.updateEmpByid(emp);
	}
	

}
