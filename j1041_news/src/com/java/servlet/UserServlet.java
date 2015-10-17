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
	//用户登录
	private void logon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String vcode=request.getParameter("vcode");
		UserInfo u=ud.queryUserByName(username);
		if(username=="" || username.equals(null)){
			request.setAttribute("error", "用户名为空！");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		if(password=="" || password.equals(null)){
			request.setAttribute("error", "密码为空！");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		//判断验证码是否为空
		if(vcode=="" || vcode.equals(null)){
			request.setAttribute("error", "验证码为空！");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		//获取作用域中的存放的4个字符
		String xcode=(String)request.getSession().getAttribute("vcode");
		//判断验证码是否输入正确
		if(!xcode.equalsIgnoreCase(vcode)){
			request.setAttribute("error", "验证码错误！");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		
		if(u==null){
			request.setAttribute("error", "用户名不存在！");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else{
			if(!(u.getPwd().equals(password))){
				request.setAttribute("error", "密码错误！");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			
			else{
				//创建cookie
				Cookie c1=new Cookie("username",username);
				Cookie c2=new Cookie("password",password);
				//获取请求的参数
				String isSaveCookie=request.getParameter("isSaveCookie");
				if(isSaveCookie.equals("1")){
				
					c1.setMaxAge(60*60);
					c2.setMaxAge(60*60);
				}else{
					c1.setMaxAge(0);
					c2.setMaxAge(0);
				}
				//将cookie对象添加到响应中
				response.addCookie(c1);
				response.addCookie(c2);
				
				//创建session对象并且把u对象存入session作用域
				HttpSession ses=request.getSession();
				ses.setAttribute("u", u);
				
				//获取ServletContext对象
				ServletContext slc=this.getServletContext();
				//从ServletContext对象走过获取属性
				Integer count=(Integer)slc.getAttribute("count");
				if(count==null){
					count=1;
				}else{
					count++;
				}
				//存入Integer的作用域
				slc.setAttribute("count", count);
				NewsServlet newsServlet =new NewsServlet();
				newsServlet.newsList(request, response);
			}
		}
	}

	
	//用户注销
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession ses=request.getSession();
		ses.invalidate();
		response.sendRedirect("index.jsp");
	}

}
