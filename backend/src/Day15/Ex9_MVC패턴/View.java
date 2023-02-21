package Day15.Ex9_MVC패턴;

import java.util.Scanner;

public class View {
	
	Scanner sc = new Scanner(System.in);
	
	//싱글톤
	private static View view = new View();
	private View() {}
	public static View getInstance() {return view;}
	
	// 1. 초기 메인 페이지
	public void index() {
		while(true) {
			System.out.println("-----시작------");
			System.out.print("1.등록 : 2.출력 3.수정 4.삭제 : ");
			int ch = sc.nextInt();
			if(ch==1) {
				signup();
			}else if(ch==2) {}
			else if(ch==3) {}
			else if(ch==4) {}
			
		}//while e
	}// index e
	
	//2. 회원가입 페이지
	public void signup() {
		System.out.println("-----등록------");
		// 1. 입력 받기
		System.out.print("아이디 : "); String mid = sc.next();
		System.out.print("비밀번호 : "); String mpw = sc.next();
		// 2. 입력받은 데이터를 컨트롤에게 전달 후 결과값 받기
		boolean result = Controller.getInstance().signup(mid,mpw);
		// 3. 결과에 따른 출력
		if(result) {System.out.println("회원가입 성공");}
		else {System.out.println("회원가입 실패");}
	} // signup e
	
	// 3. 회원목록 화면
	public void list() {
		
	}// list e
	
	
	
	
} // class e












