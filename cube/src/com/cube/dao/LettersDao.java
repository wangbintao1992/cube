package com.cube.dao;

import java.util.Map;

import com.cube.hadoop.HbaseTemplate;
import com.cube.pojo.Letters;

public class LettersDao {
	
	private HbaseTemplate template = new HbaseTemplate();
	
	public Letters selectOneByid(String id){
		Map<String, String> map = template.get("letters", id, null);
		
		return null;
	}
}
