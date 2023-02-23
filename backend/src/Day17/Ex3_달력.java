package Day17;

import java.util.Calendar;
import java.util.Scanner;

public class Ex3_달력 {
	public static void main(String[] args) {
		// - static 멤버는 인스턴스 멤버 호출 X
		// 1. [해당멤버[메소드/필드]가 static멤버]run메소드도 정적멤버하자
		run2();
		// 2. [해당멤버[메소드/필드]가 인스턴스멤버] 객체 만들어서 메소드 호출
		
		Ex3_달력 ex3_달력 = new Ex3_달력();
		ex3_달력.run();
		
		
	}// main e
	
	static void run2() {}
	
	// 1. 달력함수
	void run() {
		
		Scanner scanner = new Scanner(System.in);
		
		Calendar cal = Calendar.getInstance(); // 1. 현재 날짜
		int year = cal.get(Calendar.YEAR); // 2. 현재 년도		
		int month = cal.get(Calendar.MONTH)+1; // 3. 현재 월		
		int day = cal.get(Calendar.DAY_OF_MONTH); // 4. 현재 일
		
		while(true) {
			System.out.printf("=====================%d년 %d월=====================\n",year,month);
			System.out.println("일\t월\t화\t수\t목\t금\t토");
			
			// *** 1. 현재 월의 1일 날짜의 요일
			cal.set(year, month-1,1);	// 현재 연도/월의 1일 날짜 형식으로 변경
			int sweek = cal.get(Calendar.DAY_OF_WEEK);
			// *** 2. 현재 월의 마지막 일
			// 2023-02 월의 일수의 최대 = 2월의 마지막 일자
			int eday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);	
			// * 출력
			// * 해당 월 1일 전까지 공백으로 채우기
			for(int i=1;i<sweek;i++) {
				System.out.print("\t");
			}
			
			for(int i=1;i<=eday;i++) {
				System.out.printf("%2d\t",i);
				if(sweek%7==0) {System.out.println("");	}//7일마자 줄바꿈 처리
				sweek++; // 요일증가
			}
			System.out.println("\n===================================================");
			System.out.print("1.이전달 2.다음달 3.검색 : ");
			int ch = scanner.nextInt();
			if(ch==1) {
				month--;
				if(month<1) {
					month = 12;
					year--;
				}
			}else if (ch==2) {
				month++;
				if(month>12) {
					month = 1;
					year++;
				}
			}else if(ch==3) {
				System.out.print("연도 : "); int inputY = scanner.nextInt();
				System.out.print("월 : "); int inputM = scanner.nextInt();
				// 만약에 입력값이 정상이면 대입
				if(inputY>=1900&&inputY<=9999&&inputM>=1&&inputM<=12) {
					year = inputY;
					month = inputM;
				}
				// 입력값이 잘못되었으면
				else {
					System.err.println("[*]출력할 수 없는 달력 입니다.");
				}
			}
			
			
		} // while e
		
		
	}// run e
	
	
	
	
	
} // class e
