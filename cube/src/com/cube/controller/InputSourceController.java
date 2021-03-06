package com.cube.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cube.file.FileTask;
import com.cube.mapreduce.MapReduce;
import com.cube.util.IOUtil;
import com.cube.util.PathKit;
import com.cube.util.PropKit;
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
				PropKit.use("hadoop.properties");
				String tmpDir = PathKit.ROOT + PropKit.getProp("input") + File.separator + UUID.randomUUID().toString();
				String inputPath = tmpDir + File.separator + UUID.randomUUID().toString();
				IOUtil.writeData(file.getInputStream(),inputPath,tmpDir);
				MapReduce mp = new MapReduce(inputPath);
				Map<String, Integer> result = mp.start();
				if(result != null){
					renderJson(response,new Gson().toJson(result));
				}else{
					renderJson(response,"任务失败！");
				}
			/*	hadoop调用
			  	int code = HadoopTask.main(new String[]{uuid,inputPath});
				new Thread(new FileTask(inputPath)).start();
				if(0 == code){
					Map<String,String> result = new LettersDao().selectOneByid(uuid);
					renderJson(response,new Gson().toJson(result));
				}else{
					renderJson(response,"任务失败！");
				}*/
			}else{
				renderText(response,"2");
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
			BufferedReader br = new BufferedReader(new StringReader(StringUtil.prehandle(java.net.URLDecoder.decode(text,"UTF-8"))));
			String tmpDir = PathKit.getTmpDir();
			String inputPath = PathKit.getInputPath(tmpDir);
			IOUtil.wirterDataWithOutpreHandle(br,inputPath,tmpDir);
			String data = PathKit.getDataPath(tmpDir);
			//切分
			FileTask fs = new FileTask();
			if(fs.start(inputPath, data)){
				
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
			String uuid = UUID.randomUUID().toString();
			PropKit.use("hadoop.properties");
			String tmpDir = PathKit.ROOT + PropKit.getProp("input") + File.separator + UUID.randomUUID().toString();
			String inputPath = tmpDir + File.separator + UUID.randomUUID().toString();
			IOUtil.writeData(new URL(url).openStream(),inputPath,tmpDir);
			MapReduce mp = new MapReduce(inputPath);
			Map<String, Integer> result = mp.start();
			if(result != null){
				renderJson(response,new Gson().toJson(result));
			}else{
				renderJson(response,"任务失败！");
			}
		} catch (Exception e) {
			log.error("InputSourceController url 网址打开异常 url =" + url, e);
		}
    }
}
