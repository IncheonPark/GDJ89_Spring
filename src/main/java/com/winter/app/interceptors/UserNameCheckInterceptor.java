package com.winter.app.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.winter.app.boards.BoardDTO;
import com.winter.app.boards.notice.NoticeDAO;
import com.winter.app.users.UserDTO;

@Component
public class UserNameCheckInterceptor extends HandlerInterceptorAdapter {
	
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	
	
	// DS에서 컨트롤러로 갈 때
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		
			return true;		
	}

	// 컨트롤러에서 DS로 나갈 때
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		UserDTO userDTO = (UserDTO)request.getSession().getAttribute("user");
		
		BoardDTO boardDTO = (BoardDTO)modelAndView.getModel().get("dto");
		
		// 비교한 유저네임이 같지 않을 때 그대로 진행이 되지 않도록 처리한다
		if(!userDTO.getUserName().equals(boardDTO.getUserName())) {
			modelAndView.setViewName("commons/result");
			modelAndView.getModel().put("result", "작성자가 아닙니다");
			modelAndView.getModel().put("path", "./list");
		}
		
	}

	// HTML 렌더링 후 나갈 때
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}
	
	
	
	
	

}

