<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${player}" var="dto">

해당 team_ID가  ${dto.teamId} 팀의 포지션이 ${dto.position}이 일치하는 선수는 ${dto.playerName}입니다.  <br>
</c:forEach> 



</body>
</html>