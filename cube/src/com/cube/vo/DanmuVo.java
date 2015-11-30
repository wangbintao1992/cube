package com.cube.vo;

public class DanmuVo {
	private String danmu;
	private boolean flag;
	public String getDanmu() {
		return danmu;
	}
	public void setDanmu(String danmu) {
		this.danmu = danmu;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public DanmuVo(String danmu, boolean flag) {
		super();
		this.danmu = danmu;
		this.flag = flag;
	}
	public DanmuVo() {
		super();
	}
}
