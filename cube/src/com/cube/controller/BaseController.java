package com.cube.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
/**
 * @ClassName: BaseController
 * @Description: BaseController
 * @author wangbintao
 * @date 2015-10-8
 * @version 1.0
 * @since JDK1.6
 */
public class BaseController {
	
	/**
	 * 直接输出纯字符串
	 */
	public void renderText(HttpServletResponse response, String content) {
		try {
			response.setContentType("text/plain;charset=UTF-8");
			response.getWriter().write(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 直接输出json
	 */
	public void renderJson(HttpServletResponse response, String content) {
		try {
			response.setContentType("text/json;charset=UTF-8");
			response.getWriter().write(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
