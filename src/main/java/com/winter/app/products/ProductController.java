package com.winter.app.products;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.winter.app.boards.CommentDTO;
import com.winter.app.pages.Pager;
import com.winter.app.users.UserDTO;

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
	public void getList(Model model, Pager pager) throws Exception {
		//@RequestParam(value="p", defaultValue="1", required=false) Long page) throws Exception {
		
		System.out.println("Product List");
		List<ProductDTO> ar = service.getList(pager);
		
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		//return "products/list";
				
	}
	
	
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView getDetail(Model model, ProductDTO dto) throws Exception {
		
		System.out.println("Product Detail");
		
		ProductDTO dto2 = service.getDetail(dto);
		
		ModelAndView mv = new ModelAndView();
		//model
		mv.addObject("dto", dto2);
		
		//view
		mv.setViewName("products/detail");
		return mv;
				
	}
	
	
	//
	@RequestMapping(value = "detailFiles", method = RequestMethod.POST)
	public String detailFiles(MultipartFile uploadFile, HttpSession session, Model model) throws Exception {
		
		System.out.println("fileNameBefore : " + uploadFile.getOriginalFilename());
		
		String fileName = service.detailFiles(uploadFile, session.getServletContext());
		
		System.out.println("fileNameAfter : " + fileName);
		
		fileName = "/resources/images/products/"+fileName;
		model.addAttribute("result", fileName);
		
		return "commons/ajaxResult";
	}
	
	
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(ModelAndView mv) throws Exception {
		
		System.out.println("Product add 메서드 GET");
		
//		return mv;
		return "products/add";
		
	}
	
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
//	public String add(HttpServletRequest request) throws Exception {
	public String add(ProductDTO dto) throws Exception {
		
		System.out.println("Product add 메서드 POST");
		
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
		
		if (result > 0) {
			System.out.println("입력 성공");
		} else {
			System.out.println("입력 실패");
		}
		
		return "redirect:./list";
				
	}
	
	
	//
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(ProductDTO dto) throws Exception {
		System.out.println("Product delete 메서드");
		int result = service.delete(dto);
		
		if (result > 0) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
		
		return "redirect:./list";
	}
	
	
	//
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView update(Model model, ProductDTO dto) throws Exception {
		
		System.out.println("Product update 메서드 GET");
		
		ProductDTO dto2 = service.getDetail(dto);
		
		ModelAndView mv = new ModelAndView();
		//model
		mv.addObject("dto", dto2);
		
		//view
		mv.setViewName("products/update");
		return mv;
		
	}
	
	
	//
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update(ProductDTO dto) throws Exception {
		
		System.out.println("Product update 메서드 POST");
		
		int result = service.update(dto);
		
		if (result > 0) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}
		
		
		ModelAndView mv = new ModelAndView();
		
//		List<ProductDTO> ar = new ArrayList<ProductDTO>();
//		ar.add(dto);
//		mv.addObject("list", ar);
		
		mv.setViewName("redirect:./list");
//		mv.setViewName("products/list");
		
		return mv;
		
	}
	
	
	///////////////////
	// add Comments
	@RequestMapping(value = "addComments", method = RequestMethod.POST)
	public String addComments(CommentsDTO commentsDTO, HttpSession session, Model model) throws Exception {
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		commentsDTO.setUserName(userDTO.getUserName());
		
		System.out.println(commentsDTO.getUserName());
		System.out.println(commentsDTO.getBoardContent());
		System.out.println(commentsDTO.getProductNum());
		
		int result = service.addComments(commentsDTO);
		
		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
	}
	
	
	//
	@RequestMapping(value = "deleteComments", method = RequestMethod.POST)
	public String deleteComments(CommentsDTO commentsDTO, HttpSession session, Model model) throws Exception {
//		UserDTO userDTO = (UserDTO)session.getAttribute("user");
//		commentsDTO.setUserName(userDTO.getUserName());
		
		int result = service.deleteComments(commentsDTO);
		
		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
	}
	
	
	//
	@RequestMapping(value = "updateComments", method = RequestMethod.POST)
	public String updateComments(CommentsDTO commentsDTO, HttpSession session, Model model) throws Exception {
//		UserDTO userDTO = (UserDTO)session.getAttribute("user");
//		commentsDTO.setUserName(userDTO.getUserName());
		
		int result = service.updateComments(commentsDTO);
		
		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
	}
	
	
	// list Comments
	@RequestMapping(value = "listComments", method = RequestMethod.GET)
	public String getCommentsList(CommentsDTO commentsDTO, Pager pager, Model model) throws Exception {
		
		System.out.println("comments list");
		
		List<CommentsDTO> ar = service.getCommentList(commentsDTO, pager);
		model.addAttribute("list", ar);
		//이미 모델에 있으므로 생략. model.addAttribute("pager", pager);
		
		return "commons/commentsList";
		
	}
	
	
	
	
	
	
	
	
	

}
