package 과제.과제7.View;

import 과제.과제7.Controller.Controller;
import 과제.과제7.Model.Account;

import java.util.ArrayList;
import java.util.Scanner;

public class Front {
	
	// *싱글톤
	private static Front front = new Front();
	private Front() {}
	public static Front getInstance() {return front;}
	
	private static Scanner scanner = new Scanner(System.in);
	
	public void index() {
		while(true) {
			printAccount();
			System.out.print("메뉴>> 1.계좌생성 2.예금 : ");
			int ch = scanner.nextInt();	// 채널 int로 입력받음
			if(ch == 1) {makeAccount_page();}	// 1번선택하면 계좌생성 페이지
			else if(ch==2) {savingMoney_page();}	// 2번 선택하면 예금 페이지
		}
	}
	//계좌 출력 페이지
	public void printAccount() {
		System.out.println("------------- 계좌 관리 ---------------");
		System.out.println("은행명\t계좌번호\t\t예금액");
		ArrayList<Account> result = Controller.getInstance().PrintAccount();
		for(int i=0;i<result.size();i++) {
			System.out.println("~~은행\t"+result.get(i).getAcountno()+"\t"+result.get(i).money);
		}
		
	} 
	
	// 계좌 생성 페이지
	public void makeAccount_page() {
		System.out.println("------------- 계좌 생성 ---------------");
		System.out.print("은행선택>> 1.신한은행 2.국민은행 3.우리은행 : ");
		int bank_Ch = scanner.nextInt();
		if(bank_Ch==1 || bank_Ch==2 || bank_Ch==3) {
			System.out.print("계좌주 : "); String name = scanner.next();
			System.out.print("계좌비밀번호 : ");	String password = scanner.next();
			if(password.length()!=4) {
				System.err.println("계좌비밀번호는 4글자로 입력해주세요.");
				return;
			}
			Account result = Controller.getInstance().addAccount(bank_Ch,password, name);
			System.out.println("------------- 계좌 생성 완료  -----------");
			System.out.println("계좌주 : "+result.getName());
			System.out.println("계좌번호 : "+result.getAcountno());
			System.out.println("은행 : ");
		}
		else {System.err.println("유효하지 않은 접근입니다.");}
	}
	
	// 예금 페이지
	public static void savingMoney_page() {
		System.out.print("입금할 계좌번호 : ");
		String Accountno = scanner.next();
		System.out.print("예금액 : ");
		int plusmoney = scanner.nextInt();
		if(Controller.getInstance().plusmoney(Accountno, plusmoney)) {
			System.out.println("입금하였습니다.");
		}else {System.out.println("일치하는 계좌번호가 없습니다.");}
		
	}
	//계좌번호, 예금액 입력 - controller에 있는 입금메소드
	
}