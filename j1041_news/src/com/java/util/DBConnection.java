package com.java.util;

import java.sql.*;
public class DBConnection {
	private static Connection conn = null;
		
		//构造器私有
		private DBConnection() {}
		
		private static void init() {
			//加载驱动包
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("没有找到驱动包!");
			}
			
			//初始化连接
			
			try {
				String url="jdbc:mysql://localhost:3306/j1041"; 
				conn = DriverManager.getConnection(url, "root", "root");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("初始化连接对象失败!");
			}	
		}
		
		/**
		 * 获取Connection对象
		 * @return Connection
		 */
		public static Connection getConnection(){
			if(conn == null){
				//初始化连接
				init();
			}
			return conn;
			
		}
		
		/**
		 * 释放资源
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


