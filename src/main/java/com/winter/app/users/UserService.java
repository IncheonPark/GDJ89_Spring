package com.winter.app.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.boards.notice.NoticeDTO;

@Service
public class UserService {
	
	@Autowired
	private UserDAO dao;
	
	
	// login
	public UserDTO login(UserDTO dto) {
		
		System.out.println("유저 서비스 로그인");
		return dao.login(dto);
		
	}
	
	
	
	// getDetail
	public UserDTO getDetail(UserDTO dto) {
		
		System.out.println("유저 서비스 getDetail");
		System.out.println("유저네임"+dto.getUserName());
		return dao.getDetail(dto);
		
	}
	
	
	
	// userNameCheck
	public int userNameCheck(UserDTO dto) {
		
		System.out.println("유저 Service userNameCheck");
		return dao.userNameCheck(dto);
		
	}
	
	
	// join
	public int join(UserDTO dto) {
		
		System.out.println("유저 Service join");
		return dao.join(dto);
		
	}
	
	
	//
	public int delete(UserDTO dto1) throws Exception {
		
		System.out.println("유저 서비스 딜리트 ");
		
		int result = dao.delete(dto1);
		return result;
		
	}
	

}
