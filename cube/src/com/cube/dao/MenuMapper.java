package com.cube.dao;

import java.util.List;

import com.cube.pojo.Menu;

/**
 * @ClassName: MenuMapper
 * @Description: menu
 * @author wangbintao
 * @date 2015-11-3
 * @version 1.0
 * @since JDK1.6
 */
public interface MenuMapper extends BaseMapper<Menu>{
	
	//根据id查找
	public List<Menu> selectMenubyid(Integer id);
}
