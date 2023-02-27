package Day19.Ex1_p596;

import java.awt.Toolkit;

public class 실행 {
	// p.596
	// main() 메소드 : 메인 thread 싱글스레드
	public static void main(String[] args) {
		System.out.println("싱글 스레드 시작");
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i=0;i<5;i++) {
			toolkit.beep(); // 비프음 소리내기
			try{Thread.sleep(500);}
			catch (Exception e) {}
		}
		// 2. 출력코드
		for(int i=0;i<5;i++) {
			System.out.println("띵");
			try{Thread.sleep(500);}	// 스레드 0.5초 대기상태
			catch (Exception e) {}
		}
		//----------------------------------------
		//---------------멀티 스레드 구현1---------------
		//Thread thread = new Thread(구현 인터페이스)
			// 익명[이름이없는] 구현 객체
		// 스레드 객체 생성
		Thread thread = new Thread(new Runnable() {
			// run 메소드를 구현
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for(int i=0; i<5;i++) {
					toolkit.beep();
					try {Thread.sleep(500);}
					catch (Exception e) {}
				} // for e
				
			} // run e
		}); // 생성자 e
		System.out.println("멀티 스레드 시작");
		thread.start();	// 3. run 메소드 실행
		// 2.  출력 코드
		for(int i=0;i<5;i++) {
			System.out.println("띵");
			try{Thread.sleep(500);}
			catch (Exception e) {}
		} // for e
		
		//----------------------------------------
		//---------------멀티 스레드 구현2---------------
		System.out.println("멀티 스레드 시작2");
		Sound thread2 = new Sound();
		thread2.start();
		// 2. 출력코드
		for(int i=0;i<5;i++) {
			System.out.println("띵");
			try{Thread.sleep(500);}
			catch (Exception e) {}
		} // for e
		
		//----------------------------------------
		//---------------멀티 스레드 구현3---------------
		System.out.println("멀티 스레드 시작3");
		Runnable runnable = new Sound2();
		Thread thread3 = new Thread(runnable);
		thread3.start();
		// 2.  출력 코드
		for(int i=0;i<5;i++) {
			System.out.println("띵");
			try{Thread.sleep(500);}
			catch (Exception e) {}
		} // for e
		
		
		
	}// main e
} // class e
























