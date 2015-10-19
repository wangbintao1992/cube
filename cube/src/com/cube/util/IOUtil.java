package com.cube.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IOUtil {
	
	private static final Log log = LogFactory.getLog("blog");
	
	public static void writeData(InputStream input,HttpServletRequest request,String uuid){
		wirterData(new BufferedReader(new InputStreamReader(input)),request,uuid);
	}
	
	public static void wirterData(BufferedReader br,HttpServletRequest request,String uuid){
		try {
			Properties properties = new Properties();
			properties.load(new FileReader(new File(IOUtil.class.getClassLoader().getResource("hadoop.properties").toURI())));
			String inputPath = request.getSession().getServletContext().getRealPath(File.separator) + properties.getProperty("input");
			File root = new File(inputPath);
			if(!root.exists()){
				root.mkdir();
			}
			String diffPath = inputPath + File.separator + uuid;
			File diff = new File(diffPath);
			diff.mkdir();
			Writer writer = new FileWriter(new File(diffPath + File.separator + "data"));
			String tmp;
			while((tmp = br.readLine()) != null){
				writer.write(StringUtil.prehandle(tmp));
			}
			br.close();
			writer.close();
		} catch (Exception e) {
			log.error("源数据生成异常", e);
		}
	}
	
	public static void wirterDataWithOutpreHandle(BufferedReader br,HttpServletRequest request,String uuid){
		try {
			Properties properties = new Properties();
			properties.load(new FileReader(new File(IOUtil.class.getClassLoader().getResource("hadoop.properties").toURI())));
			String inputPath = request.getSession().getServletContext().getRealPath(File.separator) + properties.getProperty("input");
			File root = new File(inputPath);
			if(!root.exists()){
				root.mkdir();
			}
			String diffPath = inputPath + File.separator + uuid;
			File diff = new File(diffPath);
			diff.mkdir();
			Writer writer = new FileWriter(new File(diffPath + File.separator + "data"));
			String tmp;
			while((tmp = br.readLine()) != null){
				writer.write(tmp);
			}
			br.close();
			writer.close();
		} catch (Exception e) {
			log.error("源数据生成异常", e);
		}
	}
	public static boolean deleteDirectory(String sPath) {  
	    //如果sPath不以文件分隔符结尾，自动添加文件分隔符  
	    if (!sPath.endsWith(File.separator)) {  
	        sPath = sPath + File.separator;  
	    }  
	    File dirFile = new File(sPath);  
	    //如果dir对应的文件不存在，或者不是一个目录，则退出  
	    if (!dirFile.exists() || !dirFile.isDirectory()) {  
	        return false;  
	    }  
	    boolean flag = true;  
	    //删除文件夹下的所有文件(包括子目录)  
	    File[] files = dirFile.listFiles();  
	    for (int i = 0; i < files.length; i++) {  
	        //删除子文件  
	        if (files[i].isFile()) {  
	            flag = deleteFile(files[i].getAbsolutePath());  
	            if (!flag) break;  
	        } //删除子目录  
	        else {  
	            flag = deleteDirectory(files[i].getAbsolutePath());  
	            if (!flag) break;  
	        }  
	    }  
	    if (!flag) return false;  
	    //删除当前目录  
	    if (dirFile.delete()) {  
	        return true;  
	    } else {  
	        return false;  
	    }  
	}
	
	public static boolean deleteFile(String sPath) {  
	    boolean flag = false;  
	    File file = new File(sPath);  
	    // 路径为文件且不为空则进行删除  
	    if (file.isFile() && file.exists()) {  
	        file.delete();  
	        flag = true;  
	    }  
	    return flag;  
	} 
}
