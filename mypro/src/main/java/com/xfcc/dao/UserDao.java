package com.xfcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xfcc.entity.Users;
import com.xfcc.util.ConnUtil;
import com.xfcc.util.JDBCUtil;

public class UserDao {
	
	//ʵ�ֵ�¼
	public Users userLogin(String username ,String password){
		Users user = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConnection();
			//conn = ConnUtil.getConn();
			String sql = "select * from users where username = ? and password = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, username);
			pstm.setString(2, password);
			rs = pstm.executeQuery();
			if(rs.next()){
				user = new Users();
				user.setId(rs.getInt("id"));
				user.setRealname(rs.getString("realname"));
				user.setUsername(rs.getString("username"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.release(conn, pstm, rs);
		}
		
		return user;
		
	}
	
	
	//ע��
	
	public int register(String username,String password,String realname){
		Users user = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		int counter = 0;
		try {
			conn = JDBCUtil.getConnection();
			//conn = ConnUtil.getConn();
			String sql = "insert into users values(null,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, username);
			pstm.setString(2, password);
			pstm.setString(3, realname);
			counter = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.release(conn, pstm);
		}
		
		return counter;
		
	}

//��ʾ�����û�
	public List<Users> findAllUsers() {
		Users user = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Users> userslist = new ArrayList<>();
		try {
			conn = JDBCUtil.getConnection();
			//conn = ConnUtil.getConn();
			String sql = "select * from users ";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				user = new Users();
				user.setId(rs.getInt("id"));
				user.setRealname(rs.getString("realname"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				userslist.add(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.release(conn, pstm, rs);
		}
		return userslist;
	}

//ɾ���û�
	public int deleteUser(int id) {
		Users user = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		int counter = 0;
		try {
			conn = JDBCUtil.getConnection();
			//conn = ConnUtil.getConn();
			String sql = "delete from users where id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			counter = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.release(conn, pstm);
		}
		
		return counter;
	}

/*
 *��ȡ�û�
 */
	public Users getUserById(int uid) {
		Users user = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConnection();
			//conn = ConnUtil.getConn();
			String sql = "select * from users where id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, uid);
			rs = pstm.executeQuery();
			while(rs.next()){
				user = new Users();
				user.setId(rs.getInt("id"));
				user.setRealname(rs.getString("realname"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.release(conn, pstm, rs);
		}
		return user;
	}


	public int updateUserByUser(Users users) {
		Users user = users;
		Connection conn = null;
		PreparedStatement pstm = null;
		int counter = 0;
		try {
			conn = JDBCUtil.getConnection();
			//conn = ConnUtil.getConn();
			String sql = "update users set username = ? ,password = ? ,realname = ? where id = ?";
			pstm = conn.prepareStatement(sql);
			//��input������Ķ������õ���ӦID��user��
			pstm.setString(1, user.getUsername());
			pstm.setString(2, user.getPassword());
			pstm.setString(3, user.getRealname());
			pstm.setInt(4, user.getId());
			
			counter = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.release(conn, pstm);
		}
		
		return counter;
	}
}
