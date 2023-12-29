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
$(document).ready(function(){
	$('#submit').click(function(){
	    validateForm();  
	    return false;
	});

	function validateForm(){
	    var name = $('#visitor').val();
	    var numberType = $('input[name=numberType]:checked', '#myForm').val();
	    var min = 1 ;
	    var max = -1 ;
	    var ballNumber = -1 ;
	    if (numberType == 'BIG') {
	    	max = 49;
	    	ballNumber = 6;
	    } else if (numberType == 'MID') {
	    	max = 42;
	    	ballNumber = 6;
	    } else if (numberType == 'SMALL') {
	    	max = 39;
	    	ballNumber = 5;
	    } 

        var data = {
       		'visitor': name,
       		'min': min,
       		'max': max,
       		'ballNumber': 	ballNumber
        }
        $.ajax({
        	  type: "POST",
        	  url: "<c:url value='advncedGoodLuck' />",
        	  data: data,
        	  success: function(html){  
        		  $('body').replaceWith(html);                 
              },
        	  async:false      // 同步請求
       	});
	}   
	});
</script>
</head>
<body> 
<h2>查詢明牌</h2>
<Form id="myForm">
      訪客姓名:<input type="text" name="visitor" id="visitor"   size="10"><BR><P/>
   <input type="radio"  name="numberType" value="BIG" CHECKED="CHECKED">大樂透(六個介於1-49的數字)<br>
   <input type="radio"  name="numberType" value="MID">中樂透(六個介於1-42的數字)<br>
   <input type="radio"  name="numberType" value="SMALL">小樂透(五個介於1-39的數字)<br>
   <P/>
   <button id='submit'>確定  </button>  
</Form>
</body>
</html>