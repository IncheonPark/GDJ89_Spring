package com.winter.app.users;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	
	@RequestMapping(value="/users/detail", method = RequestMethod.GET)
	public void getDetail() throws Exception {
		
		System.out.println("User, getDetail");
		
	}
	
	
}
