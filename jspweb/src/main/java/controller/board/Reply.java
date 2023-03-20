package controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.BoardDao;
import model.dao.MemberDao;
import model.dto.ReplyDto;


@WebServlet("/board/reply")
public class Reply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Reply() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.
		int bno = Integer.parseInt(request.getParameter("bno"));
		int type = Integer.parseInt(request.getParameter("type"));
		int rindex = 0;
		if(type==1) { // 상위 댓글 출력
			
		}else if(type==2) { // 하위 댓글 출력
			rindex = Integer.parseInt(request.getParameter("rindex"));
		}
		// 2.
		ArrayList<ReplyDto> result =  BoardDao.getInstance().getReplyList(bno, rindex);
		// 3.
		ObjectMapper mapper = new ObjectMapper();
		String jsonArray = mapper.writeValueAsString(result);
		// 4.
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.
		request.setCharacterEncoding("UTF-8");
		int bno = Integer.parseInt(request.getParameter("bno"));
		int mno = MemberDao.getInstance().getMno((String)request.getSession().getAttribute("login"));
		String rcontent = request.getParameter("rcontent");
		int type = Integer.parseInt(request.getParameter("type"));
		
		ReplyDto dto = new ReplyDto(rcontent, mno, bno);
		
		if(type==1) { // 최상위 댓글 쓰기
			// 최상위 댓글에는 rindex를 입력해줄 필요가 없음
		}else if(type==2) { // 대댓글 작성
			int rindex = Integer.parseInt(request.getParameter("rindex"));
			dto.setRindex(rindex);
		}
		
		boolean result = BoardDao.getInstance().rwite(dto);
		System.out.println(result);
		response.getWriter().print(result);
		
		
	}

}
