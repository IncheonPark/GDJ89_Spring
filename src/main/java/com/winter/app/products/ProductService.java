package com.winter.app.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO dao;
	
	
	
	
	
	// list
	public void getList() throws Exception {
		System.out.println("Service 리스트");
		dao.getList();
		
	}
	
	

}
