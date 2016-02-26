package com.cube.util;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Writer;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * @ClassName: IOUtil
 * @Description: IO帮助类
 * @author wangbintao
 * @date 2015-10-26
 * @version 1.0
 * @since JDK1.6
 */
public class IOUtil {
	
	private static final Log log = LogFactory.getLog("blog");
	
	public static void writeData(InputStream input,String inputPath,String tmpDir){
		wirterData(new BufferedReader(new InputStreamReader(input)),inputPath,tmpDir);
	}
	/**
	 * @Title:wirterData
	 * @Description: 数据源生成
	 * @param br
	 * @param request
	 * @param uuid
	 * @return:void
	 */
	public static void wirterData(BufferedReader br,String inputPath,String tmpDir){
		try {
			File root = new File(tmpDir);
			if(!root.exists()){
				root.mkdir();
			}
			new File(inputPath).createNewFile();
			Writer writer = new FileWriter(new File(inputPath));
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
	/**
	 * @Title:wirterDataWithOutpreHandle
	 * @Description: 数据源生成
	 * @param br
	 * @param request
	 * @param uuid
	 * @return:void
	 */
	public static void wirterDataWithOutpreHandle(BufferedReader br,String inputPath,String tmpDir){
		try {
			File root = new File(tmpDir);
			if(!root.exists()){
				root.mkdir();
			}
			File dataNode = new File(inputPath);
			dataNode.createNewFile();
			Writer writer = new FileWriter(new File(inputPath));
			String tmp;
			while((tmp = br.readLine()) != null){
				writer.write(tmp);
			}
			br.close();
			writer.close();
		} catch (Exception e) {
			log.error("源数据生成异常", e);
		}finally{
			
		}
	}
	/**
	 * @Title:deleteDirectory
	 * @Description: 删除目录和其下所有文件
	 * @param sPath
	 * @return
	 * @return:boolean
	 */
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
	
	/**
	 * @Title:deleteFile
	 * @Description: 删除单个文件
	 * @param sPath
	 * @return
	 * @return:boolean
	 */
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
	
	public static void copyInputToOutPut(InputStream in,String path){
		try {
			OutputStream out = new BufferedOutputStream(new FileOutputStream(path));
			byte[] buffer = new byte[1024];
			while(in.read(buffer) != -1){
				out.write(buffer);	
			}
			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
