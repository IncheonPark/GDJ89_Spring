<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/templates/boot_css.jsp"></c:import>
</head>
<body class="d-flex flex-column min-vh-100">
<c:import url="/WEB-INF/views/templates/layout_header.jsp"></c:import>

<div class="container-fluid my-5">
	<div class="row col-md-8 offset-md-2">
		
		<!-- 컨텐츠 내용 작성 -->
		<h1>로그인 페이지입니다</h1>
		<form action="./login" method="post">
		  <div class="mb-3 col-3">
		    <label for="userName" class="form-label">아이디</label>
		    <input type="text" class="form-control" id="userName" name="userName" >
		  </div>
		  <div class="mb-3 col-3">
		    <label for="password" class="form-label">패스워드</label>
		    <input type="text" class="form-control" id="password" name="password" >
		  </div>
		  		  
		  <button type="submit" class="btn btn-primary">로그인 하기</button>
		  <button type="button" id="checkEmpty">공백 확인</button>
		</form>
		
		
	</div>
</div>
<script src="/resources/js/login.js"></script>


<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>