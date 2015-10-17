<%@ page language="java" import="java.util.*,com.java.entity.*" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>�����б�--�����̨</title>
<link href="CSS/admin.css" rel="stylesheet" type="text/css" />
</head>

<script language="javascript">
	function chageSize(txt){
		if(parseInt(txt.value)<=0){
			txt.value=3;
		}
		window.location.href="<%=basePath%>admin/topic?method=topicList&pageSize="+txt.value;
	}
	
</script>

<body>
<%@include file="top.jsp" %>
<div id="main">
<%@ include file="left.jsp" %>
  <div id="opt_area">
    <ul class="classlist">
    	<c:forEach var="newsType" items="${requestScope.typeList}">
    		<li> &#160;&#160;&#160;&#160;${newsType.typeName} 
    		&#160;&#160;&#160;&#160; <a href='admin/topic?method=gotoModify&id=${newsType.typeId }'>�޸�</a> 
    		&#160;&#160;&#160;&#160; <a href='admin/topic?method=topicDel&id=${newsType.typeId }'  onclick='return confirm("�Ƿ�ɾ��?")'>ɾ��</a> 
    		</li>
   		</c:forEach>
    </ul>
    <p align="right"> 
	          ��ǰҳ��:[${pageData.currPage }/${pageData.sumPages }]&nbsp;&nbsp; 
	          ÿҳ<input type="text" name="pageSize" style="width:15px;text-align:center;" onblur="chageSize(this)" value="${pageData.pageSize}"/>����¼
	    <c:if test="${pageData.currPage eq 1}">
    	    <font color="gray">��ҳ  ��һҳ</font>
    	</c:if>
    	<c:if test="${pageData.currPage ne 1}">
	    	<a href='admin/topic?method=topicList&currPage=1'>��ҳ</a>
	    	<a href='admin/topic?method=topicList&currPage=${pageData.currPage-1}'>&nbsp;&nbsp;��һҳ</a>
    	</c:if>
    	<c:if test="${pageData.currPage eq pageData.sumPages}">
    	    <font color="gray">��һҳ  ĩҳ</font>
    	</c:if>
    	<c:if test="${pageData.currPage ne pageData.sumPages}">
	    	<a href='admin/topic?method=topicList&currPage=${pageData.currPage+1}'>&nbsp;&nbsp;��һҳ</a> 
	    	<a href='admin/topic?method=topicList&currPage=${pageData.sumPages}'>&nbsp;&nbsp;ĩҳ</a>
    	</c:if>
     </p>
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
