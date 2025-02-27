package com.winter.app.boards;

import java.util.List;

import com.winter.app.pages.Pager;

public interface BoardService {
	
	
	
	// list
	List<BoardDTO> getList(Pager pager) throws Exception;
	
	
	// detail
	BoardDTO getDetail(BoardDTO dto) throws Exception;
	
	
	// add
	int add(BoardDTO dto) throws Exception;
	
	
	// update
	int update(BoardDTO dto) throws Exception;
	
	
	// delete
	int delete(BoardDTO dto) throws Exception;
	
	
	
	
	

}
