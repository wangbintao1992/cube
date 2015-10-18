package com.cube.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IOUtil {
	
	private static final Log log = LogFactory.getLog("blog");
	
	public static void writeData(InputStream input){
		wirterData(new BufferedReader(new InputStreamReader(input)));
	}
	
	public static void wirterData(BufferedReader br){
		try {
			Properties properties = new Properties();
			//路径待定
			properties.load(new FileReader(new File("/hadoop.properties")));
			Writer writer = new FileWriter(new File(properties.getProperty("input")));
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
	
	public static void wirterDataWithOutpreHandle(BufferedReader br){
		try {
			Properties properties = new Properties();
			properties.load(new FileReader(new File("/hadoop.properties")));
			Writer writer = new FileWriter(new File(properties.getProperty("input")));
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
	
}
