package com.xfcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xfcc.entity.Information;
import com.xfcc.entity.PageBean;
import com.xfcc.util.JDBCUtil;

public class InformationDao{
	
	//添加创业动态
	public int addInfo(String title,String time,String context){
		//访问数据库
		Connection conn = null;
		int count = 0;
		//获取连接
		try {
			conn = JDBCUtil.getConnection();
			String sql = "insert into infomation values(null,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, title);
			pstm.setString(2, time);
			pstm.setString(3, context);
			count = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//访问数据库
		return count;
		
	}

	
	//查询所有的创业动态
	public List<Information> selectInfos() {
		//ctrl+shift+o
		List<Information> infomations = new ArrayList<Information>();
		Connection conn = null;
		Information info = null;
		//获取连接
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from infomation";
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				info = new Information();
				info.setId(rs.getInt("id"));
				info.setTitle(rs.getString("title"));
				info.setTime(rs.getString("time"));
				info.setContext(rs.getString("context"));
				infomations.add(info);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//访问数据库
		return infomations;
	}
	
	//根据id删除创业动态
	public int deleteInfo(int id) {
		Connection conn = null;
		int count = 0;
		//获取连接
		try {
			conn = JDBCUtil.getConnection();
			String sql = "delete from infomation where id = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			count = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//访问数据库
		return count;
	}


    //根据id获取创业动态
	public Information getInfoById(int id) {
		Connection conn = null;
		Information info = null;
		//获取连接
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from infomation where id = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			if(rs.next()){
				info = new Information();
				info.setId(rs.getInt("id"));
				info.setTitle(rs.getString("title"));
				info.setTime(rs.getString("time"));
				info.setContext(rs.getString("context"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//访问数据库
		return info;
	}


	//分页查询显示数据
	
	public PageBean<Information> getInfoBypage(int pc, int ps, String title) {
		
		int len = findNum();
		//实例化当前页面对象
		PageBean<Information> pb = new PageBean<Information>();
		pb.setPc(pc);//当前页数 比如 第一页 为 1,第二页 为 2 
		pb.setPs(ps);//每页记录数 比如每页显示 5 行
		pb.setTr(len);//总记录数  比如  总共有为 9 行
		String sql = "";
		List<Information> infomations = new ArrayList<Information>();
		Information info = null;
		if(title == null){
			sql = "select * from infomation limit ?,?";
		}else{
			sql = "select * from infomation where title like ? limit ?,?";
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
				info = new Information();
				info.setId(rs.getInt("id"));
				info.setTitle(rs.getString("title"));
				info.setTime(rs.getString("time"));
				info.setContext(rs.getString("context"));
				infomations.add(info);
			}
			pb.setBeanList(infomations);
			
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
			String sql = "select count(*) as count from infomation";
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


	public int updateInfo(Information info) {
		Connection conn = null;
		int count = 0;
		//获取连接
		try {
			conn = JDBCUtil.getConnection();
			String sql = "update infomation set title = ?,time=?,context=? where id = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, info.getTitle());
			pstm.setString(2, info.getTime());
			pstm.setString(3, info.getContext());
			pstm.setInt(4, info.getId());
			count = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//访问数据库
		return count;
	}


	//获取index.jsp显示的创业动态的前五条数据
	public List<Information> getFiveInfos() {
		//ctrl+shift+o
		List<Information> infomations = new ArrayList<Information>();
		Connection conn = null;
		Information info = null;
		//获取连接
		try {
			conn = JDBCUtil.getConnection();
			//limit 1,5  1为第一页   5为每页显示5条记录
			String sql = "select * from infomation limit 0,5";
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				info = new Information();
				info.setId(rs.getInt("id"));
				info.setTitle(rs.getString("title"));
				info.setTime(rs.getString("time"));
				info.setContext(rs.getString("context"));
				infomations.add(info);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//访问数据库
		return infomations;
	}
    
}