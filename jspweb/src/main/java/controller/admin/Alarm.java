package controller.admin;

import java.util.ArrayList;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import model.dao.MemberDao;
import model.dto.ClientDto;

@ServerEndpoint("/alarm/{mid}")
public class Alarm {
	
	private static ArrayList<ClientDto> 알림명단 = new ArrayList<>();
	
	@OnOpen // 클라이언트 소켓이 들어왔을때
	public void 서버입장(Session session, @PathParam("mid") String mid) throws Exception  {
		알림명단.add(new ClientDto(session,mid));
	}
	@OnClose // 클라이언트 소켓이 나갔을때
	public void 서버나가기(Session session) throws Exception  {
		for( ClientDto c : 알림명단) {
			if( c.getSession() == session) {알림명단.remove(c);}
		}
	}
	@OnError // 클라이언트 소켓에서 에러가 발생했을때
	public  void 서버에러(Session session , Throwable e) throws Exception  {System.out.println(" 서버소켓 : " + session);}
	
	@OnMessage // 클라이언트 소켓에서 메세지가 왔을때 매핑[연결]
	public static void 서버메시지(Session session, String msg) throws Exception {
		// 메세지를 받는 회원 번호
		int tomno = Integer.parseInt(msg.split(",")[0]);
		// 메시지 내용
		String tomsg = msg.split(",")[1];
		for(ClientDto c : 알림명단) {
			int cmno = MemberDao.getInstance().getMember(c.getMid()).getMno();
			if(cmno == tomno) { // 받는 회원번호가 알림명단에 존재하면
				c.getSession().getBasicRemote().sendText(tomsg);
			}
		}
		
	}
	
}
