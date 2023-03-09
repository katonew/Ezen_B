package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;


@WebServlet("/mconfirm")
public class Mconfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public Mconfirm() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 검사할 아이디 요청
		String mid =request.getParameter("mid");
		// 2. DAO 에게 전달하고 결과 받기
		boolean result = MemberDao.getInstance().idcheck(mid);
		// 3. 결과 응답
		response.getWriter().print(result);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
