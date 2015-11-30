package com.cube.util;

import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.cube.webSocket.ConsoleHandler;

public class Sender implements Runnable{
	
	private static final Log log = LogFactory.getLog(Sender.class);
	
	private Set<WebSocketSession> userSession;
	
	private LinkedBlockingQueue<String> queue = ConsoleHandler.queue;;
	
	public void run() {
		try {
			TextMessage msg = null;
			while(true){
				msg = new TextMessage(queue.take());
				for(WebSocketSession session : userSession){
					session.sendMessage(msg);
				}
			}
		} catch (final Exception e) {
			log.error("Sender run", e);
		}
	}

	public Set<WebSocketSession> getUserSession() {
		return userSession;
	}

	public void setUserSession(Set<WebSocketSession> userSession) {
		this.userSession = userSession;
	}

	public Queue<String> getQueue() {
		return queue;
	}
	public void setQueue(LinkedBlockingQueue<String> queue) {
		this.queue = queue;
	}
	public Sender() {
		super();
	}
	public Sender(Set<WebSocketSession> userSession, LinkedBlockingQueue<String> queue) {
		super();
		this.userSession = userSession;
		this.queue = queue;
	}
}
