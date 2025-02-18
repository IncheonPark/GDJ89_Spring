package com.winter.app.products;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/products/*")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	
	/*
	 * Model -> requestScope와 라이프 사이클이 비슷하다
	 * 응답이 발생하면 소멸
	 * request와 비슷한 일을 함
	 * java -> jsp로 데이터를 전달할 때 사용
	 *  
	 * 
	 * */
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String getList(Model model) throws Exception {
		
		System.out.println("Product List");
		List<ProductDTO> ar = service.getList();
		
		model.addAttribute("list", ar);
		return "products/list";
				
	}
	
	
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String getDetail(Model model, ProductDTO dto) throws Exception {
		
		System.out.println("Product Detail");
		
		ProductDTO dto2 = service.getDetail(dto);
		
		model.addAttribute("dto", dto2);
		return "products/detail";
				
	}
	
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() throws Exception {
		
		System.out.println("프로덕트 추가 메서드 GET");
		
		return "products/add";
		
	}
	
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
//	public String add(HttpServletRequest request) throws Exception {
	public String add(ProductDTO dto) throws Exception {
		
		System.out.println("프로덕트 추가 메서드 POST");
		
		/* 파라미터 처리 방법
		 * 1. 모든 요청 정보는 Request에 있다. (URL, METHOD, PARAMETER, COOKIE 등)
		 * 메서드의 매개변수로 HttpServletRequest request 선언, 전통적 방법
		 * request.getParameter("");
		 * 
		 * 2. 매개변수로 파라미터 이름과 동일한 변수명, 동일한 타입으로 선언 
		 * 
		 * 3. 매개변수로 DTO를 선언
		 * 		파라미터의 이름과 타입이 DTO의 Setter의 이름과 동일
		 * 
		 * */
//		String name = request.getParameter("productName");
//		double rate = Double.parseDouble(request.getParameter("productRate"));
//		System.out.println(name);
//		System.out.println(rate);
		
		int result = service.add(dto);
		
		return "redirect:./list";
		
	}
	
	
	
	
	

}
