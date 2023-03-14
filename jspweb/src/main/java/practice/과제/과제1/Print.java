package practice.과제.과제1;

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

@WebServlet("/print")
public class Print extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Print() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");
		
		if( type.equals("0") ) { // 타입이 0 일때 전체 사원 출력
			
			// Dao 에게 모든 회원명단 요청후 저장
			ArrayList<Mdto> result = printDao.getInstance().print();
			// JAVA객체를 JS객체로 형변환
			ObjectMapper mapper = new ObjectMapper();
			String jsonArray = mapper.writeValueAsString(result);
			// ajax에게 응답
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			response.getWriter().print(jsonArray);
			
		} else if ( type.equals("1") ) { // 타입이 1 일때 재직자 출력
			
			ArrayList<Mdto> result = printDao.getInstance().inprint();
			
			ObjectMapper mapper = new ObjectMapper();
			String jsonArray = mapper.writeValueAsString(result);
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			response.getWriter().print(jsonArray);
			
		}else if ( type.equals("2") ) { // 타입이 2 일때 퇴직자 출력
			
			ArrayList<Mdto> result = printDao.getInstance().outprint();
			
			ObjectMapper mapper = new ObjectMapper();
			String jsonArray = mapper.writeValueAsString(result);
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			response.getWriter().print(jsonArray);
			
		}else if ( type.equals("3") ) { // 타입이 2 일때 퇴직자 출력
			
			String serch = request.getParameter("serch");
			ArrayList<Mdto> result = printDao.getInstance().serch(serch);
			ObjectMapper mapper = new ObjectMapper();
			String jsonArray = mapper.writeValueAsString(result);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			response.getWriter().print(jsonArray);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt( request.getParameter("no") );
		String outreason = request.getParameter("outreason");
		
		boolean result = regDao.getInstance().outdate(no, outreason);
		
		response.getWriter().print(result);
		
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getSession().getServletContext().getRealPath("/practice/과제/과제1/img");
		// 2. 객체
		MultipartRequest multi = new MultipartRequest(
			request, 
			path , 
			1024*1024*10,
			"UTF-8",
			new DefaultFileRenamePolicy()
		);
		String img = multi.getFilesystemName("newimg");
		String name = multi.getParameter("name");
		String type = multi.getParameter("type");
		String part = multi.getParameter("part");
		int no = Integer.parseInt( multi.getParameter("no") ) ;
		System.out.println("수정 img : "+img);
		System.out.println("수정 name : "+name);
		System.out.println("수정 type : "+type);
		System.out.println("수정 part : "+part);
		System.out.println("수정 no : "+ no);
		boolean result = printDao.getInstance().onUpdate(img, name, type, part, no);
		response.getWriter().print(result);
		
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		System.out.println("no : " + no);
		boolean result = printDao.getInstance().onDelete(no);
		response.getWriter().print(result);
	}

}
