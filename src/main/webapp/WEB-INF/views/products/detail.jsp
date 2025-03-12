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
		
		<h3>${dto.productDetail }</h3>
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

		<div class="input-group textareaDiv mt-3">
			<span class="input-group-text">댓글</span>
			<textarea class="form-control textarea" aria-label="댓글" id="comment"></textarea>

			<button type="button" id="addComment" data-comment-num="">댓글 등록</button>
		</div>

		<div class="mb-3" id="commentsListResult">
			
		</div>

		<!-- Button trigger modal -->
		<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
			Launch demo modal
		</button>
		
		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
				<h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>

				<div class="modal-body">
					<div class="mb-3">
						<label for="message-text" class="col-form-label">Message:</label>
						<textarea class="form-control" id="message-text"></textarea>
						<input type="hidden" id="modal_boardNum">
					</div>
				</div>

				<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary" id="modal_change" data-bs-dismiss="modal">Save changes</button>
				</div>
			</div>
			</div>
		</div>

			</div>
		</div>



<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>

<script src="/resources/js/products/detail.js"></script>
</body>
</html>