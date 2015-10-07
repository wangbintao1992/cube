package com.cube.pojo;

import java.util.Date;

import javax.persistence.Id;

/**
 * @ClassName: Articles
 * @Description: 章
 * @author wangbintao
 * @date 2015-9-24
 * @version 1.0
 * @since JDK1.6
 */
public class Articles {
	@Id
	private Integer id;
	private String title;
	private String summary;
	private String content;
	private String imgPath;
	private String label;
	private int type;
	private int viewTimes;
	private Date inputTime;
	
	public Articles() {
		super();
	}
	public Articles(Integer id, String title, String summary, String content,
			String imgPath, String label, int type, int viewTimes,
			Date inputTime) {
		super();
		this.id = id;
		this.title = title;
		this.summary = summary;
		this.content = content;
		this.imgPath = imgPath;
		this.label = label;
		this.type = type;
		this.viewTimes = viewTimes;
		this.inputTime = inputTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getViewTimes() {
		return viewTimes;
	}
	public void setViewTimes(int viewTimes) {
		this.viewTimes = viewTimes;
	}
	public Date getInputTime() {
		return inputTime;
	}
	public void setInputTime(Date inputTime) {
		this.inputTime = inputTime;
	}
	
	
}
