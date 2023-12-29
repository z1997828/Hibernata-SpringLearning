<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href="<c:url value='/css/styles.css' />"  type='text/css' />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>報明牌</title>
</head>
<body>
<H2>多個請求路徑可對應同一個控制器方法</H2>   
本請求的URI: ${requestURI}<br>  
<hr>
<pre>
@GetMapping(value= {"/mappings1", "/mappings2"}, method=RequestMethod.GET)
public String mappings(HttpServletRequest req, Model model) {
	// 在瀏覽器中顯示Request URI
	String uri = req.getRequestURI();
	model.addAttribute("requestURI", uri);
	return "ch02/mappings";
}
</pre>
<p>
<div align='center'>
<small>&lt;&lt;<a href='<c:url value="/ch02/index"/>'>回前頁</a>&gt;&gt;</small>
</div>  
</body>
</html>