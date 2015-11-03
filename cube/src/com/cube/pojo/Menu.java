package com.cube.pojo;

import javax.persistence.Id;
/**
 * @Description 菜单
 * @author moming
 * jdk1.6
 */
public class Menu {
	@Id
	private Integer id;
	private String menuName;
	private int sort;
	private String url;
	private int parnetId;
	
	public Menu() {
		super();
	}
	public Menu(Integer id, String menuName, int sort, String url, int parnetId) {
		super();
		this.id = id;
		this.menuName = menuName;
		this.sort = sort;
		this.url = url;
		this.parnetId = parnetId;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getParnetId() {
		return parnetId;
	}
	public void setParnetId(int parnetId) {
		this.parnetId = parnetId;
	}
	
	
}
