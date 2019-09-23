package com.xfcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xfcc.entity.Employee;
import com.xfcc.entity.Users;
import com.xfcc.util.JDBCUtil;
/*
 * 员工dao
 */
public class EmpDao {
//实现员工后台登录
	public Employee backLogin(String empName, String empPassword) {
		Employee emp = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConnection();
			//conn = ConnUtil.getConn();
			String sql = "select * from employee where name = ? and password = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, empName);
			pstm.setString(2, empPassword);
			rs = pstm.executeQuery();
			if(rs.next()){
				emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setRealname(rs.getString("realname"));
				emp.setName(rs.getString("name"));
				emp.setPassword(rs.getString("password"));

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.release(conn, pstm, rs);
		}
		
		return emp;
		
	}
	
	//获取所有员工信息

	public List<Employee> findAllemp() {
		
		Employee emp = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Employee> empList = new ArrayList<>();
		try {
			conn = JDBCUtil.getConnection();
			//conn = ConnUtil.getConn();
			String sql = "select * from employee ";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setRealname(rs.getString("realname"));
				emp.setName(rs.getString("name"));
				emp.setPassword(rs.getString("password"));			
				empList.add(emp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.release(conn, pstm, rs);
		}
		
		return empList;
		
	}
	
	
	
	//使用emp的id 来删除员工
	public int deleteEmpById(int eid) {
		Employee emp = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		int count = 0;
		try {
			conn = JDBCUtil.getConnection();
			//conn = ConnUtil.getConn();
			String sql = "delete from employee where id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, eid);
			 count = pstm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.release(conn, pstm);
		}
		
		return count;
		
		
	}

	
	//根据id获取员工
	public Employee getEmpById(int uid) {
		Employee emp = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConnection();
			//conn = ConnUtil.getConn();
			String sql = "select * from employee where id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, uid);
			rs = pstm.executeQuery();
			if(rs.next()){
				emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setRealname(rs.getString("realname"));
				emp.setName(rs.getString("name"));
				emp.setPassword(rs.getString("password"));

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.release(conn, pstm, rs);
		}
		
		return emp;
	}

	
	//修改员工信息
	public int updateEmpByid(Employee emp) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int count = 0;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "update employee set name = ?,password = ? , realname = ? where id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, emp.getName());
			pstm.setString(2, emp.getPassword());
			pstm.setString(3, emp.getRealname());
			pstm.setInt(4, emp.getId());
			 count = pstm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.release(conn, pstm);
		}
		
		return count;
		
	}

}
