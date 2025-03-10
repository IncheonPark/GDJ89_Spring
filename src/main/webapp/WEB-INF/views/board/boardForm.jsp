<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.textareaDiv {
	margin-top: 10px;
	margin-bottom: 50px;

}

.textarea {
	height: 400px;
}

.files1 {
	margin-bottom: 25px;
}
</style>
<c:import url="/WEB-INF/views/templates/boot_css.jsp"></c:import>
</head>
<body class="d-flex flex-column min-vh-100">
<c:import url="/WEB-INF/views/templates/layout_header.jsp"></c:import>

<div class="container-fluid my-5">
	<div class="row col-md-8 offset-md-2">
		
		<!-- 컨텐츠 내용 작성 -->
		<h1>${kind} 페이지입니다</h1>
		<form action="" method="post" enctype="multipart/form-data">
		
			<input type="hidden" name="boardNum" value="${dto.boardNum }">
			
		  <div class="input-group">
			  <span class="input-group-text">제목</span>
			  <textarea class="form-control" aria-label="제목" name="boardTitle">${dto.boardTitle }</textarea>
		  </div>
		  
		  <div class="input-group textareaDiv">
			  <span class="input-group-text">내용</span>
			  <textarea class="form-control textarea" aria-label="내용" name="boardContent">${dto.boardContent }</textarea>
		  </div>
		  
		  <div class="mb-3">
		  	<c:forEach items="${dto.boardFileDTOs }" var="f">
			  <div class="alert alert-primary" role="alert">
	  			${f.oldName } <button data-file-num="${f.fileNum}" data-kind="${kind}" 
	  			type="button" class="btn badge text-bg-secondary file-delete">X</button>
			  </div>		  		
		  	</c:forEach>
		  </div>
		  
		  <div id="files" class="files1 mb-3" data-files-size="${dto.boardFileDTOs.size()}">
		  	<div class="mb-3">		  
			<button type="button" id="addFile" class="btn btn-info">파일 추가</button>
			</div>
		  </div>
		  		  
		  <!-- 세션의 유저 아이디를 같이 보냄 -->
		  <input type="hidden" name="userName" value="${user.userName }">
		  		  
		  <button type="submit" class="btn btn-primary">진행하기</button>
		</form>
		
		
	</div>
</div>



<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
<script src="/resources/js/files/fileManager.js"></script>
<script src="/resources/js/files/fileDelete.js"></script>
</body>
</html>