package com.winter.app.boards.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.boards.BoardDAO;
import com.winter.app.boards.BoardDTO;
import com.winter.app.pages.Pager;

@Repository
public class QnaDAO implements BoardDAO {
	
	@Autowired
	private SqlSession session;
	
	private final String NAMESPACE = "com.winter.app.qna.QnaDAO.";

	
	
	
	@Override
	public Long getTotalCount(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(NAMESPACE+"getTotalCount", pager);
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE+"getList", pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(NAMESPACE+"getDetail", dto);
	}

	@Override
	public int add(BoardDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return session.insert(NAMESPACE+"add", dto);
	}

	@Override
	public int update(BoardDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return session.update(NAMESPACE+"update", dto);
	}

//	@Override
//	public int updateHit(BoardDTO dto) throws Exception {
//		// TODO Auto-generated method stub
//		return session.update(NAMESPACE+"updateHit", dto);
//	}

	@Override
	public int delete(BoardDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return session.delete(NAMESPACE+"delete", dto);
	}
	
	
	//
	public int updateStep(QnaDTO qnaDTO) throws Exception {
		
		return session.update(NAMESPACE+"updateStep", qnaDTO);
	}
	
	
	//
	public int reply(QnaDTO qnaDTO) throws Exception {
		
		return session.insert(NAMESPACE+"reply", qnaDTO);
	}
	
	
	
	

}
