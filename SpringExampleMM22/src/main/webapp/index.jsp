<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href="<c:url value='/css/styles.css' />"  type="text/css" />
<title>Spring 對Web Application的支援</title>
</head>
<body>
<div align="center">
<h1>Spring、Hibernate與Web的整合</h1>
<a href="<c:url value='/ch05/index.jsp' />">第五章、Spring 對 Web Application 的支援</a><br><p/>
<a href="<c:url value='/ch06/index.jsp' />">第六章、Spring + Hibernate對 Web Application 的支援</a><br><p/>
<p/>
<hr>
<font color='darkgreen' size='-1' >Category / ProductEntity initDataS.do<br></font>
<font size='-3'>${globalService.dbType}</font>
</div>
</body>
</html>