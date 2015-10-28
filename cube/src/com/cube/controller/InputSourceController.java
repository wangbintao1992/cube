/**
 * @ClassName:asdsad
 */
package com.cube.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cube.dao.LettersDao;
import com.cube.hadoop.HadoopTask;
import com.cube.util.IOUtil;
import com.cube.util.StringUtil;
import com.google.gson.Gson;

/**
 * @ClassName: InputSourceController
 * @Description: 输入源
 * @author wangbintao
 * @date 2015-10-12
 * @version 1.0
 * @since JDK1.6
 */
@Controller
@RequestMapping("/inputSource")
public class InputSourceController extends BaseController{
	private static final Log log = LogFactory.getLog("blog");
	
    /**
     * @Title:upload
     * @Description: 上传源
     * @param file
     * @throws IOException
     * @return:void
     */
    @RequestMapping(value = "/upload")
    public void upload(@RequestParam("file") MultipartFile file,HttpServletResponse response,HttpServletRequest request) throws IOException {
    	try {
			if(file.getOriginalFilename().endsWith("txt")){
				String uuid = UUID.randomUUID().toString();
				IOUtil.writeData(file.getInputStream(),request,uuid);
				int code = HadoopTask.main(new String[]{uuid});
				if(0 == code){
					Map<String,String> result = new LettersDao().selectOneByid(uuid);
					renderJson(response,new Gson().toJson(result));
				}else{
					renderJson(response,"任务失败！");
				}
			}else{
				renderText(response,"上传文件非法");
			}
		} catch (Exception e) {
			renderText(response,"上传文件非法");
			log.error("InputSourceController upload", e);
		}
    }
    /**
     * @Title:inputText
     * @Description: 输入源
     * @param file
     * @throws IOException
     * @return:void
     */
    @RequestMapping(value = "/inputText")
    public void inputText(@RequestParam("text") String text,HttpServletRequest request,HttpServletResponse response){
    	try {
			text = java.net.URLDecoder.decode(text,"UTF-8");
			String data = StringUtil.prehandle(text);
			BufferedReader br = new BufferedReader(new StringReader(data));
			String uuid = UUID.randomUUID().toString();
			Properties properties = new Properties();
			properties.load(new FileReader(new File(IOUtil.class.getClassLoader().getResource("hadoop.properties").toURI())));
			String inputPath = request.getSession().getServletContext().getRealPath(File.separator) + properties.getProperty("input") + File.separator + uuid;
			IOUtil.wirterDataWithOutpreHandle(br,request,uuid);
			int code = HadoopTask.main(new String[]{uuid,inputPath});
			if(0 == code){
				Map<String,String> result = new LettersDao().selectOneByid(uuid);
				renderJson(response,new Gson().toJson(result));
			}else{
				renderJson(response,"任务失败！");
			}
    	} catch (Exception e) {
    		log.error("InputSourceController inputText", e);
		}
    }
    
    /**
     * @Title:url
     * @Description: 地址源
     * @param text
     * @return:void
     */
    @RequestMapping(value = "/webSite")
    public void url(@RequestParam("url") String url,HttpServletRequest request,HttpServletResponse response){
    	try {
			URL webSite = new URL(url);
			String uuid = UUID.randomUUID().toString();
			IOUtil.writeData(webSite.openStream(),request,uuid);
			Properties properties = new Properties();
			properties.load(new FileReader(new File(IOUtil.class.getClassLoader().getResource("hadoop.properties").toURI())));
			String inputPath = request.getSession().getServletContext().getRealPath(File.separator) + properties.getProperty("input") + File.separator + uuid;
			int code = HadoopTask.main(new String[]{uuid,inputPath});
			if(0 == code){
				Map<String,String> result = new LettersDao().selectOneByid(uuid);
				renderJson(response,new Gson().toJson(result));
			}else{
				renderJson(response,"任务失败！");
			}
		} catch (Exception e) {
			log.error("InputSourceController url 网址打开异常 url =" + url, e);
		}
    }
}
