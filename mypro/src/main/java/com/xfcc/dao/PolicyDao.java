package com.xfcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xfcc.entity.PageBean;
import com.xfcc.entity.Policy;
import com.xfcc.entity.Project;
import com.xfcc.util.JDBCUtil;

public class PolicyDao {
	//获取前五个的政策
	public List<Policy> findFivePolicy() {
		List<Policy> polList = new ArrayList<>();
		Connection conn = null;
		Policy pol = null;
		PreparedStatement pstm = null;
		//获取连接
		try {
			conn = JDBCUtil.getConnection();
			//limit 1,5  1为第一页   5为每页显示5条记录
			String sql = "select * from policy limit 0,5";
			pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				pol = new Policy();
				pol.setId(rs.getInt("id"));
				pol.setTitle(rs.getString("title"));
				pol.setTime(rs.getString("time"));
				pol.setContext(rs.getString("context"));
				polList.add(pol);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.release(conn, pstm);
			
		}
		//访问数据库
		return polList;
	}
	//获取所有政策
	public List<Policy> findAllpolicy() {
		List<Policy> policies = new ArrayList<Policy>();
		Connection conn = null;
		Policy pol = null;
		//获取连接
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from policy";
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				pol = new Policy();
				pol.setId(rs.getInt("id"));
				pol.setTitle(rs.getString("title"));
				pol.setTime(rs.getString("time"));
				pol.setContext(rs.getString("context"));
				policies.add(pol);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//访问数据库
		return policies;
	}

	public Policy getPolById(int id) {
		Connection conn = null;
		Policy pol = null;
		//获取连接
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from policy where id = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			if(rs.next()){
				pol = new Policy();
				pol.setId(rs.getInt("id"));
				pol.setTitle(rs.getString("title"));
				pol.setTime(rs.getString("time"));
				pol.setContext(rs.getString("context"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//访问数据库
		return pol;
	}

	//修改政策
	public int updatePol(Policy pol) {
		Connection conn = null;
		int count = 0;
		//获取连接
		try {
			conn = JDBCUtil.getConnection();
			String sql = "update policy set title = ?,time=?,context=? where id = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, pol.getTitle());
			pstm.setString(2, pol.getTime());
			pstm.setString(3, pol.getContext());
			pstm.setInt(4, pol.getId());
			count = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//访问数据库
		return count;
	}

	public int deletePolById(int polId) {
		Connection conn = null;
		
		int count = 0;
		//获取连接
		try {
			conn = JDBCUtil.getConnection();
			String sql = "delete from policy where id = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1,polId);
			count = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//访问数据库
		return count;
	}
	
		//添加政策
	public int addPoly(String title, String timeFormat, String context) {
		//访问数据库
		Connection conn = null;
		int count = 0;
		PreparedStatement pstm = null;
		//获取连接
		try {
			conn = JDBCUtil.getConnection();
			String sql = "insert into policy values(null,?,?,?)";
		    pstm = conn.prepareStatement(sql);
			pstm.setString(1, title);
			pstm.setString(2, timeFormat);
			pstm.setString(3, context);
			count = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			JDBCUtil.release(conn, pstm);
		}
		//访问数据库
		return count;			
	}

	
	//查询政策
	public PageBean<Policy> getPolBypage(int pc, int ps, String title) {
		int len = findNum();
		//实例化当前页面对象
		PageBean<Policy> pb = new PageBean<Policy>();
		pb.setPc(pc);//当前页数 比如 第一页 为 1,第二页 为 2 
		pb.setPs(ps);//每页记录数 比如每页显示 5 行
		pb.setTr(len);//总记录数  比如  总共有为 9 行
		String sql = "";
		List<Policy> policies = new ArrayList<>();
		Policy pol = null;
		if(title == null){
			sql = "select * from policy limit ?,?";
		}else{
			sql = "select * from policy where title like ? limit ?,?";
		}
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			if(title == null){
				pstm.setInt(1,(pc-1)*ps);
				pstm.setInt(2,ps);
			}else{
				pstm.setString(1, title);
				pstm.setInt(2,(pc-1)*ps);
				pstm.setInt(3,ps);
			}
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				pol = new Policy();
				pol.setId(rs.getInt("id"));
				pol.setTitle(rs.getString("title"));
				pol.setTime(rs.getString("time"));
				pol.setContext(rs.getString("context"));
				policies.add(pol);
			}
			pb.setBeanList(policies);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return pb;
	}
	
	//获取所有的行数
		public int findNum() {
			Connection conn = null;
			int count = 0;
			try {
				conn = JDBCUtil.getConnection();
				String sql = "select count(*) as count from policy";
				PreparedStatement pstm = conn.prepareStatement(sql);
				ResultSet rs = pstm.executeQuery();
				if(rs.next()){
					count = rs.getInt("count");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return count;
		}
		

	

}
