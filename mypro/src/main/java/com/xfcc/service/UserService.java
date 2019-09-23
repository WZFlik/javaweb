package com.xfcc.service;

import java.util.List;

import com.xfcc.dao.UserDao;
import com.xfcc.entity.Users;

//业务层调用数据访问层
public class UserService {
	UserDao dao = new UserDao();
	public Users login(String username,String password){
		
		return dao.userLogin(username,password);
		
		
	}
	public int rigeter(String username,String password,String realname){
		
		
		return dao.register(username,password,realname);
		
		
	}

	//显示所有用户
	public List<Users> findAllUsers() {
		// TODO Auto-generated method stub
		return dao.findAllUsers();
	}
	//删除用户
	public int deleteUser(int id) {
		return dao.deleteUser(id);
	}
	//获取用户
	
	public Users getUserByid(int uid) {
		return dao.getUserById(uid);
	}
	public int updateUserByUser(Users users) {
		return  dao.updateUserByUser(users);
	}
	
	
	

}
