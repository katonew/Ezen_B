package 과제.과제4.view;

import java.util.Scanner;

import 과제.과제4.controller.Mcontroller;

// * 입출력 : print , scanner

public class Front {
	
	Scanner scanner = new Scanner(System.in);
	Mcontroller mc = new Mcontroller();
	
	//1. 메인페이지
	public void index() {
		while(true) {
			System.out.print("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호 찾기 : ");
			int ch = scanner.nextInt();
			if(ch==1) {	signup();}
			else if(ch==2) {login();}
			else if(ch==3) {findid();}
			else if(ch==4) {findpwd();}
			else {}
		} //while e
	}
		//2. 회원가입 페이지
	public void signup() {
		System.out.print("아이디 : ");String id = scanner.next();
		System.out.print("비밀번호 : ");String pwd = scanner.next();
		System.out.print("비밀번호 확인 : ");String confirmpwd = scanner.next();
		System.out.print("이름 : ");String name = scanner.next();
		System.out.print("전화번호 : ");String phone = scanner.next();
		int result = mc.signup(id,pwd,confirmpwd,name,phone);
		if(result==1) {System.out.println("회원가입 실패");}
		else if(result==0) {System.out.println("회원가입 성공");}
	}	
		//3. 로그인 페이지
	public void login() {
		System.out.print("아이디 : ");	String id = scanner.next();
		System.out.print("비밀번호 : ");	String pwd = scanner.next();
		int result = mc.login(id, pwd);
		if(result>0) {
			System.out.println("로그인 성공");
			//게시판으로 이동
		}else if(result==-1) {
			System.err.println("비밀번호가 틀렸습니다.");
		}else if(result==-2) {
			System.err.println("일치하는 아이디가 없습니다.");
		}
	}	
		//4. 아이디 찾기 페이지
	public void findid() {
		System.out.print("이름 : ");		String name = scanner.next();
		System.out.print("전화번호 : ");	String phone = scanner.next();
		String findid = mc.findId(name,phone);
		System.out.println(findid);
	}
		//5. 비밀번호 찾기 페이지
	public void findpwd() {
		System.out.print("아이디 : ");	String id = scanner.next();
		System.out.print("전화번호 : ");	String phone = scanner.next();
		String findpwd = mc.findpwd(id,phone);
		System.out.println(findpwd);
	}
}
