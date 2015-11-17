package com.cube.util;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class MapReduce {
	private String inputPath;
	
	public MapReduce() {
		super();
	}
	public MapReduce(String inputPath) {
		super();
		this.inputPath = inputPath;
	}

	public Map<String,Integer> start(){
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

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}
}
