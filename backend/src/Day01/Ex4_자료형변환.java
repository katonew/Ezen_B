package Day01;

public class Ex4_자료형변환 {	//class s
	public static void main(String[] args) { //main s
		
		// 1. 자동타입 변환 [p.54]
		byte b1 = 10; int i1=b1; 			// byte => int 가능		/ byte가 int보다 작기 때문에
		char c1 = '가'; i1=c1;				// char => int 가능 		/ char가 int보다 작기 때문에
		int i2 =50; long l1=i2;				// int => long 가능		/ int가 long보다 작기 때문에
		long l2 = 100; float f1=l2;			// long => float 가능	/ long이 float보다 작기 때문에
		float f2 = 100.5f; double d1=f2;	// float => double 가능	/ float가 double보다 작기 때문에
		
		//2. 강제 타입 변환	
		int i3 = 30000;	byte b2 = (byte)i3; 		//int => byte 불가능		[강제변환 필요]
		long l3 = 300; int i4 =(int)l3; 			//long => int 불가능		[강제변환 필요]
		int i5 = 65; char c2 = (char) i5;			//int => char 불가능		[강제변환 필요]
		double d2 = 3.14; int i6= (int) d2;			//double => int 불가능	[강제변환 필요]
		
		// 3. 연산시 타입 자동 변환 [예제 p.58~64 참고]
		
		//4. 문자열 타입 변환 [p.65]
		String str1 = "10";		// 10 :int vs "10" : String 다르다.
		int 인트1 = Integer.parseInt(str1);		//String --> int
		byte 바이트1 = Byte.parseByte(str1);		//String --> byte
		short 쇼트1 = Short.parseShort(str1); 	//String --> short
		long 롤1 = Long.parseLong(str1);			//String --> long
		float 플롯1 = Float.parseFloat(str1); 	//String --> float
		double 더블1 = Double.parseDouble(str1); //String --> double
		
			// "10" --> 문자열 타입의 숫자 10 --> 정수형 타입의 숫자10
			// "ABC" --> 문자열 타입의 ABC --> 변환 불가
			
		String str2 = "안녕";
		//int 인트2 = Integer.parseInt(str2);	System.out.println(인트2); //불가능
		
		//int 인트3 = (Integer)str1;	//불가능
		
		
	} //main e
} //class e

/*
	자료형/타입 변환
		-허용범위 순서
		byte[1] > short , char [2] > int[4] > long[8] > float[4] > double[16]
		
		1. 자동 타입 변환 [ 캐스팅 ] 
			-작은 타입에서 큰타입으로 변환 가능
			
			큰 허용범위 타입 = 작은 허용범위 타입
			
		2. 강제 타입 변환 [ 캐스팅 ] 
			- 손실이 있더라도 강제로 변환
			(새로운타입)변환할 데이터
			
			작은 허용 범위 타입 = 큰 허용 범위 타입 [X]
			작은 허용 범위 타입 = (작은허용범위타입)큰 허용 범위 타입 [O]
			
		3. 연산 시 자동 타입 변환
			-피연산자 중 큰 타입을 결과로 반환
			1. 정수
				1. * int보다 작은 byte, short 연산시 무조건 int로 결과
					byte + byte => int
					short + short => int
				2. long 연산시
					long + long => long
			2. 실수
				float + double => double
				float + float => float
				double + double => double
				
		4. !문자열 타입변환
			byte 
*/





