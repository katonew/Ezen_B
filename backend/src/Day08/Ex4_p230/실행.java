package Day08.Ex4_p230;

public class 실행 {
	public static void main(String[] args) {
		
		//powerOn(); 메모리 할당 전이기 때문에 오류
		
		// 1. 외부에서 함수 호출
		Calculator calculator = new Calculator();
		
		// 2. 객체를 통한 멤버 함수 호출
		calculator.powerOn();
		
		//3.
		int result1 = calculator.plus(5, 6);
		System.out.println(result1);
		
		//4.
		int x = 10;
		int y = 4;
		double result2 = calculator.divide(x, y);
		System.out.println(result2);
		
		//5
		calculator.powerOff();
		
		//6.
		System.out.println(calculator.info());
	}
}
