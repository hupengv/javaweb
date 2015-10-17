package com.java.entity;

public class PageData {
	private int currPage=1;//当前页码
	private int pageSize=3;//设置默认每页显示新闻条数
	private int maxCount;//新闻总数
	private int sumPages;//设置新闻的总页面数
	
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getMaxCount() {
		return maxCount;
	}
	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}
	public int getSumPages() {
		return maxCount%pageSize==0 ? maxCount/pageSize : (maxCount/pageSize)+1;
	}

	
}
