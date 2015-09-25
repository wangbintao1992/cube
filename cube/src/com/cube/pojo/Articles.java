package com.cube.pojo;

import java.util.Date;

import lombok.Data;
/**
 * @ClassName: Articles
 * @Description: 章
 * @author wangbintao
 * @date 2015-9-24
 * @version 1.0
 * @since JDK1.6
 */
@Data
public class Articles {

	private Integer id;
	private String title;
	private String content;
	private String imgPath;
	private String label;
	private int type;
	private int viewTimes;
	private Date inputTime;
	
}
