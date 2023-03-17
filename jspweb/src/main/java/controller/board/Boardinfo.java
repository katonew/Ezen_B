package controller.board;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.BoardDao;
import model.dao.MemberDao;
import model.dto.PageDto;


@WebServlet("/board/info")
public class Boardinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Boardinfo() { super();}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int type = Integer.parseInt(request.getParameter("type")) ;
		if(type==1) { // 타입이 1이면 전체 출력
			
			// -------------- 카테고리 별 출력 -------------//
			// 1. 카테고리 매개변수 요청 [ cno ]	2.gettotalsize()/getBoardList() 조건 전달 
			int cno = Integer.parseInt( request.getParameter("cno") );
			
			// -------------- 검색 처리 -----------------//
			// 1. 검색에 필요한 매개변수 요청[ key, keyword ]   2.gettotalsize/getBoardList 조건 전달
			String key = request.getParameter("key");			
			String keyword = request.getParameter("keyword");
			
			// ------------- page 처리 --------------- //
			// 1. 현재페이지[요청] , 2.페이지당 표시할게시물수 3.현재페이지[ 게시물시작  ]
			int page = Integer.parseInt( request.getParameter("page") );
			int listsize = Integer.parseInt( request.getParameter("listsize") ) ; // 화면에 표시할 게시물수 요청
			int startrow = (page-1)*listsize; // 해당 페이지에서의 게시물 시작번호
			
			// ------------- page 버튼 만들기 ------------ //
			// 1. 전체페이지수[ 총게시물레코드수/페이지당 표시수 ] 2. 페이지 표시할 최대버튼수 3. 시작버튼/마지막버튼 번호  
			int totalsize = BoardDao.getInstance().gettotalsize( key , keyword , cno );
			int totalpage = totalsize % listsize == 0 ? 	// 만약에 나머지가 0 이면 
							totalsize/listsize :  totalsize/listsize+1;
			int btnsize = 5; // 최대 페이징버튼 출력수
			int startbtn = ( (page-1) / btnsize ) * btnsize +1 ; 
			int endbtn = startbtn + (btnsize-1);
			// * 단 마지막버튼수가 총페이지수보다 커지면 마지막버튼수 총페이지수로 대입 
			if( endbtn > totalpage ) endbtn = totalpage;

			ArrayList<BoardDto> result = BoardDao.getInstance().getBoardList( startrow , listsize , key , keyword , cno );

			// page Dto 만들기 
			PageDto pageDto = new PageDto(page, listsize, startrow, totalsize, totalpage, btnsize, startbtn, endbtn, result);
			// JAVA 형식 --> JS 형식
			ObjectMapper mapper = new ObjectMapper();
			String jsonArray = mapper.writeValueAsString(pageDto);
			// 응답
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			response.getWriter().print(jsonArray);
		}else if(type==2) { // 타입이 2이면 개별 출력
			int bno = Integer.parseInt(request.getParameter("bno"));
			System.out.println("bno : "+bno);
			// Dao 처리
			BoardDto result = BoardDao.getInstance().getBoard(bno);
			// 형변환 처리
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(result);
			// 응답 처리
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			response.getWriter().print(json);
		}
		
		
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
		//업로드 담당
		String path = request.getSession().getServletContext().getRealPath("/board/bfile");
		MultipartRequest multi = new MultipartRequest(
				request,  						// 1. 요청방식 
				path , 							// 2. 첨부파일 가져와서 저장할 서버내 폴더 
				1024*1024 * 10 ,				// 3. 첨부파일 허용 범위 용량[ 바이트단위 ] 10MB
				"UTF-8" ,						// 4. 첨부파일 한글 인코딩 
				new DefaultFileRenamePolicy() 	// 5. 동일한 첨부파일명이 존재했을때 뒤에 숫자 붙여서 식별
				);
		// 수정할 대상 + 수정된 정보 호출
		int bno = Integer.parseInt(multi.getParameter("bno"));
		int cno = Integer.parseInt(multi.getParameter("cno"));
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile");
		
		/* 첨부파일의 수정 경우의 수
			1. 기존에 첨부파일이 없었다. 	
				--> 새로운 첨부파일이 없다. [행동 없음]
				--> 새로운 첨부파일이 있다. [업로드 , 새로운 파일로 업데이트 처리]	
			2. 기존에 첨부파일이 있었다. --> 
				--> 새로운 첨부파일이 없다. [ 기존파일명으로 업데이트 처리 (그대로 사용) ]
				--> 새로운 첨부파일이 있다. [ 업로드,새로운 파일로 업데이트 처리, 기존파일 삭제 ]
		*/
		String oldbfile = BoardDao.getInstance().getBoard(bno).getBfile();
		
		if(bfile==null) {	// 새로운 첨부파일이 없다.
			bfile = oldbfile;
		}else { // 새로운 첨부파일이 있다.
			// 1. 수정 전 기존 첨부파일명 가져오기
			String Filepath = request.getSession().getServletContext().getRealPath("/board/bfile/"+oldbfile);
			File file = new File(Filepath);
			if(file.exists()) {file.delete();}
		}
		
		//dto
		BoardDto dto = new BoardDto(bno, btitle, bcontent, bfile, cno);
		System.out.println("dto : "+ dto);
		//dao
		boolean result = BoardDao.getInstance().bupdate(dto);
		// 응답
		response.getWriter().print(result);
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int type = Integer.parseInt(request.getParameter("type"));
		int bno =  Integer.parseInt(request.getParameter("bno")) ;
		
		//삭제 전 첨부파일명 구하기 [ 타입공통코드 ]
		String bfile = BoardDao.getInstance().getBoard(bno).getBfile();
		boolean result = true;
		
		if(type==1) { // db삭제 + 파일삭제
			// [1] DB에서 삭제처리
			result = BoardDao.getInstance().bdelete(bno);
		}else if(type==2) { // DB업데이트 + 파일삭제
			result = BoardDao.getInstance().bfiledelete(bno);
		}
		
		// [ 삭제] 공통
		if(result) { // 만약에 DB에서 레코드 삭제를 성공 했으면
			String path = request.getSession().getServletContext().getRealPath("/board/bfile/"+bfile);
			File file = new File(path); // 객체화
			if(file.exists()){		// 만약에 파일이 존재하면
				file.delete();		// 파일 삭제
			}
		}
		response.getWriter().print(result);
		
	} // delete e

}// class e




/*
	총 게시물수 = 10		, 페이지당 표시할 게시물수 = 3
	총 레코드수 = 10	총 레코드의 인덱스 : 0~9
	1. 총 페이지수 = 012 , 345 , 678 , 9
	
	2. 페이지별 게시물시작 번호 찾기 
		1페이지 요청 -> (1-1)*3	=> 0
		2페이지 요청 -> (2-1)*3	=> 3
		3페이지 요청 -> (3-1)*3	=> 6
		
	3. 시작버튼 , 마지막버튼 수 
		7페이지	btnsize = 5
				시작번호패턴 : 1 6 11 16 21
		1페이지 -> 12345
		2페이지 -> 12345
		3페이지 -> 12345
		4페이지 -> 12345
		5페이지 -> 12345
		6페이지 -> 678910	--> 67
		7페이지 -> 678910	--> 67
		
		7페이지	btnsize = 3
				시작번호패턴 : 1 4 7 10
		1페이지 -> 123
		2페이지 -> 123
		3페이지 -> 123
		4페이지 -> 456
		5페이지 -> 456
		6페이지 -> 456
		7페이지 -> 7
		
			1페이지 	: 1-1 / 5 	*5 +1			-> 	0*5+1	 	1 
 			2페이지	: 2-1 / 5	*5 +1			->	0*5+1		1
 			3페이지 	: 3-1 / 5	*5 +1			->  0*5+1		1
 			4페이지	: 4-1 / 5	*5 +1			->	0*5+1		1
 			5페이지	: 5-1 / 5	*5 +1			->  0*5+1		1
 			6페이지	: 6-1 / 5 	*5 +1			->  1*5+1 		6
 			7페이지	: 7-1 / 5	*5 +1			->	1*5+1		6
*/













