package kr.co.hucloud.utilities.web;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Minchang
 *
 */
public class UploadUtil {

	private String uploadPath;
	
	public String getUploadPath() {
		return uploadPath;
	}
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	
	private static UploadUtil uploadUtil;
	
	private UploadUtil() {}
	 
	public static UploadUtil getInstance(String uploadPath) {
		if ( uploadUtil == null ) {
			uploadUtil = new UploadUtil();
		}
		
		uploadUtil.setUploadPath(uploadPath);
		
		File path = new File(uploadUtil.getUploadPath());
		if ( !path.exists() ) {
			path.mkdirs();
		}
		
		return uploadUtil;
	}
	
	public void uploadFile(MultipartFile file,
			String originalFileName,
			String displayFileName) {
		
		// 사용자가 파일을 업로드 했다면...
		if ( !file.isEmpty() ) {
			
			File uploadedFile = 
					new File(this.getUploadPath() + File.separator + originalFileName);
			try {
				file.transferTo(uploadedFile);
			}
			catch(IOException ioe) {
				throw new RuntimeException(ioe.getMessage(), ioe);
			}
			
		}
		
	}
	
	public String uploadFileUseUUID(MultipartFile file,
			String displayFileName) {
		
		String originalFileName = "";
		
		// 사용자가 파일을 업로드 했다면...
		if ( !file.isEmpty() ) {
			
			// 서버에 저장될 파일의 명
			originalFileName = 
					UUID.randomUUID().toString();
			
			File uploadedFile = 
					new File(this.getUploadPath() + File.separator + originalFileName);
			try {
				file.transferTo(uploadedFile);
			}
			catch(IOException ioe) {
				throw new RuntimeException(ioe.getMessage(), ioe);
			}
			
		}
		
		return originalFileName;
	}
	
}
