<%@ page language="java" import="java.util.*,com.java.entity.*" pageEncoding="gbk"%>

<div id="header">
  <div id="welcome">��ӭʹ�����Ź���ϵͳ��</div>
  <div id="nav">
    <div id="logo"><img src="Images/logo.jpg" alt="�����й�" /></div>
    <div id="a_b01"><img src="Images/a_b01.gif" alt="" /></div>
  </div>
</div>
<div id="admin_bar">
  <div id="status">����Ա��<font color="red">${sessionScope.u.userName}</font> ��¼  
  <font>${requestScope.error }</font>
  &#160;&#160;&#160;&#160; 
  <font color="red"><a href="index.jsp">���������ҳ</a></font>
  &#160;&#160;&#160;&#160; 
  <a href="user?method=logOut">login out</a></div>
  <div id="channel"> </div>
</div>
