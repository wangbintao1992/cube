package com.cube.webSocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebMvc
@EnableWebSocket
public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer{

	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(getDanmuHandler(), "/danmu.html");
		registry.addHandler(getConsoleHandler(), "/console.html");
	}
	
	@Bean
	public DanmuHandler getDanmuHandler(){
		return new DanmuHandler();
	}
	@Bean
	public ConsoleHandler getConsoleHandler(){
		return new ConsoleHandler();
	}
}
