package com.cube.pojo;

import java.util.Date;
/**
 * @Description 文章
 * @author moming
 * jdk1.6
 */
public class Articles {
	private Integer id;
	private String title;
	private String content;
	private String imgPath;
	private String label;
	private Date inputTime;
	
	public Articles() {
		super();
	}
	public Articles(Integer id, String title, String content, String imgPath,
			String label, Date inputTime) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.imgPath = imgPath;
		this.label = label;
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
	public Date getInputTime() {
		return inputTime;
	}
	public void setInputTime(Date inputTime) {
		this.inputTime = inputTime;
	}

	
}
