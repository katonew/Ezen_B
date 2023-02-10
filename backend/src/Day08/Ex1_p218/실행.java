//1.클래스의 사용목적 : main함수 가지고 있는 클래스
package Day08.Ex1_p218;

public class 실행 { //class s
	public static void main(String[] args) {	//main s
		
		// 1. Car 클래스를 이용한 객체 생성
		// 클래스명 변수명 = new 생성자명();
		
		//1.기본 생성자
		Car car = new Car();
		car.model = "그랜저";
		car.color = "노랑";
		System.out.println(car.toString());
		
		//2. 2개의 매개변수 생성자
		Car car2 = new Car("그랜저", "파랑");
		System.out.println(car2.toString());
		
		//3. 3개의 매개변수 생성자
		Car car3 = new Car("그랜저", "검정", 250);
		System.out.println(car3.toString());
		
	} //main e
} //class e
