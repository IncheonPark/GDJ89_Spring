<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/templates/boot_css.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/summerNote.jsp"></c:import>
</head>
<body class="d-flex flex-column min-vh-100">
<c:import url="/WEB-INF/views/templates/layout_header.jsp"></c:import>

<div class="container-fluid my-5">
	<div class="row col-md-8 offset-md-2">
		
		<!-- 컨텐츠 내용 작성 -->
		<h1>상품추가 페이지입니다</h1>
		<form action="./add" method="post" id="addForm">
		  <div class="mb-3 col-8">
		    <label for="product_Name" class="form-label">상품 이름</label>
		    <input type="text" class="form-control addInput" id="productName" name="productName" placeholder="상품명 입력">
		  </div>
		  <div class="mb-3 col-8">
		    <label for="product_Rate" class="form-label">상품 이율</label>
		    <input type="text" class="form-control addInput" id="productRate" name="productRate" placeholder="0.00">
		  </div>
		  <div class="mb-3 col-8">
		    <label for="product_Date" class="form-label">만기일</label>
		    <input type="date" class="form-control addInput" id="productDate" name="productDate" >
		  </div>
		  
		  <div class="mb-3 col-8" >
			<label for="productDetail" class="form-label">상품설명</label>
			<textarea class="form-control addInput" name="productDetail" id="detail" rows="10"></textarea>
		  </div>
		  	  
		  
		  <button type="button" class="btn btn-primary" id="sub1">상품 등록</button>
		</form>
		
		
	</div>
</div>



<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>

<script src="/resources/js/add.js"></script>
<script src="/resources/js/summerNote.js"></script>
</body>
</html>