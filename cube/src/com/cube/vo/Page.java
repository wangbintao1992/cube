package com.cube.vo;

import java.util.List;

import com.cube.pojo.Articles;
/**
 * @ClassName: Page
 * @Description: TODO
 * @author wangbintao
 * @date 2015-10-9
 * @version 1.0
 * @since JDK1.6
 */
public class Page {
	private List<Articles> data;
	private int totalCount;
	public Page() {
		super();
	}
	public Page(List<Articles> data, int totalCount) {
		super();
		this.data = data;
		this.totalCount = totalCount;
	}
	public List<Articles> getData() {
		return data;
	}
	public void setData(List<Articles> data) {
		this.data = data;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
}
