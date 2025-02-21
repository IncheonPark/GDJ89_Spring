package com.winter.app.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService service;
	
	
	//
	@RequestMapping(value="list", method=RequestMethod.GET)
	public void getList(Model model) throws Exception {
		
		System.out.println("노티스 컨트롤러 겟리스트");
		
		List<NoticeDTO> list = service.getList();
		
		model.addAttribute("list", list);
		
	}
	
	
	//
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public void getDetail(NoticeDTO dto1, Model model) throws Exception {
		
		System.out.println("노티스 컨트롤러 겟디테일");
		
		NoticeDTO dto = service.getDetail(dto1);
		
		model.addAttribute("dto", dto);
		
	}
	
	
	//
	@RequestMapping(value="add", method=RequestMethod.GET)
	public void addGet() throws Exception {
		
		System.out.println("노티스 컨트롤러 애드 겟");
		
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
		
		NoticeDTO dto = service.getDetail(dto1);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", dto);
		mv.setViewName("notice/update");
		
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
