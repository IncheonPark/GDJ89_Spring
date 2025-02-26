package com.winter.app.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.pages.Pager;

@Service
public class QnaService {
	
	@Autowired
	private QnaDAO dao;
	
	
	
	//
	public List<QnaDTO> getList(Pager pager) throws Exception {
		
		System.out.println("QnA 서비스 겟리스트");
		
		Long totalCount = dao.totalCount();
		
		pager.make(totalCount);
		
		pager.makeNum();
		
		pager.makeNum();
		List<QnaDTO> list = dao.getList(pager);
		return list;
		
	}
	
	//
	public QnaDTO getDetail(QnaDTO dto1) throws Exception {
		
		System.out.println("QnA 서비스 겟디테일 ");
		
		QnaDTO dto = dao.getDetail(dto1);
		return dto;
		
	}
	
	//
	public int add(QnaDTO dto1) throws Exception {
		
		System.out.println("QnA 서비스 애드 ");
		
		int result = dao.add(dto1);
		return result;
		
	}
	
	//
	public int update(QnaDTO dto1) throws Exception {
		
		System.out.println("QnA 서비스 업데이트 ");
		
		int result = dao.update(dto1);
		return result;
		
	}
	
	//
	public int delete(QnaDTO dto1) throws Exception {
		
		System.out.println("QnA 서비스 딜리트 ");
		
		int result = dao.delete(dto1);
		return result;
		
	}

}
