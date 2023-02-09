package Day07.Ex6;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex6_회원시스템_컬렉션프레임워크 {
	public static void main(String[] args) { //main s
		
		Scanner scanner = new Scanner(System.in);
		ArrayList<Member> memberList = new ArrayList<>();
			//ArrayList 	: 리스트 선언 사용되는 클래스
			//<자료형/타입> 	: 리스트 안의 항목에 들어갈 자료형/타입
		
		
		while(true) {
			// js : (인수)=>{실행문} 익명화살표 함수 vs java : (인수)=>{실행문;}
			// 배열명.length : 배열 내 길이				[고정길이]
			// 리스트명.size() : 리스트 내 요소들의 개수 	[가변길이]
			System.out.println("번호\t회원명\t전화번호");
			for(int i=0;i<memberList.size();i++) {
				System.out.println(i+"\t"+memberList.get(i).name+"\t"+ memberList.get(i).phone);
			}
			
			System.out.print("1.회원등록 2.회원삭제 : "); //출력
			int ch = scanner.nextInt();
			if(ch==1) {
				System.out.print("회원명 : ");	
				String inputname = scanner.next();
				System.out.print("전화번호 : ");	
				String inputphone = scanner.next();
				
				Member member = new Member();
				member.name = inputname;
				member.phone = inputphone;
				memberList.add(member);	//리스트에 객체 추가 // js ==> push
				
			}else if(ch==2) {
				System.out.println("삭제할 번호 : ");
				int no = scanner.nextInt();
				memberList.remove(no);
			}
			else {System.out.println("잘못입력하였습니다."); continue;}
		} //while e		
	} //main e
}
