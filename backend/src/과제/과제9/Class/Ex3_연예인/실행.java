package 과제.과제9.Class.Ex3_연예인;

import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("---------연예인----------");
			System.out.print("1.가수 2.배우 3.개그맨 : ");
			int ch = scanner.nextInt();
			연예인 연예인 = null;
			if(ch==1) {
				연예인 = new 가수();
				System.out.println("연예인은 가수입니다.");
			}else if(ch==2) {
				연예인 = new 배우();
				System.out.println("연예인은 배우입니다.");
			}else if(ch==3) {
				연예인 = new 개그맨();
				System.out.println("연예인은 개그맨입니다.");
			}
			연예인.시상식();
			연예인.출연();
		}
	}
}
