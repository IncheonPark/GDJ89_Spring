<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/templates/boot_css.jsp"></c:import>
<style>
 .btn {
 	margin-bottom: 10px;
 }
</style>
</head>
<body class="d-flex flex-column min-vh-100">
<c:import url="/WEB-INF/views/templates/layout_header.jsp"></c:import>

<div class="container-fluid my-5">
	<div class="row col-md-8 offset-md-2">
		
		<!-- 컨텐츠 내용 작성 -->
		<h1>회원정보 페이지입니다</h1>
		
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">패스워드</th>
		      <th scope="col">이름</th>
		      <th scope="col">전화번호</th>
		      <th scope="col">이메일</th>
		    </tr>
		  </thead>
		  <tbody>
		  	
			    <tr>			      
			      <td>${user.password }</td>
			      <td>${dto.name }</td>
			      <td>${dto.phone }</td>
			      <td>${dto.email }</td>
			    </tr>
		    
		  </tbody>
		</table>
		<a href="./update?userName=${dto.userName}" class="btn btn-outline-info">정보 수정</a>
		<a href="./delete?userName=${dto.userName}" class="btn btn-outline-danger">회원 탈퇴</a>
		
	</div>
</div>



<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>