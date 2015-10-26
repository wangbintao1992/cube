package com.cube.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * @ClassName: StringUtil
 * @Description: StringUtil
 * @author wangbintao
 * @date 2015-10-26
 * @version 1.0
 * @since JDK1.6
 */
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
	
	/**
	 * @Title:prehandle
	 * @Description: 预处理
	 * @param data
	 * @return
	 * @return:String
	 */
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
	
	/**
	 * @Title:filterLetter
	 * @Description: 过滤除字母外
	 * @param data
	 * @return
	 * @return:String
	 */
	public static String filterLetter(String data){
		return data.replaceAll("[^a-zA-Z]", "");
	}
	
	/**
	 * @Title:filterPinyin
	 * @Description: 转换中文到拼音
	 * @param data
	 * @return:String
	 */
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
