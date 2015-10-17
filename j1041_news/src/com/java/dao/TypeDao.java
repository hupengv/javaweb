package com.java.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.entity.NewsType;
import com.java.entity.PageData;
import com.java.util.DBConnection;

public class TypeDao extends BaseDao {
	/**
	 * �������
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
				System.out.println("��ӳ�����");
			}finally{
				DBConnection.closeAll(null, null, pst);
			}
		return false;
	}
	/*
	 * ��ѯ�����б�
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
			System.out.println("��ѯ����");
		}finally{
			DBConnection.closeAll(rs, null, pst);
		}
		return typeList;
	}
	
	/*
	 * ɾ������
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
			System.out.println("ɾ������");
		}finally{
			DBConnection.closeAll(null, null, pst);
		}
		return false;
	}
	
	//ͨ��id��news_type
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
			System.out.println("��ѯ����");
		}finally{
			DBConnection.closeAll(rs, null, pst);
		}
		return newsType;
	}
	
	//�޸�����
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
			System.out.println("�޸ĳ���");
		}finally{
			DBConnection.closeAll(null, null, pst);
		}
		return false;
	}

	//��ѯ����������
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
			System.out.println("��ѯ��������������");
		}finally{
			DBConnection.closeAll(rs, null, pst);
		}
		return 0;
	}
	
	//���ݷ�ҳʵ�����ѯ�����б�
	public List<NewsType> getTypeList(PageData pageData) {
		List<NewsType> typeList=new ArrayList<NewsType>();
		//ȷ����ʵ������ÿҳ������Ŀ
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
			System.out.println("��ѯ����");
		}finally{
			DBConnection.closeAll(rs, null, pst);
		}
		return typeList;
	}
	
}
