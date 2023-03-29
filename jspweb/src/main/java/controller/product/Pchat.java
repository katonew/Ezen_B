package controller.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import controller.admin.Alarm;
import model.dao.MemberDao;
import model.dao.ProductDao;
import model.dto.ChatDto;


@WebServlet("/product/chat")
public class Pchat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Pchat() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pno = Integer.parseInt(request.getParameter("pno"));
		int mno = MemberDao.getInstance().getMno((String)request.getSession().getAttribute("login"));
		System.out.println("chatmno : " + request.getParameter("chatmno"));
		int chatmno = Integer.parseInt(request.getParameter("chatmno"));
		ArrayList<ChatDto> result = ProductDao.getInstance().getChatList(pno, mno, chatmno);
		ObjectMapper mapper = new ObjectMapper();
		String json= mapper.writeValueAsString(result);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(json);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post로 옴");
		request.setCharacterEncoding("UTF-8");
		String 쪽지내용 = request.getParameter("ncontent");
		int 제품번호 = Integer.parseInt(request.getParameter("pno"));
		int 보낸사람번호 = MemberDao.getInstance().getMno((String)request.getSession().getAttribute("login"));
		int 받는회원번호 = Integer.parseInt(request.getParameter("tomno")) ;
		
		ChatDto dto = new ChatDto( 0 , 쪽지내용, null, 제품번호, 보낸사람번호, 받는회원번호);
		System.out.println("dto : " + dto);
		
		boolean result = ProductDao.getInstance().setChat(dto);
		// 만약에 채팅 등록이 성공했으면 tomno에게 소켓 알림 메시지 보내기
		if(result) {
			// 서버소켓에게 채팅을 받은 유저의 번호와 내용을 전달
			try {Alarm.서버메시지(null , 받는회원번호+","+쪽지내용);} 
			catch (Exception e) {e.printStackTrace();}
		}
		response.getWriter().print(result);
		
	}

}
