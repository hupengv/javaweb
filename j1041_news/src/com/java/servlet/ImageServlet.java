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
		
		//���������������
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setDateHeader("expires", 0);
		
		
		int width=200,height=200;
		//���ɻ���ͼ��
		BufferedImage img=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		
		//��ȡָ��û�����ͼ�������Ķ���
		Graphics g=img.getGraphics();
		//����������
		g.setColor(new Color(0,0,0));
		g.fillRect(0, 0, width, height);
		
		//���ƺ�ɫ�߿�
		g.setColor(new Color(255,255,255));
		g.fillRect(0, 0, width-1, height-1);
		//���ɸ�������
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
			//��������ַ�
			char ch=str.charAt(rand.nextInt(str.length()));
			//��������
			Font font=new Font("����",Font.BOLD|Font.ITALIC,90);
			
			
			g.setFont(font);
			
			//����������ɫ
			g.setColor(getColor(0,100));
			//��ȡ4�������ĸ����ŵ�vcode������
			vcode+=ch;
			//�����ַ���x,y��ʾ��ǰ�ַ������½ǵ�����
			g.drawString(String.valueOf(ch),20+i*40,90+rand.nextInt(30));
		}
		//����֤����뵽��������
		request.getSession().setAttribute("vcode", vcode);
		
		//������ͻ���
		ImageIO.write(img, "jpeg", response.getOutputStream());

	}
	
	//���������ɫ
	private Color getColor(int i, int j) {
		int r=rand.nextInt(j-i)+i;
		int g=rand.nextInt(j-i)+i;
		int b=rand.nextInt(j-i)+i;
		return new Color(r,g,b);
	}

}
