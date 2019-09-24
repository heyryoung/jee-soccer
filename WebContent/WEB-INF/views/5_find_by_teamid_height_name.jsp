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
해당 team_ID(${origin.teamId})에 키가 ${origin.height} 이상이면서, 성이 '${origin.playerName}'씨인 선수는 <br>
<c:forEach items="${player}" var="dto">
   이름 : ${dto.playerName},  팀 team_ID(${dto.teamId}) ,  키 ${dto.height} 입니다.  <br>
</c:forEach> 

</body>
</html>