package 과제.과제4;

import 과제.과제4.view.Front;

/*

	MVC : 디자인 패턴 [ 관점별 파일 구분 ]
		M : Model			데이터					DB
		V : View			화면						HTML, CSS, JS
		C : Controller		제어[로직/기능처리]			JAVA
		
*/



public class start { //class s
	public static void main(String[] args) { // main s
		
		Front front = new Front();
		front.index();
		
	} //main e
} //class e
