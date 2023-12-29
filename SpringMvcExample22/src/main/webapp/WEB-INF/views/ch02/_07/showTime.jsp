<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*, java.text.*" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>    
<!DOCTYPE HTML>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />"  type='text/css' />
<meta charset="UTF-8">
<title>顯示當地時間</title>
</head>
<body>
<div align="center">
 <p/>
${now}<br>
<hr>
本範例的重點為控制器方法傳回值的型態為ModelAndView<br>

<p/>
<small>&lt;&lt;<a href='<c:url value="${header.referer}"/>'>回前頁</a>&gt;&gt;</small>
</div>
</body>
</html>
<!--      ch01\hello.jsp    -->