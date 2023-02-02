package Day02;

import java.util.Scanner;	//Scanner 클래스를 사용하기 위한 Scanner 클래스 가져오기

public class Ex2_입력 { //class s
	public static void main(String[] args) {	//main s
		
		//1.[p.70] 입력
			//Scanner
			//scan + 자동완성
			// 객체 생성 : 클래스명 객체명 = new 생성자명(인수);
			// 입력 객체 : Scanner scanner = new Scanner( System.in);
				// { }별 한번만 선언
		// 1. 입력 객체 선언
		Scanner scanner = new Scanner(System.in);	
		//2. 입력메소드 -> 변수 저장[자료형 맞추기]
			//1. 문자열[띄어쓰기 불가능] 입력받기 함수
		String 문자열1 = scanner.next();			System.out.println("문자열1 : "+문자열1);
			//2. 문자열[띄어쓰기 가능] 입력받기 함수 
				//[ .nextLine()앞에 다른 next() 하나로 취급 -> 해결방안은 앞에 scanner.nextLine(); 입력]
		scanner.nextLine();
		String 문자열2 = scanner.nextLine();		System.out.printf("문자열2 : "+문자열2);
			//3. 논리형 입력받기 함수
		boolean 논리 = scanner.nextBoolean();	System.out.printf("논리 : "+논리);
			//4. 첫글자만 입력받기 함수
		char 문자 = scanner.next().charAt(0);	System.out.printf("문자 : "+문자);
			//6. 정수 입력받기 함수
		byte 바이트 = scanner.nextByte();			System.out.printf("바이트 : "+바이트);
			//7. 정수 입력받기 함수
		short 쇼트 = scanner.nextShort();		System.out.printf("쇼트 : "+쇼트);
			//5. 정수 입력받기 함수
		int 인트 = scanner.nextInt();			System.out.printf("인트 : "+인트);
			//8. 정수 입력받기 함수
		long 롱 = scanner.nextLong();			System.out.printf("롱 : "+롱);
			//9. 실수 입력받기 함수
		float 플롯 = scanner.nextFloat();		System.out.printf("플롯 : "+플롯);
			//10.실수 입력받기 함수
		double 더블 = scanner.nextDouble();		System.out.printf("더블 : "+더블);
		
		
		
		// 기본 자료형 비교 [ 비교 연산자 가능]
		int  비밀번호 = 1234;			System.out.println(비밀번호 == 1234);	//true
		// 문자열[String 객체] 비교 [ 비교 연산자 불가능 -> 문자열A.equals("문자열B")]
		String 아이디 = "qwe";		System.out.println(아이디.equals("qwe"));	
	} //main e
} //class e

/*
	System	import java.lang 패키지는 생략
	String 	import java.lang 패키지는 생략
	Scanner import java.Scanner;
	
	
	System.in
	
*/