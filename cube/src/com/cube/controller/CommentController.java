package com.cube.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cube.dao.CommentMapper;
import com.cube.pojo.Comment;
import com.cube.util.RedisBeanUtil;
import com.cube.util.RedisPage;
import com.cube.util.StringUtil;
import com.cube.vo.CommentPage;
import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;

import redis.clients.jedis.Jedis;
/**
 * @ClassName: CommentController
 * @Description: 评论
 * @author wangbintao
 * @date 2015-11-23
 * @version 1.0
 * @since JDK1.6
 */
@Controller
@RequestMapping(value="comment")
public class CommentController extends BaseController{
	
	private static final Log log = LogFactory.getLog("blog");
	
	@Resource
	private Jedis jedisBean;
	
	@RequestMapping(value="getComments")
	public void getComments(@RequestParam("pageSize") String pageSize,@RequestParam("pageNow") String pageNow,@RequestParam("articleId") String articleId,HttpServletResponse response){
		try {
			RedisPage page = new RedisPage(Integer.valueOf(pageNow),Integer.valueOf(pageSize));
			String key = "comment-" + articleId;
			List<String> comments = jedisBean.lrange(key, page.getStart(), page.getEnd());
			CommentPage result = new CommentPage();
			result.setData(RedisBeanUtil.parseBean(comments, Comment.class));
			result.setTotalCount(Integer.valueOf(jedisBean.llen(key).toString()));
			renderJson(response, new Gson().toJson(result));
		} catch (NumberFormatException e) {
			log.error("CommentController save", e);
		}
	}
	/**
	 * @Title:save
	 * @Description: 发布动弹
	 * @param request
	 * @param response
	 * @return:void
	 */
	@RequestMapping(value="save")
	public void save(@RequestParam("content") String content,@RequestParam("articleId") String articleId,HttpServletResponse response){
		try {
			Comment comment = new Comment();
			comment.setContent(java.net.URLDecoder.decode(content,"utf-8"));
			comment.setArticleId(Integer.valueOf(articleId));
			comment.setIp("");
			comment.setInputTime(new Date());
			comment.setSupportTimes(0);
			jedisBean.lpush("comment-" +articleId,new Gson().toJson(comment));
			renderText(response, "0");
		} catch (Exception e) {
			renderText(response, "1");
			log.error("CommentController save", e);
		}
	}
	public Jedis getJedis() {
		return jedisBean;
	}
	public void setJedis(Jedis jedis) {
		this.jedisBean = jedis;
	}
}
