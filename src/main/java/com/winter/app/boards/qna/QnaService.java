package com.winter.app.boards.qna;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.boards.BoardDTO;
import com.winter.app.boards.BoardFileDTO;
import com.winter.app.files.FileManager;
import com.winter.app.pages.Pager;

@Service
public class QnaService {
	
	@Autowired
	private QnaDAO dao;
	@Autowired
	private FileManager fileManager;
	
	
	
	//
	public List<BoardDTO> getList(Pager pager) throws Exception {
		
		System.out.println("QnA 서비스 겟리스트");
		
		Long totalCount = dao.getTotalCount(pager);
		
		pager.make(totalCount);
		
		pager.makeNum();
		
		pager.makeNum();
		List<BoardDTO> list = dao.getList(pager);
		return list;
		
	}
	
	//
	public BoardDTO getDetail(BoardDTO dto1) throws Exception {
		
		System.out.println("QnA 서비스 겟디테일 ");
		
		BoardDTO dto = dao.getDetail(dto1);
		return dto;
		
	}
	
	//
	public int add(BoardDTO dto1, HttpSession session, MultipartFile[] attaches) throws Exception {
		
		System.out.println("QNA 서비스 애드 ");
		
		// 1. DB에 Notice정보를 insert
		int result = dao.add(dto1);
		
		// 2. HDD에 파일을 저장하고, 그 정보들을 DB에 저장한다
		for(MultipartFile attach : attaches) {
			if(attach.isEmpty()) {
				continue;
			}
			BoardFileDTO boardFileDTO = this.fileSave(attach, session.getServletContext());
			// DB에 저장
			boardFileDTO.setBoardNum(dto1.getBoardNum()); //Mapper에서 넣어준 boardNum을 get
			result = dao.addFile(boardFileDTO);
			
		}
		
		
		return result;
		
	}
	
	//
	public int update(BoardDTO dto1) throws Exception {
		
		System.out.println("QnA 서비스 업데이트 ");
		
		int result = dao.update(dto1);
		return result;
		
	}
	
	//
	public int delete(BoardDTO dto1) throws Exception {
		
		System.out.println("QnA 서비스 딜리트 ");
		
		int result = dao.delete(dto1);
		return result;
		
	}
	
	//
	public int reply(QnaDTO dto) throws Exception {
		//boardDTO 답글 : 이름, 제목, 내용, 부모글 : 글 번호
		QnaDTO parent = (QnaDTO)dao.getDetail(dto);
		
		// ref 부모의 ref
		dto.setBoardRef(parent.getBoardRef());
		
		//step 부모의 step+1
		dto.setBoardStep(parent.getBoardStep()+1);
		
		//depth 부모의 depth+1
		dto.setBoardDepth(parent.getBoardDepth()+1);
		
		//step update
		int result = dao.updateStep(parent);
		
		result = dao.reply(dto);
		
		return result;
		
		
	}
	
	//
	private BoardFileDTO fileSave(MultipartFile attach, ServletContext servletContext) throws Exception {
		
		// 1. 어디에 저장할 것인지 지정
		String path = servletContext.getRealPath("/resources/images/qna/");
		File file = new File(path);
		System.out.println("path : "+path);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		// 2. HDD에 파일을 저장하고, 저장된 파일명을 리턴
		String fileName = fileManager.fileSave(path, attach);
		
		// 3. 파일의 정보를 DTO에 담아서 리턴
		BoardFileDTO boardFileDTO = new BoardFileDTO();
		boardFileDTO.setFileName(fileName);
		boardFileDTO.setOldName(attach.getOriginalFilename());
		
		return boardFileDTO;
	}
	
	

}
