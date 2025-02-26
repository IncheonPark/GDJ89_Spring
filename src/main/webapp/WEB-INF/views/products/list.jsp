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
		
		<form action="./list" class="row row-cols-lg-auto g-3 align-items-center">
		
		  <div class="col-12">
		    <label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
		    <select name="kind" class="form-select" id="inlineFormSelectPref">		      
		      <option value="k1">제목</option>
		      <option value="k2">내용</option>
		      <option value="k3">제목+내용</option>
		    </select>
		  </div>
				
		  <div class="col-12">
		    <label class="visually-hidden" for="inlineFormInputGroupUsername">Username</label>
            <input type="text" name="search" class="form-control" id="inlineFormInputGroupUsername" placeholder="검색어 입력">
 		  </div>
		  
		  <div class="col-12">
		    <button type="submit" class="btn btn-primary">검색하기</button>
		  </div>
		</form>
		
		
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

		<a href="./add" class="btn btn-outline-info add">상품 등록</a>

		<nav aria-label="Page navigation example">
		  <ul class="pagination">
		  
		    <li class="page-item">
		      <a class="page-link" href="./list?page=${pager.start-1}&kind=${param.kind}&search=${pager.search}" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
		    
		    <c:forEach begin="${pager.start}" end="${pager.end}" var="i">
		    <li class="page-item">
		    	<a class="page-link" href="./list?page=${i}&kind=${param.kind}&search=${pager.search}">
		    		${i}
		    	</a>
		    </li>
		    </c:forEach>
		    
		    <li class="page-item ${pager.endCheck?'disabled':''}">
		      <a class="page-link" href="./list?page=${pager.end+1}&kind=${param.kind}&search=${pager.search}" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
		    
		  </ul>
		</nav>
		
	</div>
</div>



<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>