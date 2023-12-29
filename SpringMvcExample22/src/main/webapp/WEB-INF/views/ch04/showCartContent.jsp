<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />"  type='text/css' />
<meta charset="UTF-8">
<title>顯示購物車</title>
</head>
<body>
<div align='center'>
	<h2>顯示購物車</h2>
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
			<table border='1'>
			   <c:choose>
			   	<c:when test='${ShoppingCart.itemNumber > 0 }'>
			   			<tr>
							<th width='100'>書籍標號</th>
							<th width='360'>書名</th>							
							<th width='120'>作者</th>							
							<th width='60'>單價</th>							
							<th width='60'>數量</th>						
						</tr>	
			   		<c:forEach items='${ShoppingCart.content}' var='entry'>
						<tr>
							<td align='center'>${entry.value.bean.bookId}</td>
							<td>${entry.value.bean.title}</td>							
							<td>${entry.value.bean.author}</td>							
							<td align='right'>${entry.value.bean.price}</td>							
							<td align='right'>${entry.value.quantity}</td>							
						</tr>	
					</c:forEach>
			   	</c:when>
				<c:otherwise>
					<tr >
						<td>您尚未購買任何商品</td>
					</tr>	
				</c:otherwise>
			</c:choose>
			</table>	
		<hr>
		<small>&lt;&lt;<a href='<c:url value="/"/>'>回首頁</a>&gt;&gt;</small><br>
	</div>


</body>
</html>