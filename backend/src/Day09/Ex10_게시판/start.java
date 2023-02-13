package Day09.Ex10_게시판;

import Day09.Ex10_게시판.view.Front;

/*
	Ex10_게시판 패키지
		controller 패키지
			Bcontroller.java
		model 패키지
			Board.java
		view 패키지
			Front.java
		Start.java
		
	- 1. Start[main함수] 클래스가 Front 클래스를 호출
	- 2. Front 클래스에서 사용자로부터 입출력 받기
	- 3. Bcontroller 클래스에서 Front로부터 전달받은 데이터를 처리/로직
	- 4. Board 클래스에서  게시물의 모델링
	
*/

public class start {
	public static void main(String[] args) {
		
		Front.getInstance().index();
		
	}
}






























