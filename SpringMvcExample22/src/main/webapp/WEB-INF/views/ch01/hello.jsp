<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*, java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c' %>
    
<!DOCTYPE HTML>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />"  type='text/css' />

<meta charset="UTF-8">
<title>Hello, World! 大家好(Spring MVC版)</title>
</head>
<body> 
<div align='center'>
<H3>Hello, World! 大家好(Spring MVC版)</H3>
<p/>
<font style="font-size:16px;">
本回應由 /WEB-INF/views/ch01/hello.jsp送出<br>
</font>
<br>
<hr>
<small>&lt;&lt;<a href="<c:url value='/ch01/index' />">回第一章首頁</a>&gt;&gt;</small>
</div>
</body>
</html>
<!--      ch01\hello.jsp    -->