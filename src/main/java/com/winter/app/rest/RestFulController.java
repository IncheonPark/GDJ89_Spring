package com.winter.app.rest;


import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class RestFulController {
	
	
	@RequestMapping("/rest/t1")
	public void f1() throws Exception {
		
		// Server에서 다른 서버로 요청을 보낸다
		
		
		// URL, Method, Parameter, Header값
		RestTemplate restTemplate = new RestTemplate();
		
		// 1. Header 생성
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED); // 둘이 똑같음
		
		// 2. parameter
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", "authorization_code");
		
		// 3. 요청 객체 생성
		HttpEntity<MultiValueMap<String, String>> req = 
				new HttpEntity<MultiValueMap<String,String>>(params, headers);
		
		// 4. 요청 전송 결과 처리
		
		// 1) GET
//		ResponseEntity<String> res = 
//				restTemplate.getForEntity("https://jsonplaceholder.typicode.com/posts/1", String.class, req);
//		
//		String result = res.getBody();
//		
//		System.out.println(result);
		
		JsonDTO res = 
				restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/1", JsonDTO.class, req);
		
		// 2) POST
		restTemplate.postForEntity("url", req, JsonDTO.class);
		
		// 3) GET/POST
		ResponseEntity<JsonDTO> response = restTemplate.exchange("url", HttpMethod.POST, req, JsonDTO.class);
		
		
		// 5. 요청의 결과를 DTO에 담는데 DTO가 여러개 나올 경우
		List<JsonDTO> r = restTemplate.getForObject("url", List.class, req);
		
		
		
		
	}
	
	
	

}
