package com.winter.app.products;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.winter.app.SampleTestCase;

public class ProductDAOTest extends SampleTestCase {

	@Autowired
	private ProductDAO productDAO;
	
	@Value("${oracle.user}")
	private String username;
	
	@Test
	public void usernameTest() {
		System.out.println(username);
	}
	
	
	@BeforeClass
	public static void bf() {
		System.out.println("전체 테스트 시작 전");
	}
	
	@AfterClass
	public static void af() {
		System.out.println("전체 테스트 종료 후");
	}
	
	@Before
	public void fe() {
		System.out.println("개별 테스트 실행 전");
	}
	
	@After
	public void ae() {
		System.out.println("개별 테스트 실행 후");
	}
	
	
	
//	@Test
//	public void getDetailTest() throws Exception {
//		System.out.println("getDetail Test");
//		ProductDTO dto = new ProductDTO();
//		dto.setProductNum(1L);
//		
//		dto = productDAO.getDetail(dto);
//		
//		assertNotNull(dto);
//
//	}
	
	
//	@Test
//	public void getListTest() throws Exception {
//		System.out.println("getList Test");
//		List<ProductDTO> list = productDAO.getList();
//		
//		assertNotEquals(0, list.size());
//		
//	}
	
	
	//
//	@Test
//	public void add() throws Exception {
//		
//		ProductDTO dto = new ProductDTO();
//		Calendar ca = Calendar.getInstance();
//		
//		for (int i=0; i<110; i++) {
//			dto.setProductDate(new Date(ca.getTimeInMillis()));
//			dto.setProductDetail("ProductDetail"+i);
//			dto.setProductName("ProductName"+i);
//			
//			double r = Math.random(); // 0.0 ~ 1.0
//			r = r * 100;
//			int ri = (int)r;
//			r = ri/100.0;
//			
//			dto.setProductRate(r);
//			
//			productDAO.add(dto);
//			
//			if(i%10==0) {
//				Thread.sleep(500); //0.5초 동안 지연
//			}
//			
//			System.out.println("Finish");
//		
//			
//		}
//		
//	}
	
	

}
