package com.winter.app.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

@Component
public class FileDownView extends AbstractView {
	
	
	// down
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 
		/* key 확인용
		 * System.out.println("file down view"); Iterator<String> it =
		 * model.keySet().iterator();
		 * 
		 * while(it.hasNext()) { System.out.println(it.next()); }
		 */
		
		FileDTO fileDTO = (FileDTO)model.get("file");
		String path = (String)model.get("kind");
		
		path = request.getSession().getServletContext().getRealPath("/resources/images/"+path+"/");
				
		File file = new File(path, fileDTO.getFileName());
		
		// 한글 Encoding처리
		response.setCharacterEncoding("UTF-8");
		// filter에서 처리했다면 생략 가능
		
		// 파일의 크기를 클라이언트에게 알려준다
		response.setContentLength((int)file.length());
		
		// 다운 시 파일명을 지정
		String name = fileDTO.getOldName();
		
		// 인코딩 설정
		name = URLEncoder.encode(name, "UTF-8");
		
		// 타입을 헤더에 설정
		response.setHeader("Content-Disposition", "attachment;fileName=\""+name+"\"");
		response.setHeader("Content-transfer-Encoding", "binary");
		
		FileInputStream fi = new FileInputStream(file);
		OutputStream out = response.getOutputStream();
		
		// 읽은 것을 카피해서 보내라
		FileCopyUtils.copy(fi, out);
		
		// 자원 해제
		out.close();
		fi.close();
		
	}
	
	

}
