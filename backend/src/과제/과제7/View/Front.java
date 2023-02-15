package 과제.과제7.View;

import 과제.과제7.Controller.Controller;
import 과제.과제7.Model.Account;

import java.util.Scanner;

public class Front {
	
	// *싱글톤
	private static Front front = new Front();
	private Front() {}
	public static Front getInstance() {return front;}
	
	private Scanner scanner = new Scanner(System.in);
	
	public void index() {
		while(true) {
			System.out.println("------------- 계좌 관리 ---------------");
			System.out.println("은행명\t계좌번호\t예금액");
			System.out.println("메뉴>> 1.계좌생성 2.예금");
			int ch = scanner.nextInt();	// 채널 int로 입력받음
			if(ch == 1) {makeAccount_page();}	// 1번선택하면 계좌생성 페이지
			else if(ch==2) {savingMoney_page();}	// 2번 선택하면 예금 페이지
		}
	}
	
	// 계좌 생성 페이지
	public void makeAccount_page() {
		System.out.println("------------- 계좌 생성 ---------------");
		System.out.print("은행선택>> 1.신한은행 2.국민은행 3.우리은행 : ");
		int bank_Ch = scanner.nextInt();
		if(bank_Ch==1 || bank_Ch==2 || bank_Ch==3) {
			System.out.println("계좌주 : "); String name = scanner.next();
			System.out.println("계좌비밀번호 : ");	String password = scanner.next();
			Account result = Controller.getInstance().addAccount(password, name);
			System.out.println("------------- 계좌 생성 완료  -----------");
			System.out.println("계좌주 : "+result.name);
			System.out.println("계좌번호 : "+result.acountno);
			System.out.println("은행 : ");
		}
		else {System.err.println("유효하지 않은 접근입니다.");}
	}
	
	// 예금 페이지
	public static void savingMoney_page() {}
	//계좌번호, 예금액 입력 - controller에 있는 입금메소드
	
}