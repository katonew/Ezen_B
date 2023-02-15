package Day11.Ex2;

public class Computer extends Calculator{

	
	// 오버라이딩 : 부모 클래스의 메소드를 재정의
	@Override	// 생략가능
	public double areaCorcle(double r) {
		System.out.println("자식 객체가 재정의");
		return Math.PI*r*r;
	}
	
}
