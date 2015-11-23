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
import com.cube.util.StringUtil;
import com.github.pagehelper.PageHelper;

@Controller
@RequestMapping(value="comment")
public class CommentController extends BaseController{
	
	private static final Log log = LogFactory.getLog("blog");
	
	@Resource
	private CommentMapper commentDao;
	
	@RequestMapping(value="getComments")
	public void getComments(@RequestParam("pageNum") String pageNum){
		PageHelper.startPage(Integer.valueOf(pageNum), 10);
		PageHelper.orderBy("inputTime");
	}
	
	@RequestMapping(value="save")
	public void save(HttpServletRequest request,HttpServletResponse response){
		try {
			String ip = StringUtil.getIpAddr(request);
			String content = request.getParameter("comment");
			if(StringUtil.checkIsEmpty(ip,content)){
				Comment comment = new Comment();
				comment.setIp(ip);
				List<Comment> commentList = commentDao.select(comment);
				if(commentList != null && commentList.size() != 0){
					comment.setContent(java.net.URLDecoder.decode(content, "utf-8"));
					comment.setInputTime(new Date());
					comment.setSupportTimes(0);
					commentDao.insert(comment);
					renderText(response, "0");
					return;
				}
			}
			renderText(response, "1");
		} catch (Exception e) {
			log.error("CommentController save", e);
			e.printStackTrace();
		}
	}
}
