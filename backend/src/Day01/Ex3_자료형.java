package Day01;

public class Ex3_자료형 { //class s
	public static void main(String[] args) { //main s
		
		//1. java 진수를 표현하는 방법[p.41]
		int var1 = 0b1011; System.out.println("2진수 : " + var1);
			// 1011[2진수] => 11 [10진수]
		int var2 = 0206; System.out.println("8진수 : " + var2);
			// 13[8진수] => 134 [10진수]
		int var3 = 365; System.out.println("10진수 : " + var3);
			// 365[10진수] => 365 [10진수]
		int var4 = 0xB3; System.out.println("16진수 : " + var4);
			// 0xB3[16진수] => 179 [10진수]
		
		// 2. [p.42] byte 자료형 [ -128 ~ 127 ]
		byte b1 = -128; System.out.println("byte 자료형 : " + b1);
		byte b2 = 127; System.out.println("byte 자료형 : " + b2);
		//byte b3 = 128; //오류 발생
		
		//3. short 자료형	[+-3만2천정도]
		short s1 = 32000; System.out.println("short자료형 : " + s1);
		//short s2 = 33000;	//오류 발생 : 범위 벗어난 데이터
		
		//4. int 자료형 [+-21억정도]
		int i1 = 2000000000; System.out.println("int 자료형 : " + i1);
		//int i2 = 3000000000; //오류 발생 : 범위 벗어난 데이터
		
		// 5. long 자료형[21억이상]
		long l1 = 10; System.out.println("long 자료형 : " + l1);
		long l2 = 10000000000L; System.out.println("long 자료형 : " + l2);
			//정수 기본타입 : int 	변수에 저장되기 전 자료형이 명시되지 않은 데이터의 자료형
			// 데이터 뒤에 L을 붙이기 = int -> long
			// 10000000000 => int , 10000000000L => long
		
		//6. char 자료형[ 각국의 문자를 숫자 0~65535로 표현]
		char c1 = 'A';		System.out.println("char 자료형 : " + c1);	//문자 '' / 문자열 ""
		char c2 = 65;		System.out.println("char 자료형 : " + c2);
		char c3 = '가';		System.out.println("char 자료형 : " + c3);
		char c4 = 44032;	System.out.println("char 자료형 : " + c4);
		//char c5 = '가나';		System.out.println("char 자료형 : " + c5);
		
		//7. String 클래스 [문자 여러개 (문자열) ]
		String str1= "안녕하세요";		System.out.println("String 클래스 : " + str1);

		//8 [p.48] float[소수점8자리]/double[소수점17자리] 자료형
		float f1 = 0.123456789123456789f; System.out.println("flaot 자료형 : "+f1);
		double d1 = 0.123456789123456789; System.out.println("double 자료형 : "+d1);
		
		//9. boolean 자료형 [논리 : true/false]
		boolean bool1 = true; System.out.println("boolean 자료형 : "+bool1);
		//boolean bool2 = 1;	// 오류발생 : true 아니면 false만 저장가능
		
	} //main e
} //class e

/*
	-용량단위
		Bit 	: 0, 1
		Byte 	: 01010101 = 8Bit	컴퓨터 처리 용량 최소단위
		KByte	: 1024byte
		MByte	: 1024kbyte
		GByte	: 1024mbyte
		
	-진수 : 컴퓨터에 표현단위
		2진수 	: 0,1				기계어/이진코드/bit
		8진수 	: 0~7				
		10진수 	: 0~9				사람
		16진수	: 0~9,a,b,c,d,e,f	메모리주소체계
*/