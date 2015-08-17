package com.cube.pojo;
/**
 * @Description 菜单
 * @author moming
 * jdk1.6
 */
public class Menus {
	private Integer id;
	private String menuName;
	private int sort;
	
	public Menus() {
		super();
	}
	public Menus(Integer id, String menuName, int sort) {
		super();
		this.id = id;
		this.menuName = menuName;
		this.sort = sort;
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
	
	
}
