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
		<h1>디테일 페이지입니다.</h1>

		<div>
			<form action="/test" id=form1>
				<input type="hidden" name="productNum" value="${dto.productNum}">
				<button type="button" id="updateBtn">수정</button>
				<button type="button" id="deleteBtn">삭제</button>
				<button type="button" id="proceed">진행 버튼</button>
			</form>
		</div>
		
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">상품번호</th>
		      <th scope="col">제품명</th>
		      <th scope="col">상품이율</th>
		      
		    </tr>
		  </thead>
		  <tbody>
		  	
			    <tr>
			      <th scope="row">${dto.productNum }</th>
			      <td>${dto.productName }</td>
			      <td>${dto.productRate }</td>
			    </tr>
		    
		  </tbody>
		</table>
		<a href="./update?productNum=${dto.productNum}" class="btn btn-outline-info">상품 수정</a>
		<a href="./delete?productNum=${dto.productNum}" class="btn btn-outline-danger">상품 삭제</a>
		
	</div>
</div>



<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>

<script src="/resources/js/detail.js"></script>
</body>
</html>