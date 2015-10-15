/**
 * @ClassName:asdsad
 */
package com.cube.util;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sun.org.apache.commons.collections.HashBag;

/**
 * @ClassName: inputSourceUtil
 * @Description: TODO
 * @author wangbintao
 * @date 2015-10-15
 * @version 1.0
 * @since JDK1.6
 */
public class inputSourceUtil {
	
	private static final Log log = LogFactory.getLog("blog");
	
	public static HashBag getUrlInputSource(String url){
		try {
			InputStream input = new URL(url).openStream();
			BufferedInputStream bis = new BufferedInputStream(input);
			byte[] b = new byte[1024];
			HashBag bag = new HashBag();
			while((bis.read(b)) != -1){
				String data = new String(b,"UTF-8");
				data = data.replaceAll("[^a-z^A-Z^0-9]", "");
				for(String str : data.split("")){
					if(str != ""){
						bag.add(str);
					}
				}
			}
			return bag;
		}catch (Exception e) {
			log.error("getUrlInputSource exception", e);
		}
		return null;
	}
}
