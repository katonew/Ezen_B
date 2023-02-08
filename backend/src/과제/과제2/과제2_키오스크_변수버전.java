package 과제.과제2;

import java.util.Scanner;

public class 과제2_키오스크_변수버전 { // class s 
	public static void main(String[] args) { // main s 
		// * 입력객체
		Scanner scanner = new Scanner(System.in);
		// * 가격 변수
		int 콜라가격 = 300; 	int 사이다가격 = 400; 	int 환타가격 = 500;
		// * 재고 변수 
		int 콜라재고 = 10;	int 사이다재고 = 8;	int 환타재고 = 15;
		// * 장바구니 변수 
		int 콜라바구니 = 0;	int 사이다바구니 = 0;	int 환타바구니 = 0;
		
		// * 프로그램 실행 반복
		while( true ) { // while s 
			System.out.println("-------------------------");
			System.out.print("1.콜라 2.사이다 3.환타 4.결제 >>>>  ");
			int 메뉴 = scanner.nextInt();
			// * 메뉴에 따른 제어 !!! 
			if( 메뉴 == 1 ) { 	// 1.콜라 선택지
				//1.재고 여부 판단
				if(콜라재고>0) {	콜라재고--; 콜라바구니++; System.out.println("콜라를 담았습니다.");	}
				else {System.err.println("[알림] 콜라재고 부족"); }
				
			}
			else if( 메뉴 == 2 ) { 	//2.사이다 선택지
				if(사이다재고>0) {	사이다재고--; 사이다바구니++; System.out.println("사이다를 담았습니다.");	}
				else {System.err.println("[알림] 사이다재고 부족"); }
				
			}
			else if( 메뉴 == 3 ) { 	//3.환타 선택지
				if(환타재고>0) {	환타재고--; 환타바구니++; System.out.println("환타를 담았습니다.");	}
				else {System.err.println("[알림] 환타재고 부족"); }
				
			}
			else if( 메뉴 == 4 ) {	//결제 선택지
				System.out.println("------------구매 목록-------------");
				System.out.println("제품명\t수량\t가격");
				//1.만약 바구니에 제품이 있을 경우에만 출력
				if(콜라바구니>0) System.out.println("콜라\t"+콜라바구니+"\t"+(콜라가격*콜라바구니));
				if(사이다바구니>0) System.out.println("사이다\t"+사이다바구니+"\t"+(사이다가격*사이다바구니));
				if(환타바구니>0) System.out.println("환타\t"+환타바구니+"\t"+(환타가격*환타바구니));
				//2.총가격
				int 총가격 = (콜라가격*콜라바구니)+(사이다가격*사이다바구니)+(환타가격*환타바구니);
				if(총가격>0) {
					System.out.println("[알림] 총가격 : "+총가격);
				}
				//3. 결제 여부 제어
				System.out.println("1.결제 2.취소 선택 >>>");
				int 결제메뉴 = scanner.nextInt();
				if(결제메뉴==1) {
					System.out.println("[알림] 결제 금액 : ");
					int 금액 = scanner.nextInt();
					if(금액>=총가격) {
						System.out.println("[알림] 결제 완료 주문번호 : A - 01");
						System.out.println("거스름돈 : " + (금액-총가격));
					}else {
						System.out.println("[알림] 결제취소 : 금액이 부족합니다.");
						콜라재고 += 콜라바구니;	사이다재고 += 사이다바구니;	환타재고 += 환타바구니; //장바구니에 있던 물건들 다시 채우기
						
					}
					콜라바구니 =0; 사이다바구니 = 0; 환타바구니 = 0;	//장바구니 비우기
				}
				else if(결제메뉴==2) {
					System.out.println("[알림] 결제를 취소합니다.");
					콜라재고 += 콜라바구니;	사이다재고 += 사이다바구니;	환타재고 += 환타바구니; //장바구니에 있던 물건들 다시 채우기
					콜라바구니 =0; 사이다바구니 = 0; 환타바구니 = 0;	//장바구니 비우기
				}
				else {System.err.println(" [알림] 알수 없는 번호 입니다. ");}
			}
			else { System.err.println(" [알림] 알수 없는 번호 입니다. "); }
		} // while e 
	} // main e 
} // class e 


/*
	중요한것
		1. 변수/메모리 선택
		2. if 제어문 [흐름 제어]
*/





