package com.cube.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.util.ToolRunner;

public class HadoopTask {
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		ToolRunner.run(conf, new Runner(), args);
	}
}
