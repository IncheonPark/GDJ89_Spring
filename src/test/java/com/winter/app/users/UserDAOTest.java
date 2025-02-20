package com.winter.app.users;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.SampleTestCase;

public class UserDAOTest extends SampleTestCase {

	@Autowired
	private UserDAO dao;
	
	
	//@Test
	public void joinTest() throws Exception {
		
		UserDTO dto = new UserDTO();
		dto.setUserName("id2");
		dto.setPassword("pw");
		dto.setName("name");
		dto.setPhone("phone");
		dto.setEmail("email");
		
		int result = dao.join(dto);
		
		//단정문 assert
		assertEquals(1, result);
				
	}
	
	@Test
	public void getDetailTest() throws Exception {
		
		UserDTO dto = new UserDTO();
		dto.setUserName("DNEHD");
		dto = dao.getDetail(dto);
		
		assertEquals("12345", dto.getPassword());
		
	}
	
	

}
