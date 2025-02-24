package com.winter.app.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.pages.Pager;

@Repository
public class NoticeDAO {
	
	@Autowired
	private SqlSession session;
	
	private final String NAMESPACE = "com.winter.app.notice.NoticeDAO.";
	
	
	
	//
	public List<NoticeDTO> getList(Pager pager) throws Exception {
		
		System.out.println("노티스 dao 겟리스트");
		
		List<NoticeDTO> list = session.selectList(NAMESPACE + "getList", pager);
		System.out.println("list.size = " + list.size());
		return list;
		
	}
	
	//
	public NoticeDTO getDetail(NoticeDTO dto1) throws Exception {
		
		System.out.println("노티스 dao 겟디테일 ");
		
		NoticeDTO dto = session.selectOne(NAMESPACE + "getDetail", dto1);
		return dto;
		
	}
	
	//
	public int add(NoticeDTO dto1) throws Exception {
		
		System.out.println("노티스 dao 애드 ");
		
		int result = session.insert(NAMESPACE + "add", dto1);
		return result;
		
	}
	
	//
	public int update(NoticeDTO dto1) throws Exception {
		
		System.out.println("노티스 dao 업데이트 ");
		
		int result = session.update(NAMESPACE + "update", dto1);
		return result;
		
	}
	
	//
	public int delete(NoticeDTO dto1) throws Exception {
		
		System.out.println("노티스 dao 딜리트 ");
		
		int result = session.delete(NAMESPACE + "delete", dto1);
		return result;
		
	}
	
	//
	public Long totalCount() throws Exception {
		
		return session.selectOne(NAMESPACE + "totalCount");
		
	}
	
	
	
	
	
	

}
