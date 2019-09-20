<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>

<a href="#" id ="position"> 포지션 종류 보기</a>

<script>
	$("#position").click(function(){
		 location.assign('<%=request.getContextPath()%>/player.do?');
		alert("login");
	});
</script>
</body>
</html>