package com.cube.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cube.dao.ArticlesMapper;
import com.cube.pojo.Articles;
import com.cube.util.StringUtil;
import com.cube.vo.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
/**
 * @ClassName: ArticlesController
 * @Description: 文章controller
 * @author wangbintao
 * @date 2015-10-8
 * @version 1.0
 * @since JDK1.6
 */
@Controller
@RequestMapping("/articles")
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
	@RequestMapping("/getArticles")
	public void getArticles(HttpServletRequest req,HttpServletResponse repo){
		String type = req.getParameter("type");
		String pageNow = req.getParameter("pageNow");
		String pageSize = req.getParameter("pageSize");
		try {
			if(StringUtil.checkIsEmpty(type,pageNow,pageSize)){
				log.error("param is null");
				return;
			}
			PageHelper.startPage(Integer.valueOf(pageNow), Integer.valueOf(pageSize));
			ImmutableMap<String, String> paramMap  = ImmutableMap.of("type",type);
			Page page = new Page();
			page.setData(articlesDao.seletArticles(paramMap));
			page.setTotalCount(articlesDao.selectTotalCount(paramMap));
			renderText(repo, new Gson().toJson(page));
		} catch (Exception e) {
			log.error("ArticlesController getArticles type=" + type + " pageNow = " + pageNow + "pageSize= " + pageSize,e);
		}
	}
	
	/**
	 * @Title:getSingleArticle
	 * @Description: 根据id获得单个文章详情
	 * @return:void
	 */
	@RequestMapping("/getSingleArticle")
	public void getSingleArticle(HttpServletRequest req,HttpServletResponse repo){
		String id = req.getParameter("id");
		try {
			if(StringUtils.isBlank(id)){
				log.error("id is null");
				return;
			}
			Articles article = articlesDao.selectByPrimaryKey(Integer.valueOf(id));
			renderText(repo, new Gson().toJson(article));
		} catch (Exception e) {
			log.error("ArticlesController getArticles id=" + id,e);
		}
	}
	/**
	 * @Title:save
	 * @Description: save
	 * @param file
	 * @param response
	 * @return:void
	 */
	@RequestMapping(value="save")
	public void save(@RequestParam("file") MultipartFile file,HttpServletRequest request,HttpServletResponse response){
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String lable = request.getParameter("lable");
		String type = request.getParameter("type");
		String summary = request.getParameter("summary");
	}
	
	public void setArticlesDao(ArticlesMapper articlesDao) {
		this.articlesDao = articlesDao;
	}
}
