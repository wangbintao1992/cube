package com.cube.dao;

import java.util.List;

import com.cube.pojo.Articles;

public interface ArticlesMapper extends BaseMapper<Articles>{
	
	public List<Articles> seletArticles();
	
}
