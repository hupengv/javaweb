<%@ page language="java" import="java.util.*,com.java.entity.*" pageEncoding="gbk"%>

<div id="header">
  <div id="welcome">欢迎使用新闻管理系统！</div>
  <div id="nav">
    <div id="logo"><img src="Images/logo.jpg" alt="新闻中国" /></div>
    <div id="a_b01"><img src="Images/a_b01.gif" alt="" /></div>
  </div>
</div>
<div id="admin_bar">
  <div id="status">管理员：<font color="red">${sessionScope.u.userName}</font> 登录  
  <font>${requestScope.error }</font>
  &#160;&#160;&#160;&#160; 
  <font color="red"><a href="index.jsp">点击返回主页</a></font>
  &#160;&#160;&#160;&#160; 
  <a href="user?method=logOut">login out</a></div>
  <div id="channel"> </div>
</div>
