<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table table-striped">
	<thead>
		<tr>
			<th>
				작성자
			</th>
			<th>
				내용
			</th>
			<th>
				작성일
			</th>
			<th></th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list }" var="c">
			<tr>
				<td>${c.userName }</td>
				<td id="c${c.boardNum}">${c.boardContent }</td>
				<td>${c.boardDate }</td>
				<td><button type="button" class="btn btn-outline-info updateComments" 
					data-bs-toggle="modal" data-bs-target="#exampleModal" data-board-num="${c.boardNum}">수정</button></td>
				<td><button type="button" class="btn btn-outline-danger deleteComments" 
				data-board-num="${c.boardNum}">삭제</button></td>
				
			</tr>			
		</c:forEach>
	</tbody>
</table>

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


