package Day09.Ex2;

import java.util.ArrayList;

/*
 	
 	생성자 : 객체를 생성할 때 객체의 초기화 담당
 		- new 생성자()
 		- 생성자 선언이 없을경우 기본생성자 자동생성
 		- 생성자 이름은 클래스와 동일
 		목적	
 			1. 인수로 받은 데이터를 필드 초기화
 			2. 필터링 / 행위
 			
 	메소드 : 
 		인수[매개변수] : 함수 안으로 들어오는 데이터
 		반환[리턴]	: 함수 종료시 호출했던 곳으로 반환되는 데이터
 		
 		1. 선언
 		리턴타입 함수명(타입 매개변수,타입 매개변수,...){
 			return 허용범위내 데이터;
 		}
 		
 		2. 호출
 		내부 : 함수명(데이터,데이터,...);
 		외부 : 객체명.함수명(데이터,데이터,...)
 		
*/


// JVM 메소드 영역
public class 붕어빵틀 {

	//1. 필드
	String 재료1;
	String 재료2;
	
	//2. 생성자
		// 1. 기본 생성자
	public 붕어빵틀() {}
		// 2. 필드 1개 생성자
	public 붕어빵틀(String 재료1){
		this.재료1 = 재료1;
	}
		// 3. 필드 2개 생성자
	public 붕어빵틀(String 재료1, String 재료2){
		this.재료1 = 재료1;
		this.재료2 = 재료2;
	}
	//3. 메소드
		// 1. toString() 메소드
	@Override
	public String toString() {
		return "붕어빵틀 [재료1=" + 재료1 + ", 재료2=" + 재료2 + "]";
	}
	
		// 2. 붕어빵 굽기	// 리턴타입없음[void] 인수없음
	void 굽기() { 
		System.out.println("붕어빵 굽습니다.");
	}
		// 3. 붕어빵 속 변경 // 리턴타입없음[void] 인수2개
	void 변경(String 재료1, String 재료2) {
		this.재료1 = 재료1;
		this.재료2 = 재료2;
		System.out.println("붕어빵 속 변경되었습니다.");
	}
		// 4. 붕어빵 판매가	// 리턴타입있음[타입] 인수 없음
	int 판매가() {
		return 3000;
	}
		// 5. 붕어빵 판매
	붕어빵틀 판매() {
		붕어빵틀 붕어빵 = new 붕어빵틀();
		return 붕어빵;
	}
		// 6.
	void 확인(붕어빵틀 붕어빵) {
		System.out.println(붕어빵);
	}
		// 7.
	ArrayList<붕어빵틀> 여러개판매( int 개수){
		
		ArrayList<붕어빵틀> 붕어빵포장종이 = new ArrayList<>();
		
		for(int i=1;i<=개수;i++) {
			붕어빵포장종이.add(판매());
		}
		return 붕어빵포장종이;
	}
	
}	//class e
