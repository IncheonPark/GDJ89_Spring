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
 
 .textarea {
 	height: 400px;
 	
 }
 
 .textareaDiv {
 	margin-bottom: 50px;
 }
</style>
</head>
<body class="d-flex flex-column min-vh-100">
<c:import url="/WEB-INF/views/templates/layout_header.jsp"></c:import>

<div class="container-fluid my-5">
	<div class="row col-md-8 offset-md-2">
		
		<!-- 컨텐츠 내용 작성 -->
		<h1>QnA 디테일 페이지입니다.</h1>
		
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
		  	
			    <tr>
			      <td>${dto.boardNum }</td>
			      <td>${dto.boardTitle }</td>
			      <td>${dto.boardDate }</td>
			      <td>${dto.boardHit }</td>
			      <td>${dto.userName }</td>			      
			    </tr>
		    
		  </tbody>
		</table>
		
		<div class="input-group textareaDiv">
		  <span class="input-group-text">내용</span>
		  <textarea class="form-control textarea" aria-label="내용" readonly>${dto.boardContent }</textarea>
		</div>
		
		<c:if test="${user.userName eq dto.userName }">
		<a href="./update?boardNum=${dto.boardNum}" class="btn btn-outline-info">글 수정</a>
		<a href="./delete?boardNum=${dto.boardNum}" class="btn btn-outline-danger">글 삭제</a>
		</c:if>
		
	</div>
</div>



<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>