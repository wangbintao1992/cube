package com.cube.pojo;

import java.util.Date;

import javax.persistence.Id;

import lombok.Data;

import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;
/**
 * @ClassName: Articles
 * @Description: 章
 * @author wangbintao
 * @date 2015-9-24
 * @version 1.0
 * @since JDK1.6
 */
@NameStyle(Style.normal)
public @Data class Articles{
	@Id
	private Integer id;
	private String title;
	private String summary;
	private String content;
	private String imgPath;
	private String label;
	private Integer type;
	private Integer viewTimes;
	private Date inputTime;
	
}
