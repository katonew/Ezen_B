package Day11.Ex1;

public class Smartphone extends Phone {
			//자식클래스명 exends 부모클래스
			//부모 클래스의 멤버들을 자식 클래스가 사용할 수 있다.
	
	// 1. 필드
	public boolean wifi;
	
	//2. 생성자
	public Smartphone() {}
	public Smartphone(String model, String color) {
		super(model,color);
		System.out.println("자식클래스 생성자 실행");
	}
	
	//3. 메소드
	public void setWifi(boolean wifi) {
		this.wifi = wifi;
		System.out.println("와이파이 상태를 변경했습니다.");
	}
	public void internet() {
		System.out.println("인터넷에 연결합니다.");
	}
	
}
