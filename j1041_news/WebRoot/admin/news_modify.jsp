<%@ page language="java" import="java.util.*,com.java.dao.*" pageEncoding="gbk"%>
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
<body>
<%@include file="top.jsp"  %>
<div id="main">
<%@include file="left.jsp" %>
  <div id="opt_area">
    <h1 id="opt_type"> �޸����ţ� </h1>
    <form action="admin/news?method=newsModify" method="post" onsubmit="return check()">
      <p>
        <label> ���� </label>   
        <input name="typeName" value="${requestScope.typeName }" readonly="readonly"/>
      </p>
      <p>
        <label> ���� </label>
       <input name="title" type="text" class="opt_input" value="${requestScope.title }" />
      </p>
      <p>
        <label> ���� </label>
        <input name="author" type="text" class="opt_input" value="${requestScope.author }" />
      </p>
      <p>
        <label> ժҪ </label>
        <textarea name="summary" cols="40" rows="3" >${requestScope.summary }</textarea>
      </p>
      <p>
        <label> ���� </label>
        <textarea name="content" cols="70" rows="10" >${requestScope.content }</textarea>
      </p>
      <p>
        <label> �ϴ�ͼƬ </label>
        <input name="file" type="file" class="opt_input" />
      </p>
      <input type="submit" value="�ύ" class="opt_sub" />
      <input type="reset" value="����" class="opt_sub" />
    </form>
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
