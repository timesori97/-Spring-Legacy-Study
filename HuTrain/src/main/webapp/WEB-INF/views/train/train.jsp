<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
</head>
<link rel="stylesheet" type="text/css" href="./resources/css/book.css">
<body>
	<header>
		<!--  html 문서의 메인 타이틀 -->
		<h2>휴먼 열차 조회 시스템</h2>
	</header>
	<nav>
		<!--  메뉴... -->
		<span><a href="/hom3/allt">모든열차보기</a></span> <input type="text"
			id="searchWord"> <input type="button" value="검색"
			onclick="goSearch()"> <select id="selectWord"
			onchange="goSelect()">
			<option>선택</option>
			<option value="서울">서울</option>
			<option value="대전">대전</option>
			<option value="부산">부산</option>
		</select>
		<script>
			function goSearch() {
				let sword = document.getElementById('searchWord').value
				let url = "/hom3/find?word=" + sword;
				alert(url)
				location.href = "/hom3/find?word=" + sword
			}
			function goSelect() {
				let sword = document.getElementById('selectWord').value
				let url = "/hom3/find?word=" + sword;
				alert(url)
				location.href = "/hom3/find?word=" + sword
			}
		</script>
	</nav>
	<section>
		<!--  문서의 주요내용 -->
		<hr>
		<h3>검색결과</h3>
		<c:forEach var="train_dto" items="${train_list }">
			<!--  순서가 있고 0 1 2 3 -->
			 도시 : ${train_dto.city } <br>
		         기차명 : ${train_dto.tname } <br>
		         출발시간 : ${train_dto.starttime } <br>
		         도착시간 : ${train_dto.arrTime } <br>
			<hr>
		</c:forEach>

	</section>
</body>
</html>