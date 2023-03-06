package practice.day03;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet("/Ex3/Board")
public class Board extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Board() {
        super();
    }
    
    // 1. 등록
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 1. 요청시 한글 인코딩
		request.setCharacterEncoding("UTF-8");
		// 2. 매개변수 요청 [ ajax data 속성에서 보내준 매개변수 이름]
		String content = request.getParameter("content");
		System.out.println("content : "+content);
		String writer = request.getParameter("writer");
		System.out.println("writer : "+writer);
		// 3. Dto 객체 [ int 필드의 기본값 : 0 / 객체 필드의 기본값 : null ]
		BoardDto dto = new BoardDto(0,content,writer,null);
		// 4. Dao 호출해서 결과 저장
		boolean result = BoardDao.getInstance().onwrite(dto);
		//5. dao 결과인 true/false 데이터를 response
			// true vs {true}
		response.getWriter().print(result);
		
	}
    
    // 2. 모든 게시물 조회
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 1. 응답데이터 한글 인코딩 
		response.setCharacterEncoding("UTF-8");
		// 2. DAO 호출해서 모든 게시물 반환
		ArrayList<BoardDto> result = BoardDao.getInstance().onlist();
		System.out.println("DAO LIST : " + result);
		// 3. JSON[JS객체] 형식의 문자열로 변환
		ObjectMapper mapper = new ObjectMapper(); // JACKSON 라이브러리에서 제공하는 클래스
		String jsonArray = mapper.writeValueAsString(result);	// dao로부터 전달받은 list를 문자열로 변환하기
		System.out.println("jsonArray : " + jsonArray);
		// 4. 응답
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
		
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 삭제할 게시물 정보 요청
		int bno = Integer.parseInt(request.getParameter("bno"));
		System.out.println("삭제할 번호 요청 : " + bno);
		// 2. dao 호출해서 결과 얻기
		boolean result = BoardDao.getInstance().ondelete(bno);
		
		// 3. 결과를 응답
		response.getWriter().print(result);
				
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		// 1. 수정할 게시물 번호 요청
		int bno = Integer.parseInt(request.getParameter("bno"));
		System.out.println("수정할 번호 요청 : " + bno);
		
		// 2. 수정할 게시글 내용 요청
		String newContent = request.getParameter("newContent");
		System.out.println("수정할 내용 요청 : " + newContent);
		
		// 3. dao 호출해서 결과 얻기
		boolean result = BoardDao.getInstance().onupdate(bno,newContent);
		
		// 4. 결과를 응답
		response.getWriter().print(result);
		
	}
}












