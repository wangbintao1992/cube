package com.cube.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class StringUtil {
	
	private static final Log log = LogFactory.getLog("blog");
	
	/**
	 * @Descript 参数集是否为空，空返回true
	 * @param params
	 * @return
	 */
	public static boolean checkIsEmpty(String ...params){
		for(String param : params){
			if(StringUtils.isBlank(param)){
				return true;
			}
		}
		return false;
	}
	
	public static String prehandle(String data){
		String pinyin = filterPinyin(data);
		StringBuffer sb = new StringBuffer();
		pinyin = filterLetter(pinyin);
		if(StringUtils.isNotBlank(pinyin)){
			sb.append(pinyin.toLowerCase());
		}
		sb.append(filterLetter(data));
		return sb.toString().toLowerCase();
	}
	
	public static String filterLetter(String data){
		return data.replaceAll("[^a-zA-Z]", "");
	}
	
	public static String filterPinyin(String data){
		try {
			data = data.replaceAll("[^\u4e00-\u9fa5]", "");
			return PinyinUtil.convertToPinyin(data);
		} catch (Exception e) {
			log.error("拼音转换异常", e);
		}
		return null;
	}
}
