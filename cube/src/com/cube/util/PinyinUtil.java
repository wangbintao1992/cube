package com.cube.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;

public class PinyinUtil {
	
	public static String convertToPinyin(String str) throws Exception{
		HanyuPinyinOutputFormat hanYuPinOutputFormat = new HanyuPinyinOutputFormat();
		hanYuPinOutputFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE); //小写
		hanYuPinOutputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);//无声调
		return PinyinHelper.toHanyuPinyinString(str, hanYuPinOutputFormat, "");
	}
	
}
