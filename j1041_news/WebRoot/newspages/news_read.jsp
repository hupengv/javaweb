<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
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
<title>�����й�</title>
<link href="CSS/read.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	  		function check(){
	  			var cauthor = document.getElementById("cauthor");
	  			var content = document.getElementById("ccontent");
	  			if(cauthor.value == ""){
	  				alert("�û�������Ϊ�գ���");
	  				return false;
	  			}else if(content.value == ""){
	  				alert("�������ݲ���Ϊ�գ���");
	  				return false;
	  			}
	  			return true;
	  		}
	  	</script>
</head>
<body>
<form action="#" method="post" onsubmit="return check()">
<div id="header">
  <div id="top_login">
  
    <label> ��¼�� </label>
    <input type="text" id="uname" value="" class="login_input" />
    <label> ��&#160;&#160;�� </label>
    <input type="password" id="upwd" value="" class="login_input" />
    <input type="button" class="login_sub" value="��¼" onclick="login()"/>
    <label id="error"> </label>
    <a href="index.html" class="login_link">������ҳ</a> <img src="Images/friend_logo.gif" alt="Google" id="friend_logo" /> </div>
  <div id="nav">
    <div id="logo"> <img src="Images/logo.jpg" alt="�����й�" /> </div>
    <div id="a_b01"> <img src="Images/a_b01.gif" alt="" /> </div>
    <!--mainnav end-->
  </div>
</div>
<div id="container">
  <div class="sidebar">
    <h1> <img src="Images/title_1.gif" alt="��������" /> </h1>
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
      <ul class="classlist">
        <table width="80%" align="center">
          <tr >
            <td colspan="2" align="center">${newsInfo.newsTitle }</td>
          </tr>
          <tr>
            <td colspan="2"><hr />
            </td>
          </tr>
          <tr>
            <td align="center">${newsInfo.newsDate }</td>
            <td align="left">${newsInfo.newsAut} </td>
          </tr>
          <tr>
            <td colspan="2" align="center"></td>
          </tr>
          <tr>
            <td colspan="2"> ${newsInfo.newsCon}�� </td>
          </tr>
          <tr>
            <td colspan="2"><hr />
            </td>
          </tr>
        </table>
      </ul>
      <ul class="classlist">
        <table width="80%" align="center">
          <tr>
          <td colspan="6"> �������ۣ� </td>
          </tr>
          <tr>
            <td colspan="6"><hr />
            </td>
          </tr>
        </table>
      </ul>
      <ul class="classlist">
        
          <table width="80%" align="center">
            <tr>
              <td> �� �� </td>
            </tr>
            <tr>
              <td> �û�����${sessionScope.u}== null ?"��һ����ʲôҲû����": ${sessionScope.u}</td>
              <td><input id="cauthor" name="cauthor" value="��һ����ʲôҲû����"/>
                IP��
                <input name="cip" value="127.0.0.1"
											readonly="readonly"/>
              </td>
            </tr>
            <tr>
              <td colspan="2"><textarea name="ccontent" cols="70" rows="10"></textarea>
              </td>
            </tr>
            <tr>
            <td><input name="submit" value="��  ��" type="submit"/>
              </td>
              </tr>
          </table>
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
</form>
</body>
</html>
