package com.java.dao;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.entity.NewsInfo;
import com.java.util.DBConnection;
import com.java.util.DateUtil;

public class NewsDao extends BaseDao {
	
	//查询整个newsinfo表
	public List<NewsInfo> queryNewsInfo() {
		List<NewsInfo> newsList=new ArrayList<NewsInfo>();
		try {
			String sql="select * from news_info";
			conn=DBConnection.getConnection();
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			NewsInfo newsInfo=null;
			while(rs.next()){
				newsInfo=new NewsInfo();
				newsInfo.setNewsId(rs.getInt(1));
				newsInfo.setTypeId(rs.getInt(2));
				newsInfo.setNewsTitle(rs.getString(3));
				newsInfo.setNewsAut(rs.getString(4));
				newsInfo.setNewsSum(rs.getString(5));
				newsInfo.setNewsCon(rs.getString(6));
				newsInfo.setNewsPic(rs.getString(7));
				newsInfo.setNewsDate(rs.getTimestamp(8));
				newsList.add(newsInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("查询出错！");
		}finally{
			DBConnection.closeAll(rs, null, pst);
		}
		return newsList;
	}
	
	
	//添加新闻
	public boolean addNewsInfo(NewsInfo newsInfo) {
		try {
			String sql="insert into news_info(type_id,news_title,news_author,news_summary,news_content,news_pic,news_pubDate) values(?,?,?,?,?,?,?)";
			conn=DBConnection.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setInt(1, newsInfo.getTypeId());
			pst.setString(2, newsInfo.getNewsTitle());
			pst.setString(3, newsInfo.getNewsAut());
			pst.setString(4, newsInfo.getNewsSum());
			pst.setString(5, newsInfo.getNewsCon());
			pst.setString(6, newsInfo.getNewsPic());
			pst.setTimestamp(7, DateUtil.toTimestamp(newsInfo.getNewsDate()));
			int rows=pst.executeUpdate();
			if(rows>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("插入数据出错！");
		}finally{
			DBConnection.closeAll(null, null, pst);
		}
		return false;
	}
	
	//删除新闻
	public boolean deleteNewsById(int newsId) {
		try {
			String sql="delete from news_info where news_id=?";
			conn=DBConnection.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setInt(1, newsId);
			int rows=pst.executeUpdate();
			if(rows>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("删除新闻出错！");
		}finally{
			DBConnection.closeAll(null, null, pst);
		}
		return false;
	}

	//根据newsId查询newsInfo
	public NewsInfo queryNewsById(int newsId) {
		NewsInfo newsInfo=null;
		try {
			String sql="select * from news_info where news_id=?";
			conn=DBConnection.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setInt(1, newsId);
			rs=pst.executeQuery();
			if(rs.next()){
				newsInfo=new NewsInfo();
				newsInfo.setNewsId(rs.getInt(1));
				newsInfo.setTypeId(rs.getInt(2));
				newsInfo.setNewsTitle(rs.getString(3));
				newsInfo.setNewsAut(rs.getString(4));
				newsInfo.setNewsSum(rs.getString(5));
				newsInfo.setNewsCon(rs.getString(6));
				newsInfo.setNewsPic(rs.getString(7));
				newsInfo.setNewsDate(rs.getDate(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("查询出错！");
		}finally{
			DBConnection.closeAll(rs, null, pst);
		}
		
		return newsInfo;
	}

	//修改新闻
	public boolean updateNewsById(NewsInfo newsInfo,int newsId) {
		try {
			String sql="update news_info set news_title=?,news_author=?,news_summary=?,news_content=?,news_pic=?,news_pubDate=? where news_id=?";
			conn=DBConnection.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setString(1, newsInfo.getNewsTitle());
			pst.setString(2, newsInfo.getNewsAut());
			pst.setString(3, newsInfo.getNewsSum());
			pst.setString(4, newsInfo.getNewsCon());
			pst.setString(5, newsInfo.getNewsPic());
			pst.setTimestamp(6, DateUtil.toTimestamp( newsInfo.getNewsDate()));
			pst.setInt(7, newsId);
			int rows=pst.executeUpdate();
			if(rows>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("修改新闻出错！");
		}finally{
			DBConnection.closeAll(null, null, pst);
		}	
		return false;
	}
	
}
