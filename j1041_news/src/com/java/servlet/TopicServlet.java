package com.java.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dao.TypeDao;
import com.java.entity.NewsType;
import com.java.entity.PageData;

public class TopicServlet extends HttpServlet {
	private TypeDao typeDao=new TypeDao();
	private NewsType newsType =new NewsType();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String method=request.getParameter("method");
		if(method.equals("topicAdd")){
			topicAddServlet(request,response);
		}else if(method.equals("topicList")){
			topicList(request,response);
		}else if(method.equals("topicDel")){
			topicDelete(request,response);
		}else if(method.equals("gotoModify")){
			gotoModify(request,response);
		}else if(method.equals("topicModify")){
			topicModify(request,response);
		}
	}
	//修改主题
	private void topicModify(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
	
		//获取topic_modify.jsp中typename中输入的文本信息
		String typeName=request.getParameter("typeName");
		//获取对应的id号
		int typeId=Integer.parseInt(request.getParameter("typeId"));
		//将输入的文本信息和获取的id设置到NewsType对象中
		newsType.setTypeId(typeId);
		newsType.setTypeName(typeName);
		//判断时是否修改成功
		boolean flag= typeDao.modifyType(newsType);
		if(flag){
			topicList(request,response);
		}else{
			request.setAttribute("error","修改出错！");
			request.getRequestDispatcher("/admin/topic_modify.jsp").forward(request,response);
		}
		
	}
	//进入修改主题页面
	private void gotoModify(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		//获取名字为id对应数据库中的id号
		int typeId=Integer.parseInt(request.getParameter("id"));
		//通过typeid查询出newstype信息
		NewsType newsType=typeDao.queryNewsById(typeId);
		//设置请求作用域中的newstype信息
		request.setAttribute("newsType", newsType);
		request.getRequestDispatcher("/admin/topic_modify.jsp").forward(request, response);
	}
	//删除主题
	private void topicDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		int typeId=Integer.parseInt(request.getParameter("id"));
		boolean flag=typeDao.delType(typeId);
		if(!flag){
			request.setAttribute("error", "删除失败！");
		}else{
			topicList(request,response);
		}
		
	}
	
	//查询分页主题列表
	private void topicList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		String  currPage=request.getParameter("currPage");
		String  pageSize=request.getParameter("pageSize");
		
		PageData pageData =new PageData();
		int maxCount=typeDao.getMaxCount();
		pageData.setMaxCount(maxCount);
	
		if(pageSize!=null && !pageSize.equals("")){
			pageData.setPageSize(Integer.parseInt(pageSize));
		}
		if(currPage!=null && !currPage.equals("")){
			pageData.setCurrPage(Integer.parseInt(currPage));
		}else{
			pageData.setCurrPage(1);
		}
		
		//获取newtyp集合元素
		List<NewsType> typeList=typeDao.getTypeList(pageData);
		//设置请求作用域的属性
		request.setAttribute("typeList", typeList);
		request.setAttribute("pageData", pageData);
		request.getRequestDispatcher("/admin/topic_list.jsp").forward(request,response);
	}
	
	//主题添加
	private void topicAddServlet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		String typeName=request.getParameter("typeName");
		boolean flag=typeDao.addType(typeName);
		if(flag){
			topicList(request,response);
		}else{
			request.setAttribute("error","查询出错！");
			request.getRequestDispatcher("/admin/topic_add.jsp").forward(request,response);
		}
		
	}

}
