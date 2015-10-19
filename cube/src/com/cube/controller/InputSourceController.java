/**
 * @ClassName:asdsad
 */
package com.cube.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cube.util.IOUtil;
import com.cube.util.StringUtil;

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
    	String msg = "上传文件非法";
    	if(file.getOriginalFilename().endsWith("txt")){
    		IOUtil.writeData(file.getInputStream(),request,UUID.randomUUID().toString());
        	msg = "上传成功";
    	}
        renderJson(response,msg);
    }
    /**
     * @Title:inputText
     * @Description: 输入源
     * @param file
     * @throws IOException
     * @return:void
     */
    @RequestMapping(value = "/inputText")
    public void inputText(@RequestParam("text") String text,HttpServletRequest request){
    	try {
			text = java.net.URLDecoder.decode(text,"UTF-8");
			String data = StringUtil.prehandle(text);
			BufferedReader br = new BufferedReader(new StringReader(data));
			IOUtil.wirterDataWithOutpreHandle(br,request,UUID.randomUUID().toString());
			
    	} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    }
    
    /**
     * @Title:url
     * @Description: 地址源
     * @param text
     * @return:void
     */
    @RequestMapping(value = "/webSite")
    public void url(@RequestParam("url") String url,HttpServletRequest request){
    	try {
			URL webSite = new URL(url);
			IOUtil.writeData(webSite.openStream(),request,UUID.randomUUID().toString());
		} catch (Exception e) {
			log.error("网址打开异常 url =" + url, e);
		}
    }
}
