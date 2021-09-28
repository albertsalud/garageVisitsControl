package com.albertsalud.garage.utils;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.albertsalud.garage.utils.ftp.FTPConnection;
import com.albertsalud.garage.utils.ftp.FTPServices;

import lombok.Getter;

@Component
public class FileUploadService {
	
	@Value("${gvc.ftp.host}")
	private String hostname;
	
	@Value("${gvc.ftp.username}")
	private String username;
	
	@Value("${gvc.ftp.password}")
	private String password;
	
	
	@Getter
	public class FileUploadServiceResult {
		private FileUploadServiceResult(String destinationFolder, String destinationName, 
				MultipartFile file) {
			
			this.destinationFolder = destinationFolder;
			this.destinationName = destinationName;
			this.file = file;
		}
		
		private String destinationFolder;
		private String destinationName;
		private String errorMessage;
		private MultipartFile file;
		private boolean ok;
	}
	
	public FileUploadServiceResult saveFile(String destinationFolder, String destinationName, 
			MultipartFile file) {
		
		FileUploadServiceResult result = new FileUploadServiceResult(destinationFolder, destinationName,
				file);
		
		try {
			FTPServices ftp = new FTPConnection(hostname, username, password);
			result.ok = ftp.uploadFile(destinationFolder, destinationName, file.getInputStream());
			
			ftp.disconnect();
		
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			result.ok = false;
			result.errorMessage = e.getMessage();
		}
		
		return result;
	}

	public FileUploadServiceResult deleteFile(String containingFolder, String fileName) {
		FileUploadServiceResult result = new FileUploadServiceResult(containingFolder, fileName,
				null);
		
		try {
			FTPServices ftp = new FTPConnection(hostname, username, password);
			result.ok = ftp.deleteFile(containingFolder, fileName);
			
			ftp.disconnect();
		
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			result.ok = false;
			result.errorMessage = e.getMessage();
		}
		
		return result;
		
	}

}
