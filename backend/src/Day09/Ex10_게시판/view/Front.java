package Day09.Ex10_게시판.view;

import java.util.Date;
import java.util.Scanner;

import Day09.Ex10_게시판.controller.Bcontroller;

public class Front {
	// 1. 싱글톤 객체	[1. 프로그램 내 하나의 객체 - 공유 메모리]
		private static Front front = new Front();
		private  Front() {}
		public static Front getInstance() {
			return front;
		}
		
		
		// 필드 : 입력 객체 필드 [ 인스턴스 멤버]
		private Scanner scanner = new Scanner(System.in);
		
		//2.index 함수
		public void index() {
			while(true) {
				print_page(); //출력함수
				System.out.print("1. 쓰기 : ");
				int ch = scanner.nextInt();
				if(ch==1) {write_page();}	//쓰기 함수
			} // while e
		} // index 함수 e
		
		//3. 쓰기 페이지 함수
		private void write_page() {
			System.out.println("----------글쓰기 페이지------------");
			System.out.print("제목 : ");
			String title = scanner.next();
			System.out.print("내용 : ");
			String content = scanner.next();
			System.out.print("작성자 : ");
			String writer = scanner.next();
			System.out.print("비밀번호 : ");
			String password = scanner.next();
			Date date = new Date();
			System.out.println("현재날짜/시간 : "+date);
			int view = 0;
			Bcontroller.getInstance().write(title, content,writer,password,date,view);
			
		}
		
		//4. 출력 페이지 함수
		private void print_page() {
			System.out.println("----------글보기 페이지------------");
		}
}
