package com.winter.app.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.SampleTestCase;

public class NoticeDAOTest extends SampleTestCase {

	@Autowired
	private NoticeDAO dao;
	
	
	@Test
	public void addTest() throws Exception {
		
		NoticeDTO dto = new NoticeDTO();
		dto.setBoardTitle("id2");
		dto.setBoardContent("pw");
		dto.setBoardHit(1);
		dto.setUserName("a3");
		
		int result = dao.add(dto);
		System.out.println("result : " + result);
		//단정문 assert
		assertEquals(1, result);
				
	}
	
//	@Test
//	public void getDetailTest() throws Exception {
//		
//		NoticeDTO dto = new NoticeDTO();
//		dto.setBoardNum(3);
//		dto = dao.getDetail(dto);
//		
//		assertEquals("a7", dto.getUserName());
//		
//	}
//	
//	@Test
//	public void getListTest() throws Exception {
//		
//		List<NoticeDTO> list = dao.getList();
//		
//		assertNotEquals(0, list.size());
//		
//		
//	}
//	
//	@Test
//	public void updateTest() throws Exception {
//		
//		NoticeDTO dto = new NoticeDTO();
//		dto.setBoardTitle("id22");
//		dto.setBoardContent("pw22");
//		
//		dto.setBoardNum(3);
//		dto.setUserName("a7");
//		
//		int result = dao.update(dto);
//		
//		assertEquals(1, result);
//		
//	}
//	
//	@Test
//	public void deleteTest() throws Exception {
//		
//		NoticeDTO dto = new NoticeDTO();
//		dto.setBoardNum(3);
//		
//		int result = dao.delete(dto);
//		
//		assertEquals(1, result);
//		
//	}
	
	
	
	
	
	
	

}
