package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.BoardDao;
import model.dao.MemberDao;


@WebServlet("/board/info")
public class Boardinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Boardinfo() { super();}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 업로드
			// 1. 업로드 할 파일의 위치
			// 2. 경로찾기
		String path = request.getSession().getServletContext().getRealPath("/board/bfile");
		System.out.println( "파일이 저장 될 경로 : "+ path );
		
			// 3. 파일 복사 [ 대용량 바이트 복사하기 ]
		MultipartRequest multi = new MultipartRequest(
				request,  						// 1. 요청방식 
				path , 							// 2. 첨부파일 가져와서 저장할 서버내 폴더 
				1024*1024 * 10 ,				// 3. 첨부파일 허용 범위 용량[ 바이트단위 ] 10MB
				"UTF-8" ,						// 4. 첨부파일 한글 인코딩 
				new DefaultFileRenamePolicy() 	// 5. 동일한 첨부파일명이 존재했을때 뒤에 숫자 붙여서 식별
				);
		System.out.println("multi : "+multi);
		// ------------ 확인 ------------
		int cno = Integer.parseInt(multi.getParameter("cno")) ;	System.out.println("cno : "+cno);
		String btitle = multi.getParameter("btitle");			System.out.println("btitle : "+btitle);
		String bcontent = multi.getParameter("bcontent");		System.out.println("bcontent : "+bcontent);
		String bfile = multi.getFilesystemName("bfile");		System.out.println("bfile : "+bfile);
			// 1. 회원제게시판 [ 로그인 된 회원 mno 필요!]
		String mid = (String)request.getSession().getAttribute("login");
		System.out.println("가져온 mid : "+ mid);
			// 2. mid ==> mno (Dao)
		int mno = MemberDao.getInstance().getMno(mid);
			// 3. 만약 회원번호가 존재하지 않으면 글쓰기 불가능
		if(mno<=0) {
			response.getWriter().print("false");
		}
		System.out.println("가져온 mno : " + mno);
		// dto
		BoardDto dto = new BoardDto(btitle, bcontent, bfile, mno, cno);
		// dao
		boolean result = BoardDao.getInstance().bwrite(dto);
		// 응답
		response.getWriter().print(result);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
