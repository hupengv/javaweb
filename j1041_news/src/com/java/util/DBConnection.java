package com.java.util;

import java.sql.*;
public class DBConnection {
	private static Connection conn = null;
		
		//������˽��
		private DBConnection() {}
		
		private static void init() {
			//����������
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("û���ҵ�������!");
			}
			
			//��ʼ������
			
			try {
				String url="jdbc:mysql://localhost:3306/j1041"; 
				conn = DriverManager.getConnection(url, "root", "root");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("��ʼ�����Ӷ���ʧ��!");
			}	
		}
		
		/**
		 * ��ȡConnection����
		 * @return Connection
		 */
		public static Connection getConnection(){
			if(conn == null){
				//��ʼ������
				init();
			}
			return conn;
			
		}
		
		/**
		 * �ͷ���Դ
		 * @param rs
		 * @param stmt
		 * @param pst
		 */
		public static void closeAll(ResultSet rs,Statement stmt,PreparedStatement pst){
			try {
				if(rs!=null){
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(stmt!=null){
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(pst!=null){
					pst.close();
				}
			} catch (SQLException e) {
		
				e.printStackTrace();
			}
		}
}


