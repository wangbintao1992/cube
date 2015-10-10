package com.cube.dao;

import java.util.List;
import java.util.Map;

import com.cube.pojo.Articles;
/**
 * @ClassName: ArticlesMapper
 * @Description: ArticlesDao
 * @author wangbintao
 * @date 2015-10-8
 * @version 1.0
 * @since JDK1.6
 */
public interface ArticlesMapper extends BaseMapper<Articles>{
	
	//根据type获得文章列表
	public List<Articles> seletArticles(Map map);
	//分页总数量
	public int selectTotalCount(Map map);
}
