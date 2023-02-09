package Day06;

import java.util.Random;
import java.util.Scanner;

public class Ex5_틱택토 {	//class s
	public static void main(String[] args) { //main s
		
		//* 입력 객체
		Scanner sc = new Scanner(System.in); 
		
		// 1. 배열선언 : 자료형타입[] 배열명 = { 데이터1, 데이터2, 데이터3 }
		// * 게임판 9칸 문자열 선언
		String[] 게임판 = {
			"[ ]","[ ]","[ ]",
			"[ ]","[ ]","[ ]",
			"[ ]","[ ]","[ ]"
		};
		//* 승리판단 결과 저장 변수
		boolean 결과 = false;	//false 일경우 결과판단 없음 
		
		// 3. 알두기 
		game : while(true) {	//무한 루프 [ 종료조건 : 승리판단 있을경우]
			// ------------1. 배열 내 데이터 호출 // 게임판 반복 출력----------
			for(int i=0;i<게임판.length;i++) {
				System.out.print(게임판[i]);
				if(i%3==2) {System.out.println("");}
			}
			
			
			// --------------2.플레이어가 알두기----------------------------
			while(true) { //무한루프 [ 종료조건 : 정상 알두기를 완료했을때]
				System.out.print("위치[0~8] 선택 : ");
				int 위치 = sc.nextInt();
				// 유효성 검사 [ 1.0~8사이가 아니거나 2. 알이 이미 존재하는 위치라면 --> 다시 입력]
				if(위치<0||위치>8) { // 1. 입력한 숫자가 0~8사이가 아니라면	다시입력	
					System.err.println("[알림] 허용 범위내 입력해주세요.");
					continue;
				}
				if(!게임판[위치].equals("[ ]")) { // 2. 공백이 아니면 다시 입력
					System.err.println("[알림] 이미 알이 존재하는 위치입니다.");
					continue;
				}
				게임판[위치] = "[O]";
				break;
			} // 플레이어 차례 while e
			
			//** 결과가 존재하면 게임종료-------------------------------------
			if(결과==true) {break;}
			//3. 무승부 : 알이 9개이면
			int 빈자리수 = 0;
			for(int i=0;i<게임판.length;i++){
				if(게임판[i].equals("[ ]")) {빈자리수++;}
			}
			if(빈자리수==0) {	결과 = true; System.out.println("[결과] : 무승부"); break game;}
			
			//--------------3. 컴퓨터가 알두기------------------------------
			while(true) {	//무한루프 [ 종료조건 : 정상적인 난수 생성될 떄 break;]
				Random random = new Random();		//난수관련 메소드 제공
				int com = random.nextInt(9);		//0~8
				if(!게임판[com].equals("[ ]")) {continue;}//공백이 아니면 다시 난수 생성
				게임판[com] = "[X]";
				break;
			} // 컴퓨터 차례 while e
			
			//------------4. 승리판단[1.승리 2.패배 3.무승부] -----------------
				//1. 승리판단
					//1. 가로승리		[0,1,2], [3,4,5], [6,7,8]
			for(int i =0;i<=6;i+=3) {
				if(!게임판[i].equals("[ ]")&&게임판[i].equals(게임판[i+1])&&게임판[i+1].equals(게임판[i+2])) {
					System.out.println("[결과] 승리자: " + 게임판[i] );
					break game;
				}
			}
					//2. 세로승리		[0,3,6], [1,4,7], [2,5,8]
			for(int i=0;i<=2;i++) {
				if(!게임판[i].equals("[ ]")&&게임판[i].equals(게임판[i+3])&&게임판[i+3].equals(게임판[i+6])) {
					System.out.println("[결과] 승리자: " + 게임판[i] );
					break game;
				}		
			}
					//3. 대각선승리 	[0,4,8], [2,4,6]
			if(!게임판[0].equals("[ ]")&&게임판[0].equals(게임판[4])&&게임판[4].equals(게임판[8])) {
				System.out.println("[결과] 승리자: " + 게임판[0] );
				break game;
			}
			if(!게임판[2].equals("[ ]")&&게임판[2].equals(게임판[4])&&게임판[4].equals(게임판[6])) {
				System.out.println("[결과] 승리자: " + 게임판[2] );
				break game;
			}
			
			
			
		} //알두기 게임 while e
	} // main e
}	// class e
