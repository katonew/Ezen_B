package Day20.gallary.View;

import java.util.Scanner;

import Day20.gallary.Contoller.Mcontroller;

public class IndexView {

	//1. 싱글톤
	private static IndexView dao = new IndexView();
	private IndexView() {}
	public static IndexView getInstance() {return dao;}
			
	private Scanner scanner = new Scanner(System.in);
	
	// 메인페이지
	public void index() {
		while(true) {
			System.out.println("-------갤러리---------");
			System.out.print("1.로그인 2.회원가입 : ");
			try {
				int ch = scanner.nextInt();
				if(ch==1) {login();}
				else if(ch==2) {signup();}
			}catch (Exception e) {
				System.out.println("잘못된 입력입니다.");
				scanner = new Scanner(System.in);
			}	
		} // while e
	} // index e
	
	// 회원가입 페이지
	public void signup() throws Exception{ // 만일 해당 메소드에서 예외 발생하면 호출했던 곳으로 예외 이동
		
		System.out.println("-------회원가입---------");
		System.out.print("아이디 : ");	String mid = scanner.next();
		System.out.print("비밀번호 : ");	String mpw = scanner.next();
		System.out.print("이름 : ");		String mname = scanner.next();
		System.out.print("전화번호 : ");	String mphone = scanner.next();
		
		int result = Mcontroller.getInstance().signup(mid, mpw, mname, mphone);
		if (result==1) {System.out.println("회원가입 성공");}
		else if (result==2) {System.out.println("이미 사용중인 아이디입니다.");}
		else if (result==3) {System.out.println("시스템 오류");}
		
	}
	
	// 3. 로그인 페이지
	public void login() {
		System.out.println("-------로그인---------");
		System.out.print("아이디 : ");	String mid = scanner.next();
		System.out.print("비밀번호 : ");	String mpw = scanner.next();
		
		boolean result = Mcontroller.getInstance().login(mid, mpw);
		if(result) {
			System.out.println("로그인 성공");
			// 게시글 초기메뉴로 이동
		}
		else {System.out.println("로그인 실패");}
		
	}
	
	
	
	
} // class e
