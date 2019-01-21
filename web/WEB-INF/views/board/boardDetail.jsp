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
	<c:if test="${ !empty sessionScope.loginUser }">
		<jsp:include page="../common/menubar.jsp" />
		<h1 align="center">게시판 상세보기</h1>
		<table align="center">
			<tr>
				<td width="100px">글번호</td>
				<td><b>${ b.bid }</b></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><b>${ b.bTitle }</b></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><b>${ b.userName }</b></td>
			</tr>
			<tr>
				<td>조회수</td>
				<td><b>${ b.bCount }</b></td>
			</tr>
			<tr>
				<td>작성일</td>
				<td><b>${ b.createDate }</b></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><p style="height:100px">${ b.bContent }</p></td>
			</tr>
		</table>
		<table align="center">
			<tr>
				<td>
					<textarea cols="60" rows="5"></textarea>
				</td>
				<td>
					<button>등록하기</button>
				</td>
			</tr>
			<tr>
				<td colspan="2"><b>답글(${ rCount })</b></td>
			</tr>
		</table>
		
		<table align="center">
			<c:forEach var ="r" items="${ b.replyList }">
				<tr>
					<td width="100px">${ r.userName }</td>
					<td width="300px">${ r.rContent }</td>
					<td width="100px">${ r.createDate }</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
	<c:if test="${ empty sessionScope.loginUser }">
		<c:set var="message" value="로그인이 필요한 서비스입니다." scope="request" />
		<jsp:forward page="../common/errorPage.jsp" />
	</c:if>
	

</body>
</html>