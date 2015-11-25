package com.cube.vo;

import java.util.List;

import com.cube.pojo.Articles;
import com.cube.pojo.Comment;
/**
 * @ClassName: Page
 * @Description: TODO
 * @author wangbintao
 * @date 2015-10-9
 * @version 1.0
 * @since JDK1.6
 */
public class CommentPage {
	private List<Comment> data;
	private int totalCount;
	public List<Comment> getData() {
		return data;
	}
	public void setData(List<Comment> data) {
		this.data = data;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public CommentPage(List<Comment> data, int totalCount) {
		super();
		this.data = data;
		this.totalCount = totalCount;
	}
	public CommentPage() {
		super();
	}
}
