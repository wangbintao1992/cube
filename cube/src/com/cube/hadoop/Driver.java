package com.cube.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.util.ToolRunner;

public class Driver {
	public static void start(String[] args) throws Exception {
		Configuration conf = new Configuration();
		int a = ToolRunner.run(conf, new Runner(), args);
	}
}
