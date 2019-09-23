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
	
	//��Ӵ�ҵ��̬
	public int addInfo(String title,String time,String context){
		//�������ݿ�
		Connection conn = null;
		int count = 0;
		//��ȡ����
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
		//�������ݿ�
		return count;
		
	}

	
	//��ѯ���еĴ�ҵ��̬
	public List<Information> selectInfos() {
		//ctrl+shift+o
		List<Information> infomations = new ArrayList<Information>();
		Connection conn = null;
		Information info = null;
		//��ȡ����
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
		//�������ݿ�
		return infomations;
	}
	
	//����idɾ����ҵ��̬
	public int deleteInfo(int id) {
		Connection conn = null;
		int count = 0;
		//��ȡ����
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
		//�������ݿ�
		return count;
	}


    //����id��ȡ��ҵ��̬
	public Information getInfoById(int id) {
		Connection conn = null;
		Information info = null;
		//��ȡ����
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
		//�������ݿ�
		return info;
	}


	//��ҳ��ѯ��ʾ����
	
	public PageBean<Information> getInfoBypage(int pc, int ps, String title) {
		
		int len = findNum();
		//ʵ������ǰҳ�����
		PageBean<Information> pb = new PageBean<Information>();
		pb.setPc(pc);//��ǰҳ�� ���� ��һҳ Ϊ 1,�ڶ�ҳ Ϊ 2 
		pb.setPs(ps);//ÿҳ��¼�� ����ÿҳ��ʾ 5 ��
		pb.setTr(len);//�ܼ�¼��  ����  �ܹ���Ϊ 9 ��
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


	//��ȡ���е�����
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
		//��ȡ����
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
		//�������ݿ�
		return count;
	}


	//��ȡindex.jsp��ʾ�Ĵ�ҵ��̬��ǰ��������
	public List<Information> getFiveInfos() {
		//ctrl+shift+o
		List<Information> infomations = new ArrayList<Information>();
		Connection conn = null;
		Information info = null;
		//��ȡ����
		try {
			conn = JDBCUtil.getConnection();
			//limit 1,5  1Ϊ��һҳ   5Ϊÿҳ��ʾ5����¼
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
		//�������ݿ�
		return infomations;
	}
    
}