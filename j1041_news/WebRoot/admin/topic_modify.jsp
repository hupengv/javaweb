<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>�޸�����--�����̨</title>
<link href="CSS/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>&nbsp; 
<%@ include file="top.jsp" %>
<div id="main">
  <%@ include file="left.jsp" %>
  <div id="opt_area">
    <h1 id="opt_type"> �޸����⣺ </h1>
    <form action="admin/topic?method=topicModify" method="post" onsubmit="return check()">
      <p>
        <label> �������� </label>
        <input name="typeName" type="text" class="opt_input" value="${requestScope.newsType.typeName }" />
        <input name="typeId" type="hidden" value="${requestScope.newsType.typeId }"/>"
      </p>
      <input type="submit" value="�ύ" class="opt_sub" />
      <input type="reset" value="����" class="opt_sub" />
    </form>
     <font color="red">${requestScope.error}</font>
  </div>
</div>
<div id="site_link"> <a href="#">��������</a><span>|</span> <a href="#">Aboue Us</a><span>|</span> <a href="#">��ϵ����</a><span>|</span> <a href="#">������</a><span>|</span> <a href="#">�������</a><span>|</span> <a href="#">��������</a><span>|</span> <a href="#">��Ƹ��Ϣ</a><span>|</span> <a href="#">��վ��ͼ</a><span>|</span> <a href="#">���Է���</a> </div>
<div id="footer">
  <p class="">24Сʱ�ͻ��������ߣ�010-68988888  &#160;&#160;&#160;&#160; <a href="#">����������</a> &#160;&#160;&#160;&#160;  �������ߣ�010-627488888<br />
    �����������������ٱ��绰��010-627488888  &#160;&#160;&#160;&#160;  �ٱ����䣺<a href="#">jubao@wh-os.com.cn</a></p>
  <p class="copyright">Copyright &copy; 1999-2009 News China gov, All Right Reserver<br />
    �����й�   ��Ȩ����</p>
</div>
</body>
</html>
    