package Day13.Ex4_p365;

public class 실행 {
	public static void main(String[] args) {
		
		/*
			A			B
				상속
				 C
		
		*/
		
		// 1.객체 만들기
		InterfaceCImpl impl = new InterfaceCImpl();
		
		//2. 인터페이스 변수에 구현객체 대입
		InterfaceA ia = impl;
		ia.methodA();		// 본인 추상메소드 호출 가능
		//ia.methodB();		// 자식의 추상메소드 호출 불가능
		//ia.methodC();		// 자식의 추상메소드 호출 불가능
		
		//3.
		InterfaceB ib = impl;
		//ib.methodA();		// 자식이 상속받은 다른 부모의 추상메소드 호출 불가능
		ib.methodB();		// 본인 추상메소드 호출 가능
		//ib.methodC();		// 자식의 추상메소드 호출 불가능
		
		//4. 
		InterfaceC ic = impl;
		ic.methodA();		// 부모1 추상메소드 호출 가능
		ic.methodB();		// 부모2 추상메소드 호출 가능	
		ic.methodC(); 		// 본인 추상메소드 호출 가능
		
	}
}
