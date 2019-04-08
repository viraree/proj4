<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>


<%@page import="tggroup.SendEmail2"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>菜鸟教程(runoob.com)</title>
</head>
<body>
<h1>使用 POST 方法读取数据</h1>
<ul>
<li><p><b>站点名:</b>
<%
// 解决中文乱码的问题
String name = new String((request.getParameter("name")).getBytes("ISO-8859-1"),"UTF-8");
String url = new String((request.getParameter("url")).getBytes("ISO-8859-1"),"UTF-8");


int number = 1;
String text="我爱你";
int res=-1;
String sentTo="站长QQ号码@qq.com";

       
	   SendEmail2 mailer=new SendEmail2();
	   String subject="我爱你";
	 
	   
	 
	   
	   subject=name;
	   text=url;
	  res= mailer.send(subject, text);
	  
	  if(res==-1)
	  {
		  
		  text="服务器错误：邮件发送失败";
	  }

%>

   <%=(text+","+name)%>
</p></li>
<li><p><b>网址:</b>
   <%=url%>
</p></li>

<li><p><b>发送站长:</b>
  <%=sentTo%>,  <%=res%> 
</ul>
</body>
</html>