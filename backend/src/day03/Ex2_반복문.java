package day03;

public class Ex2_반복문 {	// class s
	public static void main(String[] args) { //main s
		
		/* for (1.초기값;2.조건식;4.증감식){
			3.실행문
		}
		*/
		//1. [p.124]
		int sum = 0;
		sum = sum +1;
		sum = sum +2;
		sum = sum +3;
		sum = sum +4;
		sum = sum +5;
		
		for(int i=1;i<=5;i++) {sum = sum+i;}
		
		//2. [p.125] 1부터 10까지 출력
		for(int i = 1; i<=10;i++) {
			//i는 1부터 10까지 1씩 증가
			System.out.print(i + " ");
		}
		System.out.println("");
		//3.[p.126] 1부터 100까지의 누적합계
		int total =0;
		for(int i=1;i<=100;i++) {
			//i는 1부터 100까지 1씩 증가
			
			System.out.print(i + " ");
			total += i;
		}
		System.out.println("\n누적합계 : "+total);
		
		//4. [p.127] 0.1~1.0 사이의 실수 출력
		for(float x = 0.1f; x<=1.0 ; x += 0.1f) {
			//x는 0.1부터 1.0까지 0.1씩 증가 반복
			System.out.println(x + " ");
		}
		
		//5. [p.127]
		/*
			단 : 2 3 4 5 6 7 8 9
			곱 : 1 2 3 4 5 6 7 8 9
			곱은 단마다 반복 [ 단:8회 , 곱:9회 -> 8*9= 총 72회
		*/
		for(int i=2;i<=9;i++) {
			System.out.println("단 : "+i);
			for(int x=1;x<=9;x++) {
				System.out.print("\t곱 :"+ x + "\t");
				System.out.println("\t"+i+" X "+x+" = " + (i*x) );
			}
		}
		
		//6.[p.134] break; 반복문퇴출 vs return; 함수종료
		while(true) { //무한 루프
			int num = (int)((Math.random()*6)+1);
			System.out.println(num);
			if(num==6) {	//난수가 6일 경우
				System.out.println("while 탈출");
				break;	//가장 가까운 반복문 탈출
			}
		}
		
		//7. [p.135]
			// 이름: for(){}
			// break 이름;
			//1. for1
		첫번째for : for(char upper = 'A'; upper<='Z'; upper++) {
				// 'A'~'Z'까지 문자하나씩 증가 반복
			System.out.println(upper+" ");
			//for2
			두번째for :for(char lower= 'a';lower <='z';lower++) {
				// 'a'~'z'까지 문자하나씩 증가 반복
				System.out.print("\t"+lower + " ");
				if(lower=='g') {
					//만약 소문자 g이면
					//break; //가장 가까운 반복문(for 2) 탈출
					break 첫번째for;
				}
			}
		}
		
		System.out.println("");
		//8. [p.136] continue
		forname : for(int i =1;i<=10;i++) {
			if(i%2!=0) {	//i가 홀수이면
				//continue; //가장 가까운 반복문[증감식]으로 이동
				continue forname;	//특정 증감식으로 이동
			}
			System.out.println(i);
		}
		
	} //main e
} //class e



























