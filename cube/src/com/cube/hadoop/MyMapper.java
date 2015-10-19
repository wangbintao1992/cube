package com.cube.hadoop;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MyMapper extends
Mapper<LongWritable, Text, Text, Text> {
	//private final word one = new wrod(1);
	private Text word = new Text();
	private Text word2 = new Text("1");
	public void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		String[] line = value.toString().split("");
		for (String str : line) {
			if (!"".equals(str)) {
				word.set(str);
				context.write(word, word2);
			}
		}
	}
}
