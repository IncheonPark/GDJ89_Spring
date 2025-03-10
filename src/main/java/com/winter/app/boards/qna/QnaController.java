package com.winter.app.boards.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.winter.app.boards.BoardDTO;
import com.winter.app.boards.BoardFileDTO;
import com.winter.app.pages.Pager;
import com.winter.app.users.UserDTO;

@Controller
@RequestMapping(value="/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService service;
	
	
	//
	@ModelAttribute("kind")
	public String getKind() {
		
		return "qna";
	}
	
	
	//
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String getList(Model model, Pager pager) throws Exception {
		
		System.out.println("QnA 컨트롤러 겟리스트");
		
		List<BoardDTO> list = service.getList(pager);
		
		model.addAttribute("list", list);
		model.addAttribute("pager", pager);
		
		return "board/list";
		
	}
	
	
	//
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public String getDetail(QnaDTO dto1, Model model) throws Exception {
		
		System.out.println("QnA 컨트롤러 겟디테일");
		
		QnaDTO dto = (QnaDTO)service.getDetail(dto1);
		
		model.addAttribute("dto", dto);
		
		return "board/detail";
		
	}
	
	
	//
	@RequestMapping(value="add", method=RequestMethod.GET)
	public String addGet() throws Exception {
		
		System.out.println("QnA 컨트롤러 애드 겟");
		
		return "board/boardForm";
		
	}
	
	
	//
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String addPost(QnaDTO dto1, HttpSession session, MultipartFile[] attaches) throws Exception {
		
		System.out.println("QnA 컨트롤러 애드 포스트");
		
		int result = service.add(dto1, session, attaches);
		if(result > 0) {
			System.out.println("등록 성공");
		} else {
			System.out.println("등록 실패");
		}
		
		return "redirect:./list";
		
	}
	
	
	//
	@RequestMapping(value="update", method=RequestMethod.GET)
	public ModelAndView updateGet(QnaDTO dto1) throws Exception {
		
		System.out.println("QnA 컨트롤러 업데이트 겟");
		
		QnaDTO dto = (QnaDTO)service.getDetail(dto1);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", dto);
		mv.setViewName("board/boardForm");
		
		return mv;
		
	}
	
	
	//
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String updatePost(QnaDTO dto1) throws Exception {
		
		System.out.println("QnA 컨트롤러 업데이트 포스트");
		
		int result = service.update(dto1);
		if(result > 0) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}
				
		return "redirect:./detail?boardNum="+dto1.getBoardNum();
		
	}
	
	
	//
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public ModelAndView delete(QnaDTO dto1) throws Exception {
		
		System.out.println("QnA 컨트롤러 딜리트");
		
		int result = service.delete(dto1);
		if(result > 0) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", "게시글 삭제 완료");
		mv.addObject("path", "./list");
		mv.setViewName("commons/result");
		
		return mv;
		
	}
	
	
	//
	@RequestMapping(value="reply", method=RequestMethod.GET)
	public String reply(BoardDTO dto) throws Exception {
		
		System.out.println("QnA 컨트롤러 reply GET");
		
		return "board/boardForm";
		
	}
	
	
	//
	@RequestMapping(value="reply", method=RequestMethod.POST)
	public String reply(QnaDTO boardDTO, HttpSession session) throws Exception {
		
		System.out.println("QnA 컨트롤러 reply POST");
		
		UserDTO userDTO = (UserDTO) session.getAttribute("user");
		
		boardDTO.setUserName(userDTO.getUserName());
		
		int result = service.reply(boardDTO);
		
		return "redirect:./list";
		
	}
	
	@RequestMapping(value="fileDelete", method=RequestMethod.POST)
	public String fileDelete(BoardFileDTO boardFileDTO, HttpSession session, Model model) throws Exception {
		
		int result = service.fileDelete(boardFileDTO, session);
		
		model.addAttribute("result", result);
		return "commons/ajaxResult";
	}
	
	
	

}
