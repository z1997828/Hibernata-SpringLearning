<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>    
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />"  type='text/css' />
<meta charset="UTF-8">
<title>第三頁商品資料</title>
</head>
<body>
<div align='center'>
	<h2>第三頁商品資料</h2>  
	會員: <font color='red'>${memberBean.name}</font>
	<hr>
		<table border='1'>
			<tr>
				<td width='100' align='center'><a href="<c:url value='/ch04/index'/>">第一頁</a></td>
				<td width='100' align='center'><a href="<c:url value='/ch04/secondPage'/>">第二頁</a></td>
				<td width='100' align='center'><a href="<c:url value='/ch04/thirdPage'/>">第三頁</a></td>
				<td width='100' align='center'><a href="<c:url value='/ch04/fourthPage'/>">第四頁</a></td>
				<td width='136' align='center'><a href="<c:url value='/ch04/showCartContent'/>">查看購物明細</a></td>
				<td width='180' align='center'>移除購物車 <a href="<c:url value='/ch04/removeCartOK'/>">OK</a>&nbsp;&nbsp;
				<a href="<c:url value='/ch04/removeCartNG'/>">NG</a></td>
			</tr>
			<tr>
				<td colspan='2' width='260' align='center'>${ShoppingCart.creteTime}</td>
				<td colspan='2'  width='260' align='center'>${requestScope.ShoppingCart.creteTime}</td>
				<td colspan='2'  width='260' align='center'>${sessionScope.ShoppingCart.creteTime}</td>
			</tr>
		</table>

		<hr>
			<form action='addToCart' method='POST'>
				<input type='hidden'  name='bookId' value='3'> 
				<input type='hidden'  name='page' value='thirdPage'>
			   <table border='1'>
			   <tr height='36'>
					<td width='100' align='right'>書名：</td>
					<td width='320' align='left'>深入淺出網站設計</td>
			   	</tr>
			   <tr height='36'>
			   		<td width='100' align='right'>作者：</td>
			   		<td width='260' align='left'>莊惠淳</td>
			   </tr>
			    <tr height='36'>
			   		<td width='100' align='right'>單價：</td>
			   		<td width='260' align='left'>880</td>
			   </tr> 	   
			   <tr height='36'>
			   		<td width='100' align='right'>數量：</td>
			   		<td width='260' align='left'>
			   			<input type='text' size='1' name='qty' value='1'>
			   		</td>
			   </tr>
			   <tr height='36'>
			   		<td colspan='2' align='center'><input type='submit'></td>
				</tr>			   		
				</table>
			</form>
		<hr>
		<small>&lt;&lt;<a href='<c:url value="/"/>'>回首頁</a>&gt;&gt;</small><br>
	</div>

</body>
</html>