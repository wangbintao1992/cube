/**
 * @ClassName:asdsad
 */
package com.cube.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName: InputSourceController
 * @Description: 输入源
 * @author wangbintao
 * @date 2015-10-12
 * @version 1.0
 * @since JDK1.6
 */
@Controller
@RequestMapping(value = "/inputSource")
public class InputSourceController extends BaseController{
	
    /**
     * @Title:upload
     * @Description: 上传源
     * @param file
     * @throws IOException
     * @return:void
     */
    @RequestMapping(value = "/upload")
    public void upload(@RequestParam("file") MultipartFile file,HttpServletResponse response) throws IOException {
    	//上传输入源
    	byte[] bytes;

        if (!file.isEmpty()) {
             bytes = file.getBytes();
            //store file in storage
        }
        renderText(response, "asd");
        System.out.println(file.getOriginalFilename());
        
    }
    /**
     * @Title:inputText
     * @Description: 输入源
     * @param file
     * @throws IOException
     * @return:void
     */
    @RequestMapping(value = "/inputText")
    public void inputText(@RequestParam("text") String text){
    	//手动输入
    	System.out.println(text);
    }
    
    /**
     * @Title:url
     * @Description: 地址源
     * @param text
     * @return:void
     */
    @RequestMapping(value = "/url")
    public void url(@RequestParam("url") String url){
    	//远程地址
    	System.out.println(url);
    }
}
