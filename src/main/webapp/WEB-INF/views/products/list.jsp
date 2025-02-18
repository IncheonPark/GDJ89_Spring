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
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">상품번호</th>
		      <th scope="col">제품명</th>
		      <th scope="col">상품이율</th>		      
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${list }" var="v">
			    <tr style="cursor:pointer;" onClick="location.href='./detail?productNum=${v.productNum}'">
			      <th scope="row">${v.productNum }</th>			      
			      <td>${v.productName }</td>
			      <td>${v.productRate }</td>
			    </tr>
		    </c:forEach>
		  </tbody>
		</table>
		<a href="./add" class="btn btn-outline-info">상품 등록</a>
		
	</div>
</div>



<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>