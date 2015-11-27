package com.cube.util;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

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
	 * @Descript 鍙傛暟闆嗘槸鍚︿负绌猴紝绌鸿繑鍥瀟rue
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
	 * @Description: 棰勫鐞�
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
	 * @Description: 杩囨护闄ゅ瓧姣嶅
	 * @param data
	 * @return
	 * @return:String
	 */
	public static String filterLetter(String data){
		return data.replaceAll("[^a-zA-Z]", "");
	}
	
	/**
	 * @Title:filterPinyin
	 * @Description: 杞崲涓枃鍒版嫾闊�
	 * @param data
	 * @return:String
	 */
	public static String filterPinyin(String data){
		try {
			data = data.replaceAll("[^\u4e00-\u9fa5]", "");
			return PinyinUtil.convertToPinyin(data);
		} catch (Exception e) {
			log.error("鎷奸煶杞崲寮傚父", e);
		}
		return null;
	}
	
	public static String getIpAddr(HttpServletRequest request) { 
	    String ip = request.getHeader("x-forwarded-for"); 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("Proxy-Client-IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){ 
	        ip = request.getHeader("WL-Proxy-Client-IP");
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getRemoteAddr(); 
	    }
	    return ip; 
	}
	
	public static String Html2Text(String inputString) {
        String htmlStr = inputString; // 鍚玥tml鏍囩鐨勫瓧绗︿覆
        String textStr = "";
        java.util.regex.Pattern p_script;
        java.util.regex.Matcher m_script;
        java.util.regex.Pattern p_style;
        java.util.regex.Matcher m_style;
        java.util.regex.Pattern p_html;
        java.util.regex.Matcher m_html;
 
        try {
            String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 瀹氫箟script鐨勬鍒欒〃杈惧紡{鎴�<script[^>]*?>[\\s\\S]*?<\\/script>
                                                                                                        // }
            String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 瀹氫箟style鐨勬鍒欒〃杈惧紡{鎴�<style[^>]*?>[\\s\\S]*?<\\/style>
                                                                                                    // }
            String regEx_html = "<[^>]+>"; // 瀹氫箟HTML鏍囩鐨勬鍒欒〃杈惧紡
         
            
            p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
            m_script = p_script.matcher(htmlStr);
            htmlStr = m_script.replaceAll(""); // 杩囨护script鏍囩
 
            p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
            m_style = p_style.matcher(htmlStr);
            htmlStr = m_style.replaceAll(""); // 杩囨护style鏍囩
 
            p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(htmlStr);
            htmlStr = m_html.replaceAll(""); // 杩囨护html鏍囩
 
            textStr = htmlStr;
            
            textStr = textStr.replace("&nbsp;", "").replace("&gt;", "").replace("&lt;", "");
    
        } catch (Exception e) {
            System.err.println("Html2Text: " + e.getMessage());
        }
 
        return textStr;// 杩斿洖鏂囨湰瀛楃涓�
    }
}
