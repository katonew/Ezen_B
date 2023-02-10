package Day08.Ex5;

import java.util.ArrayList;
import java.util.Scanner;

public class Front {
	Scanner scanner = new Scanner(System.in);
	ArrayList<Member> memberList = new ArrayList<>();
	//1. 필드
	
	//2. 생성자
		
	//3. 메소드
	
		//1. 메인페이지 프론트 함수
	void index() {
		while(true) {
			print();
			System.out.print("1.회원등록 2.회원삭제 : ");
			int ch = scanner.nextInt();
			if(ch==1) {	signup();}
			else if(ch==2) {delete();}
			else {}
		} // while e
	} //index e
	
		//2. 회원 등록 페이지 함수
	void signup() {
		System.out.print("회원명 : ");	String name = scanner.next();
		System.out.print("전화번호 : ");	String phone = scanner.next();
		
		Member member = new Member(name, phone);
		// * 배열 or 리스트에 객체 저장
		memberList.add(member);
	}
	
		//3. 회원 삭제 페이지 함수
	void delete() {
		System.out.print("삭제할 번호 : ");
		int no = scanner.nextInt();
		memberList.remove(no);
	}
	
		//4. 회원 출력 함수
	void print() {
		System.out.println("번호\t회원\t전화번호");
		for(int i =0;i<memberList.size();i++) {
			System.out.println(i+"\t"+memberList.get(i).name+"\t"+memberList.get(i).phone);
		}
	}
	
} // class e

















