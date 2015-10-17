package com.java.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.java.entity.UserInfo;

public class RoloFilter implements Filter {
	
	public void init(FilterConfig fc) throws ServletException {}
	

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request =(HttpServletRequest)req;
		HttpSession ses=request.getSession();
		UserInfo u=(UserInfo)ses.getAttribute("u");
		if(u==null){
			request.setAttribute("error", "无访问权限请登录！");
			request.getRequestDispatcher("/index.jsp").forward(request, resp);
		}else{
			chain.doFilter(request, resp);
		}
 		
		
	}
	
	public void destroy() {}
	

}
