package com.winter.app.products;

import java.util.List;

import org.springframework.stereotype.Repository;

// DAO역할의 해당 클래스의 객체를 생성
@Repository
public class ProductDAO {
	
	
	// list
	public List<ProductDTO> getList() throws Exception {
		System.out.println("DAO LIST");
		
		
		
		return null;
		
	}
	
	

}
