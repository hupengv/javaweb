package com.java.entity;

public class PageData {
	private int currPage=1;//��ǰҳ��
	private int pageSize=3;//����Ĭ��ÿҳ��ʾ��������
	private int maxCount;//��������
	private int sumPages;//�������ŵ���ҳ����
	
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
