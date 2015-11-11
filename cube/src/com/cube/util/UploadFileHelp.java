package com.cube.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName: UploadFileHelp
 * @Description: 上传文件help
 * @author wangbintao
 * @date 2015-11-11
 * @version 1.0
 * @since JDK1.6
 */
public class UploadFileHelp {
	
	private String fileName = "default.jpg";
	
	private MultipartFile file;
	
	private String localPath;
	
	private String url;
	
	private HttpServletRequest request;
	
	private static String UPLOAD_DIR = "uploadImg";
	

	public void writeDataToLocal(){
		try {
			IOUtil.copyInputToOutPut(this.file.getInputStream(), localPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public UploadFileHelp(MultipartFile file,HttpServletRequest request){
		this.file = file;
		this.request = request;
		if(this.file != null){
			setFileName(file.getOriginalFilename());
		}
		setLocalPath(request);
		setUrl(request);
	} 
	public UploadFileHelp(HttpServletRequest request){
		this.request = request;
		setLocalPath(request);
		setUrl(request);
	} 
	
	private void setFileName(String name){
		String suffix = name.substring(name.lastIndexOf("."));
		this.fileName = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss-SSS").format(new Date()) + suffix;
	}
	
	private void setLocalPath(HttpServletRequest request){
		String realPath = request.getSession().getServletContext().getRealPath(File.separator);
		String imgPath = realPath + UPLOAD_DIR;
		this.localPath = imgPath + File.separator + this.fileName;
	}
	public void rollBack(){
		File f = new File(this.localPath);
		if(!f.exists()){
			f.delete();
		}
	}
	private void setUrl(HttpServletRequest request){
		this.url = request.getContextPath() + File.separator + UPLOAD_DIR + File.separator + this.fileName;
	}
	public String getFileName() {
		return fileName;
	}
	public String getLocalPath() {
		return localPath;
	}
	public String getUrl() {
		return url;
	}
}
