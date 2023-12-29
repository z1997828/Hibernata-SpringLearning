<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c' %>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />"  type='text/css' />
<meta charset="UTF-8">
<title>第一頁</title>
</head>
<body>
<div align='center'>
<h2>本頁為第一頁</h2>
<small>&lt;&lt;<a href='<c:url value="/"/>'>回首頁</a>&gt;&gt;</small><br>
<p/>
<table border='1'>
  	<tr>    
  		<td width='100' align='center'><a href="<c:url value='/ch03/index'/>">第一頁</a></td>
  		<td width='100' align='center'><a href="<c:url value='/ch03/secondPage'/>">第二頁</a></td>
  		<td width='100' align='center'><a href="<c:url value='/ch03/thirdPage'/>">第三頁</a></td>
  	</tr>
  </table>
<hr>
<a href='inspectSession'>查看Session物件的內容，然後轉向第三頁</a><br>
在Ch03Controller1類別內的控制器方法取得的Cat物件：${indexPageCat}
<hr>
<%--
  out.println("----------------執行index.jsp時，位於HttpSession中的屬性物件----------------<br>");
  java.util.Enumeration<String> sessEnum = session.getAttributeNames();
--%>  
<!--   <table border='1'> -->
<!--   <tr><th>Key</th><th>Value</th></tr> -->
<%--  
  while (sessEnum.hasMoreElements()) {
	String s = sessEnum.nextElement();
	out.println("<tr><td>" + s + "</td><td>" + session.getAttribute(s) + "</td></tr>");
  }
--%>
<!-- </table> -->
</div>
</body>
</html>