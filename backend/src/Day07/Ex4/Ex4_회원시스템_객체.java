package Day07.Ex4;

import java.util.Scanner;

public class Ex4_회원시스템_객체 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Member[] memberList = new Member[3];	// Member객체 3개를 저장할 수 있는 배열 선언
												// Member객체 => String 2개를 저장할 수 있는 클래스
		
		while(true) {
			
			//* 출력
			
			System.out.println("-----------------");
			System.out.println("번호\t회원명\t전화번호");
			for(int i=0;i<memberList.length;i++) {
				if(memberList[i]!=null) {
					System.out.println((i+1)+"\t"+memberList[i].name+"\t"+memberList[i].phone);
				}
			}
			
			
			System.out.print("1.회원등록 2.회원삭제 : "); //출력
			int ch = scanner.nextInt();
			if(ch==1) {
				System.out.print("회원명 : ");	
				String inputname = scanner.next();
				System.out.print("전화번호 : ");	
				String inputphone = scanner.next();
				
				for(int i=0;i<memberList.length;i++) {
					if(memberList[i]==null) {
						//[ x ] name + "," + phone
						//[ o ] 객체만들기
						Member member = new Member();	// 1. 객체생성
						member.name = inputname;		// 2. 객체에 입력받은 값을 해당 필드에 대입
						member.phone = inputphone;		// 3. 객체에 입력받은 값을 해당 필드에 대입
						memberList[i] = member;			// 4. 객체를 배열에 저장
						System.out.println((i+1)+"번 회원이 등록되었습니다.");
						break;
					} // if e
				} // for e
				
				
				
			}else if(ch==2) {
				
			}else {
				
			}
		} //while e
	} //main e
} //class e
