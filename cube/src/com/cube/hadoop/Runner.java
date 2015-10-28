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

/**
 * @ClassName: Runner
 * @Description: TODO
 * @author wangbintao
 * @date 2015-10-21
 * @version 1.0
 * @since JDK1.6
 */
public class Runner extends Configured implements Tool {
	
	/**
	 * @Title:run
	 * @Description: job提交
	 * @param arg0
	 * @return
	 * @throws Exception
	 */
	public int run(String[] arg0) throws Exception {
		Configuration conf = HBaseConfiguration.create();
		conf.set("uuid", arg0[0]);
		Properties prop = new Properties();					 
		prop.load(new FileReader(new File(Runner.class.getClassLoader().getResource("hadoop.properties").toURI())));
		Job job = Job.getInstance(conf);
		job.setJarByClass(HadoopTask.class);

		job.setInputFormatClass(TextInputFormat.class);
		FileInputFormat.addInputPath(job, new Path(arg0[1]));

		job.setMapperClass(MyMapper.class);
		job.setReducerClass(MyReduce.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
		TableMapReduceUtil.initTableReducerJob("letters", MyReduce.class,job);

		return job.waitForCompletion(true) == true ? 0 : 1;
	}
}
