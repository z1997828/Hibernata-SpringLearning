<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />"  type='text/css' />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查詢明牌</title>
<script>
var uri = [
	         'advPathVariableGoodLuck/0/9/3',
	         'advPathVariableGoodLuck/0/9/4',
	         'advPathVariableGoodLuck/0/9/5'
		  ];
document.addEventListener("DOMContentLoaded", function(event) { 
	var rad = document.getElementById('myForm').numberType;
	var form = document.getElementById('myForm');
	for(var i = 0 ; i < rad.length; i++){
		if (rad[i].checked) {
			form.action = uri[i];
		}
	}
});
var currentValue = 0;

function handleClick(myRadio) {
	var form = document.getElementById('myForm');
	if (myRadio.value == '3') {
		form.action = uri[0];	
	} else if (myRadio.value == '4') {
		form.action = uri[1];
	} else if (myRadio.value == '5') {
		form.action = uri[2];
	}
}
</script>
</head>
<body> 
<div align='center'>
<h2>City Time</h2>
<Form id="myForm" action='cityTimeZone'  method='POST'>
   <input type="radio"  name="city" value="Asia/Taipei"  
   		CHECKED="checked" onclick="handleClick(this);">台北<br>
   <input type="radio"  name="city" value="America/New_York">紐約<br>
   <input type="radio"  name="city" value="Europe/London">倫敦<br>
   <input type="radio"  name="city" value="Australia/Sydney">雪梨<br>
   <input type="radio"  name="city" value="Asia/Tokyo">東京<br>
   <P/>
   <input type="submit" id='submit' value='確定'>
</Form>
<p/>
<small>&lt;&lt;<a href='<c:url value="/ch02/index"/>'>回第二章首頁</a>&gt;&gt;</small>
</div>
</body>
</html>