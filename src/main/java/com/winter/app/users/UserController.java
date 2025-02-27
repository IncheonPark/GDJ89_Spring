package com.winter.app.users;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public ModelAndView joinP(UserDTO dto) throws Exception {
		System.out.println("User 컨트롤러, joinP");
		
		ModelAndView mv = new ModelAndView();
		//유저네임 중복 검증
		int result1 = service.userNameCheck(dto);
		System.out.println("result1 : " + result1);
		if (result1 > 0) {
			
			mv.addObject("message", "아이디가 중복되었습니다");
			mv.setViewName("./users/join");
			
			return mv;
			
		} else {
			// 가입 처리
			int result2 = service.join(dto);
			if (result2 > 0 ) {
				System.out.println("가입 성공");
			} else {
				System.out.println("가입 실패");
			}
			
			mv.setViewName("./users/login");
			return mv;
		}
				
		
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
	
	
}
