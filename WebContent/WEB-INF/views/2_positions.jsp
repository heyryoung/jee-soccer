<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포지션</title>
</head>
<body>
포지션은 
<c:forEach items="${positions}" var="dto">
${dto} ,
</c:forEach>입니다
</body>
</html>