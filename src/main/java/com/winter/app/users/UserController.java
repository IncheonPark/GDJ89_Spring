package com.winter.app.users;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.winter.app.boards.notice.NoticeDTO;

@Controller
@RequestMapping(value="/users/*")
public class UserController {
	
	@Autowired
	private UserService service;
	
	
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public void loginG() throws Exception {
		
		System.out.println("User 컨트롤러, loginG");
	}
	
	
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String loginP(UserDTO dto, HttpSession session, Model model) throws Exception {
		
		dto = service.login(dto);
		if(dto != null) {
			session.setAttribute("user", dto);
			return "redirect:../";
			
		} else {
			model.addAttribute("result", "로그인 실패");
			model.addAttribute("path", "./login");
			return "commons/result";
			
		}
		
	}
	
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		
		System.out.println("유저 컨트롤러 로그아웃");
		session.invalidate();
		return "redirect:../";
		
	}
	
	
	
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public ModelAndView detail(UserDTO dto) throws Exception {
		
		System.out.println("유저 컨트롤러, detail");
		
		// 1. Session에 user정보
		
		
		// 2. 유저 정보를 다시 조회해서 jsp로 보내는 방법
		
		
		
		
		ModelAndView mv = new ModelAndView();
		dto = service.getDetail(dto);
		
		mv.addObject("dto", dto);
		mv.setViewName("./users/detail");
		
		return mv;
		
	}
	
	
	
	@RequestMapping(value="join", method = RequestMethod.GET)
	public void joinG(ModelAndView mv, UserDTO dto) throws Exception {
		
		System.out.println("User 컨트롤러, joinG");
		
	}
	
	
	
	@RequestMapping(value="join", method = RequestMethod.POST)
	public String join(UserDTO userDTO, MultipartFile profile, HttpSession session)throws Exception{
		System.out.println(profile.getContentType());
		System.out.println(profile.getName());
		System.out.println(profile.getOriginalFilename());
		System.out.println(profile.getSize());
		System.out.println(profile.isEmpty());
		System.out.println(session.getServletContext());
		
		int result = service.join(userDTO, profile, session.getServletContext());
		return "redirect:/";
	}
	
	
	//
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public ModelAndView delete(UserDTO dto1, HttpSession session) throws Exception {
		
		System.out.println("유저 컨트롤러 딜리트");
		
		int result = service.delete(dto1);
		if(result > 0) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
		
		session.invalidate();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", "회원 탈퇴 완료");
		mv.addObject("path", "/");
		mv.setViewName("commons/result");
		
		return mv;		
	}
	
	
	@RequestMapping(value="update", method=RequestMethod.GET)
	public ModelAndView updateG(HttpSession session){
		
		System.out.println("유저 컨트롤러 업데이트");
		
		UserDTO dto = new UserDTO();
		Object obj = session.getAttribute("user");
		dto = (UserDTO)obj;
		dto = service.getDetail(dto);
		
		ModelAndView mv = new ModelAndView();		
		mv.addObject("dto", dto);
		mv.setViewName("./users/update");
		
		return mv;
	}
	
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ModelAndView updateP(HttpSession session) throws Exception {
		
		System.out.println("유저 컨트롤러 업데이트");
		
		UserDTO dto = new UserDTO();
		Object obj = session.getAttribute("user");
		dto = (UserDTO)obj;
		
		int result = service.update(dto);
		if(result > 0) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", "회원 수정 완료");
		mv.addObject("path", "./detail?userName="+dto.getUserName());
		mv.setViewName("commons/result");
		
		return mv;
	}
	
	
	
	
	
}
