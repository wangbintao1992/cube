package com.cube.hadoop;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;

public class HbaseTemplate {
	
	private Configuration hbaseConf = HBaseConfiguration.create();
	
	public Map<String,String> get(String tableName,String rowKey,String qualifier){
		try {
			HTable table = new HTable(hbaseConf, tableName);
			Get get = new Get(rowKey.getBytes());
			Result result = table.get(get);
			KeyValue[] kv = result.raw();
			Map<String,String> map = new HashMap<String, String>();
			for(KeyValue k : kv){
				map.put(new String(k.getFamily()),new String(k.getValue()));
			}
			return map;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
