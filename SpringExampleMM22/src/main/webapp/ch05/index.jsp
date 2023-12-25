<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />"  type="text/css" />
<meta charset="UTF-8">
<title>Spring 對 Web Application的支援</title>
</head>
<body>
<table border='1'  style="background-color:#A8FF55; width:100%; height:20px">
	<tr>
		<td align="CENTER" >
			<h2><FONT face="Verdana" >Spring 對 Web Application 的支援</FONT></h2>
		</td>
	</tr>
</table>
<br>
<div align="center">

<table border="1">
   <tr height="70" bgcolor="lightblue" align="center">
    <td  width="350">
      <a href="<c:url value='/ch05/ex01/registerMember.jsp' />">新增會員資料(In Memory)</a><br>
      <font face="verdana" size="-1">
      webapp/ch05/ex01/*.jsp ch05.ex01.*.java
      </font>
    </td>
    <td  width="350">
      <a href="<c:url value='/ch05/ex02/queryAllMembers.do' />">查詢會員資料(In Memory)</a><br>
      <font face="verdana" size="-1">
      webapp/ch05/ex02/*.jsp, ch05.ex02.*.java
      </font>
    </td>
  </tr>
</table>

<hr>
<small>&lt;&lt;<a href="<c:url value='/index.jsp' />">回首頁</a>&gt;&gt;</small>
</div>
</body>
</html>