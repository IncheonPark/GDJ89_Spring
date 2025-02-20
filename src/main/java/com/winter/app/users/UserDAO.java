package com.winter.app.users;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
	
	private String NAMESPACE = "com.winter.app.users.UserDAO.";
	@Autowired
	private SqlSession sqlSession;
	
	//
	public UserDTO login(UserDTO dto) {
		
		System.out.println("유저 DAO login");
		return sqlSession.selectOne(NAMESPACE + "login", dto);
		
	}
	
	
	// user의 detail 정보 조회 (where userName)
	public UserDTO getDetail(UserDTO dto) {
		
		System.out.println("유저 DAO getDetail");
		return sqlSession.selectOne(NAMESPACE + "getDetail", dto);
		
	}
		
	
	// userNameCheck
	public int userNameCheck(UserDTO dto) {
		
		System.out.println("유저 DAO userNameCheck");
		return sqlSession.selectOne(NAMESPACE + "userNameCheck", dto);
	}
	
		
	// join
	public int join(UserDTO dto) {
		
		System.out.println("유저 DAO join");
		return sqlSession.insert(NAMESPACE + "join", dto);
		
	}
	
	
	

}
