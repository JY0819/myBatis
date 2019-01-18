<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List</title>
</head>
<body>
	<c:if test="${ !empty sessionScope.loginUser }">
		<jsp:include page="../common/menubar.jsp" />
		<h1 align="center">게시판</h1>
		
		<!-- 검색 영역 추가 -->
		<div id="searchArea" align="center">
			<label>검색조건</label>
			<select id="searchCondition" name="searchCondition">
				<option value="writer">작성자</option>
				<option value="title">제목</option>
				<option value="content">내용</option>
			</select>
			<input type="search" id="search">
			<button>검색하기</button>
		</div>
		
		<!-- 게시물 목록 영역 -->
		<table id="boardArea" align="center" style="text-align: center;">
			
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>작성일</th>
			</tr>
			
			<c:forEach var="b" items="${ list }">
				<tr>
					<td>${ b.bid }</td>
					<td>${ b.bTitle }</td>
					<td>${ b.userName }</td>
					<td>${ b.bCount }</td>
					<td>${ b.createDate }</td>
				</tr>
			</c:forEach>
		
		</table>
		
		<!-- 페이징 버튼 영역 -->
		<div id="pagingArea" align="center">
			<c:if test="${ pi.currentPage <= 1 }">
				[이전] &nbsp;
			</c:if>
			
			<c:if test="${ pi.currentPage > 1 }">
				<c:url var="blistBack" value="/selectList.bo">
					<c:param name="currentPage" value="${ pi.currentPage - 1 }" />
				</c:url>
				<a href="${ blistBack }">[이전]</a> &nbsp;
			</c:if>
			
			
			<c:forEach var="p" begin="${ pi.startPage }" end="${ pi.endPage }">
				<c:if test="${ p eq pi.currentPage }">
					<font color="#FA5858" size="4"><b>[${ p }]</b></font>
				</c:if>
				
				<c:if test="${ p ne pi.currentPage }">
					<c:url var="blistCheck" value="selectList.bo">
						<c:param name="currentPage" value="${ p }" />
					</c:url>
					<a href="${ blistCheck }">${ p }</a>
				</c:if>
			
			</c:forEach>
			
			
			<c:if test="${ pi.currentPage >= pi.maxPage }">
				&nbsp; [다음] 
			</c:if>
			
			<c:if test="${ pi.currentPage < pi.maxPage }">
				<c:url var="blistEnd" value="/selectList.bo">
					<c:param name="currentPage" value="${ pi.currentPage + 1 }" />
				</c:url>
				<a href="${ blistEnd }">&nbsp; [다음]</a> 
			</c:if>
			
		</div>
	
	</c:if>
	
	<c:if test="${ empty sessionScope.loginUser }">
		<c:set var="message" value="로그인이 필요한 서비스입니다." scope="request" />
		<jsp:forward page="../common/errorPage.jsp" />
	</c:if>
</body>
</html>