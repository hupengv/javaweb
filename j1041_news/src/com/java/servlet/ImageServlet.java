package com.java.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageServlet extends HttpServlet {
	private Random rand=new Random();
	private String str="0123456789abcdefghijklmopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("image/jpeg");
		
		//设置浏览器不缓存
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setDateHeader("expires", 0);
		
		
		int width=200,height=200;
		//生成缓冲图像
		BufferedImage img=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		
		//获取指向该缓冲区图像上下文对象
		Graphics g=img.getGraphics();
		//绘制填充矩形
		g.setColor(new Color(0,0,0));
		g.fillRect(0, 0, width, height);
		
		//绘制黑色边框
		g.setColor(new Color(255,255,255));
		g.fillRect(0, 0, width-1, height-1);
		//生成干扰线条
		for(int i=0;i<800;i++){
			int x1=rand.nextInt(width);
			int y1=rand.nextInt(height);
			int x2=x1+rand.nextInt(30);
			int y2=y1+rand.nextInt(30);
			g.setColor(getColor(100,200));
			g.drawLine(x1, y1, x2, y2);
		}
		String vcode="";
		for(int i=0;i<4;i++){
			//随机生成字符
			char ch=str.charAt(rand.nextInt(str.length()));
			//设置字体
			Font font=new Font("宋体",Font.BOLD|Font.ITALIC,90);
			
			
			g.setFont(font);
			
			//设置字体颜色
			g.setColor(getColor(0,100));
			//获取4个随机字母并存放到vcode变量中
			vcode+=ch;
			//绘制字符串x,y表示当前字符串左下角的坐标
			g.drawString(String.valueOf(ch),20+i*40,90+rand.nextInt(30));
		}
		//将验证码存入到作用域中
		request.getSession().setAttribute("vcode", vcode);
		
		//输出到客户端
		ImageIO.write(img, "jpeg", response.getOutputStream());

	}
	
	//生成随机颜色
	private Color getColor(int i, int j) {
		int r=rand.nextInt(j-i)+i;
		int g=rand.nextInt(j-i)+i;
		int b=rand.nextInt(j-i)+i;
		return new Color(r,g,b);
	}

}
