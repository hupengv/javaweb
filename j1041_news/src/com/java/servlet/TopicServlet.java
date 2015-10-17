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
	//�޸�����
	private void topicModify(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
	
		//��ȡtopic_modify.jsp��typename��������ı���Ϣ
		String typeName=request.getParameter("typeName");
		//��ȡ��Ӧ��id��
		int typeId=Integer.parseInt(request.getParameter("typeId"));
		//��������ı���Ϣ�ͻ�ȡ��id���õ�NewsType������
		newsType.setTypeId(typeId);
		newsType.setTypeName(typeName);
		//�ж�ʱ�Ƿ��޸ĳɹ�
		boolean flag= typeDao.modifyType(newsType);
		if(flag){
			topicList(request,response);
		}else{
			request.setAttribute("error","�޸ĳ���");
			request.getRequestDispatcher("/admin/topic_modify.jsp").forward(request,response);
		}
		
	}
	//�����޸�����ҳ��
	private void gotoModify(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		//��ȡ����Ϊid��Ӧ���ݿ��е�id��
		int typeId=Integer.parseInt(request.getParameter("id"));
		//ͨ��typeid��ѯ��newstype��Ϣ
		NewsType newsType=typeDao.queryNewsById(typeId);
		//���������������е�newstype��Ϣ
		request.setAttribute("newsType", newsType);
		request.getRequestDispatcher("/admin/topic_modify.jsp").forward(request, response);
	}
	//ɾ������
	private void topicDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		int typeId=Integer.parseInt(request.getParameter("id"));
		boolean flag=typeDao.delType(typeId);
		if(!flag){
			request.setAttribute("error", "ɾ��ʧ�ܣ�");
		}else{
			topicList(request,response);
		}
		
	}
	
	//��ѯ��ҳ�����б�
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
		
		//��ȡnewtyp����Ԫ��
		List<NewsType> typeList=typeDao.getTypeList(pageData);
		//�������������������
		request.setAttribute("typeList", typeList);
		request.setAttribute("pageData", pageData);
		request.getRequestDispatcher("/admin/topic_list.jsp").forward(request,response);
	}
	
	//�������
	private void topicAddServlet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		String typeName=request.getParameter("typeName");
		boolean flag=typeDao.addType(typeName);
		if(flag){
			topicList(request,response);
		}else{
			request.setAttribute("error","��ѯ����");
			request.getRequestDispatcher("/admin/topic_add.jsp").forward(request,response);
		}
		
	}

}
