package Day06;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Ex6_비회원게시판 {	//class s
	public static void main(String[] args) throws Exception { //main s
		
		//step1 : 필요한 데이터를 입력받아 저장
		//step2 : 쓰기 페이지 실행되는 조건
		//step3 : 입력된 데이터를 파일처리 [ 영구저장 ]
		//step4 : 파일에 있는 문자열 가지고 오기
		//step5 : 문자열 분리해서 출력하기
		
		//* 입력 객체
		Scanner sc = new Scanner(System.in);
		
		while(true) {	// 무한 루프 종료조건 : -2 입력시
			
			//현재 파일에 존재하는 모든 문자열 호출
			//1. 파일 입력 클래스 객체 생성(파일경로)
			FileInputStream fin = new FileInputStream("c:/java/board.txt");
			//2. 읽어온 바이트를 저장하기 위해 미리 바이트배열 1000바이트 미리 생성
			byte[] inbytes = new byte[1000];	//영문1바이트 한글3바이트
			//3. .read() 메소드를 이용한 파일 읽기 [ * 읽은 바이트를 바이트 배열 저장]
				// inbytes 		: 읽어온 바이트를 배열에 저장
				// bytecount 	: 읽어온 바이트의 개수
			int bytecount = fin.read(inbytes);	// 읽어온 바이트를 바이트배열 저장
			//4. 바이트 배열 --> 문자열
				// new String("유재석");
				// new String(바이트배열); new String(바이트배열, 시작인덱스, 마지막인덱스);
			String fStr = new String(inbytes, 0, bytecount); //바이트 배열 ---> 문자열 변환
			
			System.out.println("---------------게시판----------------");
			System.out.printf("%s\t%s\t%s\n","번호","제목","작성자");
			//* 행 기준 자르기
			String[] borads = fStr.split("\n");	// 행기준으로 분리 [ 만약에 게시물 2개일때는 3조각인데 마지막 인덱스 사용안함]
			//* [행마다] 열 기준 자르기 [길이-1한 이유 : 마지막 인덱스 제외 시키기 위해]
			for(int i =0;i<borads.length;i++) {
				//* 게시물 마다 열 자르기
				String[] cols = borads[i].split(",");
				String title = cols[0];
				String content = cols[1];
				String writer = cols[2];
				String password = cols[3];
				System.out.printf("%2d\t%s\t%s\n",i+1,title,writer);
			}
			
			System.out.print(" 메뉴> 쓰기 : [-1] 나가기 : [-2] 	: ");
			int ch = sc.nextInt();
			if(ch==-1) {
				System.out.print("제목 : ");		String title = sc.next();
				System.out.print("내용 : ");		String content = sc.next();
				System.out.print("작성자 : ");	String writer = sc.next();
				System.out.print("비밀번호 : ");	String password = sc.next();
				
				
				String outStr = title+","+content+","+writer+","+password+","+"\n";
				
				FileOutputStream fout = new FileOutputStream("c:/java/board.txt",true);
				fout.write(outStr.getBytes());
				
			}else if(ch==-2) {sc.close(); break;}
			
			
		} //while e
		
	} //main e

} //class e
