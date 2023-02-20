package Day14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Ex5_DB연동2 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;	//여러 if{} 안에서 사용하기 위해 무한루프 밖에 선언
		
		while(true) {
			try { // 1. 예외 발생할 것 같은 코드 [ 예상 : nextInt()인데 문자열 입력시 예외 발생 ]
				System.out.print("1.연결 2.SQL구문 삽입 3.매개변수 구문 삽입 : ");
				int ch = scanner.nextInt();
				if(ch==1) {
					System.out.print("--연동할 DB명 입력 : ");
					String dbname = scanner.next();
					System.out.println(dbname+"에 연결합니다.");
					
					//* 입력받은 db와 연결
					conn = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/"+dbname,"root","1234");
					System.out.println("**연결 성공");
				}
				else if(ch==2) {
					System.out.println("-- SQL구문 입력 : ");
					scanner.nextLine();	// nextLine() 앞에 next()가 있으면 오류방지용
					String sql = scanner.nextLine();
					// * 연결된 DB객체에 SQL 대입 [PreparedStatement 매개변수 처리]
					PreparedStatement ps = conn.prepareStatement(sql);
					//* SQL 실행
					ps.execute();
					System.out.println("등록되었습니다.");
				}else if(ch==3) {
					System.out.print("번호 : ");		int mno = scanner.nextInt();
					System.out.print("아이디 : ");	String mid = scanner.next();
					System.out.print("비밀번호 : ");	String mpw = scanner.next();
					// * sql 구문작성 [? : 변수가 들어갈 자리]
					String sql = "insert into member values(?,?,?);";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setInt(1, mno);		// 1 : sql구문에서 첫번째 ? 자리
					ps.setString(2,mid );	// 2. 두번째 ?
					ps.setString(3, mpw);	// 3. 세번째 ?
					//*
					ps.executeUpdate();
					
				}
				
			}catch (InputMismatchException e) { // try()에서 예외발생하면 실행되는 코드
				System.err.println("알수없는 입력입니다.");
				scanner = new Scanner(System.in); // 기존에 입력된 데이터를 제거
			}catch (SQLException e) {
				System.err.println("SQL오류 : "+e);
			}catch (Exception e) {
				System.out.println("[DB연결 후 다시 실행]");
			}
					
		}// while e
	} //main e
} //class e
