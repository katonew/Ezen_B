package controller.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.mapper.Mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.MemberDao;
import model.dto.MemberDto;

/**
 * Servlet implementation class Info
 */
@WebServlet("/member")
public class Info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Info() {super();}

	// 2. 로그인 // 회원정보 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 1. DAO에게 모든 회원명단 요청 후 전달
		ArrayList<MemberDto> result = MemberDao.getInstance().allmember();
		// 2. JAVA객체 -> JS 객체 형변환
		ObjectMapper mapper = new ObjectMapper(); // JACKSON 라이브러리에서 제공하는 클래스
		String jsonArray = mapper.writeValueAsString(result);	// dao로부터 전달받은 list를 문자열로 변환하기
		// 응답
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
	}
	// 첨부파일 있을때
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request는 첨부파일(대용량)에 대한 요청이 불가능 ---> 외부 라이브러리 --> cos.jar
		// 1. 프로젝트 build path 추가
		// 2. 프로젝트 web-inf -> lib 추가
		// cos
			// MultipartRequest 클래스 제공
		
		// 현재 작업 프로젝트 경로 찾기
		String path = "C:\\Users\\504\\git\\Ezen_B\\jspweb\\src\\main\\webapp\\member\\pimg";
		
		// 현재 배포된 서버의 프로젝트 내 경로 찾기
		String uploadpath = request.getSession().getServletContext().getRealPath("/member/pimg");
		System.out.println(uploadpath);
		// * 첨부파일 업로드
		MultipartRequest multi = new MultipartRequest(
				request,						// 1. 요청 방식
				uploadpath ,					// 2. 첨부파일을 가져와서 저장할 서버 내 폴더
				1024*1024*10,					// 3. 첨부파일의 허용 범위 용량 [ 바이트 단위 ] 10MB
				"UTF-8",						// 4. 첨부파일 한글 인코딩
				new DefaultFileRenamePolicy()	// 5. 동일한 첨부파일명이 있으면 뒤에 숫자를 붙여줌
				);
		// 그외 매개변수 요청 [ request ---> multi ] // form 하위 태그 내 input 태그의 name 식별자
		String mid = multi.getParameter("mid");
		String mpwd = multi.getParameter("mpwd");
		String memail = multi.getParameter("memail");
		String mimg = multi.getFilesystemName("mimg"); // 첨부파일된 파일명 호출 getFilesystemName
		MemberDto dto = new MemberDto(0, mid, mpwd, mimg, memail);
		System.out.println("dtp : " + dto);
		boolean result = MemberDao.getInstance().signup(dto);
		System.out.println("result : " + result);
		response.getWriter().print(result);
		
		
	}

	// 3. 회원정보 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	// 4. 회원 탈퇴
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

/*
// 첨부파일 없을때
	// 1. 회원가입
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 1. ajax에게 데이터 요청
		String mid = request.getParameter("mid");
		String mpwd = request.getParameter("mpwd");
		String memail = request.getParameter("memail");
		String mimg = request.getParameter("mimg");
		
		// 2. DTO 만들기
		MemberDto dto = new MemberDto(0, mid, mpwd, mimg, memail);
		System.out.println(dto);
		
		// 3. DAO 호출하고 결과 받기
		boolean result = MemberDao.getInstance().signup(dto);
		// 4. 결과 응답하기
		response.getWriter().print(result);
		
	}
	*/
