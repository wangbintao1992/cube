package com.cube.hadoop;

import java.io.IOException;

import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableReducer;
import org.apache.hadoop.io.Text;
/**
 * @ClassName: MyReduce
 * @Description: TODO
 * @author wangbintao
 * @date 2015-10-21
 * @version 1.0
 * @since JDK1.6
 */
public class MyReduce extends TableReducer<Text,Text,ImmutableBytesWritable>{

	@Override
	protected void reduce(Text key, Iterable<Text> values,
			Context context)
			throws IOException, InterruptedException {
		   int sum = 0;  
            for (Text val : values) {  
                sum += Integer.valueOf(val.toString());
            }  
        Put putrow = new Put("1".getBytes());
        putrow.add(key.getBytes(), "times".getBytes(), String.valueOf(sum).getBytes());  
        context.write(new ImmutableBytesWritable(key.getBytes()), putrow);
	}
}
