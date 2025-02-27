package com.winter.app.boards.notice;

import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.winter.app.boards.BoardDTO;
import com.winter.app.pages.Pager;

@Controller
@RequestMapping(value="/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService service;
	
	
	//
	@ModelAttribute("kind")
	public String getKind() {
		
		return "공지사항";
	}
	
	
	//
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String getList(Model model, Pager pager) throws Exception {
		// void인 경우는 url을 String으로 반환한다.
		
		System.out.println("노티스 컨트롤러 겟리스트");
		
		List<BoardDTO> list = service.getList(pager);
		
		
		model.addAttribute("list", list);
		model.addAttribute("pager", pager);
		
		return "board/list";
		
	}
	
	
	//
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public String getDetail(NoticeDTO dto1, Model model) throws Exception {
		// 처음 컨트롤러에서 디스패쳐 서블릿으로부터 생성된 DTO객체를 받아올 때 지정한 타입이 매퍼에서 결정된다.
		// BoardDTO로 받아오면 매퍼에서 BoardDTO로 인식함
		
		System.out.println("노티스 컨트롤러 겟디테일");
				
		NoticeDTO dto = (NoticeDTO)service.getDetail(dto1);
		
		model.addAttribute("dto", dto);
		
		return "board/detail";
		
	}
	
	
	//
	@RequestMapping(value="add", method=RequestMethod.GET)
	public String addGet() throws Exception {
		
		System.out.println("노티스 컨트롤러 애드 겟");
		
		return "board/boardForm";
		
	}
	
	
	//
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String addPost(NoticeDTO dto1) throws Exception {
		
		System.out.println("노티스 컨트롤러 애드 포스트");
		
		int result = service.add(dto1);
		if(result > 0) {
			System.out.println("등록 성공");
		} else {
			System.out.println("등록 실패");
		}
		
		return "redirect:./list";
		
	}
	
	
	//
	@RequestMapping(value="update", method=RequestMethod.GET)
	public ModelAndView updateGet(NoticeDTO dto1) throws Exception {
		
		System.out.println("노티스 컨트롤러 업데이트 겟");
		
		
		
		NoticeDTO dto = (NoticeDTO)service.getDetail(dto1);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", dto);
		mv.setViewName("board/boardForm");
		
		return mv;
		
	}
	
	
	//
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String updatePost(NoticeDTO dto1) throws Exception {
		
		System.out.println("노티스 컨트롤러 업데이트 포스트");
		
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
	public ModelAndView delete(NoticeDTO dto1) throws Exception {
		
		System.out.println("노티스 컨트롤러 딜리트");
		
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
	
	
	
	
	

}
