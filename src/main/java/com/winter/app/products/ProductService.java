package com.winter.app.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO dao;
	
	
	
	
	
	// list
	public List<ProductDTO> getList() throws Exception {
		System.out.println("Service 리스트");
		List<ProductDTO> ar = dao.getList();
		
		return ar;
		
	}
	
	
	// detail
	public ProductDTO getDetail(ProductDTO dto1) throws Exception {
		System.out.println("서비스 디테일");
		ProductDTO dto = dao.getDetail(dto1);
		
		return dto;
		
	}
	
	
	// add
	public int add(ProductDTO dto) throws Exception {
		System.out.println("서비스 애드");
		int isDone = dao.add(dto);
				
		return isDone;
		
	}
	
	

}
