package com.cube.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class MapReduce {
	private String inputPath;
	
	public MapReduce() {
		super();
	}
	public MapReduce(String inputPath) {
		super();
		this.inputPath = inputPath;
	}

	/*public Map<String,Integer> start(){
		try {
			Path path = Paths.get(this.inputPath);
			FileChannel in = FileChannel.open(path);
			ByteBuffer buf = ByteBuffer.allocate(200);
			Map<String,Integer> map = new HashMap<String,Integer>();
			String str;
			while(in.read(buf) != -1){
				buf.flip();
				str = new String(buf.array());
				String[] arr = str.split("");
				for(String s : arr){
					if(map.get(s) != null){
						map.put(s, map.get(s) + 1);
					}else{
						map.put(s, 1);
					}
				}
			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
*/	
	public Map<String,Integer> start(){
		try {
			BufferedReader bf = new BufferedReader(new FileReader(this.inputPath));
			Map<String,Integer> map = new HashMap<String,Integer>();
			String str = "";
			while((str = bf.readLine()) != null){
				String[] data =str.split("");
				for(String s : data){
					if(StringUtils.isNotBlank(s)){
						if(map.get(s) != null){
							map.put(s, map.get(s) + 1);
						}else{
							map.put(s, 1);
						}
					}
				}
			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}
}
