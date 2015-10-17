package com.java.dao;

import java.sql.SQLException;

import com.java.entity.UserInfo;
import com.java.util.DBConnection;

public class UserDao extends BaseDao{
	public UserInfo queryUserByName(String username) {
		UserInfo u=null;
		try {
			String sql="select * from user_info where username=?";
			conn = DBConnection.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1,username);
			rs = pst.executeQuery();
			if(rs.next()){
				u=new UserInfo();
				u.setUserName(rs.getString(2));
				u.setPwd(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("²éÑ¯ÐÅÏ¢´íÎó£¡£¡£¡£¡");
		}finally{
			DBConnection.closeAll(rs,null,pst);
		}
		return u;
	}
}
