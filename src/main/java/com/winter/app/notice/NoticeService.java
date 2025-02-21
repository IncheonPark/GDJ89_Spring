package com.winter.app.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDAO dao;
	
	
	
	//
	public List<NoticeDTO> getList() throws Exception {
		
		System.out.println("노티스 서비스 겟리스트");
		
		List<NoticeDTO> list = dao.getList();
		return list;
		
	}
	
	//
	public NoticeDTO getDetail(NoticeDTO dto1) throws Exception {
		
		System.out.println("노티스 서비스 겟디테일 ");
		
		NoticeDTO dto = dao.getDetail(dto1);
		return dto;
		
	}
	
	//
	public int add(NoticeDTO dto1) throws Exception {
		
		System.out.println("노티스 서비스 애드 ");
		
		int result = dao.add(dto1);
		return result;
		
	}
	
	//
	public int update(NoticeDTO dto1) throws Exception {
		
		System.out.println("노티스 서비스 업데이트 ");
		
		int result = dao.update(dto1);
		return result;
		
	}
	
	//
	public int delete(NoticeDTO dto1) throws Exception {
		
		System.out.println("노티스 서비스 딜리트 ");
		
		int result = dao.delete(dto1);
		return result;
		
	}

}
