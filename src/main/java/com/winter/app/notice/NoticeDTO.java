package com.winter.app.notice;

import java.sql.Date;

public class NoticeDTO {
	
	private long boardNum;
	private String boardTitle;
	private Date boardDate;
	private String boardContent;
	private long boardHit;
	private String userName;
	
	
	
	public long getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(long boardNum) {
		this.boardNum = boardNum;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public long getBoardHit() {
		return boardHit;
	}
	public void setBoardHit(long boardHit) {
		this.boardHit = boardHit;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
	
	

}
