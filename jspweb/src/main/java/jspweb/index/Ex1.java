package jspweb.index;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspweb.model.Dao;

/**
 * Servlet implementation class indextest
 */
@WebServlet("/Ex1")
public class Ex1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Ex1() { super();}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// 1. DAO 실행해서 데이터 호출
		ArrayList<String> result = Dao.getInstance().getData();
		// 2. 확인
		System.out.println("확인 : "+ request);
		// 3. 응답
		response.getWriter().print(result);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. HTTP 객체 [ request : JS에게 요청, response : JS에게 응답]
			// 1. request.getParameter("매개변수명");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String data = request.getParameter("data"); // ajax({ "매개변수명" : 데이터 })
		System.out.println("JS post방식으로 받은 데이터 : " + data);
		
		// 1. DB연동 후 요청된 데이터를 DAO에게 전달 후 결과를 result에 저장
		boolean result = Dao.getInstance().setData(data);
		
		response.getWriter().print("JS post방식으로 받았습니다." + result);
		
		
	}

}
