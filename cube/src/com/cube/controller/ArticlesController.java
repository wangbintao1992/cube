package com.cube.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cube.dao.ArticlesMapper;
import com.cube.pojo.Articles;
import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;

@Controller
public class ArticlesController extends BaseController{
	
	@Resource
	private ArticlesMapper articlesDao;
	
	private static final Log log = LogFactory.getLog("blog");
	
	/**
	 * @Title:getArticles
	 * @Description: 根据type 查找文章列表
	 * @param req
	 * @param repo
	 * @return:void
	 */
	@RequestMapping("getArticles")
	public void getArticles(HttpServletRequest req,HttpServletResponse repo){
		try {
			String type = req.getParameter("type");
			if(StringUtils.isBlank(type)){
				log.error("type is null");
				return;
			}
			ImmutableMap<String, String> paramMap = ImmutableMap.of("type",type);
			List<Articles> data = articlesDao.seletArticles(paramMap);
			renderText(repo, new Gson().toJson(data));
		} catch (Exception e) {
			log.error("ArticlesController getArticles");
		}
	}
	
	/**
	 * @Title:getSingleArticle
	 * @Description: 根据id获得单个文章详情
	 * @return:void
	 */
	@RequestMapping("getSingleArticle")
	public void getSingleArticle(HttpServletRequest req,HttpServletResponse repo){
		try {
			String id = req.getParameter("id");
			if(StringUtils.isBlank(id)){
				log.error("id is null");
				return;
			}
			Articles article = articlesDao.selectOneById(Integer.valueOf(id));
			renderText(repo, new Gson().toJson(article));
		} catch (Exception e) {
			log.error("ArticlesController getArticles");
		}
	}
	public void setArticlesDao(ArticlesMapper articlesDao) {
		this.articlesDao = articlesDao;
	}
}