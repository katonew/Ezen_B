package 과제.과제9.Class.Ex2_운동;

import java.util.Scanner;

public class 실행 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("---------운동----------");
			System.out.print("1.축구 2.핸드볼 3.하키 : ");
			int ch = scanner.nextInt();
			운동 운동 = null;
			if(ch==1) {
				운동 = new 축구();
				System.out.println("선택한 운동은 축구입니다.");
			}else if(ch==2) {
				운동 = new 핸드볼();
				System.out.println("선택한 운동은 핸드볼입니다.");
			}else if(ch==3) {
				운동 = new 하키();
				System.out.println("선택한 운동은 하키입니다.");
			}
			운동.골넣기();
			운동.뛰기();
		}
	}
}
