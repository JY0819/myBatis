<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MenuBar</title>
<style>
.login-area {
	height: 100px;
}

.btn-login {
	height: 50px;
}

.nav-area {
	background: #FA5858;
	height: 50px;
}

.menu {
	display: table-cell;
	width: 250px;
	height: 50px;
	text-align: center;
	vertical-align: middle;
	font-size: 20px;
	background: #FA5858;
	color: white;
}

.menu:hover {
	background: white;
	color: #FA5858;
	cursor: pointer;
}
</style>
</head>
<body>
	<h1 align="center">Welcome to MyBatis World</h1>
	<br>

	<div class="login-area">
	
		<!-- session의 loginUser가 null일 경우 : 로그인 하지 않았을 경우 -->
		<c:if test="${ empty sessionScope.loginUser }">
			<form action="${ contextPath }/login.me" method="post">
				<table align="right">
					
					<tr>
						<td>아이디</td>
						<td>
							<input type="text" name="userId">
						</td>
						<td rowspan="2">
							<button class="btn-login">로그인</button>
						</td>
					</tr>
					
					<tr>
						<td>비밀번호</td>
						<td>
							<input type="password" name="userPwd">
						</td>
					</tr>
					
					<tr>
						<td colspan="3">
							<a href="#">회원가입하기</a>
							<a href="#">아이디/비밀번호 찾기</a>
						</td>
					</tr>
					
				</table>
			</form>
		</c:if>

		<!-- session의 loginUser가 null이 아닐 경우 : 로그인을 한 경우 -->
		<c:if test="${ !empty sessionScope.loginUser }">
			<table align="center">
				<tr>
					<td colspan="2">
						<h3>${ loginUser.userName }님 환영합니다 ^ㅁ^</h3>
					</td>
				</tr>
				
				<tr>
					<td>
						<button>회원정보수정</button>
					</td>
					<td>
						<button onclick="location.href='${ contextPath }/logout.me'">로그아웃</button>
					</td>
				</tr>
			</table>
		</c:if>
		
	</div>
	
	<div class="nav-area" align="center">
		<div class="menu" onclick="home();">HOME</div>
		<div class="menu">NOTICE</div>
		<div class="menu" onclick="board();">BOARD</div>
		<div class="menu">etc.</div>
		<div class="menu">etc.</div>
	</div>
	
	<script>
		function home(){
			location.href = "index.jsp";
		}
		
		function board(){
		}
	</script>
</body>
</html>












