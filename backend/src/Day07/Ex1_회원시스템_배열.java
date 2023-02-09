package Day07;

import java.util.Scanner;

public class Ex1_회원시스템_배열 {	//class s

	public static void main(String[] args) { // main s
		Scanner scanner = new Scanner(System.in);	//입력객체
		// 문자열 3개를 저장할 수 있는 배열 선언
		// 초기값 : { NULL, NULL, NULL}
		String[] memberList = new String[3];	//고정길이
		
		while(true) { //무한루프 [종료조건 없음]
			
			//2.배열 내 데이터 출력
			System.out.println("-----------------");
			System.out.println("번호\t회원명\t전화번호");
			for(int i=0;i<memberList.length;i++) {
				if(memberList[i]!=null) {
					String[] member = memberList[i].split(",");
					System.out.println((i+1)+"\t"+member[0]+"\t"+member[1]);
				}
			}
			
			System.out.print("1.회원등록 2.회원삭제 : "); //출력
			int ch = scanner.nextInt();	//입력받은 값
			if(ch==1) { //1을 입력했을때
				System.out.print("회원명 : ");		String name = scanner.next();
				System.out.print("전화번호 : ");	String phone = scanner.next();
				
				// 1. 배열내 데이터 등록 // push 기능 만들기 [ 배열내 빈공간(NULL) 찾기]
				for(int i=0; i<memberList.length;i++) {
					if(memberList[i]==null) { // i번째 인덱스가 null이면
						memberList[i] = name+","+phone;	//이름과 전화번호 1개의 문자열 합치기
						System.out.println((i+1)+"번 회원이 등록되었습니다. 정보 : " + memberList[i]);
						break;	//저장했으면 반복문 종료
					}//if e
				}//for e
				
				
			}else if(ch==2){	//2를 입력했을때
				System.out.print("삭제할 번호 : ");
				int no = scanner.nextInt();
				//3. 배열 내 데이터 삭제 // splice 기능 [ 배열내 null 만들기]
				memberList[no-1] = null;
				//* 삭제 후 빈자리 채우기 [ 삭제 된 인덱스 뒤로 한칸씩 당기기 ]
				for(int i = (no-1);i<memberList.length;i++){
					if(i+1==memberList.length) {	//마지막 인덱스 이면
						memberList[i] = null;	//마지막 인덱스에 null 넣고 나가기
						break;
					}
					memberList[i] = memberList[i+1];
					if(memberList[i+1]==null) {break;} //다음 인덱스가 null이면 종료
				}
				
				
			}else {	// 그외를 입력했을때
				
			}
		} //while e

	} //main e
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

} //class s
