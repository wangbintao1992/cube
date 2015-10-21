/**
 * @ClassName:asdsad
 */
package com.cube.hadoop;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

/**
 * @ClassName: HiveUtil
 * @Description: TODO
 * @author wangbintao
 * @date 2015-10-21
 * @version 1.0
 * @since JDK1.6
 */
public class HiveUtil {
	
	private static String Driver = "org.apache.hadoop.hive.jdbc.HiveDriver";
	
	private static String URL = "";
	
	private static String USER_NAME = "";
	
	private static String USER_PWD = "";
	
	
	
	public static void main(String[] args) {
		DataSource data  = new DataSource() {
			
			public <T> T unwrap(Class<T> iface) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			
			public boolean isWrapperFor(Class<?> iface) throws SQLException {
				// TODO Auto-generated method stub
				return false;
			}
			
			public void setLoginTimeout(int seconds) throws SQLException {
				// TODO Auto-generated method stub
				
			}
			
			public void setLogWriter(PrintWriter out) throws SQLException {
				// TODO Auto-generated method stub
				
			}
			
			public int getLoginTimeout() throws SQLException {
				// TODO Auto-generated method stub
				return 0;
			}
			
			public PrintWriter getLogWriter() throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			
			public Connection getConnection(String username, String password)
					throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			
			public Connection getConnection() throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
		};
		QueryRunner run = new QueryRunner();
	}
}
