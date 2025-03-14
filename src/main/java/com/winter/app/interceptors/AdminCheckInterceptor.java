package com.winter.app.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class AdminCheckInterceptor extends HandlerInterceptorAdapter {
	
	
	
	
	// DS에서 컨트롤러로 갈 때
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// TODO Auto-generated method stub
		
		// return이 true라면 Controller로 진행
		// return이 false라면 Controller로 진행 X
		System.out.println("preHandle");
		Object user = request.getSession().getAttribute("user");
		if(user != null) {
			return true;
		}
		
		// redirect
		//response.sendRedirect("/users/login");
		
		// forward
		request.setAttribute("result", "로그인이 필요합니다");
		request.setAttribute("path", "/users/login");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/commons/result.jsp");
		view.forward(request, response);
		
		return false;
	}

	// 컨트롤러에서 DS로 나갈 때
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	// HTML 렌더링 후 나갈 때
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}
	
	
	
	
	

}
