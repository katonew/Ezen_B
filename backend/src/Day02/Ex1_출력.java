package Day02;


// ! : 자바는 무조건 class 단위
	// 자바는 100% 객체지향
	// 클래스 기반으로 메모리 할당 : 객체
	// 클래스 : 객체 설계도

public class Ex1_출력 {	//class s
	
	//* main 함수 : main 스레드 [스레드 : 프로세스 내에서 실행되는 흐름의 단위]
	public static void main(String[] args) { //main s
		//[p.67] syso+자동완성
		System.out.println("");
			//System : 시스템 클래스 [관련 메소드 제공]
			//out : 출력 vs in : 입력
				//println() : 출력 후 줄바꿈 철
				//print() : 출력
				//printf() : 형식 출력
		//2.print()
		System.out.print("Print함수1 ");
		System.out.print("Print함수2 ");
		
		//3.println()
		System.out.println("Println 함수1 ");	 //출력후 \n
		System.out.println("Println 함수2 ");
		
		//4.printf()
		/*
		 형식문자열
		 	%d : 정수
		 		%자릿수d 	: 자릿수 차리 			[만일 자릿수에 데이터가 없을 시 공백처리]
		 		%0자릿수d : 자릿수 차리		 	[만일 자릿수에 데이터가 없을 시 0으로 공백처리]
		 		%-자릿수d : 왼쪽부터 자릿수 차리 	[만일 자릿수에 데이터가 없을 시 뒤에 공백처리]
		 	%f : 실수
		 		%.자릿수f : 원하는 자릿수 까지 소수점 출력
		 		
		 	%s : 문자열
		 */
		int value = 123;
		System.out.println("상품의 가격: "+value+"원");
		System.out.printf("상품의 가격: %d원\n", value);
		System.out.printf("상품의 가격: %6d원\n", value);
		System.out.printf("상품의 가격: %-6d원\n", value);
		System.out.printf("상품의 가격: %06d원\n", value);
		
		double area = 3.14159;
		System.out.println("반지름 넓이 : "+area);
		System.out.printf("반지름 넓이 : %f\n", area);
		System.out.printf("반지름 넓이 : %3.1f\n", area);
		System.out.printf("반지름 넓이 : %3.3f\n", area);
		System.out.printf("반지름 넓이 : %3.4f\n", area);
		
		String name = "홍길동";
		String job = "도적";
		System.out.printf("%6d | %-10s | %10s \n" , 1 ,name, job);
		//     1 | 홍길동        |         도적 
		
		
	} // main e
} // class e

/*
	System : 시스템 클래스
	String : 문자열 클래스
	
	제어 / 이스케이프 문자
		\n : 줄바꿈
		\t : 들여쓰기
		\" : "
		\' : '
*/