package com.winter.app.boards;

import java.util.List;

import com.winter.app.pages.Pager;

public interface BoardDAO {
	
	// 상수, 추상 메서드
	
	
	// totalCount
	public abstract Long getTotalCount(Pager pager) throws Exception;
	
	// list
	public abstract List<BoardDTO> getList(Pager pager) throws Exception;
	
	// detail
	// 접근 지정자 제어 지정자 생략 가능
	BoardDTO getDetail(BoardDTO dto) throws Exception;
	
	// add
	int add(BoardDTO dto) throws Exception;
	
	// update
	int update(BoardDTO dto) throws Exception;
	
	// updateHit
//	int updateHit(BoardDTO dto) throws Exception;
	
	// delete
	int delete(BoardDTO dto) throws Exception;
	
	
	
	
	

}
