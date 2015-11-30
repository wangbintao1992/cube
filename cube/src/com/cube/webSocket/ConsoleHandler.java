package com.cube.webSocket;

import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.cube.util.Console;
import com.cube.util.Sender;

@Component
public class ConsoleHandler implements WebSocketHandler {
	private static final Log log = LogFactory.getLog(ConsoleHandler.class);
	private static Set<WebSocketSession> wss = new HashSet<WebSocketSession>();
	public static LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>();
	
	static{
		try {
			Properties properties = new Properties();
			properties.load(new FileReader(new File(ConsoleHandler.class.getClassLoader().getResource("hadoop.properties").toURI())));
			Console console = new Console();
			String data = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
			console.setCmd(properties.getProperty("cmd") + data + ".txt");
			new Thread(console).start();
			Sender sender = new Sender();
			sender.setUserSession(wss);
			new Thread(sender).start();
		} catch (final Exception e) {
			log.error("ConsoleHandler static black",e);
		} 
	}
	public void afterConnectionClosed(WebSocketSession session, CloseStatus arg1) throws Exception {
		wss.remove(session);
	}

	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		wss.add(session);
	}

	public void handleMessage(WebSocketSession arg0, WebSocketMessage<?> arg1) throws Exception {
		
	}

	public void handleTransportError(WebSocketSession arg0, Throwable arg1) throws Exception {
		// TODO Auto-generated method stub

	}

	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}

}
