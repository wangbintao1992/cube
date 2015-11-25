package com.cube.pojo;

import java.util.Date;
/**
 * @ClassName: Comment
 * @Description: 评论
 * @author wangbintao
 * @date 2015-11-23
 * @version 1.0
 * @since JDK1.6
 */
public class Comment {
	private Integer articleId;
	private String content;
	private String ip;
	private Date inputTime;
	private Integer supportTimes;
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getInputTime() {
		return inputTime;
	}
	public void setInputTime(Date inputTime) {
		this.inputTime = inputTime;
	}
	public Integer getSupportTimes() {
		return supportTimes;
	}
	public void setSupportTimes(Integer supportTimes) {
		this.supportTimes = supportTimes;
	}
	public Comment(Integer articleId, String content, String ip, Date inputTime, Integer supportTimes) {
		super();
		this.articleId = articleId;
		this.content = content;
		this.ip = ip;
		this.inputTime = inputTime;
		this.supportTimes = supportTimes;
	}
	public Comment() {
		super();
	}
}
