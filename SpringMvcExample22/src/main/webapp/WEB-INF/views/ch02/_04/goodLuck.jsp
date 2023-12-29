<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />"  type='text/css' />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>報明牌</title>
</head>
<body style="background-color: #e1efbb; font-family: verdana; font-size: 15pt;">
<div align='center'>

<h2>卜籤求明牌</h2>   
${visitName}，您好，<br>  
您的明牌為：${luckyNumber}
<p>
<hr>
<h3>${replyMessage}</h3>
<hr>
<p>
<small>&lt;&lt;<a href='<c:url value="${header.referer}"/>'>回前頁</a>&gt;&gt;</small>
<small>&lt;&lt;<a href='<c:url value="/ch02/index"/>'>回第二章首頁</a>&gt;&gt;</small>
</div>  
</body>
</html>