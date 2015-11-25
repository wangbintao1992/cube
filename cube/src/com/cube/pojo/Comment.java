package com.cube.pojo;

import java.util.Date;

import javax.persistence.Id;

import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;
/**
 * @ClassName: Comment
 * @Description: 评论
 * @author wangbintao
 * @date 2015-11-23
 * @version 1.0
 * @since JDK1.6
 */
@NameStyle(Style.normal)
public class Comment {
	@Id
	private Integer id;
	private String content;
	private String ip;
	private Date inputTime;
	private Integer supportTimes;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Comment(Integer id, String content, String ip, Date inputTime, Integer supportTimes) {
		super();
		this.id = id;
		this.content = content;
		this.ip = ip;
		this.inputTime = inputTime;
		this.supportTimes = supportTimes;
	}
	public Comment() {
		super();
	}
}
