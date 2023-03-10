package Day15.Ex9_MVC패턴;

public class Start {
	public static void main(String[] args) {
		View.getInstance().index();
	}
}


/*
	내부에서 메소드[멤버] 호출 방법 [메모리 할당 전]
		1. 메소드명();
	
	
	외부에서 메소드[멤버] 호출 방법 [메모리 할당]
		1. 인스턴스 메소드
			클래스명 객체명 = new 생성자();	-- 변수명이 존재하므로 재호출 가능
			객체명.메소드명();
				vs
			new 생성자().메소드명();			-- 단발성
			
		2. 정적[static] 메소드
			클래스명.메소드명();
			
		3. 싱글톤내 메소드 호출
			클래스명.get싱글톤.메소드();
			
		JVM
		[ 현재 사용중인 메모리[클래스] : 컴파일한 클래스 + import 클래스]
		
		메소드영역				스택영역				힙영역
		- 전역에서 사용 가능		- 기본 자료형 데이터		- 주소
		- 클래스 멤버정보		- 힙주소 저장
		- static			
				
							클래스명 객체명   	=	new 생성자;
							
												new 생성자().메소드명();
												
		클래스명.메소드명();		
			-정적필드								
		static 타입 필드명						=	new 필드명();


*/

