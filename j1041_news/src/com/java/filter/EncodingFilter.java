package com.java.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {
	private FilterConfig fc;
	public void init(FilterConfig fc) throws ServletException {
		this.fc=fc;
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		String charset=fc.getInitParameter("charset");
		req.setCharacterEncoding(charset);
		//将请求转发给另外的资源
		chain.doFilter(req, resp);
	}
	
	public void destroy() {
		// TODO Auto-generated method stub

	}
	

}
