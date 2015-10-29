package com.cube.util;
/**
 * @ClassName: FileTask
 * @Description: 删除线程任务
 * @author wangbintao
 * @date 2015-10-29
 * @version 1.0
 * @since JDK1.6
 */
public class FileTask implements Runnable{
	
	private String path;
	
	public FileTask(String path) {
		this.path = path;
	}

	/**
	 * @Title:run
	 * @Description: 删除任务
	 */
	public void run() {
		IOUtil.deleteDirectory(path);
	}

}
