package 과제.과제4_싱글톤.view;

import java.util.ArrayList;
import java.util.Scanner;

import 과제.과제4_싱글톤.controller.Bcontroller;
import 과제.과제4_싱글톤.controller.Mcontroller;
import 과제.과제4_싱글톤.model.Board;

public class Front {
	
	//*  싱글톤
	private static Front front = new Front();
	private Front() {}
	public static Front getInstance() {return front;}
	
	private Scanner scanner = new Scanner(System.in);
	
	//1. 메인 페이지
	public void index() {
		while(true) { // 무한루프 : 종료조건 없음
			System.out.println("--------------로그인----------------");
			System.out.print("1.회원가입 2.로그인 3.아이디찾기 4. 비밀번호 찾기 : ");
			int ch = scanner.nextInt();
			if(ch==1) {signup_page();}
			else if(ch==2) {login_page();}
			else if(ch==3) {findid_page();}
			else if(ch==4){findpw_page();}
		} // while e
	} // index e
	
	//2. 회원가입 페이지
	public void signup_page() {
		//1. 입력부
		System.out.print("아이디 : ");		String id = scanner.next();
		System.out.print("비밀번호 : ");		String pw = scanner.next();
		System.out.print("비밀번호 확인 : ");	String confirmpw = scanner.next();
		System.out.print("이름 : ");			String name = scanner.next();
		System.out.print("전화번호 : ");		String phone = scanner.next();
		//2. 컨트롤에게 전달 후 결과 받기
		int result = Mcontroller.getInstance().signup(id, pw, confirmpw, name, phone);
		//3. 결과 제어
		if(result==1) {System.err.println("[알림] 회원가입 실패. 패스워드가 다릅니다.");}
		else if(result==0) {System.out.println("[알림] 회원가입 성공.");}
		else {System.err.println("잘못입력하였습니다");}
	}// signup_page e
	
	//3. 로그인 페이지
	public void login_page() {
		System.out.print("아이디 : ");		String id = scanner.next();
		System.out.print("비밀번호 : ");		String pw = scanner.next();
		//2. 컨트롤에게 전달 후 결과 받기
		int result = Mcontroller.getInstance().login(id, pw);
		//3. 결과 제어
		if(result==-1) {System.err.println("[알림] 로그인 실패. 패스워드가 다릅니다.");}
		else if(result==-2) {System.err.println("[알림] 로그인 실패. 패스워드가 다릅니다.");}
		else{
			System.out.println("[알림] 로그인 성공");
			// 로그인 성공 시 게시글을 볼 수 있도록 보드페이지 함수로 이동
			board_page();
		}
	}//login_page e
	
	//4. 아이디 찾기 페이지
	public void findid_page() {
		System.out.print("이름 : ");		String name = scanner.next();
		System.out.print("전화번호 : ");		String phone = scanner.next();
		//2. 컨트롤에게 전달 후 결과 받기
		String result = Mcontroller.getInstance().findid(name, phone);
		if(result==null) {System.err.println("[알림] 일치하는 정보가 없습니다.");}
		else{System.out.println("회원님의 아이디는 "+result+" 입니다.");}
		
	} //findid_page e
	
	//5. 비밀번호 찾기 페이지
	public void findpw_page() {
		System.out.print("id : ");		String id = scanner.next();
		System.out.print("전화번호 : ");		String phone = scanner.next();
		//2. 컨트롤에게 전달 후 결과 받기
		String result = Mcontroller.getInstance().findpw(id, phone);
		if(result==null) {System.err.println("[알림] 일치하는 정보가 없습니다.");}
		else{System.out.println("회원님의 비밀번호는 "+result+" 입니다.");}
	}	//findpw_page e
	
	// 6. 로그인 성공시 게시물 출력 페이지
	public void board_page() {
		while(true) {
			System.out.println("--------------커뮤니티----------------");
			System.out.println("번호\t조회수\t작성자\t제목");
			// 출력부 전체출력
			int i=0;	//인덱스용
			for(Board b : Bcontroller.getInstance().getList()) { 
				System.out.println(i+"\t"+b.getView()+"\t"+b.getMember().getId()+"\t"+b.getTitle());
				i++;
			}
			//메뉴
			System.out.print("1.쓰기 2.글보기 3.로그아웃 : ");
			int ch2 = scanner.nextInt();
			if(ch2==1) {	//글 쓰기 선택시
				write_page();
			}
			else if(ch2==2) {	//글 보기 선택시
				view_page();
			}
			else if(ch2==3) { //로그아웃 선택시
				Mcontroller.getInstance().logOut(); //로그아웃 함수
				return; // index 함수로 돌아가기
			}
			
		}// while e
	}//board_page e
	
	// 7. 게시글 쓰기 페이지
	public void write_page() {
		System.out.print("제목 : ");		String title = scanner.next();
		System.out.print("내용 : ");		String content = scanner.next();
		boolean result = Bcontroller.getInstance().write(title, content);
		if(result) {System.out.println("[알림] 글 작성 성공");}
		else {System.err.println("[알림] 글 작성 실패");}
	}//write_page e
	
	// 8. 게시글 상세보기 페이지
	public void view_page() {
		System.out.print("*이동할 게시물 번호[인덱스] : ");
		int bno = scanner.nextInt();
		Board result = Bcontroller.getInstance().getBoard(bno);
		System.out.println("제목 : "+result.getTitle());
		System.out.println("작성자 : "+result.getMember().getId()+"\t조회수 : "+result.getView());
		System.out.println("내용 : "+result.getContent());
		System.out.print("1.삭제 2.수정 3.뒤로가기 : ");
		int ch3 = scanner.nextInt();
		if(ch3==1) {delete(bno);}			//삭제 선택시
		else if(ch3==2) {update_page(bno);}	//수정 선택시
		else if(ch3==3) {return;}			//뒤로가기 선택시
	}//view_page e
	
	// 9. 게시물 삭제 페이지
	public void delete(int bno) {
		//유효성 검사 [ 현재 게시글의 작성자와 현재 로그인 된 회원과 같으면
		if(Bcontroller.getInstance().getBoard(bno).getMember().equals(Mcontroller.getInstance().getLoginSession())) {
			Bcontroller.getInstance().delete(bno);
			System.out.println("[알림] 게시글 삭제 성공");
			return;
		}else {
			System.err.println("[알림] 삭제 권한이 없습니다.");
			return;
		}
	}
	
	// 10. 게시글 수정 페이지
	public void update_page(int bno) {
		if(Bcontroller.getInstance().getBoard(bno).getMember().equals(Mcontroller.getInstance().getLoginSession())) {
			System.out.print("수정할 제목 : ");		String title = scanner.next();
			System.out.print("수정할 내용 : ");		String content = scanner.next();
			Bcontroller.getInstance().update(bno,title,content);
			System.out.println("[알림] 게시글 수정 성공");
			return;
		}else {
			System.err.println("[알림] 수정 권한이 없습니다.");
			return;
		}
	}	//update_page e
	
}//class e








