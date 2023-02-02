package 과제.과제1.연산자문제;

import java.util.Scanner;

public class 과제1 { //class s
	public static void main(String[] args) { //main s
		Scanner scanner = new Scanner(System.in);
		
		//문제1
		System.out.println("문제1");
		System.out.println("|\\_/|");
		System.out.println("|q p|   /}");
		System.out.println("( 0 )\"\"\"\\");
		System.out.println("|\"^\"`    |");
		System.out.println("||_/=\\\\__|");
		
		//문제2
		System.out.println("문제2");
		int no = 1;
		System.out.print("이름을 입력해주세요: ");
		String name = scanner.nextLine();
		System.out.print("내용을 입력해주세요 : ");
		String content = scanner.nextLine();
		System.out.print("날짜를 입력해주세요 : ");
		String date = scanner.nextLine();
		System.out.println("--------------방문록--------------------");
		System.out.println(" |\t순번\t|\t작성자\t|\t내용\t|\t날짜\t|");
		System.out.printf(" |\t%d\t|\t%s\t|\t%s\t|\t%s\t|\n",no,name,content,date);
		
		//문제3
		System.out.println("문제3");
		System.out.print("기본급을 입력해주세요 : ");
		int a = scanner.nextInt();
		System.out.print("수당을 입력해주세요 : ");
		int b = scanner.nextInt();
		int temp = (int) (a + b - (a * 0.1));
		System.out.printf("실수령액 : %d\n",temp);
		
		//문제4
		System.out.println("문제4");
		System.out.print("금액을 입력해주세요 : ");
		int money = scanner.nextInt();
		System.out.printf("십만원권 : %d장\n", (money/100000));
		System.out.printf("만원권 : %d장\n", (money/10000)-((money/100000)*10));
		System.out.printf("천원권 : %d장\n", (money/1000)-((money/10000)*10));
		System.out.printf("백원 : %d개\n", (money/100)-((money/1000)*10));
		
		//문제5
		System.out.println("문제5");
		System.out.print("숫자을 입력해주세요 : ");
		int a2 = scanner.nextInt();
		String temp1 = a2%7==0 ? "O" : "X";
		System.out.println(temp1);
		
		//문제6
		System.out.println("문제6");
		System.out.print("숫자을 입력해주세요 : ");
		int a3 = scanner.nextInt();
		String temp2 = a3%2==1 ? "O" : "X";
		System.out.println(temp2);
		
		//문제7
		System.out.println("문제7");
		System.out.print("숫자을 입력해주세요 : ");
		int a4 = scanner.nextInt();
		String temp3 = a4%7==0&&a4%2==0 ? "O" : "X";
		System.out.println(temp3);
		
		//문제8
		System.out.println("문제8");
		System.out.print("숫자을 입력해주세요 : ");
		int a5 = scanner.nextInt();
		String temp4 = a5%7==0&&a5%2==1 ? "O" : "X";
		System.out.println(temp4);
		
		//문제9
		System.out.println("문제9");
		System.out.print("첫번째 숫자을 입력해주세요 : ");
		int a6 = scanner.nextInt();
		System.out.print("두번째 숫자을 입력해주세요 : ");
		int a7 = scanner.nextInt();
		int temp5 = a6>a7 ? a6 : a7;
		System.out.println("더 큰수는 : "+temp5);
		
		//문제10
		System.out.println("문제10");
		System.out.print("반지름을 입력해주세요 : ");
		int a8 = scanner.nextInt();
		double temp6 = a8 * a8 * 3.14;
		System.out.println("원의 넓이 : "+temp6);
		
		
		//문제11 두 실수를 입력받아 앞실수의 값이 뒤의 값의 몇% 인지 출력하기 
		System.out.println("문제11");
		System.out.print("첫번째 실수를 입력해주세요 : ");
		float a9 = scanner.nextFloat();
		System.out.print("두번째 실수를 입력해주세요 : ");
		float a10 = scanner.nextFloat();
		float temp7 = (a9/a10)*100;
		System.out.println(a9+"은 "+ a10+ "의 "+temp7+"%입니다.");
		
		
		//문제12 : 사다리꼴 넓이 구하기[윗변과 밑변 높이를 입력받아 출력하기 ]
		//계산식) 사다리꼴 계산식 = > (윗변 * 밑변) * 높이 / 2
		System.out.println("문제12");
		System.out.print("윗변을 입력해주세요 : ");
		int a11 = scanner.nextInt();
		System.out.print("밑변을 입력해주세요 : ");
		int a12 = scanner.nextInt();
		System.out.print("높이을 입력해주세요 : ");
		int a13 = scanner.nextInt();
		int temp8 = ((a11*a12)*a13)/2;
		System.out.println("사다리꼴의 넓이 : "+ temp8);
		
		//문제13: 키를 정수를 입력받아 표준체중 출력하기 
		//계산식) 표준체중 계산식 = > (키 - 100) * 0.9
		System.out.println("문제13");
		System.out.print("키를 입력해주세요 : ");
		int a14 = scanner.nextInt();
		double temp9 = (double) ((a14-100)*0.9);
		System.out.println("표준체중 : "+ temp9);
		
		//문제14: 키와 몸무게를 입력받아 BMI 출력하기 
		//계산식) BMI 계산식 = > 몸무게 / ((키 / 100) * (키 / 100))
		System.out.println("문제14");
		System.out.print("키를 입력해주세요 : ");
		int a15 = scanner.nextInt();
		System.out.print("몸무게를 입력해주세요 : ");
		int a16 = scanner.nextInt();
		double temp10 = a16 / ((a15 / 100) * (a15 / 100));
		System.out.println("BMI : "+ temp10);
		
		
		//문제15: inch 를 입력받아 cm 로 변환하기 
		//계산식) 1 inch -> 2.54cm
		System.out.println("문제15");
		System.out.print("인치를 입력해주세요 : ");
		int a17 = scanner.nextInt();
		double temp11 = (double)(a17 * 2.54);
		System.out.println("cm : "+ temp11);
		
		
		//문제16:  중간고사, 기말고사, 수행평가를 입력받아 반영비율별 계산하여 소수 둘째자리까지 점수 출력하시오 
		//계산식 반영비율)  중간고사 반영비율 => 30 %  / 기말고사 반영비율 => 30 %   / 수행평가 반영비율 => 40 %
		System.out.println("문제16");
		System.out.print("중간고사 점수를 입력해주세요 : ");
		int a18 = scanner.nextInt();
		System.out.print("기말고사 점수를 입력해주세요 : ");
		int a19 = scanner.nextInt();
		System.out.print("수행평가 점수를 입력해주세요 : ");
		int a20 = scanner.nextInt();
		double temp12 = (a18 * 0.3)+(double)(a19 * 0.3)+(double)(a20 * 0.4);
		System.out.printf("점수 : %.2f\n", temp12);
	
		//문제17 :  연산 순서 나열 하고 printf() 에 출력되는 x 와 y 값을 예측하시오.
		System.out.println("문제17");
		int x = 10;
		int y = x-- + 5 + --x;
		System.out.printf(" x의 값 : %d\n", x);
		System.out.printf(" --x : x값에서 1감소 : x값은 9 \n");
		System.out.printf(" x+5+x : 9+5+9  => 값은 23 x값은 9 \n");
		System.out.printf(" y에 23대입 => x값은 9, y값은 23 \n");
		System.out.printf(" x-- ;이후 x값 1감소 x값은 8, y값은 23 \n");
		System.out.printf(" x의 값 : %d , y의값 :  %d\n", x, y);
		
		//문제18 : 나이를 입력받아 나이가 10세이상이면 학생 , 20세이상이면 성인 , 40세이상이면 중년 으로 출력하기
		System.out.println("문제18");
		System.out.print("나이를 입력해주세요 : ");
		int a21 = scanner.nextInt();
		String temp13 = a21>=40? "중년" : a21>=20? "성인" : a21>=10? "학생" : "그외";
		System.out.println("cm : "+ temp13);
		
		
		//문제19 : 국어 , 영어 , 수학 점수를 입력받아 각 변수에 저장하고 총점(소수점 0자리) 출력 , 평균(소수점 2자리 까지) 출력
		System.out.println("문제19");
		System.out.print("국어 점수를 입력해주세요 : ");
		int a22 = scanner.nextInt();
		System.out.print("영어 점수를 입력해주세요 : ");
		int a23 = scanner.nextInt();
		System.out.print("수학 점수를 입력해주세요 : ");
		int a24 = scanner.nextInt();
		int total = a22+a23+a24;
		double temp14 = total/3;
		System.out.println("총점 : "+ total);
		System.out.printf("평균 : %.2f\n",temp14);
		
		//문제20 : 아이디[문자열] 와 비밀번호[문자열] 를 입력받아 아이디가 'admin' 이고 비밀번호가 '1234' 와 일치하면 로그인성공 아니면 로그인실패 출력
		System.out.println("문제20");
		System.out.print("아이디를 입력해주세요 : ");
		String id = scanner.next();
		System.out.print("비밀번호를 입력해주세요 : ");
		String pw = scanner.next();
		String result = id.equals("admin") && pw.equals("1234")? "로그인 성공" : "로그인실패";
		System.out.println(result);
		
		
		//문제21 : 세 정수를 입력받아 가장 큰수 출력 
		System.out.println("문제21");
		System.out.print("첫번째 숫자를 입력해주세요 : ");
		int a25 = scanner.nextInt();
		System.out.print("두번째 숫자를 입력해주세요 : ");
		int a26 = scanner.nextInt();
		System.out.print("세번째 숫자를 입력해주세요 : ");
		int a27 = scanner.nextInt();
		int temp16 = a25>a26? a25>a27? a25 : a27 : a26>a27? a26 : a27;
		System.out.println("가장 큰 수 : "+ temp16);
		
		//문제22 가위바위보
		System.out.println("문제22");
		System.out.println("가위: '0', 바위 :'1', 보: '2'");
		System.out.print("플레이어1: ");
		int a28 = scanner.nextInt();
		System.out.print("플레이어2 : ");
		int a29 = scanner.nextInt();
		String temp17 = a28<0||a28>=3? "잘못입력하였습니다" :
							a29<0||a29>=3? "잘못입력하였습니다" :
								a28==a29? "무승부": 
									a28==0&&a29==2? "플레이어1 승리" : 
										a28==1&&a29==0? "플레이어1 승리" : 
											a28==2&&a29==1? "플레이어1 승리" : "플레이어2 승리" ;
		System.out.println("결과 : "+ temp17);
		
	} //main e
} //class e






















