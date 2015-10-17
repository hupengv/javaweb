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
<title>添加主题--管理后台</title>
<link href="CSS/admin.css" rel="stylesheet" type="text/css" />
<script language="javascript">
	function clickdel(){
		return confirm("删除请点击确认");
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
    	 <li> ${newsInfo.newsTitle } <span> 作者：${newsInfo.newsAut }                                             
        &#160;&#160;&#160;&#160; <a href='admin/news?method=gotonewsModify&newsId=${newsInfo.newsId }'>修改</a> 
        &#160;&#160;&#160;&#160; <a href='admin/news?method=newsDelete&newsId=${newsInfo.newsId }' onclick='return clickdel()'>删除</a> 
        </span><font color="red">${requestScope.error }</font> </li>
    </c:forEach>
      <li> 深足教练组：说我们买球是侮辱 朱广沪常暗中支招 <span> 作者：
        sport                                             
        &#160;&#160;&#160;&#160; <a href='news_modify.html'>修改</a> &#160;&#160;&#160;&#160; <a href='#' onclick='return clickdel()'>删除</a> </span> </li>
      <li> 省政府500万悬赏建业登顶 球员:遗憾主场放跑国安 <span> 作者：
        sport                                             
        &#160;&#160;&#160;&#160; <a href='news_modify.html'>修改</a> &#160;&#160;&#160;&#160; <a href='#' onclick='return clickdel()'>删除</a> </span> </li>
      <li> 洪元硕：北京人的脸就看你们了 最后一哆嗦看着办 <span> 作者：
        sport                                             
        &#160;&#160;&#160;&#160; <a href='news_modify.html'>修改</a> &#160;&#160;&#160;&#160; <a href='#' onclick='return clickdel()'>删除</a> </span> </li>
      <li> 临界冠军京城夺票总动员 球迷:夺冠!让所有人闭嘴 <span> 作者：
        sport                                             
        &#160;&#160;&#160;&#160; <a href='news_modify.html'>修改</a> &#160;&#160;&#160;&#160; <a href='#' onclick='return clickdel()'>删除</a> </span> </li>
      <li> 一纸传真暗含申花处理态度 国足征调杜威突生悬疑 <span> 作者：
        sport                                             
        &#160;&#160;&#160;&#160; <a href='news_modify.html'>修改</a> &#160;&#160;&#160;&#160; <a href='#' onclick='return clickdel()'>删除</a> </span> </li>
      <li class='space'></li>
      <li> 气候变化导致海平面上升 <span> 作者：news
        
        &#160;&#160;&#160;&#160; <a href='news_modify.html'>修改</a> &#160;&#160;&#160;&#160; <a href='#' onclick='return clickdel()'>删除</a> </span> </li>
      <li> 商贸联委会在杭州开会 中美对贸易争端态度低调 <span> 作者：news                                              
        &#160;&#160;&#160;&#160; <a href='news_modify.html'>修改</a> &#160;&#160;&#160;&#160; <a href='#' onclick='return clickdel()'>删除</a> </span> </li>
      <li> 迟福林：“十二五”改革应向消费大国转型 <span> 作者：
        news                                              
        &#160;&#160;&#160;&#160; <a href='news_modify.html'>修改</a> &#160;&#160;&#160;&#160; <a href='#' onclick='return clickdel()'>删除</a> </span> </li>
      <li> 伊朗称放弃美元作为外储地位 人民币或上位 <span> 作者：
        out                                               
        &#160;&#160;&#160;&#160; <a href='news_modify.html'>修改</a> &#160;&#160;&#160;&#160; <a href='#' onclick='return clickdel()'>删除</a> </span> </li>
      <li> “持械抢劫，当场击毙” 浙江永康现超雷人标语 <span> 作者：
        news                                              
        &#160;&#160;&#160;&#160; <a href='news_modify.html'>修改</a> &#160;&#160;&#160;&#160; <a href='#' onclick='return clickdel()'>删除</a> </span> </li>
      <li class='space'>to</li>
      <li> 国内成品油价格上调几成定局 <span> 作者：
        news                                              
        &#160;&#160;&#160;&#160; <a href='news_modify.html'>修改</a> &#160;&#160;&#160;&#160; <a href='#' onclick='return clickdel()'>删除</a> </span> </li>
      <li> 俄数百所幼儿园和学校因流感停课 <span> 作者：
        news                                              
        &#160;&#160;&#160;&#160; <a href='news_modify.html'>修改</a> &#160;&#160;&#160;&#160; <a href='#' onclick='return clickdel()'>删除</a> </span> </li>
      <li> 喀布尔市中心传出爆炸和枪声 目前原因不明 <span> 作者：
        out                                               
        &#160;&#160;&#160;&#160; <a href='news_modify.html'>修改</a> &#160;&#160;&#160;&#160; <a href='#' onclick='return clickdel()'>删除</a> </span> </li>
      <li> 国台办介绍大陆高校加大对台招生力度情况 <span> 作者：
        news                                              
        &#160;&#160;&#160;&#160; <a href='news_modify.html'>修改</a> &#160;&#160;&#160;&#160; <a href='#' onclick='return clickdel()'>删除</a> </span> </li>
      <li> 国台办将授权福建等六省市部分赴台管理审批权 <span> 作者：
        news                                              
        &#160;&#160;&#160;&#160; <a href='news_modify.html'>修改</a> &#160;&#160;&#160;&#160; <a href='#' onclick='return clickdel()'>删除</a> </span> </li>
      <li class='space'>r</li>
    </ul>
     <p align="right"> 当前页数:[1/3]&nbsp; <a href="#">下一页</a> <a href="#">末页</a> </p>
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
