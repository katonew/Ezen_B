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


@WebServlet("/regist")
public class regist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public regist() { super(); }

    // 1. 회원등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uploadpath = request.getSession().getServletContext().getRealPath("/practice/과제/과제1/img");
		System.out.println( uploadpath );
		
		MultipartRequest multi = new MultipartRequest(
				request, 
				uploadpath,
				1024*1024*10,
				"UTF-8",
				new DefaultFileRenamePolicy() 
		);
		
		String name = multi.getParameter("name");			System.out.println( name );
		String part = multi.getParameter("part");			System.out.println( part );
		String jobgrade = multi.getParameter("jobgrade");	System.out.println( jobgrade );
		String type = multi.getParameter("type");			System.out.println( type );
		String img = multi.getFilesystemName("img");		System.out.println( img );
		
		Mdto dto = new Mdto(
				0 , img , name , jobgrade , type , null , null , null , part , 0 );
		
		boolean result = regDao.getInstance().regist(dto);
		
		response.getWriter().print(result);
		
		
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 2. 부서목록 가져오기
		ArrayList<Pdto> list = regDao.getInstance().partList();
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString( list );
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(json);
	}

	


}
