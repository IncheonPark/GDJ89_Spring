<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/templates/boot_css.jsp"></c:import>
<c:if test="${not empty message }">
	<script type="text/javascript">		
		var message = "<c:out value='${message}'/>";
		alert(message);
	</script>
</c:if>
</head>
<body class="d-flex flex-column min-vh-100">
<c:import url="/WEB-INF/views/templates/layout_header.jsp"></c:import>

<div class="container-fluid my-5">
	<div class="row col-md-8 offset-md-2">
		
		<!-- 컨텐츠 내용 작성 -->
		<h1>정보수정 페이지입니다</h1>
		<form action="./update" method="post" enctype="multipart/form-data">
		  
		  <div class="mb-3 col-3">
		    <label for="name" class="form-label">이름</label>
		    <input type="text" class="form-control" id="name" name="name" value="${dto.name}">
		  </div>
		  <div class="mb-3 col-3">
		    <label for="phone" class="form-label">전화번호</label>
		    <input type="text" class="form-control" id="phone" name="phone" value="${dto.phone}">
		  </div>
		  <div class="mb-3 col-3">
		    <label for="email" class="form-label">이메일</label>
		    <input type="text" class="form-control" id="email" name="email" value="${dto.email}">
		  </div>
		  
		  <div class="mb-3 col-3">
		    <label for="profile" class="form-label">프로필</label>
		    <input type="file" class="form-control" id="profile" name="profile">
		  </div>
		  
		  <button type="submit" class="btn btn-primary">수정하기</button>
		</form>
		
		
	</div>
</div>



<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>