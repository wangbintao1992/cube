package com.cube.dao;

import java.util.Map;

import com.cube.hadoop.HbaseTemplate;

public class LettersDao {
	
	private HbaseTemplate template = new HbaseTemplate();
	
	public Map<String,String> selectOneByid(String id){
		return template.get("letters", id, null);
	}
}
