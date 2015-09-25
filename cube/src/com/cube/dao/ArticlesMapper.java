package com.cube.dao;

import java.util.List;
import java.util.Map;

import com.cube.pojo.Articles;

public interface ArticlesMapper extends BaseMapper<Articles>{
	
	public List<Articles> seletArticles(Map map);
	
}
