package Day02;

public class Ex3_연산자 {	//class s
	public static void main(String[] args) { //main s
		
		// 1. 부호/증감연산자 [p.78]
		int x = +10;
		int y = -10;
		System.out.println("x :" + x);		// 10
		System.out.println("y :" + y);		// -10
		
		System.out.println("x++ : " + (x++));	// 10
		System.out.println("x :" + x);			// 11
		System.out.println("++x : " + (++x));	// 12
		
		System.out.println("y++ : " + (y--));	// -10
		System.out.println("y :" + y);			// -11
		System.out.println("++y : " + (--y));	// -12
		
		// 2. 산술연산자 [p.81]
		System.out.println("x+y : "+(x+y));	//0		12+(-12)
		System.out.println("x-y : "+(x-y));	//24 	12-(-12)
		System.out.println("x*y : "+(x*y));	//-144 	12*(-12)
		System.out.println("5/3 : "+(5/3));	//1 	5/3의 몫
		System.out.println("5%3 : "+(5%3));	//2 	5/3의 나머지
		
		// 3. 비교 연산자
		System.out.println("x==y : " + (x==y));	//false +12==-12
		System.out.println("x!=y : " + (x!=y));	//true 	+12==-12
		System.out.println("x>y : " + (x>y));	//true 	+12>-12
		System.out.println("x>=y : " + (x>=y));	//true 	+12>=-12
		System.out.println("x<y : " + (x<y));	//false +12<-12
		System.out.println("x<=y : " + (x<=y));	//false +12<=-12
		
		System.out.println("문자열 비교");
		System.out.println("ABC.equals(str2) : " + ("유재석".equals("유재석")));	// true
		System.out.println("ABC.equals(str2) : " + (!"유재석".equals("유재석")));	// false
		System.out.println("ABC.equals(str2) : " + ("유재석".equals("강호동")));	// false
		
		//4. 논리연산자 [p.91]
		System.out.println("5<x<20 : "+ (x > 5 && x<20 ));			//x=12 true and true => true
		System.out.println("5<x<10 : "+ (x > 5 && x<10 )); 			//x=12 true and false => false
		System.out.println("0>=x x>=20 : "+ (0 >= x || x>=20 ));	//x=12 false and false => false
		System.out.println("0>=x x>=10 : "+ (0 >= x || x>=10 )); 	//x=12 false and true => true
		System.out.println("!(x==y) : " + (!(x==y)));				// false => true
		
		//5. 대입연산자[p.102]
		int z = 30;
		z += x; 	// 30+= 12 	1. 30+12 => 42 2. 30=42 3. z=>42
		System.out.println("z += x : " + (z));
		z -= x; z*=x; z/=x; z%=x; 
		
		//6. 삼항연산자[p.103] 	조건 ? 참 : 거짓
		String 결과 = (x>=20) ? "합격" : "불합격";
		System.out.println("결과 : " + 결과);
		
		// 7. 연결 연산자
		String 연결문자1 = "유재석"+ "10";	//문자열 + 문자열 => 문자열				"유재석10"
		String 연결문자2 = "유재석"+ 10;	//문자열 + 숫자열 => 문자열				"유재석10"
		String 연결문자3 = "유재석"+ 10+20;	//문자열 + 숫자열 + 숫자열 => 문자열		"유재석1020"
		String 연결문자4 = "유재석"+ (10+20);	//문자열 +(숫자열 + 숫자열) => 문자열	"유재석30"
		System.out.println(연결문자1);
		System.out.println(연결문자2);
		System.out.println(연결문자3);
		System.out.println(연결문자4);
	} //main e
} // class e































