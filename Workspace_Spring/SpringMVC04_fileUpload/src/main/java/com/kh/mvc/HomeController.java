package com.kh.mvc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.kh.mvc.validate.FileValidator;
import com.kh.mvc.validate.UploadFile;

@Controller
public class HomeController {
	
	@Autowired
	private FileValidator fileValidator;

	@RequestMapping(value="/form")
	public String getUploadForm() {
		
		return "uploadForm";
	}
	
	@RequestMapping(value="/upload")
	public String fileUpload(HttpServletRequest request, Model model, 
			UploadFile uploadFile, BindingResult result) {
		
		// BindingResult : 객체를 Binding하다가 발생하는 errors의 정보를 받아준다.
		fileValidator.validate(uploadFile, result);
		if(result.hasErrors()) { //에러가 있으면 파일 업로드 화면으로 이동.
			return "uploadForm";
		}
		
		// 임시 저장소
		MultipartFile file = uploadFile.getFile();
		String filename = file.getOriginalFilename();
		
		UploadFile fileobj = new UploadFile();
		// 원본 파일 이름으로 파일 이름을 set
		fileobj.setFilename(filename);
		fileobj.setDesc(uploadFile.getDesc());
		
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		try {
			inputStream = file.getInputStream();
			// 실제 경로를 가져옴
			String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/storage");
			
			System.out.println("업로드 될 실제 경로 : " + path);
			
			File storage = new File(path);
			if(!storage.exists()) {
				storage.mkdirs(); // 폴더 생성.
			}
			
			// 경로에 파일 이름 붙여서 파일 생성.
			File newfile = new File(path + "/" + filename);
			
			if(!newfile.exists()) {
				newfile.createNewFile();
			}
			
			outputStream = new FileOutputStream(newfile);
			
			int read = 0;
			// 원본 파일의 사이즈만큼 바이트 배열 생성
			byte[] b = new byte[(int)file.getSize()];
			
			while((read=inputStream.read(b)) != -1) {
				outputStream.write(b, 0, read);
			}
			
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		model.addAttribute("fileobj", fileobj);
		
		return "uploadFile";
	}
	
	@RequestMapping(value="/download")
	@ResponseBody
	public byte[] fileDown(HttpServletRequest request, 
			HttpServletResponse response, String filename) throws IOException {
		
		// 폴더안에 파일이름 갖고와서 파일 복사해서 복사된 파일을 응답.
		String path = WebUtils.getRealPath(
				request.getSession().getServletContext(), "/storage");
		File file = new File(path + "/" + filename);
		
		// 주어진 파일을 새로운 바이트 배열로 내용을 복사함.
		byte[] bytes = FileCopyUtils.copyToByteArray(file);
		// 8859_1 : 한글 인코딩 한거임.
		String fn = new String(file.getName().getBytes(),"8859_1");
		
		response.setHeader("Content-Disposition", 
				"attachment;filename=\""+fn+"\"");
		response.setContentLength(bytes.length);
		response.setContentType("image/jpeg");
		
		return bytes;
	}
}







