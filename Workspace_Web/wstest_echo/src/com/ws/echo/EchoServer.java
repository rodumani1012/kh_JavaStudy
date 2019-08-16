package com.ws.echo;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/echo")
public class EchoServer {
	
	private Session session;
	
	@OnOpen
	public void start(Session session) {
		this.session = session;
		System.out.println("websocket open...");
	}
	
	@OnMessage
	public void msg(String message) {
		System.out.println("message : " + message);
		
		try {
			Thread.sleep(500);
			session.getBasicRemote().sendText("<< : " + message);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@OnClose
	public void end() {
		System.out.println("websocket end...");
	}
	
	@OnError
	public void onError(Throwable t) throws Throwable {
		System.out.println("ERROR : " + t);
	}
	
	/*
	 *	@ServerEndpoint는 클라이언트에서 서버로 접속 할 주소로 지정합니다.
		@OnMessage에서는 클라이언트로 부터 메시지가 도착했을때 처리입니다.
		@OnOpen은 클라이언트에서 서버로 접속할 때의 처리입니다.
		@OnClose는 접속이 끊겼을때 처리입니다.
	 */
}
