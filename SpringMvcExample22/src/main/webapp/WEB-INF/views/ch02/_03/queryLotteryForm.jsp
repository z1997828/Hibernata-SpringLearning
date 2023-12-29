<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />"  type='text/css' />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查詢明牌</title>
</head>
<body>
<div align='center'>
<h2>查詢明牌</h2>
<h3>@RequestParam</h3>
程式將隨機產生${ball}個介於 ${lower} 與 ${upper} 的整數亂數<br>
<hr>
<Form action="<c:url value='queryLottery' />" method="POST">
    訪客姓名:<input type="text" name="visitor" size = "10"><P/>
    
  <input type='hidden' name='lower'  value='${lower}' >
  <input type='hidden' name='upper'  value='${upper}' >
  <input type='hidden' name='ball'  value='${ball}' >
  <input type="submit" value="確定"><P/>
</Form>
<p/>
<small>&lt;&lt;<a href='<c:url value="/ch02/index"/>'>回第二章首頁</a>&gt;&gt;</small>
</div>
</body>
</html>