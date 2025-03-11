package com.winter.app.comments;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.SampleTestCase;
import com.winter.app.products.CommentsDTO;
import com.winter.app.products.ProductDAO;

public class CommentDAOTest extends SampleTestCase {
	
	
	
	@Autowired
	private ProductDAO dao;
	
	@Test
	public void add() throws Exception {
		
		CommentsDTO dto = new CommentsDTO();
		
		dto.setBoardContent("boardContent");
		dto.setProductNum(10L);
		dto.setUserName("a3");
					
		int result = dao.addComments(dto);
		
		assertEquals(1, result);
	
		
	}
		
	
	
	
	

}
