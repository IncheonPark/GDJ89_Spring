package com.winter.app.accounts;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.winter.app.users.UserDTO;

@Service
public class AccountService {
	
	@Autowired
	private AccountDAO accountDAO;
	
	
	
	
	//
	@RequestMapping(value="add", method=RequestMethod.GET)
	public int add(Long[] nums, UserDTO userDTO) throws Exception {
		List<AccountDTO> list = new ArrayList<AccountDTO>();
		
		for(Long l : nums) {
			AccountDTO accountDTO = new AccountDTO();
			accountDTO.setProductNum(l);
			accountDTO.setUserNama(userDTO.getUserName());
			
			Calendar ca = Calendar.getInstance();
			accountDTO.setAccountNum(String.valueOf(ca.getTimeInMillis()));
			list.add(accountDTO);
			Thread.sleep(10);
			
			
		}
		int result = accountDAO.add(list);
		
		if(result > 0) {
			
		}
		
		return result;
	}
	
	
	
	
	

}
