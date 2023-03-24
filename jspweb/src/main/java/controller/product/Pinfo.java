package controller.product;

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

import model.dao.ProductDao;
import model.dto.ProductDto;


@WebServlet("/product/info")
public class Pinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Pinfo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String 동 = request.getParameter("동"); 	System.out.println("동 :" + 동);
		String 서 = request.getParameter("서");	System.out.println("서 :" + 서);
		String 남 = request.getParameter("남");	System.out.println("남 :" + 남);
		String 북 = request.getParameter("북");	System.out.println("북 :" + 북);
		
		
		ArrayList<ProductDto> result =  ProductDao.getInstance().getlist(동,서,남,북);
		
		ObjectMapper mapper = new ObjectMapper();

		String json= mapper.writeValueAsString(result);

		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(json);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getSession().getServletContext().getRealPath("/product/pimg");
		MultipartRequest multi = new MultipartRequest(
				request,						// 1. 요청 방식
				path ,							// 2. 첨부파일을 가져와서 저장할 서버 내 폴더
				1024*1024*10,					// 3. 첨부파일의 허용 범위 용량 [ 바이트 단위 ] 10MB
				"UTF-8",						// 4. 첨부파일 한글 인코딩
				new DefaultFileRenamePolicy()	// 5. 동일한 첨부파일명이 있으면 뒤에 숫자를 붙여줌
				);
		
		String pname = multi.getParameter("pname");
		String pcomment = multi.getParameter("pcomment");
		int pprice = Integer.parseInt(multi.getParameter("pprice"));
		String plat = multi.getParameter("plat");
		String plng = multi.getParameter("plng");
		
		ProductDto dto = new ProductDto(pname, pcomment, pprice, plat, plng);
		boolean result = ProductDao.getInstance().onwrite(dto);
		response.getWriter().print(result);
		
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
