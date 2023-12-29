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
<h2>本範例說明如何在控制器方法內讀取瀏覽器送來的路徑變數(Path Varaible)</h2>
<hr>
<h2>查詢明牌</h2>
<h3>@PathVariable</h3>
<Form id="myForm" action='advPathVariableGoodLuck/0/9/3'  method='POST'>
      訪客姓名:<input type="text" name="visitor" id="visitor"   size="10"><BR><P/>
   <input type="radio"  name="numberType" value="3" CHECKED="checked" onclick="handleClick(this);">三星彩(三個介於0-9的可重複的數字)<br>
   <input type="radio"  name="numberType" value="4" onclick="handleClick(this);">四星彩(四個介於0-9的可重複的數字)<br>
   <input type="radio"  name="numberType" value="5" onclick="handleClick(this);">五星彩(五個介於0-9的可重複的數字)<br>
   <P/>
   <input type="submit" id='submit' value='確定'>
</Form>
<p/>
<small>&lt;&lt;<a href='<c:url value="/ch02/index"/>'>回第二章首頁</a>&gt;&gt;</small>
</div>
</body>
</html>