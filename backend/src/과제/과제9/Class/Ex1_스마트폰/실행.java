package 과제.과제9.Class.Ex1_스마트폰;

import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("---------스마트폰----------");
			System.out.print("1.갤럭시 2.아이폰 3.블랙베리 : ");
			int ch = scanner.nextInt();
			스마트폰 스마트폰 = null;
			if(ch==1) {
				스마트폰 = new 갤럭시();
				System.out.println("선택한 스마트폰은 안드로이드입니다.");
			}else if(ch==2) {
				스마트폰 = new 아이폰();
				System.out.println("선택한 스마트폰은 아이폰입니다.");
			}else if(ch==3) {
				스마트폰 = new 블랙베리();
				System.out.println("선택한 스마트폰은 블랙베리입니다.");
			}
			스마트폰.자판();
			스마트폰.Os();
		}
	}
}
