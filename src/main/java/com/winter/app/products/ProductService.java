package com.winter.app.products;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.boards.BoardFileDTO;
import com.winter.app.files.FileDTO;
import com.winter.app.files.FileManager;
import com.winter.app.pages.Pager;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO dao;
	
	@Value("${products.file.path}")
	private String path;
	
	
	
	
	
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
	
	
	//
	public void detailFilesDelete(FileDTO fileDTO, HttpSession session) throws Exception {
		String path = session.getServletContext().getRealPath("/resources/images/products/");
		
		FileManager fileManager = new FileManager();
		fileManager.fileDelete(path, fileDTO.getFileName());
		
	}
	
	
	
	//
	public String detailFiles(MultipartFile uploadFile, ServletContext servletContext) throws Exception {
		String path = servletContext.getRealPath("/resources/images/products/");
				
		FileManager fileManager = new FileManager();
		String fileName = fileManager.fileSave(path, uploadFile);
		
		return fileName;
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
	
	//////////////////////////
	// Comments
	public int addComments(CommentsDTO commentsDTO) throws Exception {
		
		return dao.addComments(commentsDTO);
	}
	
	
	//
	public List<CommentsDTO> getCommentList(CommentsDTO commentsDTO, Pager pager) throws Exception {
		
		Long totalCount = dao.totalCount(pager);
		pager.make(totalCount);
		pager.makeNum();		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("comments", commentsDTO);
		map.put("pager", pager);
		
		return dao.getCommentList(map);
	} 
	
	
	//
	public int deleteComments(CommentsDTO commentsDTO) throws Exception {
		
		return dao.deleteComments(commentsDTO);
	}
	
	
	//
	public int updateComments(CommentsDTO commentsDTO) throws Exception {
		
		return dao.updateComments(commentsDTO);
	}
	
	

}
