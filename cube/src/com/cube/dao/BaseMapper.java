package com.cube.dao;

import tk.mybatis.mapper.common.Mapper;
/**
 * @ClassName: BaseMapper
 * @Description: BaseDao集成通用mapper
 * @author wangbintao
 * @date 2015-10-8
 * @version 1.0
 * @since JDK1.6
 */
public interface BaseMapper<T> extends Mapper<T>{
	
	public T selectOneById(Integer id);
	
}
