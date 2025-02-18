package com.winter.app.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.winter.app.utils.DBConnection;

// DAO역할의 해당 클래스의 객체를 생성
@Repository
public class ProductDAO {
	
	
	// list
	public List<ProductDTO> getList() throws Exception {
		System.out.println("DAO LIST");
		
		Connection con = DBConnection.getConnection();
		String sql = "SELECT * FROM PRODUCTS";
		
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		List<ProductDTO> ar = new ArrayList<ProductDTO>();
		while(rs.next()) {
			ProductDTO dto = new ProductDTO();
			dto.setProductNum(rs.getLong("PRODUCTNUM"));
			dto.setProductName(rs.getString("PRODUCTNAME"));
			dto.setProductRate(rs.getDouble("PRODUCTRATE"));
			ar.add(dto);
		}
		
		DBConnection.disConnection(st, con);
		return ar;
		
	}
	
	
	// detail
	public ProductDTO getDetail(ProductDTO dto1) throws Exception {
		
		Connection con = DBConnection.getConnection();
		String sql = "SELECT * FROM PRODUCTS WHERE PRODUCTNUM=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, dto1.getProductNum());
		
		ResultSet rs = st.executeQuery();
		
		ProductDTO dto = new ProductDTO();
		
		if(rs.next()) {
			dto.setProductNum(rs.getLong("PRODUCTNUM"));
			dto.setProductName(rs.getString("PRODUCTNAME"));
			dto.setProductRate(rs.getDouble("PRODUCTRATE"));
			dto.setProductDate(rs.getDate("PRODUCTDATE"));
			dto.setProductDetail(rs.getString("PRODUCTDETAIL"));
		}
		
		DBConnection.disConnection(rs, st, con);
		return dto;
		
	}
	
	
	// add
	public int add(ProductDTO dto) throws Exception {
		
		Connection con = DBConnection.getConnection();
		String sql = "INSERT INTO PRODUCTS VALUES (PRODUCTNUM_SEQ.NEXTVAL, ?, ?, SYSDATE+365, ?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, dto.getProductName());
		st.setDouble(2, dto.getProductRate());
		st.setString(3, dto.getProductDetail());
		
		int isDone = st.executeUpdate();
		
		return isDone;
	}
	
	
	
	
	
	
	
	

}
