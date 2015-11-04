package com.cube.vo;

import java.util.List;

/**
 * @ClassName: MenuVo
 * @Description: menuVo
 * @author wangbintao
 * @date 2015-11-3
 * @version 1.0
 * @since JDK1.6
 */
public class ResultMenu {
	
	private String title;
	private String url;
	private List<ResultMenu> child;
	
	public ResultMenu(String title, String url, List<ResultMenu> child) {
		super();
		this.title = title;
		this.url = url;
		this.child = child;
	}
	public ResultMenu() {
		super();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<ResultMenu> getChild() {
		return child;
	}
	public void setChild(List<ResultMenu> child) {
		this.child = child;
	} 
	
	
}
