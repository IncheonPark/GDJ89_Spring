package com.winter.app.notice;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.SampleTestCase;
import com.winter.app.boards.notice.NoticeDAO;
import com.winter.app.boards.notice.NoticeDTO;
import com.winter.app.products.ProductDTO;

public class NoticeDAOTest extends SampleTestCase {

	@Autowired
	private NoticeDAO dao;
	
	@Test
	public void add() throws Exception {
		
		NoticeDTO dto = new NoticeDTO();
		
		
		for (int i=0; i<110; i++) {
			dto.setBoardTitle("boardTitle"+i);
			dto.setBoardContent("boardContent"+i);
			dto.setUserName("a7");
						
			dao.add(dto);
			
			if(i%10==0) {
				Thread.sleep(500); //0.5초 동안 지연
			}
			
			System.out.println("Finish");
		
			
		}
		
	}
	
	
//	@Test
//	public void addTest() throws Exception {
//		
//		NoticeDTO dto = new NoticeDTO();
//		dto.setBoardTitle("id2");
//		dto.setBoardContent("pw");
//		dto.setBoardHit(1);
//		dto.setUserName("a3");
//		
//		int result = dao.add(dto);
//		System.out.println("result : " + result);
//		//단정문 assert
//		assertEquals(1, result);
//				
//	}
	
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
