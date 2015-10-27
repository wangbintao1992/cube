package com.cube.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.util.ToolRunner;

/**
 * @ClassName: HadoopTask
 * @Description: Hadoop job驱动
 * @author wangbintao
 * @date 2015-10-26
 * @version 1.0
 * @since JDK1.6
 */
public class HadoopTask {
	public static int main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		conf.set("uuid", args[0]);
		return ToolRunner.run(conf, new Runner(), args);
	}
}
