<%@ page language="java" import="java.util.*,com.java.entity.*,com.java.dao.*" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	 NewsDao newsDao=new NewsDao();
	 List<NewsInfo> newsList=newsDao.queryNewsInfo();
	 request.setAttribute("newsList",newsList);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>�����й�</title>
<link href="CSS/main.css" rel="stylesheet" type="text/css" />
<script language="javascript">
	function logon(){
		var result=confirm("��ȷ�������û���������?");
		if(result){
			document.loginform.isSaveCookie.value="1";
		}else{
			document.loginform.isSaveCookie.value="0";
		}
	}
	
	function refreshImage(obj){
		obj.src="image?"+Math.random();
	
	}
	
</script>
</head>
<body>
<div id="header">
  <div id="top_login">

  	<c:if test="${empty sessionScope.u}" >
	  		<form name="loginform" method="post" action="user?method=logOn">
		  	<input type="hidden" name="isSaveCookie" value="" />
		    <label> ��¼�� </label>
		    <input type="text" name="username" value="${requestScope.cookie.username.value}" class="login_input" />
		    <label> ��&#160;&#160;�� </label>
		    <input type="password" name="password" value="${requestScope.cookie.password.value}" class="login_input" />
		    <label> ��֤�� </label>
		    <input type="text" name="vcode" value="" class="login_input" />
		    <img src="image" width="80" height="24" onclick="refreshImage(this)" alt="���ˢ��" style="cursor:hand;" />
		    <input type="submit" class="login_sub" value="��¼" onclick="logon()"/>
		    <label id="error" style="color:red">${requestScope.error } </label>
		    <img src="Images/friend_logo.gif" alt="Google" id="friend_logo" /> 
		    </form>
	</c:if>
	<c:if test="${not empty sessionScope.u}" >
	  		��ӭ��,<font color="red">${sessionScope.u.userName}</font>
	  				<a href="admin/news?method=newsList">�����̨��������</a>	
  	</c:if>
  	����վ�ĵ�½����Ϊ:<font color="red">${applicationScope.count}</font>
  
  	
    </div>
  <div id="nav">
    <div id="logo"> <img src="Images/logo.jpg" alt="�����й�" /> </div>
    <div id="a_b01"> <img src="Images/a_b01.gif" alt="" /> </div>
    <!--mainnav end-->
  </div>
</div>
<div id="container">
  <div class="sidebar">
    <p> <img src="Images/title_1.gif" alt="��������" /> </p>
    <div class="side_list">
      <ul>
        <li> <a href='#'><b> ������ڸ�����ǿ��ͥ�����Դ��໥ì�� </b></a> </li>
        <li> <a href='#'><b> ����ί��4����Ͷ�ʼƻ����ἷռ���Ͷ�ʿռ� </b></a> </li>
        <li> <a href='#'><b> ����2��������������������ȫһ������ע </b></a> </li>
      </ul>
    </div>
    <h1> <img src="Images/title_2.gif" alt="��������" /> </h1>
    <div class="side_list">
      <ul>
        <li> <a href='#'><b> �ձ������ɽ�״�ȫ������������⽻���� </b></a> </li>
        <li> <a href='#'><b> �������ɫ���ٴν������ڵ� </b></a> </li>
        <li> <a href='#'><b> ���ʽ���30��ǰ�ͺ�ȼ�Ϲ�Ӧ���������� </b></a> </li>
        <li> <a href='#'><b> ������й���֯���ƶ԰͸��������ը���� </b></a> </li>
      </ul>
    </div>
    <h1> <img src="Images/title_3.gif" alt="��������" /> </h1>
    <div class="side_list">
      <ul>
        <li> <a href='#'><b> ʩ����������Ӱ��ҵ��Ǩ�ƻ� �ƽ����ݾ��ø��� </b></a> </li>
        <li> <a href='#'><b> ���׺������ݻ�Ӧ�������� �����ܳ�Խ�������� </b></a> </li>
        <li> <a href='#'><b> �������ߺš�������Ƭ���� ����ɭ�ȳ�ϯ </b></a> </li>
        <li> <a href='#'><b> ���Ĵ��������ػ����� �������Ϸ���Ľ� </b></a> </li>
      </ul>
    </div>
  </div>
  <div class="main">
    <div class="class_type"> <img src="Images/class_type.gif" alt="��������" /> </div>
    <div class="content">
      <ul class="class_date">
        <li id='class_month'> <a href='#'><b> ���� </b></a> <a href='#'><b> ���� </b></a> <a href='#'><b> ���� </b></a> <a href='#'><b> ���� </b></a> <a href='#'><b> ���� </b></a> <a href='#'><b> ��� </b></a> <a href='#'><b> �ƾ� </b></a> <a href='#'><b> �Ƽ� </b></a> <a href='#'><b> ���� </b></a> <a href='#'><b> ���� </b></a> <a href='#'><b> ���� </b></a> </li>
        <li id='class_month'> <a href='#'><b> ���� </b></a> <a href='#'><b> �Ҿ� </b></a> <a href='#'><b> ���� </b></a> <a href='#'><b> �Ļ� </b></a> <a href='#'><b> ���� </b></a> </li>
      </ul>
      <ul class="classlist">
      <li><a href='newspages/news_read.html'> ��������飺˵�������������� ��㻦������֧�� </a><span> 2009-10-28 01:03:51.0 </span></li>
      <c:forEach var="newsInfo" items="${requestScope.newsList }">
        <li><a href='admin/news?method=readNews&newsId=${newsInfo.newsId }'>${newsInfo.newsTitle }  </a><span> ${newsInfo.newsDate } </span></li>
   	  </c:forEach>
        <li><a href='#'> ʡ����500�����ͽ�ҵ�Ƕ� ��Ա:�ź��������ܹ��� </a><span> 2009-10-28 01:03:19.0 </span></li>
        <li><a href='#'> ��Ԫ˶�������˵����Ϳ������� ���һ���¿��Ű� </a><span> 2009-10-28 01:02:56.0 </span></li>
        <li><a href='#'> �ٽ�ھ����Ƕ�Ʊ�ܶ�Ա ����:���!�������˱��� </a><span> 2009-10-28 01:02:17.0 </span></li>
        <li><a href='#'> һֽ���氵���껨����̬�� ������������ͻ������ </a><span> 2009-10-28 01:01:47.0 </span></li>
        <li class='space'></li>
        <li><a href='#'> ����仯���º�ƽ������ </a><span> 2009-10-28 01:00:37.0 </span></li>
        <li><a href='#'> ��ó��ί���ں��ݿ��� ������ó������̬�ȵ͵� </a><span> 2009-10-28 01:00:11.0 </span></li>
        <li><a href='#'> �ٸ��֣���ʮ���塱�ĸ�Ӧ�����Ѵ��ת�� </a><span> 2009-10-28 12:59:45.0 </span></li>
        <li><a href='#'> ���ʳƷ�����Ԫ��Ϊ�ⴢ��λ ����һ���λ </a><span> 2009-10-28 12:58:42.0 </span></li>
        <li><a href='#'> ����е���٣��������С� �㽭�����ֳ����˱��� </a><span> 2009-10-28 12:58:20.0 </span></li>
        <li class='space'></li>
        <li><a href='#'> ���ڳ�Ʒ�ͼ۸��ϵ����ɶ��� </a><span> 2009-10-28 12:57:18.0 </span></li>
        <li><a href='#'> ���������׶�԰��ѧУ������ͣ�� </a><span> 2009-10-28 12:56:51.0 </span></li>
        <li><a href='#'> �����������Ĵ�����ը��ǹ�� Ŀǰԭ���� </a><span> 2009-10-28 12:56:24.0 </span></li>
        <li><a href='#'> ��̨����ܴ�½��У�Ӵ��̨����������� </a><span> 2009-10-28 12:55:07.0 </span></li>
        <li><a href='#'> ��̨�콫��Ȩ��������ʡ�в��ָ�̨��������Ȩ </a><span> 2009-10-28 12:54:12.0 </span></li>
        <li class='space'></li>
        <li><a href='#'> �˱������״ξ�ͬ��ͬ�������涨 </a><span> 2009-10-28 11:00:45.0 </span></li>
        <li><a href='#'> ���쾯�����ϱ�ΧŹ������������������� </a><span> 2009-10-28 11:00:25.0 </span></li>
        <li><a href='#'> ����һ���⽻�ٴ�ְ�������԰��������� </a><span> 2009-10-28 11:00:02.0 </span></li>
        <li><a href='#'> ������ͨ��������18������ײ�¹ʴ�ְ </a><span> 2009-10-28 10:59:38.0 </span></li>
        <li><a href='#'> ��Ҧʱ����ι�ע���߱�ƴ �������з�PK�������� </a><span> 2009-10-28 10:59:07.0 </span></li>
        <li class='space'></li>
        <li><a href='#'> �����Ļս���Խ�ʯ���ײ��� ���λ��ѡһ������ </a><span> 2009-10-28 10:58:36.0 </span></li>
        <li><a href='#'> ʱ����Ǩ������Ʊ����� �Կ�˫����˧ֻһ�ƿ�ʩ </a><span> 2009-10-28 10:58:11.0 </span></li>
        <li><a href='#'> ��Ҧ��������į��Ȼ���� ����һ�ָı������Ŀ�ʼ </a><span> 2009-10-28 10:57:49.0 </span></li>
        <li><a href='#'> ��ý���С���˻���º��� һ��ȱ���˧�ܵ��� </a><span> 2009-10-28 10:57:11.0 </span></li>
        <li><a href='#'> Ƥ�س���֮����Ȼ���� ���ɸļ����ֳ�(ͼ) </a><span> 2009-10-28 10:56:43.0 </span></li>
        <li class='space'></li>
        <li><a href='#'> 8������ʿ���ڰ�������·��ը��Ϯ������ </a><span> 2009-10-28 10:55:38.0 </span></li>
        <li><a href='#'> ������й���֯���ƶ԰͸��������ը���� </a><span> 2009-10-28 10:55:14.0 </span></li>
        <li><a href='#'> ���ʽ���30��ǰ�ͺ�ȼ�Ϲ�Ӧ���������� </a><span> 2009-10-28 10:54:54.0 </span></li>
      </ul>
      <p align="right"> ��ǰҳ��:[1/2]&nbsp; <a href="#">��һҳ</a> <a href="#">ĩҳ</a> </p>
    </div>
    <div class="picnews">
      <ul>
        <li> <a href="#"><img src="Images/Picture1.jpg" width="249" alt="" /> </a><a href="#">�����д�Խʱ��</a> </li>
        <li> <a href="#"><img src="Images/Picture2.jpg" width="249" alt="" /> </a><a href="#">������ķ���</a> </li>
        <li> <a href="#"><img src="Images/Picture3.jpg" width="249" alt="" /> </a><a href="#">�¼�����������</a> </li>
        <li> <a href="#"><img src="Images/Picture4.jpg" width="249" alt="" /> </a><a href="#">Ⱥ����ҫ���̺</a> </li>
      </ul>
    </div>
  </div>
</div>
<div id="friend">
  <h1 class="friend_t"> <img src="Images/friend_ico.gif" alt="�������" /> </h1>
  <div class="friend_list">
    <ul>
      <li> <a href="#">�й�������</a> </li>
      <li> <a href="#">�й�������</a> </li>
      <li> <a href="#">�й�������</a> </li>
      <li> <a href="#">�й�������</a> </li>
      <li> <a href="#">�й�������</a> </li>
      <li> <a href="#">�й�������</a> </li>
      <li> <a href="#">�й�������</a> </li>
    </ul>
  </div>
</div>
<div id="footer">
  <p class=""> 24Сʱ�ͻ��������ߣ�010-68988888 &#160;&#160;&#160;&#160; <a href="#">����������</a> &#160;&#160;&#160;&#160; �������ߣ�010-627488888 <br />
    �����������������ٱ��绰��010-627488888 &#160;&#160;&#160;&#160; �ٱ����䣺 <a href="#">jubao@wh-os.com.cn</a> </p>
  <p class="copyright"> Copyright &copy; 1999-2009 News China gov, All Right Reserver <br />
    �����й� ��Ȩ���� </p>
</div>
</body>
</html>
