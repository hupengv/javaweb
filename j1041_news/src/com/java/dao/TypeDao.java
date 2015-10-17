package com.java.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.entity.NewsType;
import com.java.entity.PageData;
import com.java.util.DBConnection;

public class TypeDao extends BaseDao {
	/**
	 * 添加主题
	 * @param typeName
	 * @return
	 */
	public boolean addType(String typeName) {
		try {
			String sql="insert news_type(type_name) value(?)";
			conn = DBConnection.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1,typeName);
			int row=pst.executeUpdate();
			
			if(row>0){
				return true;
			}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("添加出错！！");
			}finally{
				DBConnection.closeAll(null, null, pst);
			}
		return false;
	}
	/*
	 * 查询主题列表
	 */
	public List<NewsType> getTypeList() {
		List<NewsType> typeList=new ArrayList<NewsType>();
		try {
			String sql="select * from news_type";
			conn = DBConnection.getConnection();
			pst = conn.prepareStatement(sql);
			rs=pst.executeQuery();
			NewsType type=null;
			while(rs.next()){
				type =new NewsType();
				type.setTypeId(rs.getInt(1));
				type.setTypeName(rs.getString(2));
				typeList.add(type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("查询出错！");
		}finally{
			DBConnection.closeAll(rs, null, pst);
		}
		return typeList;
	}
	
	/*
	 * 删除主题
	 */
	public boolean delType(int typeId) {
		try {
			String sql="delete from news_type where type_id=?";
			conn = DBConnection.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, typeId);
			int rows=pst.executeUpdate();
			if(rows>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("删除出错");
		}finally{
			DBConnection.closeAll(null, null, pst);
		}
		return false;
	}
	
	//通过id查news_type
	public NewsType queryNewsById(int typeId) {
		NewsType newsType=null;
		try {
			String sql="select * from news_type where type_id="+typeId;
			conn=DBConnection.getConnection();
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			if(rs.next()){
				newsType=new NewsType();
				newsType.setTypeId(rs.getInt(1));
				newsType.setTypeName(rs.getString(2));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println("查询出错！");
		}finally{
			DBConnection.closeAll(rs, null, pst);
		}
		return newsType;
	}
	
	//修改主题
	public boolean modifyType(NewsType newsType) {
		try {
			String sql="update news_type set type_name=? where type_id=?";
			conn=DBConnection.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setString(1, newsType.getTypeName());
			pst.setInt(2, newsType.getTypeId());
			int rows=pst.executeUpdate();
			if(rows>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("修改出错！");
		}finally{
			DBConnection.closeAll(null, null, pst);
		}
		return false;
	}

	//查询新闻总条数
	public int getMaxCount() {
		try {
			String sql="select count(*) from news_type";
			conn=DBConnection.getConnection();
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("查询新闻总条数出错！");
		}finally{
			DBConnection.closeAll(rs, null, pst);
		}
		return 0;
	}
	
	//根据分页实体类查询新闻列表
	public List<NewsType> getTypeList(PageData pageData) {
		List<NewsType> typeList=new ArrayList<NewsType>();
		//确定其实索引和每页新闻条目
		int startIndex=pageData.getPageSize()*(pageData.getCurrPage()-1);
		int pageSize=pageData.getPageSize();
		try {
			String sql="select * from news_type limit ?,?";
			conn = DBConnection.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, startIndex);
			pst.setInt(2, pageSize);
			rs=pst.executeQuery();
			NewsType type=null;
			while(rs.next()){
				type =new NewsType();
				type.setTypeId(rs.getInt(1));
				type.setTypeName(rs.getString(2));
				typeList.add(type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("查询出错！");
		}finally{
			DBConnection.closeAll(rs, null, pst);
		}
		return typeList;
	}
	
}
