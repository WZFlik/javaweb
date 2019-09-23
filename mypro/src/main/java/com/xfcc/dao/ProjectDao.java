package com.xfcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xfcc.entity.Information;
import com.xfcc.entity.PageBean;
import com.xfcc.entity.Policy;
import com.xfcc.entity.Project;
import com.xfcc.util.JDBCUtil;

//ProjectDao ��
public class ProjectDao {

	// ��ȡ���е���Ŀ
	public List<Project> findAllpros() {
		List<Project> pros = new ArrayList<>();
		Connection conn = null;
		Project info = null;
		PreparedStatement pstm = null;
		// ��ȡ����
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from project";
			pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				info = new Project();
				info.setId(rs.getInt("id"));
				info.setTitle(rs.getString("title"));
				info.setTime(rs.getString("time"));
				info.setContext(rs.getString("context"));
				pros.add(info);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, pstm);
		}
		// �������ݿ�
		return pros;
	}

	// ����id��ȡ��Ŀ
	public Project getProById(int id) {
		Connection conn = null;
		Project pro = null;
		PreparedStatement pstm = null;
		// ��ȡ����
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from project where id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				pro = new Project();
				pro.setId(rs.getInt("id"));
				pro.setTitle(rs.getString("title"));
				pro.setTime(rs.getString("time"));
				pro.setContext(rs.getString("context"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, pstm);
		}
		// �������ݿ�
		return pro;
	}

	public int deleteProById(int proId) {
		int count = 0;
		// ��ȡ����
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "delete from project where id = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, proId);
			count = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// �������ݿ�
		return count;
	}

	
	//������Ŀ
	public int updatePro(Project pro) {
		Connection conn = null;
		int count = 0;
		PreparedStatement pstm = null;
		// ��ȡ����
		try {
			conn = JDBCUtil.getConnection();
			String sql = "update project set title = ?,time=?,context=? where id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, pro.getTitle());
			pstm.setString(2, pro.getTime());
			pstm.setString(3, pro.getContext());
			pstm.setInt(4, pro.getId());
			count = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, pstm);
		}
		// �������ݿ�
		return count;
	}

	// �����Ŀ
	public int addPor(String title, String timeFormat, String context) {
		Connection conn = null;
		int count = 0;
		PreparedStatement pstm = null;
		// ��ȡ����
		try {
			// �������ݿ�
			conn = JDBCUtil.getConnection();
			String sql = "insert into project values(null,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, title);
			pstm.setString(2, timeFormat);
			pstm.setString(3, context);
			count = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, pstm);
		}
		// �������ݿ�
		return count;
	}

	
	
	//��ѯ�ͷ�ҳ
	public PageBean<Project> getProBypage(int pc, int ps, String title) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int len = findNum();
		//ʵ������ǰҳ�����
		PageBean<Project> pb = new PageBean<>();
		pb.setPc(pc);//��ǰҳ�� ���� ��һҳ Ϊ 1,�ڶ�ҳ Ϊ 2 
		pb.setPs(ps);//ÿҳ��¼�� ����ÿҳ��ʾ 5 ��
		pb.setTr(len);//�ܼ�¼��  ����  �ܹ���Ϊ 9 ��
		String sql = "";
		List<Project> pros = new ArrayList<>();
		Project pro = null;
		if(title == null){
			sql = "select * from project limit ?,?";
		}else{
			sql = "select * from project where title like ? limit ?,?";
		}
		
		try {
			conn = JDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
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
				pro = new Project();
				pro.setId(rs.getInt("id"));
				pro.setTitle(rs.getString("title"));
				pro.setTime(rs.getString("time"));
				pro.setContext(rs.getString("context"));
				pros.add(pro);
			}
			pb.setBeanList(pros);
			
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
					String sql = "select count(*) as count from project";
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

			
			//��ȡǰ�����Ŀ
			public List<Project> findFiveProject() {
				//�����ڼ�������
					List<Project> proList = new ArrayList<>();
					Connection conn = null;
					Project pro = null;
					PreparedStatement pstm = null;
					//��ȡ����
					try {
						conn = JDBCUtil.getConnection();
						//limit 0,5  ��ʼ   5Ϊÿҳ��ʾ5����¼
						String sql = "select * from project limit 0,5";
						pstm = conn.prepareStatement(sql);
						ResultSet rs = pstm.executeQuery();
						while(rs.next()){
							pro = new Project();
							pro.setId(rs.getInt("id"));
							pro.setTitle(rs.getString("title"));
							pro.setTime(rs.getString("time"));
							pro.setContext(rs.getString("context"));
							proList.add(pro);
						}
						
					} catch (SQLException e) {
						e.printStackTrace();
					}finally{
						JDBCUtil.release(conn, pstm);
			}
					return proList;


		}
}
