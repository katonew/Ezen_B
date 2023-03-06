package practice.day03;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet("/Ex3/Product")
public class Product extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Product() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 응답데이터 한글 인코딩 
		response.setCharacterEncoding("UTF-8");
		// 2. DAO 호출해서 모든 게시물 반환
		ArrayList<ProductDto> result = ProductDao.getInstance().plist();
		System.out.println("DAO LIST : " + result);
		ObjectMapper mapper = new ObjectMapper();
		String jsonArray = mapper.writeValueAsString(result);
		System.out.println("jsonArray : " + jsonArray);
		// 4. 응답
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pname = request.getParameter("pname");
		System.out.println("content : "+pname);
		int pprice = Integer.parseInt(request.getParameter("pprice"));
		System.out.println("writer : "+pprice);
		ProductDto dto = new ProductDto(0, pname, pprice);
		boolean result = ProductDao.getInstance().addproduct(dto);
		response.getWriter().print(result);
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 1. 수정할 게시물 번호 요청
		int pno = Integer.parseInt(request.getParameter("pno"));
		System.out.println("수정할 번호 요청 : " + pno);
		
		// 2. 수정할 게시글 내용 요청
		String newName = request.getParameter("newName");
		System.out.println("수정할 이름 요청 : " + newName);
		
		int newPrice = Integer.parseInt(request.getParameter("newPrice"));
		System.out.println("수정할 가격 요청 : " + newPrice);
		
		// 3. dao 호출해서 결과 얻기
		boolean result = ProductDao.getInstance().pupdate(pno,newName,newPrice);
		// 4. 결과를 응답
		response.getWriter().print(result);
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pno = Integer.parseInt(request.getParameter("pno"));
		System.out.println("삭제할 번호 요청 : " + pno);
		boolean result = ProductDao.getInstance().pdelete(pno);
		// 3. 결과를 응답
		response.getWriter().print(result);
	}

}
