<%@ page language="java" import="java.util.*,com.java.entity.*" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
   <base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>�������--�����̨</title>
<link href="CSS/admin.css" rel="stylesheet" type="text/css" />
<script language="javascript">
	function clickdel(){
		return confirm("ɾ������ȷ��");
	}
	
</script>
</head>

<body>
<%@include file="top.jsp" %>
<div id="main">
 <%@include file="left.jsp" %>
  <div id="opt_area">
    <ul class="classlist">
    <c:forEach var="newsInfo" items="${requestScope.newsList }">
    	 <li> ${newsInfo.newsTitle } <span> ���ߣ�${newsInfo.newsAut }                                             
        &#160;&#160;&#160;&#160; <a href='admin/news?method=gotonewsModify&newsId=${newsInfo.newsId }'>�޸�</a> 
        &#160;&#160;&#160;&#160; <a href='admin/news?method=newsDelete&newsId=${newsInfo.newsId }' onclick='return clickdel()'>ɾ��</a> 
        </span><font color="red">${requestScope.error }</font> </li>
    </c:forEach>
      <li> ��������飺˵�������������� ��㻦������֧�� <span> ���ߣ�
        sport                                             
        &#160;&#160;&#160;&#160; <a href='news_modify.html'>�޸�</a> &#160;&#160;&#160;&#160; <a href='#' onclick='return clickdel()'>ɾ��</a> </span> </li>
      <li> ʡ����500�����ͽ�ҵ�Ƕ� ��Ա:�ź��������ܹ��� <span> ���ߣ�
        sport                                             
        &#160;&#160;&#160;&#160; <a href='news_modify.html'>�޸�</a> &#160;&#160;&#160;&#160; <a href='#' onclick='return clickdel()'>ɾ��</a> </span> </li>
      <li> ��Ԫ˶�������˵����Ϳ������� ���һ���¿��Ű� <span> ���ߣ�
        sport                                             
        &#160;&#160;&#160;&#160; <a href='news_modify.html'>�޸�</a> &#160;&#160;&#160;&#160; <a href='#' onclick='return clickdel()'>ɾ��</a> </span> </li>
      <li> �ٽ�ھ����Ƕ�Ʊ�ܶ�Ա ����:���!�������˱��� <span> ���ߣ�
        sport                                             
        &#160;&#160;&#160;&#160; <a href='news_modify.html'>�޸�</a> &#160;&#160;&#160;&#160; <a href='#' onclick='return clickdel()'>ɾ��</a> </span> </li>
      <li> һֽ���氵���껨����̬�� ������������ͻ������ <span> ���ߣ�
        sport                                             
        &#160;&#160;&#160;&#160; <a href='news_modify.html'>�޸�</a> &#160;&#160;&#160;&#160; <a href='#' onclick='return clickdel()'>ɾ��</a> </span> </li>
      <li class='space'></li>
      <li> ����仯���º�ƽ������ <span> ���ߣ�news
        
        &#160;&#160;&#160;&#160; <a href='news_modify.html'>�޸�</a> &#160;&#160;&#160;&#160; <a href='#' onclick='return clickdel()'>ɾ��</a> </span> </li>
      <li> ��ó��ί���ں��ݿ��� ������ó������̬�ȵ͵� <span> ���ߣ�news                                              
        &#160;&#160;&#160;&#160; <a href='news_modify.html'>�޸�</a> &#160;&#160;&#160;&#160; <a href='#' onclick='return clickdel()'>ɾ��</a> </span> </li>
      <li> �ٸ��֣���ʮ���塱�ĸ�Ӧ�����Ѵ��ת�� <span> ���ߣ�
        news                                              
        &#160;&#160;&#160;&#160; <a href='news_modify.html'>�޸�</a> &#160;&#160;&#160;&#160; <a href='#' onclick='return clickdel()'>ɾ��</a> </span> </li>
      <li> ���ʳƷ�����Ԫ��Ϊ�ⴢ��λ ����һ���λ <span> ���ߣ�
        out                                               
        &#160;&#160;&#160;&#160; <a href='news_modify.html'>�޸�</a> &#160;&#160;&#160;&#160; <a href='#' onclick='return clickdel()'>ɾ��</a> </span> </li>
      <li> ����е���٣��������С� �㽭�����ֳ����˱��� <span> ���ߣ�
        news                                              
        &#160;&#160;&#160;&#160; <a href='news_modify.html'>�޸�</a> &#160;&#160;&#160;&#160; <a href='#' onclick='return clickdel()'>ɾ��</a> </span> </li>
      <li class='space'>to</li>
      <li> ���ڳ�Ʒ�ͼ۸��ϵ����ɶ��� <span> ���ߣ�
        news                                              
        &#160;&#160;&#160;&#160; <a href='news_modify.html'>�޸�</a> &#160;&#160;&#160;&#160; <a href='#' onclick='return clickdel()'>ɾ��</a> </span> </li>
      <li> ���������׶�԰��ѧУ������ͣ�� <span> ���ߣ�
        news                                              
        &#160;&#160;&#160;&#160; <a href='news_modify.html'>�޸�</a> &#160;&#160;&#160;&#160; <a href='#' onclick='return clickdel()'>ɾ��</a> </span> </li>
      <li> �����������Ĵ�����ը��ǹ�� Ŀǰԭ���� <span> ���ߣ�
        out                                               
        &#160;&#160;&#160;&#160; <a href='news_modify.html'>�޸�</a> &#160;&#160;&#160;&#160; <a href='#' onclick='return clickdel()'>ɾ��</a> </span> </li>
      <li> ��̨����ܴ�½��У�Ӵ��̨����������� <span> ���ߣ�
        news                                              
        &#160;&#160;&#160;&#160; <a href='news_modify.html'>�޸�</a> &#160;&#160;&#160;&#160; <a href='#' onclick='return clickdel()'>ɾ��</a> </span> </li>
      <li> ��̨�콫��Ȩ��������ʡ�в��ָ�̨��������Ȩ <span> ���ߣ�
        news                                              
        &#160;&#160;&#160;&#160; <a href='news_modify.html'>�޸�</a> &#160;&#160;&#160;&#160; <a href='#' onclick='return clickdel()'>ɾ��</a> </span> </li>
      <li class='space'>r</li>
    </ul>
     <p align="right"> ��ǰҳ��:[1/3]&nbsp; <a href="#">��һҳ</a> <a href="#">ĩҳ</a> </p>
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
