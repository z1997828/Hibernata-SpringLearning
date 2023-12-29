<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC Example</title>
</head>
<body>
	<h1 style="text-align: center">MVC Exercise</h1>
	<hr>
	<table border="1" style="margin: 0px auto;">
		<tr height="52" bgcolor="lightblue" align="center">
			<td width="350"><p align="left" /> 
				<a href="<c:url value='/welcome' />">Hello, Spring MVC</a><BR>
			</td>
			<td width="350"><p align="left"/>
                <a href="<c:url value='/products' />">查詢產品資料</a><BR>
            </td>
		</tr>

		<tr height="52" bgcolor="lightblue" align="center">
			<td width="350"><p align="left" /> 
				<a href="<c:url value='/products' />">查詢所有產品資料</a><BR>
			</td>
			<td width="350"><p align="left" /> 
				<a href="<c:url value='/update/stock' />">更新多筆產品的庫存數量</a><BR>
			</td> 
		</tr>
		
		<tr height="52" bgcolor="lightblue" align="center">
			<td width="350"><p align="left" /> 
				<a href="<c:url value='/queryByCategory' />">分類查詢</a><BR>
			</td>
			<td width="350"><p align="left" /> 
				<a href=''></a><BR></td>
		</tr>
	</table>
	
</body>
</html>
