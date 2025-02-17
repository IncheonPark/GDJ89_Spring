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
		<h1>상품추가 페이지입니다.</h1>
		<form>
		  <div class="mb-3 col-3">
		    <label for="product_Name" class="form-label">상품 이름</label>
		    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
		  </div>
		  <div class="mb-3 col-3">
		    <label for="product_Rate" class="form-label">상품 이율</label>
		    <input type="text" class="form-control" id="exampleInputPassword1">
		  </div>
		  <div class="mb-3 col-3">
		    <label for="product_Date" class="form-label">가입일</label>
		    <input type="text" class="form-control" id="exampleInputPassword1">
		  </div>
		  <div class="mb-3 col-3">
		    <label for="product_Detail" class="form-label">상세 설명</label>
		    <input type="text" class="form-control" id="exampleInputPassword1">
		  </div>
		  <button type="submit" class="btn btn-primary">Submit</button>
		</form>
		
		
	</div>
</div>



<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>