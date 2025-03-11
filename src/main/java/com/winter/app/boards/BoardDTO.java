package com.winter.app.boards;


public class BoardDTO extends CommentDTO {
	
	// 만약 Null을 받을 때 long이라면 400에러코드를 발생시킨다
	private String boardTitle;
	private Long boardHit;
	
	
	
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public Long getBoardHit() {
		return boardHit;
	}
	public void setBoardHit(Long boardHit) {
		this.boardHit = boardHit;
	}
	
	
	
	
	

}
