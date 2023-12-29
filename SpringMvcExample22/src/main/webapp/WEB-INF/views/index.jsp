<%@ page contentType="text/html; charset=UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html> 
<head>   
<link rel='stylesheet' href="<c:url value='/css/styles.css' />"  type='text/css' />
<title>JSP 範例</title>   
</head>
<body>
<c:import url="commons/header.jsp" />	
<div style="margin-left:auto; margin-right:auto; width: 600 px;">
<ul>
  <li><a href="<c:url value='/ch01/index' />" >一、Spring MVC程式基本架構</a></li>
  <li><a href="<c:url value='/ch02/index' />" >二、處理請求與產生回應</a></li>
  <li><a href="<c:url value='/ch03/index' />" >三、Session</a> </li>
  <li><a href="<c:url value='/ch04/index' />" >四、Session應用：購物車</a> </li>
</ul>
</div>
</body>
</html>