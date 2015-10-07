package com.cube.util;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {
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
}
