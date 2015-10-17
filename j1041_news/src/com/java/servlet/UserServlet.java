package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.dao.UserDao;
import com.java.entity.UserInfo;

public class UserServlet extends HttpServlet {
	
	UserDao ud=new UserDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String method=request.getParameter("method");
		if(method.equals("logOn")){
			logon(request,response);
		}else if(method.equals("logOut")){
			logout(request,response);
		}
	}
	//�û���¼
	private void logon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String vcode=request.getParameter("vcode");
		UserInfo u=ud.queryUserByName(username);
		if(username=="" || username.equals(null)){
			request.setAttribute("error", "�û���Ϊ�գ�");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		if(password=="" || password.equals(null)){
			request.setAttribute("error", "����Ϊ�գ�");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		//�ж���֤���Ƿ�Ϊ��
		if(vcode=="" || vcode.equals(null)){
			request.setAttribute("error", "��֤��Ϊ�գ�");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		//��ȡ�������еĴ�ŵ�4���ַ�
		String xcode=(String)request.getSession().getAttribute("vcode");
		//�ж���֤���Ƿ�������ȷ
		if(!xcode.equalsIgnoreCase(vcode)){
			request.setAttribute("error", "��֤�����");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		
		if(u==null){
			request.setAttribute("error", "�û��������ڣ�");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else{
			if(!(u.getPwd().equals(password))){
				request.setAttribute("error", "�������");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			
			else{
				//����cookie
				Cookie c1=new Cookie("username",username);
				Cookie c2=new Cookie("password",password);
				//��ȡ����Ĳ���
				String isSaveCookie=request.getParameter("isSaveCookie");
				if(isSaveCookie.equals("1")){
				
					c1.setMaxAge(60*60);
					c2.setMaxAge(60*60);
				}else{
					c1.setMaxAge(0);
					c2.setMaxAge(0);
				}
				//��cookie������ӵ���Ӧ��
				response.addCookie(c1);
				response.addCookie(c2);
				
				//����session�����Ұ�u�������session������
				HttpSession ses=request.getSession();
				ses.setAttribute("u", u);
				
				//��ȡServletContext����
				ServletContext slc=this.getServletContext();
				//��ServletContext�����߹���ȡ����
				Integer count=(Integer)slc.getAttribute("count");
				if(count==null){
					count=1;
				}else{
					count++;
				}
				//����Integer��������
				slc.setAttribute("count", count);
				NewsServlet newsServlet =new NewsServlet();
				newsServlet.newsList(request, response);
			}
		}
	}

	
	//�û�ע��
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession ses=request.getSession();
		ses.invalidate();
		response.sendRedirect("index.jsp");
	}

}
