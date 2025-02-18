package com.winter.app.products;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/products/*")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	
	
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String getList() throws Exception {
		
		System.out.println("Product List");
		service.getList();
		
		return "products/list";
				
	}
	
	
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String getDetail() throws Exception {
		
		System.out.println("Product Detail");
		
		return "products/detail";
				
	}
	
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() throws Exception {
		
		System.out.println("프로덕트 추가 메서드");
		
		return "products/add";
		
	}
	
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
//	public String add(HttpServletRequest request) throws Exception {
	public String add(ProductDTO dto) throws Exception {
		
		System.out.println("프로덕트 추가 메서드");
		
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
		
		System.out.println(dto.getProductName());
		System.out.println(dto.getProductRate());
		
		return "products/add";
		
	}
	
	
	
	
	

}
