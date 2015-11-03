package com.cube.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cube.dao.MenuMapper;
import com.cube.pojo.Menu;
import com.cube.vo.ResultMenu;
import com.google.gson.Gson;

/**
 * @ClassName: MenuController
 * @Description: TODO
 * @author wangbintao
 * @date 2015-11-3
 * @version 1.0
 * @since JDK1.6
 */
@Controller
@RequestMapping(value="menu")
public class MenuController extends BaseController {
	
	@Resource
	private MenuMapper menuDao;
	
	@RequestMapping(value="menus")
	public void menus(HttpServletResponse response){
		List<ResultMenu> menuList = new ArrayList<ResultMenu>();
		List<Menu> fatherMenus = menuDao.selectMenubyid(0);
		for(Menu menu : fatherMenus){
			ResultMenu rm = new ResultMenu();
			List<Menu> childMenus = menuDao.selectMenubyid(menu.getId());
			List<ResultMenu> childs = new ArrayList<ResultMenu>();
			for(Menu m : childMenus){
				ResultMenu cm = new ResultMenu();
				cm.setTitle(m.getMenuName());
				cm.setUrl(m.getUrl());
				childs.add(cm);
			}
			rm.setTitle(menu.getMenuName());
			rm.setUrl(menu.getUrl());
			rm.setChild(childs);
			menuList.add(rm);
		}
		renderJson(response, new Gson().toJson(menuList));
	}
}
