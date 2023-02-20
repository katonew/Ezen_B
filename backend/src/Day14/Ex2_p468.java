package Day14;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex2_p468 {
	public static void main(String[] args) {
		
		// 1. Class.forName("패키지명.클래스명");
			// 일반 예외 : 컴파일 전에 예외 확인
		try {
			Class.forName("java.lang.String"); // 클래스 여부 찾기
			System.out.println("java.lang.String 클래스가 존재합니다.");
		}
		catch(ClassNotFoundException e) {e.printStackTrace();}
		System.out.println("");
		try {
			Class.forName("java.lang.String2"); // 클래스 여부 찾기
			System.out.println("java.lang.String2 클래스가 존재합니다.");
		}
		catch(ClassNotFoundException e) {e.printStackTrace();}
		
		
		// 2.
		System.out.println("");
			// 배열 : 타입[] 배열명 = {데이터, 데이터, 데이터}
		String[] array = {"100", "1oo"};
			// 배열 for 시작점: 인덱스 : 0, 길이 : 1 
		for(int i=0 ; i<=array.length;i++) {
			try {
				int value = Integer.parseInt(array[i]);
				// Integer.parseInt(문자열) -> 정수형
				// 예외발생 : "100"-> 100가능 / "1oo" -> 불가능
				System.out.println("array["+i+"] : "+value);
			}catch(NumberFormatException e) {
				System.out.println("숫자로 반환할 수 없음 : "+e);
			}catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("인덱스 초과 : "+e);
			}catch (Exception e) {	// 예외 최상위 클래스는 가장 마지막에 작성
				System.out.println("예외발생 : "+e);
			}
		} // for e
		
		
		// 3.
		while(true) {
			try {
				Scanner sc = new Scanner(System.in);
				int ch = sc.nextInt();
			}
			catch (InputMismatchException e) {
				System.out.println("잘못된 입력입니다.");
			}
		}
		
		
	} // main e
} //class e
