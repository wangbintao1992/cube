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
/**
 * @ClassName: HbaseTemplate
 * @Description: TODO
 * @author wangbintao
 * @date 2015-10-26
 * @version 1.0
 * @since JDK1.6
 */
public class HbaseTemplate {
	
	private Configuration hbaseConf = HBaseConfiguration.create();
	
	/**
	 * @Title:get
	 * @Description: 根据表名，rowkey名，获得记录
	 * @param tableName
	 * @param rowKey
	 * @param qualifier
	 * @return
	 * @return:Map<String,String>
	 */
	public Map<String,String> get(String tableName,String rowKey,String qualifier){
		try {
			HTable table = new HTable(hbaseConf, tableName);
			Get get = new Get(rowKey.getBytes());
			Result result = table.get(get);
			KeyValue[] kv = result.raw();
			Map<String,String> map = new HashMap<String, String>();
			for(KeyValue k : kv){
				if(!k.getFamily().equals("id")){
					map.put(new String(k.getFamily()),new String(k.getValue()));
				}
			}
			return map;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
