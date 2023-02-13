package Day09.Ex8.package2;

import Day09.Ex8.package1.A;

public class C {
	// 1. A 클래스가 public일때
	A a;	// 가능 : 같은 패키지 아니지만 import 해서 가능
	
	// 2. A 클래스가 public이 아닐때
			// 불가능 : default는 같은 패키지만 가능
	
	A a1 = new A(true);		// public 가능
	//A a2 = new A(1);		// default 다른 패키지일 경우 불가능
	//A a3 = new A("문자열");	// private 불가능
	
	public static void main(String[] args) {
		A a4 = new A(true);
		a4.field1 = 10;			// public 필드	: 가능
		//a4.field2 = 10;		// default 필드 	: 다른 패키지 불가능
		//a4.field3 = 10;		// private 필드 	: 외부에서 사용불가능
	}
	
} // class e
