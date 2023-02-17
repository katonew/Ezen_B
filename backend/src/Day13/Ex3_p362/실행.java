package Day13.Ex3_p362;

public class 실행 {
	public static void main(String[] args) {
		
		// 1. 구현 객체
		RemoteControl rc = new SmartTelevision();
		
		
		rc.turnOn();
		rc.trunOff();
		// 2. 구현 객체
		Searchable sea = new SmartTelevision();
		sea.serch("Youtube");
	}
}
