package jspweb.index;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspweb.model.Dao;


@WebServlet("/Q1")
public class Q1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Q1() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ArrayList<String> list = Dao.getInstance().q1GetData();
		response.getWriter().print(list);
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// js에서 ajax를 이용해 가져온 데이터를 data라는 변수에 대입
		String data = request.getParameter("data");
		boolean result = Dao.getInstance().q1SetData(data);
		if(result) {System.out.println("입력성공");}
		else {System.out.println("입력실패");}
	}

}
