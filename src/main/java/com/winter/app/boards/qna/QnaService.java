package com.winter.app.boards.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.boards.BoardDTO;
import com.winter.app.pages.Pager;

@Service
public class QnaService {
	
	@Autowired
	private QnaDAO dao;
	
	
	
	//
	public List<BoardDTO> getList(Pager pager) throws Exception {
		
		System.out.println("QnA 서비스 겟리스트");
		
		Long totalCount = dao.getTotalCount(pager);
		
		pager.make(totalCount);
		
		pager.makeNum();
		
		pager.makeNum();
		List<BoardDTO> list = dao.getList(pager);
		return list;
		
	}
	
	//
	public BoardDTO getDetail(BoardDTO dto1) throws Exception {
		
		System.out.println("QnA 서비스 겟디테일 ");
		
		BoardDTO dto = dao.getDetail(dto1);
		return dto;
		
	}
	
	//
	public int add(BoardDTO dto1) throws Exception {
		
		System.out.println("QnA 서비스 애드 ");
		
		int result = dao.add(dto1);
		return result;
		
	}
	
	//
	public int update(BoardDTO dto1) throws Exception {
		
		System.out.println("QnA 서비스 업데이트 ");
		
		int result = dao.update(dto1);
		return result;
		
	}
	
	//
	public int delete(BoardDTO dto1) throws Exception {
		
		System.out.println("QnA 서비스 딜리트 ");
		
		int result = dao.delete(dto1);
		return result;
		
	}
	
	//
	public int reply(QnaDTO dto) throws Exception {
		//boardDTO 답글 : 이름, 제목, 내용, 부모글 : 글 번호
		QnaDTO parent = (QnaDTO)dao.getDetail(dto);
		
		// ref 부모의 ref
		dto.setBoardRef(parent.getBoardRef());
		
		//step 부모의 step+1
		dto.setBoardStep(parent.getBoardStep()+1);
		
		//depth 부모의 depth+1
		dto.setBoardDepth(parent.getBoardDepth()+1);
		
		//step update
		int result = dao.updateStep(parent);
		
		result = dao.reply(dto);
		
		return result;
		
		
	}
	
	
	
	

}
