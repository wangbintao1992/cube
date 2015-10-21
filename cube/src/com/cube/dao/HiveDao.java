/**
 * @ClassName:asdsad
 */
package com.cube.dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.cube.pojo.Letters;

/**
 * @ClassName: HiveDao
 * @Description: TODO
 * @author wangbintao
 * @date 2015-10-21
 * @version 1.0
 * @since JDK1.6
 */
public class HiveDao {

	private DataSource dataSource;
	
	public Letters selectLetters(int id){
		QueryRunner queryRunner = new QueryRunner(dataSource);
		try {
			return queryRunner.query("select * from letters where id = ?",new BeanHandler<Letters>(Letters.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
