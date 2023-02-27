package Day19.Ex5;

import java.util.Scanner;

public class 실행 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		//
		Thread thread = new Music();
		thread.start();
		
		Music music = new Music();
		Movie movie = new Movie();
		
		
		while(true) {
			System.out.println("1. 음악재생/중지 2.영화재생/중지 : ");
			int ch = scanner.nextInt();
			// 만약 1번을 입력했는데 음악재생여부가 false일 경우
			if(ch==1 && music.stop==false) {
				music.start();		// 음악스레드 시작
				music.stop = true;	// 음악재생여부 true
			}
			// 만약 1번을 입력했는데 음악재생여부가 true일 경우
			else if(ch==1 && music.stop==true) {
				music.stop = false;		// 음악재생여부 false
				music = new Music();	// 음악스레드 초기화
			}
			// 만약 2번을 입력했는데 영화재생여부가 false일 경우
			else if(ch==2 && movie.stop==false) {
				movie.start();		// 영화스레드 시작	
				movie.stop = true;	// 영화재생여부 true
			}
			// 만약 2번을 입력했는데 영화재생여부가 true일 경우
			else if(ch==2 && movie.stop==true) {
				movie.stop = false;		// 영화재생여부 false
				movie = new Movie();	// 영화스레드 초기화
			}
			
		} // while e
	} // main e
} // class e
