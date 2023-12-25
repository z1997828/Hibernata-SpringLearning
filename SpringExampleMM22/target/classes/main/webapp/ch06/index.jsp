<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />"  type="text/css" />
<title>MVC架構</title>
</head>
<body BGCOLOR="white">
<table border='1'  style="background-color:#A8FF55; width:100%; height:20px">
	<tr>
		<td align="CENTER" >
			<h2><FONT face="Verdana" >Spring + Hibernate 對 Web Application 的支援</FONT></h2>
		</td>
	</tr>
</table>
<br>
<div align="center">
<table border="1">
  <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
       <a href="<c:url value='/ch06/ex01/registerMember.jsp' />">
          新增會員資料(Hibernate+Spring)
       </a><br>
      <font face="verdana" size="-2">
      webapp/ch06/ex01/*.jsp
      ch06.ex01.*.java
      </font>
    </td>
    <td  width="350"><p align="left">
      <a href="<c:url value='/ch06/ex02/queryAllMembers.do' />">查詢會員資料(Hibernate+Spring)</a><br>
      <font face="verdana" size="-2" color='red'>
      </font>
      <font face="verdana" size="-2">
      webapp/ch06/ex02/*.jsp, ch06.ex02.*.java
      </font>
    </td>
  </tr>
  <!-- ================================ -->
  <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
       <a href="<c:url value='/ch06_sll/ex01/queryAllCategoriesS.do' />">
          延遲載入(Spring 解決方案)
       </a><br>
      <font face="verdana" size="-2">
      webapp/ch06_sll/ex01/*.jsp
      ch06_sll.ex01.*.java
      </font>
    </td>
    <td  width="350"><p align="left">
      <a href="<c:url value='/ch06_sll/ex02/queryAllCategoriesH.do' />">延遲載入(Hibernate 解決方案)</a><br>
      <font face="verdana" size="-2" color='red'>
      </font>
      <font face="verdana" size="-2">
      webapp/ch06_sll/ex02/*.jsp, ch06_sll.ex02.*.java
      </font>
    </td>
  </tr>
</table>
<font color='red'>${InitSuccess}</font>
</div>
<hr>
<div class='center'>
<br>
<small>&lt;&lt;<a href="<c:url value='/index.jsp' />">回首頁</a>&gt;&gt;</small>
</div>
</body>
</html>
