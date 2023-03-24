package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dto.ClientDto;
import model.dto.MessageDto;

//해당클래스 서버소켓[종착점]으로 만들기
@ServerEndpoint("/chatting/{mid}")	
//매개변수 받을때 : 경로/{매개변수1}/{매개변수2}				--> @PathParam("경로상의매개변수명") 타입 변수명
//매개변수 받을때 : 경로?매개변수명=데이터 & 매개변수명2=데이터2		--> request.getParameter("매개변수명")
public class Chatting {
	
	// 접속한 클라이언트 명단[목록] (클라이언트 소켓 여러개 저장)
	public static ArrayList<ClientDto> 접속명단 = new ArrayList<>();
	
	// 클라이언트 소켓이 접속했을때에 실행되는 메소드/함수
	@OnOpen		//session : 접속한 클라이언트 소켓 객체 // 서버 엔드포인트의 URL 매개변수[@PathParam] 가져오기
	public void onOpen(Session session, @PathParam("mid") String mid) throws IOException {
		// 접속한 클라이언트 소켓들을 보관
		접속명단.add(new ClientDto(session, mid));
		// 연결된 클라이언트 소켓을 모든 접속소켓에 보내기
		onMessage(session,"enter");
	}
	
	// 클라이언트소켓이 나갔을때
	@OnClose	
	public void onClose(Session session) throws IOException {
		System.out.println("클라이언트 소켓 접속 종료");
		for(ClientDto dto : 접속명단) {
			if(dto.getSession()==session) {
				접속명단.remove(dto);
				
				// 연결이 끊긴 클라이언트 소켓을 모든 접속명단에게 알리기
				// 1. 문자열 타입의 JSON형식 직접 작성 [ VS ObjectMapper ]
					// {"필드명" : "데이터", "필드명2" : "데이터2"}
				String msg = "{\"type\":\"alarm\",\"msgbox\":\""+dto.getMid()+"님이 채팅방을 나갔습니다.\"}";
				onMessage(session, msg);
				
				// 연결이 끊긴 클라이언트 소켓을 모든 접속명단에게 알리기
				onMessage(session, "enter");
				
				break;
			} // if e
		} // for e
	} // onclose e
	
	// 클라이언트 소켓이 메세지를 보냈을때
	@OnMessage
	public void onMessage(Session session,String msg) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		// 2.접속명단 알림
		if(msg.equals("enter")) { // 접속명단 구성
			// 회원명단[이미지,아이디] 포함된 회원리스트 생성
			ArrayList<MessageDto> list = new ArrayList<>();
			for(ClientDto dto : 접속명단) {
				list.add(new MessageDto(dto.getSession(),null)); // 현재 접속된 회원정보 객체 생성
			}
			json = mapper.writeValueAsString(list);
		}else { // 메시지 형식 구성
			MessageDto messageDto = new MessageDto(session, msg);
			json= mapper.writeValueAsString(messageDto);
		}
		
		// ** 서버가 클라이언트소켓에게 메세지를 보내기
		// 현재 서버소켓과 연결된 클라이언트 소켓 모두에게 서버가 받은 내용을 전달
		for(ClientDto dto : 접속명단) {
				//* json형식[모양]의 타입은 문자열로 전송 됨
			dto.getSession().getBasicRemote().sendText(json); //----> 클라이언트 소켓.onmessage
		}
	}
}



















