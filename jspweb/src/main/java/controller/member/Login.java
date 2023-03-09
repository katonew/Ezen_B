package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.MemberDao;
import model.dto.MemberDto;


@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Login() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 세션에 담겨진 회원 아이디 호출
		String mid = (String)request.getSession().getAttribute("login");
		// 2. 로그인한 회원의 정보 호출 [ 비밀번호 빼고 ]
		MemberDto result = MemberDao.getInstance().getmember(mid);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(result);
		
		// 3. 응답
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(json);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ajax에게 데이터 요청
		String mid = request.getParameter("mid");
		String mpwd = request.getParameter("mpwd");
		
		// 2. DAO 호출하여 요청데이터를 전송하여 결과 얻기
		boolean result = MemberDao.getInstance().login(mid,mpwd);
		// 만약 로그인이 성공했을시
		if(result) {
			// 로그인 세션 만들기
				// request.getSession() : 서버[톰캣] 내 세션 객체 호출
				// setAttribute( "key", value ); --> 서버[톰캣] 내 세션객체에 속성[데이터] 추가
			// 세션에 login 이름으로 로그인 성공한 데이터 저장
			request.getSession().setAttribute("login", mid);
		}
		
		// 3. DAO에게 받은 결과 AJAX에게 전달
		response.getWriter().print(result);
	}

}
