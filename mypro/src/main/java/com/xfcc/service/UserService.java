package com.xfcc.service;

import java.util.List;

import com.xfcc.dao.UserDao;
import com.xfcc.entity.Users;

//ҵ���������ݷ��ʲ�
public class UserService {
	UserDao dao = new UserDao();
	public Users login(String username,String password){
		
		return dao.userLogin(username,password);
		
		
	}
	public int rigeter(String username,String password,String realname){
		
		
		return dao.register(username,password,realname);
		
		
	}

	//��ʾ�����û�
	public List<Users> findAllUsers() {
		// TODO Auto-generated method stub
		return dao.findAllUsers();
	}
	//ɾ���û�
	public int deleteUser(int id) {
		return dao.deleteUser(id);
	}
	//��ȡ�û�
	
	public Users getUserByid(int uid) {
		return dao.getUserById(uid);
	}
	public int updateUserByUser(Users users) {
		return  dao.updateUserByUser(users);
	}
	
	
	

}
