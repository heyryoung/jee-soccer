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
<!-- 팀 아이디로 해당 팀의 포지션별 선수 검색 기능.  -->
<h2>4. 팀 아이디와 포지션 입력하면 해당 선수 정보 출력 </h2>
<form action="<%=request.getContextPath()%>/player.do?"  id = "04">
<input type = "text" name = "teamId"  /><br/>
<input type = "text" name = "position" /><br/>
<input type ="hidden" name = "action"  value = "find04">
<input type ="hidden" name = "page"  value = "4_find_by_teamid_position">
<input type = "submit"  /><br/>
</form>

<h2>5. 팀 아이디와 키, 성을 입력하면 해당 선수 정보를 출력 </h2>
<form action="<%=request.getContextPath()%>/player.do?"  id = "05">
<input type = "text" name = "teamId"  /><br/>
<input type = "text" name = "height" /><br/>
<input type = "text" name = "lastname" /><br/>
<input type ="hidden" name = "action"  value = "find05">
<input type ="hidden" name = "page"  value = "5_find_by_teamid_height_name">
<input type = "submit"  /><br/>
</form>




<script>
	$("#position").click(function(){
		 location.assign('<%=request.getContextPath()%>/player.do?action=find02&page=2_positions');
		alert("login");
	});
	$("#04").submit(function(){
		alert("04");
	});
	$("#05").submit(function(){
		alert("05");
	});
</script>
</body>
</html>