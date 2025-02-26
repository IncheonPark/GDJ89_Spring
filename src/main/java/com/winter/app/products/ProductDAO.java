package com.winter.app.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.pages.Pager;


// DAO역할의 해당 클래스의 객체를 생성
@Repository
public class ProductDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.winter.app.products.ProductDAO.";
	
	
	//
	public Long totalCount(Pager pager) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE + "totalCount", pager);
		
	}
	
	
	// list
	public List<ProductDTO> getList(Pager pager) throws Exception {
		System.out.println("DAO LIST");
		
		
		List<ProductDTO> list = sqlSession.selectList(NAMESPACE + "getList", pager);
		return list;
		
	}
	
	
	// detail
	public ProductDTO getDetail(ProductDTO dto1) throws Exception {
		
//		Connection con = DBConnection.getConnection();
//		String sql = "SELECT * FROM PRODUCTS WHERE PRODUCTNUM=?";
//		
//		PreparedStatement st = con.prepareStatement(sql);
//		st.setLong(1, dto1.getProductNum());
//		
//		ResultSet rs = st.executeQuery();
//		
//		ProductDTO dto = new ProductDTO();
//		
//		if(rs.next()) {
//			dto.setProductNum(rs.getLong("PRODUCTNUM"));
//			dto.setProductName(rs.getString("PRODUCTNAME"));
//			dto.setProductRate(rs.getDouble("PRODUCTRATE"));
//			dto.setProductDate(rs.getDate("PRODUCTDATE"));
//			dto.setProductDetail(rs.getString("PRODUCTDETAIL"));
//		}
//		
//		DBConnection.disConnection(rs, st, con);
//		return dto;
		//statement => mapper의 id값
		ProductDTO dto = sqlSession.selectOne(NAMESPACE + "getDetail", dto1);
		return dto;
		
	}
	
	
	// add
	public int add(ProductDTO dto) throws Exception {
		
		
		return sqlSession.insert(NAMESPACE + "add", dto);
	}
	
	
	//
	public int delete(ProductDTO dto) throws Exception {
		
		return sqlSession.delete(NAMESPACE + "delete", dto);
	}
	
	
	//
	public int update(ProductDTO dto) throws Exception {
		
		return sqlSession.update(NAMESPACE + "update", dto);
		
	}
	
	
	
	

}
