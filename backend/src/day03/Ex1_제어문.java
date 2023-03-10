package day03;

import java.util.Random;

public class Ex1_제어문 {	//class s
	public static void main(String[] args) { //main s
		/*
			if 형태
				1. if(조건문) 실행문;
				2. if(조건문) {실행문1; 실행문2;}
				3. if(조건식) {
						실행문;
					}else{
						실행문;
					}
				4. if(조건식) {
						실행문;
					}else if{
						실행문;
					}else if{
						실행문;
					}else {
						실행문;
					}
				5. if 중첩
					if(조건식){
					
						if(조건식){
						
						}else{
						
						}
					
					}else{
					
						if(조건식){
						
						}else{
						
						}
					}
		*/
		
		// 1. [p.111]
		int score = 93; // 1. 변수 선언
		if(score>=90) {	//제어문
			System.out.println("점수가 90보다 큽니다.");
			System.out.println("등급은 A입니다.");
		}
		
		if(score<90)
			System.out.println("점수가 90보다 작습니다.");
			System.out.println("등급은 B입니다.");
		
		//2. [p.113]
		if(score>=90) {	//제어문
			System.out.println("점수가 90보다 큽니다.");
			System.out.println("등급은 A입니다.");
		}else{
			System.out.println("점수가 90보다 작습니다.");
			System.out.println("등급은 B입니다.");
		}
		
		//3. [p.114]
		if(score>=90) {	//제어문
			System.out.println("점수가 100~90 입니다.");
			System.out.println("등급은 A입니다.");
		}else if(score>=80){
			System.out.println("점수가 80~89 입니다.");
			System.out.println("등급은 B입니다.");
		}else if(score>=70){
			System.out.println("점수가 70~79 입니다.");
			System.out.println("등급은 C입니다.");
		}else{
			System.out.println("점수가 70 미만입니다.");
			System.out.println("등급은 D입니다.");
		}
		
		//* [p.116]
		// Math.random() : 0부터 1사이의 실수로된 난수 생성
		System.out.println(Math.random());				//0부터 1사이의 실수로된 난수 생성
		System.out.println(Math.random()+1);			//1부터 2사이의 실수로된 난수 생성
		System.out.println((int)Math.random()+1);		//1부터 2사이의 정수로된 난수 생성
		System.out.println((int)(Math.random()*6)+1);	//1부터 6사이의 정수로된 난수 생성
		
		
		Random random = new Random();
		System.out.println(random.nextInt());		// 인트가 표현할 수 있는 범위 내 난수 생성
		System.out.println(random.nextInt(3));		// 0~2 : 총 3개
		System.out.println(random.nextInt(6));		// 0~5 : 총 6개
		System.out.println(random.nextInt(6)+1);	// 1~6 : 총 6개
		
		for(int i=0;i<15;i++) {
			char c1 = (char) (random.nextInt(26)+97);
			System.out.print(c1);
		}
		
		int num = (int)(Math.random()*6)+1;
		
		if(num==1) {System.out.println("1번이 나왔습니다.");
		}else if(num==2) {System.out.println("2번이 나왔습니다.");
		}else if(num==3) {System.out.println("3번이 나왔습니다.");
		}else if(num==4) {System.out.println("4번이 나왔습니다.");
		}else if(num==5) {System.out.println("5번이 나왔습니다.");
		}else{	System.out.println("6번이 나왔습니다.");}
		
		//5. [p.117]
		int score2 = (int)(Math.random()*20)+81;
		System.out.println("점수 :" + score2);
		
		String grade;
		
		if(score2>=90) {
				if(score2>=95){grade = "A+";}else {grade = "A";}		
		}else {
			if(score2>=85) {grade="B+";}else {grade="B";}
		}
		System.out.println("학점 :" + grade);
	} //main e
} //class e



/*
	Math : 수학 관련 메소드를 제공하는 클래스 
		Math.random()
	Random : 난수 관련 메소드를 제공하는 클래스
		Random random = new Random();
		(char) (random.nextInt(25)+97); 
			
*/






















