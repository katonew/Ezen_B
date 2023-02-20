package Day14;

public class Ex1_p466 {
	// 1. p.466
		//2. 함수 선언
		// 접근제한자 키워드 반환타입 함수명 (타입 매개변수,....){ return 데이터;}
			// 접근제한자 : public, private, default[생략] , protected
			// 키워드[생략] : static[정적], final[오버라이딩 불가]
			// return 할 데이터의 타입
			// 함수명 : 카멜표기법
			// 매개변수 : 타입에 맞추어서 선언
	public static void printLength(String data) {
		try { //예외가 발생할 것 같은 코드를 try{}안에 넣기
			int result = data.length();
			System.out.println("문자 수 : " + result);
		}
		catch(NullPointerException e) {
			// * 만약 try{ } 안에서 예외가 발생했을때 실행되는 catch { } 코드
				// ~ 만일 try{ } 안에서 예외가 발생하지 않으면 catch { } 실행 안됨.
				// e : 예외객체명[아무거나] -> 예외 정보가 남겨져 있는 객체
			System.out.println(e.getMessage());
		}
		finally { // 예외가 있어도 없어도 실행되는 코드
			System.out.println("마무리 실행");
		}
	}
	
		// 1. main 함수 선언 : main 스레드가 포함 된 함수 -> 스레드 : 코드를 읽어주는 흐름 [ 단일 스레드]
	public static void main(String[] args) {
		
		System.out.println("프로그램 시작");
		printLength("ThisIsJava");
		printLength(null);			//NullPointerException : 데이터가 null이라서 legnth()를 사용할 수 없음
		System.out.println("프로그램 종료");
	}
	
}



/*
	에러 : 컴퓨터 하드웨어 고장으로 인해 응용프로그램 실행 오류 발생
	예외 : 에러 이외 예외라는 오류
		* 잘못된 사용[사용자]이나 또는 코딩[개발자]으로 인해 발생
		* 잘못된 사용 : 사용자가 비정상적인 행동을 하였을때 -> 경험바탕
			1. 일반 예외 : 컴파일 전에 발생 할 수 있는 예외 검사 [ *자바 외부 통신(스트림) ]
			2. 실행 예외 : 컴파일 후에 발생하는 예외 -> 경험
	예외 클래스
		Exception 클래스 : 모든 예외를 받을 수 있는 예외 중 최상위 클래스
	문법
		try{
			1. 예외가 발생 할 것 같은 코드 [경험]
		}
		catch(예외클래스 e){
			2. try에서 예외가 발생했을때 실행되는 코드 [ 만일 예외 발생했을때 이후 실행코드 ]
		}
		finally{
			3. 예외 있던말던 실행되는 코드 [ *생략가능 ]
		}

*/

