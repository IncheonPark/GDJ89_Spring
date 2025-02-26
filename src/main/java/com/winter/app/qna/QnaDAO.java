package com.winter.app.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.pages.Pager;

@Repository
public class QnaDAO {
	
	@Autowired
	private SqlSession session;
	
	private final String NAMESPACE = "com.winter.app.qna.QnaDAO.";
	
	
	
	//
	public List<QnaDTO> getList(Pager pager) throws Exception {
		
		System.out.println("QnA dao 겟리스트");
		
		List<QnaDTO> list = session.selectList(NAMESPACE + "getList", pager);
		System.out.println("list.size = " + list.size());
		return list;
		
	}
	
	//
	public QnaDTO getDetail(QnaDTO dto1) throws Exception {
		
		System.out.println("QnA dao 겟디테일 ");
		
		QnaDTO dto = session.selectOne(NAMESPACE + "getDetail", dto1);
		return dto;
		
	}
	
	//
	public int add(QnaDTO dto1) throws Exception {
		
		System.out.println("QnA dao 애드 ");
		
		int result = session.insert(NAMESPACE + "add", dto1);
		return result;
		
	}
	
	//
	public int update(QnaDTO dto1) throws Exception {
		
		System.out.println("QnA dao 업데이트 ");
		
		int result = session.update(NAMESPACE + "update", dto1);
		return result;
		
	}
	
	//
	public int delete(QnaDTO dto1) throws Exception {
		
		System.out.println("QnA dao 딜리트 ");
		
		int result = session.delete(NAMESPACE + "delete", dto1);
		return result;
		
	}
	
	//
	public Long totalCount() throws Exception {
		
		return session.selectOne(NAMESPACE + "totalCount");
		
	}
	
	
	
	
	
	

}
