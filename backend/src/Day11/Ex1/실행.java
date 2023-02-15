package Day11.Ex1;

public class 실행 {
	public static void main(String[] args) {
		
		// 1. phone 객체
		Phone phone = new Phone();
		// 2. phone 객체의 인스턴스 멤버 호출
		phone.color = "빨강";
		System.out.println(phone.color);
		phone.bell();
		phone.sendVoice("안녕하세요");
		// 3. phone 클래스의 smartphone 멤버 호출
		// phone.wifi 
		// * 부모객체는 자식객체의 멤버를 호출 할 수 없다.
		
		// 1.
		Smartphone smartphone = new Smartphone();
		// 2. smartphone 클래스의 phone 멤버 호출
		// * 자식객체는 부모클래스의 멤버 호출 할 수 있다. 
		smartphone.color = "은색";
		System.out.println(smartphone.color);
		smartphone.bell();
		smartphone.sendVoice("안녕하세요");
		
		// 1. 자식 클래스로 객체 만들기
		Smartphone myphone = new Smartphone("갤럭시","은색");
		// 2. 자식 클래스로 부모클래스의 멤버 호출
		System.out.println("모델 : "+myphone.model);
		System.out.println("색상 : "+myphone.color);
		
		// 3. 자식 클래스가 본인 멤버 호출
		System.out.println("와이파이 상태 : " + myphone.wifi);
		
		// 4. 자식클래스로 부모클래스의 메소드 호출
		myphone.bell();
		myphone.sendVoice("여보세요");
		myphone.receiveVoice("안녕하세요! 저는 홍길동인데요");
		myphone.sendVoice("아~네, 반갑습니다.");
		myphone.hangUp();
		
		// 5. 자식 클래스의 본인 메소드 호출
		myphone.setWifi(true);
		myphone.internet();
		
		
	} // main e
} //class e



/*
	자동완성 메뉴
		필드 : 필드명, 자료형, 클래스명
		메소드 : 함수명(매개변수), 반환타입, 클래스명
*/