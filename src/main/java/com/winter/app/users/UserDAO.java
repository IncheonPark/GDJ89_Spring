package com.winter.app.users;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.boards.notice.NoticeDTO;

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
	
	
	//
	public int delete(UserDTO dto1) throws Exception {
		
		System.out.println("유저 dao 딜리트 ");
		
		int result = sqlSession.delete(NAMESPACE + "delete", dto1);
		
		return result;
	}
	
	
	//
	public int update(UserDTO dto) throws Exception {
		
		System.out.println("유저 dao 업데이트");
		System.out.println("dao dto.getUserName : " + dto.getUserName());
		
		int result = sqlSession.update(NAMESPACE + "update", dto);
		
		return result;
	}
	
	
	//
	public int upload(UserFileDTO userFileDTO) throws Exception {
		
		System.out.println("유저 dao upload ");
		
		int result = sqlSession.insert(NAMESPACE + "upload", userFileDTO);
		
		return result;
	}
	
	

}
