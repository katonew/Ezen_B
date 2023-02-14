package 미니팀플.view;

import java.util.ArrayList;
import java.util.Scanner;

import 미니팀플.controller.Mcontroller;
import 미니팀플.controller.Pcontroller;
import 미니팀플.model.Product;
/*
	- 회원가입
		인수: id , pw , confirmpwd,name,phone			반환 : true / false
	- 로그인
		인수: id, pw					반환 : 성공,실패
	- 마이페이지
		인수: X						반환 : 현재 로그인 된 사람에게 온 쪽지ArrayList , 현재 로그인 된 사람이 보낸 쪽지ArrayList 

	------Pcontroller

	- 상품 출력
		인수: X						반환 :  모든 제품이 담긴 ArrayList
	- 상품 등록
		인수: title,content,price				반환 : true / false
	- 상품 개별보기
		인수: 해당상품인덱스번호				반환 :  product 한개

	-------MemoController

	- 쪽지 보내기
		인수: Product올린사람member , 쪽지title, 쪽지content	반환 : true / false
	- 내게 온 쪽지	
		인수: X						반환 : 모든 내게 온 쪽지가 담긴 ArrayList
	- 쪽지보기	
		인수: 쪽지인덱스 					반환 : 해당 Memo


*/
public class Front {
	//* 싱글톤
	private static Front front = new Front();
	private Front() {}
	public static Front getInstance() {return front;}
	
	private Scanner scanner = new Scanner(System.in);
	
	// index 페이지
	public void index() {
		while(true) { // 무한루프 : 종료조건 없음
			System.out.println("--------------로그인----------------");
			System.out.print("1.회원가입 2.로그인 : ");
			int ch = scanner.nextInt();
			if(ch==1) {signup();}
			else if(ch==2) {login();}
			else{System.err.println("잘못입력하셨습니다.");}
		} // while e
	} // index e
	
	// 로그인 페이지
	public void login() {
		System.out.print("아이디 : ");
		String id = scanner.next();
		System.out.print("비밀번호 : ");
		String pw = scanner.next();
		boolean result = Mcontroller.getInstance().login(id, pw);
		if(result) {
			System.out.println("로그인 성공");
			printProduct();
		}else {
			System.err.println("잘못 입력하셨습니다.");
			return;
		}
		
	} // login e
	
	// 회원가입 페이지
	public void signup() {
		System.out.print("아이디 : ");		String id = scanner.next();
		System.out.print("비밀번호 : ");		String pw = scanner.next();
		System.out.print("비밀번호 확인 : ");	String confirmpw = scanner.next();
		System.out.print("이름 : ");			String name = scanner.next();
		System.out.print("전화번호 : ");		String phone = scanner.next();
		boolean result = Mcontroller.getInstance().signup(id, pw, confirmpw, name, phone);
		if(result) {System.out.println("[알림] 회원가입 성공.");}
		else {System.err.println("[알림] 회원가입 실패. 패스워드가 다릅니다.");}
	}
	
	//상품 출력 페이지 ( 로그인 성공시)
	public void printProduct() {
		System.out.println("-----------상품내역-----------");
		System.out.println("번호\t상품이름\t상품정보\t가격\t판매자\t판매상태");
		ArrayList<Product> result = Pcontroller.getInstance().printProduct();
		for(int i;i<result.size();i++) {
			System.out.println(i+"\t"+
								result.get(i).getName()+"\t"+
								result.get(i).getContent()+"\t"+
								result.get(i).getPrice()+"\t"+
								result.get(i).getMember().getId()+"\t"+
								result.get(i).isState()? "판매중" :"거래완료");
		}
	}
	
	// 마이페이지 페이지
	public void mypage() {
		System.out.println("이름\t전화번호\t내게온쪽지");
		System.out.println("1. 내게온 쪽지 2. 내가 보낸쪽지 : ");
		int sc = scanner.nextInt();
		if(sc==1) {
			receiveMemo();
		}
	}
	// 상품 등록 페이지
	public void plusProduct() {
		
	}
	// 상품 개별 보기 페이지
	public void getProduct() {
		
	}
	// 쪽지 보내기 페이지
	public void sendMemo() {
		
	}
	// 내게 온 쪽지 출력 페이지
	public void receiveMemo() {
		
	}
	// 내가 보낸 쪽지 출력 페이지
	public void mysendMemo() {
		
	}
	
	
	
	
	
	
	
	
}
