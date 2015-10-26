package com.cube.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
/**
 * @ClassName: PinyinUtil
 * @Description: 分词
 * @author wangbintao
 * @date 2015-10-26
 * @version 1.0
 * @since JDK1.6
 */
public class PinyinUtil {
	/**
	 * @Title:convertToPinyin
	 * @Description: 转换成拼音 小写，无声调
	 * @param str
	 * @return
	 * @throws Exception
	 * @return:String
	 */
	public static String convertToPinyin(String str) throws Exception{
		HanyuPinyinOutputFormat hanYuPinOutputFormat = new HanyuPinyinOutputFormat();
		hanYuPinOutputFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE); //小写
		hanYuPinOutputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);//无声调
		return PinyinHelper.toHanyuPinyinString(str, hanYuPinOutputFormat, "");
	}
	
}
