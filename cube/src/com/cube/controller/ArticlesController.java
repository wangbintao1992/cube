package com.cube.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cube.dao.ArticlesMapper;
import com.cube.pojo.Articles;
import com.google.gson.Gson;

@Controller
public class ArticlesController extends BaseController{
	
	@Resource
	private ArticlesMapper articlesDao;
	
	@RequestMapping("test")
	public void test(HttpServletRequest req,HttpServletResponse repo){
		List<Articles> data = articlesDao.seletArticles();
		renderText(repo, new Gson().toJson(data));
	}

	public void setArticlesDao(ArticlesMapper articlesDao) {
		this.articlesDao = articlesDao;
	};
}
