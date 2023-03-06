package practice.day03;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex3")	// <-- 해당 클래스[자원] URL 정의 , localhost:8080/jspweb/Ex3
public class Ex3 extends HttpServlet {	// <-- HttpServlet 클래스 상속
	private static final long serialVersionUID = 1L;
       
    public Ex3() {
        super();
    }
    
	// 1. post 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post메소드에서 통신 받았습니다.");
	}
	
    // 2. get 메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get메소드에서 통신 받았습니다.");
	}
	// 3. put 메소드
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("put메소드에서 통신 받았습니다.");
	}
	// 4. delete 메소드
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("delete메소드에서 통신 받았습니다.");
	}

}














