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

<div class="continer-fluid my-5">
	<div class="row col-md-8 offset-md-2">
		<!-- contents 내용 작성 -->
		<h1>Product Detail Page</h1>

		<h3>${dto.productName}</h3>
		<h3>${dto.productRate}</h3>

		<div>
			<form id="frm" action="/test">
				<input type="hidden" name="productNum" value="${dto.productNum}">
				<button type="button" id="up">수정</button>
				<button type="button" id="del">삭제</button>
			</form>
			<button type="button" id="addCart" data-product-num="${dto.productNum}">장바구니</button>

		</div>

	</div>
</div>



<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>

<script src="/resources/js/detail.js"></script>
</body>
</html>