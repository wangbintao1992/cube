package com.cube.util;

public class RedisPage {
	private int start;
	private int end;
	public RedisPage(int nowPage, int pageSize) {
		this.end = nowPage * 10 - 1 ;
		this.start = (nowPage - 1)  * 10;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
	
}
