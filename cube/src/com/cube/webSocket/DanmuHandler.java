package com.cube.webSocket;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.cube.util.StringUtil;
import com.cube.vo.DanmuVo;
import com.google.gson.Gson;
/**
 * @ClassName: DanmuHandler
 * @Description: TODO
 * @author wangbintao
 * @date 2015-11-30
 * @version 1.0
 * @since JDK1.6
 */

public class DanmuHandler implements WebSocketHandler{
	
	private static Set<WebSocketSession> userList = new HashSet<WebSocketSession>();

	public void afterConnectionClosed(WebSocketSession session, CloseStatus arg1) throws Exception {
		userList.remove(session);
	}

	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		userList.add(session);
	}

	public void handleMessage(WebSocketSession session, WebSocketMessage<?> body) throws Exception {
		String msg = StringUtil.Html2Text(body.getPayload().toString());
		sendMessageToAll(session,msg);
	}

	public void handleTransportError(WebSocketSession arg0, Throwable arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * @Title:sendMessageToAll
	 * @Description: 给所有人发送信息
	 * @param session
	 * @param msg
	 * @return:void
	 */
	private void sendMessageToAll(WebSocketSession session,String msg){
		try {
			DanmuVo danmu = null;
			for(WebSocketSession user : userList){
				danmu = new DanmuVo();
				if(user.equals(session)){
					danmu.setFlag(true);
				}
				danmu.setDanmu(msg);
				user.sendMessage(new TextMessage(new Gson().toJson(danmu)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
