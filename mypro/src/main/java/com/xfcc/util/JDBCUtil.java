package com.xfcc.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class JDBCUtil {
	static Connection conn = null;
	static DataSource ds = null;
	
	
	static{
		//��ȡ����
		try {
			InputStream is  =JDBCUtil.class.getResourceAsStream("/jdbc.properties");
			
			Properties ps  = new Properties();
			//ps.load(new FileInputStream("jdbc.properties"));
			ps.load(is);
			ds = BasicDataSourceFactory.createDataSource(ps);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//����conection����
	 	public static Connection getConnection (){
	 		try {
				
				//��drivermanagerע������
				//Class.forName("com.mysql.jdbc.Driver");
				
				//conn = DriverManager.getConnection(url, userName, password);
	 			//�����ӳ�ע������
	 			conn = ds.getConnection();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 		return conn;
	 	}
	 	
	 	//�ر���Դ
	 	public static void  release( Connection conn,PreparedStatement pstm,ResultSet rs){
	 		closeRs(rs);
	 		closePstm(pstm);
	 		closeConn(conn);
	 	}
	 	//�ر���Դ
	 	public static void  release( Connection conn,PreparedStatement pstm){
	 		closePstm(pstm);
	 		closeConn(conn);
	 	}
	 	
	 	//�ر�prepaedstatement
		public static void closePstm(PreparedStatement pstm){
			
			if(pstm!=null){
				try {
					pstm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					pstm = null;
				}
			}
		}
	 	
		//�ر�connection
public static void closeConn(Connection conn){
			
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					conn = null;
				}
			}
		}
	 	
	 	//�ر�rsultset
	 	public static void closeRs(ResultSet rs){
	 		if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					rs = null;
				}
		 		
			}
	 	}
	 	
}
