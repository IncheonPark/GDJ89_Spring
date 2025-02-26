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
		      <th scope="col">번호</th>
		      <th scope="col">제목</th>
		      <th scope="col">작성일</th>
		      <th scope="col">조회</th>
		      <th scope="col">글쓴이</th>
		      
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${list }" var="v">
			    <tr style="cursor:pointer;" onClick="location.href='./detail?boardNum=${v.boardNum}'">
			      <td>${v.boardNum }</td>
			      <td>${v.boardTitle }</td>
			      <td>${v.boardDate }</td>
			      <td>${v.boardHit }</td>
			      <td>${v.userName }</td>
			    </tr>
		    </c:forEach>
		  </tbody>
		</table>
		
		<c:if test="${not empty user }">
		<a href="./add" class="btn btn-outline-info">글 작성</a>
		</c:if>
		
	</div>
</div>



<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>