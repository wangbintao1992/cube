package com.cube.util;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class RedisBeanUtil {
	
	public static List parseBean(List<String> data,Class tarGetClass){
		Gson gson = new Gson();
		List result = new ArrayList();
		for(String str : data){
			result.add(gson.fromJson(str, tarGetClass));
		}
		return result;
	}
	
}
