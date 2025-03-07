<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.add {
	margin-bottom: 30px;
}
</style>
<title>Insert title here</title>
<c:import url="/WEB-INF/views/templates/boot_css.jsp"></c:import>
</head>
<body class="d-flex flex-column min-vh-100">
<c:import url="/WEB-INF/views/templates/layout_header.jsp"></c:import>

<div class="container-fluid my-5">
	<div class="row col-md-8 offset-md-2">
		
		<!-- 컨텐츠 내용 작성 -->
		
		<h1>Cart List Page</h1>
		
		<form id="list_form" action="./carts"  class="row row-cols-lg-auto g-3 align-items-center">
			<input type="hidden" name="page" id="pageNum">   
		</form>
		
		<table class="table">
		  <thead>
		    <tr>		      
		      <th scope="col">상품번호</th>
		      <th scope="col">제품명</th>
		      <th scope="col">상품이율</th>
		      <th scope="col">날짜</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${carts }" var="v">
			    <tr style="cursor:pointer;" onClick="location.href='../products/detail?productNum=${v.productNum}'">
			      <th scope="row">${v.productNum }</th>
			      <td>${v.productName }</td>
			      <td>${v.productRate }</td>
			      <td>${v.productDate }</td>
			    </tr>
		    </c:forEach>
		  </tbody>
		</table>



		<nav aria-label="Page navigation example">
		  <ul class="pagination">
		    <li class="page-item">
		      <button class="page-link pages" data-page-num="${pager.start-1}" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
			  </button>
		    </li>
		    <c:forEach begin="${pager.start}" end="${pager.end}" var="i">
		    <li class="page-item">
				<button class="page-link pages" data-page-num="${i}">${i}</button></li>
		    </c:forEach>
		    <li class="page-item ${pager.endCheck?'disabled':''}">
		      <button class="page-link pages" data-page-num="${pager.end+1}" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
			  </button>
		    </li>
		  </ul>
		</nav>
		
	</div>
</div>



<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>

<script src="/resources/js/list.js"></script>

</body>
</html>