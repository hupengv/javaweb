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
<title>主题列表--管理后台</title>
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
    		&#160;&#160;&#160;&#160; <a href='admin/topic?method=gotoModify&id=${newsType.typeId }'>修改</a> 
    		&#160;&#160;&#160;&#160; <a href='admin/topic?method=topicDel&id=${newsType.typeId }'  onclick='return confirm("是否删除?")'>删除</a> 
    		</li>
   		</c:forEach>
    </ul>
    <p align="right"> 
	          当前页数:[${pageData.currPage }/${pageData.sumPages }]&nbsp;&nbsp; 
	          每页<input type="text" name="pageSize" style="width:15px;text-align:center;" onblur="chageSize(this)" value="${pageData.pageSize}"/>条记录
	    <c:if test="${pageData.currPage eq 1}">
    	    <font color="gray">首页  上一页</font>
    	</c:if>
    	<c:if test="${pageData.currPage ne 1}">
	    	<a href='admin/topic?method=topicList&currPage=1'>首页</a>
	    	<a href='admin/topic?method=topicList&currPage=${pageData.currPage-1}'>&nbsp;&nbsp;上一页</a>
    	</c:if>
    	<c:if test="${pageData.currPage eq pageData.sumPages}">
    	    <font color="gray">下一页  末页</font>
    	</c:if>
    	<c:if test="${pageData.currPage ne pageData.sumPages}">
	    	<a href='admin/topic?method=topicList&currPage=${pageData.currPage+1}'>&nbsp;&nbsp;下一页</a> 
	    	<a href='admin/topic?method=topicList&currPage=${pageData.sumPages}'>&nbsp;&nbsp;末页</a>
    	</c:if>
     </p>
  </div>
</div>
<div id="site_link"> <a href="#">关于我们</a><span>|</span> <a href="#">Aboue Us</a><span>|</span> <a href="#">联系我们</a><span>|</span> <a href="#">广告服务</a><span>|</span> <a href="#">供稿服务</a><span>|</span> <a href="#">法律声明</a><span>|</span> <a href="#">招聘信息</a><span>|</span> <a href="#">网站地图</a><span>|</span> <a href="#">留言反馈</a> </div>
<div id="footer">
  <p class="">24小时客户服务热线：010-68988888  &#160;&#160;&#160;&#160; <a href="#">常见问题解答</a> &#160;&#160;&#160;&#160;  新闻热线：010-627488888<br />
    文明办网文明上网举报电话：010-627488888  &#160;&#160;&#160;&#160;  举报邮箱：<a href="#">jubao@wh-os.com.cn</a></p>
  <p class="copyright">Copyright &copy; 1999-2009 News China gov, All Right Reserver<br />
    新闻中国   版权所有</p>
</div>
</body>
</html>
