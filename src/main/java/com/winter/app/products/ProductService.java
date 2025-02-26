package com.winter.app.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.pages.Pager;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO dao;
	
	
	
	
	
	// list
	public List<ProductDTO> getList(Pager pager) throws Exception {
		System.out.println("서비스 리스트");
//		Pager pager = new Pager();
//		pager.setPage(page);
		
		Long totalCount = dao.totalCount(pager);
		
		pager.make(totalCount);
		
		pager.makeNum();
		List<ProductDTO> ar = dao.getList(pager);
		
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
	
	
	// delete
	public int delete(ProductDTO dto) throws Exception {
		System.out.println("서비스 딜리트");
		
		return dao.delete(dto);
		
	}
	
	
	// update
	public int update(ProductDTO dto) throws Exception {
		System.out.println("서비스 업데이트");
		
		return dao.update(dto);
		
	}
	
	
	
	
	

}
