package com.cube.hadoop;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.util.Tool;

public class Runner extends Configured implements Tool {

	public int run(String[] arg0) throws Exception {
		Configuration conf = HBaseConfiguration.create();
		Properties prop = new Properties();
		prop.load(new FileReader(new File(this.getClass().getClassLoader().getResource("hadoop.properties").toURI())));
		Job job = Job.getInstance(conf);
		job.setJarByClass(Driver.class);

		job.setInputFormatClass(TextInputFormat.class);
		FileInputFormat.addInputPath(job, new Path(prop.getProperty("input")));

		job.setMapperClass(MyMapper.class);
		job.setReducerClass(MyReduce.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
		TableMapReduceUtil.initTableReducerJob("letters", MyReduce.class,job);

		job.waitForCompletion(true);
		return 0;
	}
}
