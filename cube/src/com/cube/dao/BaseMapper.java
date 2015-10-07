package com.cube.dao;

import tk.mybatis.mapper.common.Mapper;

public interface BaseMapper<T> extends Mapper<T>{
	
	public T selectOneById(Integer id);
	
}
