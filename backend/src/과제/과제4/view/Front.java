package 과제.과제4.view;

import java.util.Scanner;

import 과제.과제4.controller.Bcontroller;
import 과제.과제4.controller.Mcontroller;
import 과제.과제4.model.Board;

// * 입출력 : print , scanner

public class Front {
	
	Scanner scanner = new Scanner(System.in);
	Mcontroller mc = new Mcontroller();
	Bcontroller bc = new Bcontroller();
	
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
	} // index 함수 e
	
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
		if(result>=0) {
			System.out.println("로그인 성공");
			board(result);
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
		if(findid==null) {System.err.println("일치하는 회원정보가 없습니다.");}
		else {System.out.println(findid);}
		
	}
		//5. 비밀번호 찾기 페이지
	public void findpwd() {
		System.out.print("아이디 : ");	String id = scanner.next();
		System.out.print("전화번호 : ");	String phone = scanner.next();
		String findpwd = mc.findpwd(id,phone);
		if(findpwd==null) {System.err.println("일치하는 회원정보가 없습니다.");}
		else {System.out.println(findpwd);}
	}
		// 게시판 페이지
	public void board(int loginno) {
		while(true) {
			printBoard();
			System.out.print("메뉴> 1.글쓰기 2.글보기 3.로그아웃 : ");
			int ch2 = scanner.nextInt();
			if(ch2==1) {		//글쓰기 선택시
				writeBorad(loginno);
			}else if(ch2==2) {	//글 보기 선택시
				viewBoard(loginno);
			}else if(ch2==3) {	//로그아웃 선택시
				index();		//다시 index 함수로
			}else {System.out.println("잘못 입력하셨습니다.");}
		} // while e
	}// board e
	
		// 게시판 현황 출력 페이지
	public void printBoard() {
		System.out.print(bc.printBoard());
	}
	
		// 글쓰기 페이지
	public void writeBorad(int loginno) {
		System.out.println("제목 : ");	String title = scanner.next();
		System.out.println("내용 : ");	String content = scanner.nextLine();
		bc.writeBorad(mc.loginid(loginno),title,content);
		System.out.println("글이 등록되었습니다.");
	}
		// 글 보기 페이지
	public void viewBoard(int loginno) {
		System.out.println("게시물 번호 입력 :");
		int ch3 = scanner.nextInt();
		Board closeContent = bc.viewBoard(mc.loginid(loginno),ch3);
		System.out.println("제목 : "+closeContent.title);
		System.out.println("작성자 : "+closeContent.writer);
		System.out.println("조회수 : "+closeContent.views);
		System.out.println("내용 : "+closeContent.content);
		System.out.println("메뉴> 1. 글삭제 2. 글수정 3. 뒤로가기 : ");
	}
	
} //class e



















