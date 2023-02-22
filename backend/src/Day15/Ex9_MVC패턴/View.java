package Day15.Ex9_MVC패턴;

import java.util.ArrayList;
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
			System.out.println("---------시작----------");
			System.out.print("1.등록 : 2.출력 3.수정 4.삭제 : ");
			int ch = sc.nextInt();
			if(ch==1) {signup();}
			else if(ch==2) {list();}
			else if(ch==3) {updatepw();}
			else if(ch==4) {delete();}
			
		}//while e
	}// index e
	
	//2. 회원가입 페이지
	public void signup() {
		System.out.println("----------등록----------");
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
		
		System.out.println("------------회원 목록------------");
		System.out.printf("%s\t%s\t%s\n","번호","아이디","비밀번호");
		// 1. 컨트롤에게서 모든 회원의 정보를 요청하여 반환받은 리스트를 저장
		ArrayList<MemberDto> result =  Controller.getInstance().list();
		// 2. 요청의 결과를 반복문 돌리기
		for(int i=0;i<result.size();i++) {
			System.out.printf("%2d\t%s\t%s\n",result.get(i).getMno(),result.get(i).getMid(),result.get(i).getMpw());
		}
		
	}// list e
	
	// 4. 비밀번호 수정 페이지
	public void updatepw() {
		System.out.println("-------------수정-------------");
		System.out.print("수정할 회원번호 : "); int mno = sc.nextInt();
		System.out.print("수정할 비밀번호 : "); String newpw = sc.next();
		boolean result = Controller.getInstance().updatepw(mno, newpw);
		if(result) {System.out.println("수정완료");}
		else{System.out.println("수정실패");}
	}
	
	public void delete() {
		System.out.println("-------------삭제-------------");
		System.out.print("삭제할 회원번호 : "); int mno = sc.nextInt();
		boolean result = Controller.getInstance().delete(mno);
		if(result) {System.out.println("삭제완료");}
		else{System.out.println("삭제실패");}
	}
	
	
} // class e












