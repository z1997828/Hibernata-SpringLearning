<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
    href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Products</title>
</head> 
<body>
    <section>
        <div>
            <div class="container" style="text-align: center" >
                <h1>產品清單</h1>
            </div>
        </div>
    </section>
	<div align='center'>
        <a href="<c:url value='/' />">回首頁</a>
    </div> 
    <hr style="height:1px;border:none;color:#333;background-color:#333;">
    <section class="container">
        <div class="row">
            <div class="col-sm-6 col-md-3" style="width: 360px; height: 360px">
                <div class="thumbnail" style="width: 320px; height: 340px">
                    <div class="caption">
                        <p>
                            <b style='font-size: 16px;'>${product.title}</b>
                        </p>
                        <p>${product.author}</p>
                        <p>${product.companyBean.name}</p>
                        <p>目前在庫數量: ${product.stock}本</p>
                        <p></p>
                    </div>
                </div>
            </div>
        </div>
    </section>
     <div align='center'>
        <a href="<c:url value='/' />">回首頁</a>
    </div> 
</body>
</html>
    