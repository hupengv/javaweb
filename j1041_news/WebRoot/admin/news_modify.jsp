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
<title>修改新闻--管理后台</title>
<link href="CSS/admin.css" rel="stylesheet" type="text/css" />

</head>
<body>
<%@include file="top.jsp"  %>
<div id="main">
<%@include file="left.jsp" %>
  <div id="opt_area">
    <h1 id="opt_type"> 修改新闻： </h1>
    <form action="admin/news?method=newsModify" method="post" onsubmit="return check()">
      <p>
        <label> 主题 </label>   
        <input name="typeName" value="${requestScope.typeName }" readonly="readonly"/>
      </p>
      <p>
        <label> 标题 </label>
       <input name="title" type="text" class="opt_input" value="${requestScope.title }" />
      </p>
      <p>
        <label> 作者 </label>
        <input name="author" type="text" class="opt_input" value="${requestScope.author }" />
      </p>
      <p>
        <label> 摘要 </label>
        <textarea name="summary" cols="40" rows="3" >${requestScope.summary }</textarea>
      </p>
      <p>
        <label> 内容 </label>
        <textarea name="content" cols="70" rows="10" >${requestScope.content }</textarea>
      </p>
      <p>
        <label> 上传图片 </label>
        <input name="file" type="file" class="opt_input" />
      </p>
      <input type="submit" value="提交" class="opt_sub" />
      <input type="reset" value="重置" class="opt_sub" />
    </form>
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
