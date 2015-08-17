package com.cube.dao;

public interface BaseMapper<T> {
	
	public T selectOneById(Integer id);
	
}
