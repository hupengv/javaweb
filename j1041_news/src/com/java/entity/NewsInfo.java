package com.java.entity;

import java.util.Date;

public class NewsInfo {
	private int newsId;
	private int typeId;
	private String newsTitle;
	private String newsAut;
	private String newsSum;
	private String newsCon;
	private String newsPic;
	private Date newsDate;
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public String getNewsAut() {
		return newsAut;
	}
	public void setNewsAut(String newsAut) {
		this.newsAut = newsAut;
	}
	public String getNewsSum() {
		return newsSum;
	}
	public void setNewsSum(String newsSum) {
		this.newsSum = newsSum;
	}
	public String getNewsCon() {
		return newsCon;
	}
	public void setNewsCon(String newsCon) {
		this.newsCon = newsCon;
	}
	public String getNewsPic() {
		return newsPic;
	}
	public void setNewsPic(String newsPic) {
		this.newsPic = newsPic;
	}
	public Date getNewsDate() {
		return newsDate;
	}
	public void setNewsDate(Date newsDate) {
		this.newsDate = newsDate;
	}
}
