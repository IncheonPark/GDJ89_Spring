package com.winter.app.pages;

public class Pager {
	
	// 검색 종류
	private String kind;
	
	// 검색어
	private String search;
	

	// 리스트 시작 번호
	private Long startNum;
	
	// 리스트 끝 번호
	private Long endNum;
	
	// 페이지 번호 (파라미터로 대입 받는다)
	private Long page;
	
	// 페이지당 출력할 행의 갯수
	private Long perPage;
	
	
	
	// 블럭 start, 블럭 end
	private Long start;
	private Long end;
	
	
	//
	private boolean endCheck;


	
	
	public boolean isEndCheck() {
		return endCheck;
	}


	public void setEndCheck(boolean endCheck) {
		this.endCheck = endCheck;
	}




	// 시작 번호, 끝 번호를 계산하는 메서드
	public void makeNum() {
		this.endNum = getPage() * getPerPage();
		
		// 또다른 로직 startNum = (page-1)*10+1;
		this.startNum = this.endNum-(getPerPage()-1);
		
	}
	
	
	//
	public void make(Long totalCount) {
		
		// 1. 토탈 페이지 계산
		Long totalPage = totalCount/10;
		if(totalCount%10 != 0) { //나머지 있으면 1페이지 추가
			totalPage++;
		}
				
		// 2. 토탈 블럭 계산
		Long totalBlock = totalPage/5;
		if(totalPage%5 != 0) {
			totalBlock++;
		}
		
		// 3. 현재 page번호로 블럭 번호 구하기
		Long curBlock = this.getPage()/5;
		if(this.getPage() % 5 != 0) {
			curBlock++;
		}
		
		// 4. 현재 블럭 번호로 시작 번호와 끝번호 구하기
		Long start = (curBlock-1)*5+1;
		Long end = curBlock*5;
				
		this.setStart(start);
		this.setEnd(end);
		
		// 5. 현재 블럭이 마지막 블럭이라면 마지막 페이지를 토탈 페이지(페이지의 총 수)로 설정하자
		if (totalBlock == curBlock) {
			this.setEnd(totalPage);
			this.setEndCheck(true);
		}
		
	}
		
	
	

	public Long getStart() {
		return start;
	}



	public void setStart(Long start) {
		this.start = start;
	}



	public Long getEnd() {
		return end;
	}



	public void setEnd(Long end) {
		this.end = end;
	}


	public String getKind() {
		if(this.kind == null) {
			this.kind = "k1";
		}
		return kind;
	}
	
	
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	
	public String getSearch() {
		if(this.search == null) {
			this.search=""; // 빈 문자열
		}
		return search;
	}
	
	
	public void setSearch(String search) {
		this.search = search;
	}
	
	
	public Long getPage() {
		if(this.page == null || this.page < 1) {
			this.page = 1L;
		}
		return page;
	}



	public void setPage(Long page) {
		this.page = page;
	}



	public Long getPerPage() {
		if(this.perPage == null || this.page < 1) {
			this.perPage = 10L;
		}
		return perPage;
	}



	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}



	public Long getStartNum() {
		return startNum;
	}

	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

	public Long getEndNum() {
		return endNum;
	}

	public void setEndNum(Long endNum) {
		this.endNum = endNum;
	}
	
	

}
