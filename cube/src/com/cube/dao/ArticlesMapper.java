package com.cube.dao;

import java.util.List;
import java.util.Map;

import com.cube.pojo.Articles;

public interface ArticlesMapper extends BaseMapper<Articles>{
	
	//根据type获得文章列表
	public List<Articles> seletArticles(Map map);
	
}
