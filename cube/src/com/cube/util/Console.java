package com.cube.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;

import com.cube.webSocket.ConsoleHandler;


public class Console implements Runnable{
	private static final Logger log = Logger.getLogger(Console.class);   
	
	private String cmd;
	
	private LinkedBlockingQueue<String> queue = ConsoleHandler.queue;

	public void run() {
		InputStream inputStream = null;
		BufferedReader br = null;
		try {
			Process process = Runtime.getRuntime().exec(cmd);
			inputStream = process.getInputStream();
			br = new BufferedReader(new InputStreamReader(inputStream));
			String line = null;
			while((line = br.readLine()) != null){
				queue.offer(line);
			}
		} catch (final Exception e) {
			log.error("Console run", e);
		}finally{
			try {
				inputStream.close();
				br.close();
			} catch (IOException e) {
				log.error("Console close", e);
			}
		}
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	
	public Console(String cmd, LinkedBlockingQueue<String> queue) {
		super();
		this.cmd = cmd;
		this.queue = queue;
	}

	public LinkedBlockingQueue<String> getQueue() {
		return queue;
	}

	public void setQueue(LinkedBlockingQueue<String> queue) {
		this.queue = queue;
	}

	public Console() {
		super();
	}
}