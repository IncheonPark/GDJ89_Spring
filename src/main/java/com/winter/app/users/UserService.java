package com.winter.app.users;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.boards.notice.NoticeDTO;

@Service
public class UserService {
	
	@Autowired
	private UserDAO dao;
	
	
	// login
	public UserDTO login(UserDTO dto) {
		
		System.out.println("유저 서비스 로그인");
		return dao.login(dto);
		
	}
	
	
	
	// getDetail
	public UserDTO getDetail(UserDTO dto) {
		
		System.out.println("유저 서비스 getDetail");
		System.out.println("유저네임"+dto.getUserName());
		return dao.getDetail(dto);
		
	}
	
	
	
	// userNameCheck
	public int userNameCheck(UserDTO dto) {
		
		System.out.println("유저 Service userNameCheck");
		return dao.userNameCheck(dto);
		
	}
	
	
	// join
	public int join(UserDTO userDTO, MultipartFile profile, ServletContext context)throws Exception{
		int result = dao.join(userDTO);
		
		if(profile.isEmpty()) {
			return result;
		}
		
		//1. 어디에 저장 할 것인가??
		
		String path = context.getRealPath("/resources/images/profiles/");
		System.out.println(path);
		
		File file = new File(path);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//2. 어떤파일을 어떤이름으로 저장??
		//   1)시간
//		Calendar ca = Calendar.getInstance();
//		long mil = ca.getTimeInMillis();//1234567
//		String f = profile.getOriginalFilename();
//		f = f.substring(f.lastIndexOf("."));
//		f = mil+f;
		
		//	2) 객체 사용
		String f = UUID.randomUUID().toString();
		f = f+"_"+profile.getOriginalFilename();
		
		
		
		//3. HDD에 저장
		//1) transferTo
		file = new File(file, f);
//		profile.transferTo(file);
		
		//2) FileCopyUtils
		FileCopyUtils.copy(profile.getBytes(), file);
		
		
		UserFileDTO userFileDTO = new UserFileDTO();
		userFileDTO.setUserName(userDTO.getUserName());
		userFileDTO.setFileName(f);
		userFileDTO.setOldName(profile.getOriginalFilename());
		result= dao.upload(userFileDTO);
		
		return result;
	}
	
	
	//
	public int update(UserDTO dto) throws Exception {
		
		System.out.println("유저 서비스 업데이트 ");
		
		int result = dao.update(dto);
		
		return result;
	}
	
	
	//
	public int delete(UserDTO dto1) throws Exception {
		
		System.out.println("유저 서비스 딜리트 ");
		
		int result = dao.delete(dto1);
		
		return result;
	}
	

	//
	
	
	
	
	
	
	
	
	
	
	

}
