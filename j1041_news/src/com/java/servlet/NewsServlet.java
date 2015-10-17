package com.java.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dao.NewsDao;
import com.java.dao.TypeDao;
import com.java.entity.NewsInfo;
import com.java.entity.NewsType;
import com.jspsmart.upload.SmartUpload;

public class NewsServlet extends HttpServlet {
	private NewsDao newsDao=new NewsDao();
	private TypeDao typeDao=new TypeDao();
	int newsId;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method=request.getParameter("method");
		if(method.equals("gotoNewsAdd")){
			gotoNewsAdd(request,response);
		}else if(method.equals("newsAdd")){
			newsAdd(request,response);
		}else if(method.equals("newsList")){
			newsList(request,response);
		}else if(method.equals("gotonewsModify")){
			gotonewsModify(request,response);
		}else if(method.equals("newsModify")){
			newsModify(request,response);
		}else if(method.equals("newsDelete")){
			newsDelete(request,response);
		}else if(method.equals("readNews")){
			readNews(request,response);
		}
	}

	//��ѯ���������б�
	public void gotoNewsAdd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		List<NewsType> typeList=typeDao.getTypeList();
		request.setAttribute("typeList", typeList);
		request.getRequestDispatcher("/admin/news_add.jsp").forward(request, response);
	}
	
	//��ѯ�����б�
	public void newsList(HttpServletRequest request,
			HttpServletResponse response)  throws ServletException, IOException{
		List<NewsInfo> newsList=newsDao.queryNewsInfo();
		request.setAttribute("newsList", newsList);
		request.getRequestDispatcher("/admin/admin.jsp").forward(request,response);
	}
	
	//�������(ʵ���ļ��ϴ�)
	public  void newsAdd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String filename = "";
		
		SmartUpload su = new SmartUpload();
		// ��ʼ��SmartUpload����
		su.initialize(this.getServletConfig(), request, response);
		com.jspsmart.upload.File file = null;
		// �����ϴ�����
		String allowed = "gif,jpg,doc,rar";
		// �����ϴ�����
		String denied = "jsp,asp,php,aspx,html,htm,exe,bat";
		com.jspsmart.upload.Request req = null;
		// �����ϴ��ļ���С
		int file_size = 10 * 1024 * 1024; //10mb
		String exceptionMsg = null;
		int i = 0;
		try {
			// ���������ϴ��ļ�����
			su.setAllowedFilesList(allowed);
			// �������ϴ��ļ�����
			su.setDeniedFilesList(denied);
			// �����ļ��������
			su.setMaxFileSize(file_size);
			su.setCharset("GBK");
			// ִ���ϴ�
			su.upload();
			// �õ������ϴ��ļ�����Ϣ
			file = su.getFiles().getFile(0);
			String filepath = null;
			if (!file.isMissing()) {
				// �����ļ��ڷ������ı���λ��
			
				filepath = "upload\\";
				filename = file.getFileName();
				String ext=filename.substring(filename.lastIndexOf(".")+1);
				Date date=new Date();
				filename=date.getTime()+""+(int)(Math.random()*100000)+"."+ext;
				filepath +=filename ;
				// �ļ����Ϊ
				file.setCharset("gbk");
				file.saveAs(filepath, SmartUpload.SAVE_VIRTUAL);
			}

			// ��ȡsmartupload��װ��request
			req = su.getRequest();
			// ��ȡ�������ҳ�洫�ݹ����Ĳ���
			int typeId=Integer.parseInt(req.getParameter("typeId"));
			String title=req.getParameter("title");
			String author=req.getParameter("author");
			String summary=req.getParameter("summary");
			String content=req.getParameter("content");
			String pic=filepath;//��ȡ�ļ��ϴ����·��
			
			NewsInfo newsInfo=new NewsInfo();
			newsInfo.setTypeId(typeId);
			newsInfo.setNewsTitle(title);
			newsInfo.setNewsAut(author);
			newsInfo.setNewsSum(summary);
			newsInfo.setNewsCon(content);
			newsInfo.setNewsPic(pic);
			newsInfo.setNewsDate(new Date());
			
			boolean flag=newsDao.addNewsInfo(newsInfo);
			if(flag){
				newsList(request,response);
			}else{
				request.setAttribute("error", "�������ʧ�ܣ�");
				
				request.setAttribute("newsInfo", newsInfo);
				
				gotoNewsAdd(request,response);
				}
		}catch(Exception e){
			exceptionMsg =e.getMessage();
			e.printStackTrace();
			request.setAttribute("error", "�������ʧ�ܣ�");
			gotoNewsAdd(request,response);
		}
		
	}
	
	
	//ɾ������
	private void newsDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		
		int newsId=Integer.parseInt(request.getParameter("newsId"));
		boolean flag=newsDao.deleteNewsById(newsId);
		if(flag){
			newsList(request,response);
		}else{
			request.setAttribute("error", "ɾ������ʧ�ܣ�");
			newsList(request,response);
		}
		
	}
	
	
	//����gotonewsModify����ҳ��
	private void gotonewsModify(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		
		newsId=Integer.parseInt(request.getParameter("newsId"));
		NewsInfo newsInfo=newsDao.queryNewsById(newsId);
		int typeId=newsInfo.getTypeId();
		NewsType newsType=typeDao.queryNewsById(typeId);
		String typeName=newsType.getTypeName();
		request.setAttribute("typeName", typeName);
		request.setAttribute("title",newsInfo.getNewsTitle());
		request.setAttribute("author", newsInfo.getNewsAut());
		request.setAttribute("summary", newsInfo.getNewsSum());
		request.setAttribute("content", newsInfo.getNewsCon());
		request.setAttribute("pic", newsInfo.getNewsPic());
		request.getRequestDispatcher("/admin/news_modify.jsp").forward(request, response);
	}
	
	//�����޸�
	private void newsModify(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		String title=request.getParameter("title");
		String author=request.getParameter("author");
		String summary=request.getParameter("summary");
		String content=request.getParameter("content");
		String file=request.getParameter("file");
		
		NewsInfo newsInfo=new NewsInfo();
		newsInfo.setNewsTitle(title);
		newsInfo.setNewsAut(author);
		newsInfo.setNewsSum(summary);
		newsInfo.setNewsCon(content);
		newsInfo.setNewsPic(file);
		newsInfo.setNewsDate(new Date());
		
		boolean flag=newsDao.updateNewsById(newsInfo,newsId);
		if(flag){
			newsList(request,response);
		}else{
			request.setAttribute("error", "�޸����ų���");
			request.getRequestDispatcher("/admin/news_modify.jsp").forward(request,response);
		}
		
	}
	
	//�����Ķ�
	private void readNews(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		int newsId=Integer.parseInt(request.getParameter("newsId"));
		NewsInfo newsInfo=newsDao.queryNewsById(newsId);
		request.setAttribute("newsInfo",newsInfo);
		request.getRequestDispatcher("/newspages/news_read.jsp").forward(request, response);
	}
	
	

}
