<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INDEX</title>
</head>
<body>
	<!-- 프로젝트의 절대경로 (mb) -->
	<c:set var="contextPath" value="${ pageContext.servletContext.contextPath }" scope="application" />	
<%-- 	<a href="${ contextPath }/WEB-INF/views/main/main.jsp">메인으로</a> --%>
	
	<!-- WEB-INF은 WAS 상의 폴더이기 때문에 접근하려면 forward가 필요하다 
		 index.jsp에 접근하자마자 main.jsp로 포워드 해준다 -->
	<jsp:forward page="WEB-INF/views/main/main.jsp" />
</body>
</html>