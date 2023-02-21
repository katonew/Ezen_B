package 과제.과제10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class DB과제1 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		
		while(true) {
			try {
				System.out.print("1. DB연결 2.SQL구문 작성 3.매개변수 입력 : ");
				int ch = sc.nextInt();
				if(ch==1) {
					//1선택시  - 'DB과제1' 이름의 DB와 연결한다.
					System.out.print("--연동할 DB명 입력 : ");
					String dbName = sc.next();
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName,"root","1234");
					System.out.println(dbName+"에 연결되었습니다.");
				}else if(ch==2) {
					//console에서 SQL 작성할수 있도록 하여 아래와 같이 table 생성한다. 
					//제품 테이블( 제품번호[정수] , 제품명[20] , 제품설명[100] , 제품가격[정수 );
					//create table product(pno int,pname varchar(20), pcontent varchar(100),pprice int);
					System.out.println("-- SQL구문 입력 : ");
					sc.nextLine(); //오류 방지용 nextLine;
					String sql = sc.nextLine();
					// sql에 대입
					conn.prepareStatement(sql).execute();
					System.out.println("입력되었습니다.");
				}else if(ch==3) {
					//제품번호 , 제품명 , 제품설명 , 제품가격 을 각각 입력받아 입력받은 데이터로 DB에 저장한다. [ 제품 3개 등록 ]
					System.out.print("제품번호 : ");		int pno = sc.nextInt();
					System.out.print("제품명 : ");		String pname = sc.next();
					sc.nextLine();	// 상품 설명에 띄어쓰기가 들어갈것을 고려한 nextLine(); --- 오류 방지용 nextLine;
					System.out.print("제품설명 : ");		String pconetent = sc.nextLine();
					System.out.print("제품가격 : ");		int pprice = sc.nextInt();
					String sql = "insert into product values(?,?,?,?);";
					PreparedStatement ps =  conn.prepareStatement(sql);
					// ? 에 순서대로 입력값 대입
					ps.setInt(1,pno);
					ps.setString(2, pname);
					ps.setString(3, pconetent);
					ps.setInt(4, pprice);
					// sql에 대입
					ps.executeUpdate();
				}
			}catch (InputMismatchException e) {
				System.err.println("잘못된 입력값입니다.");
				sc = new Scanner(System.in);
			}catch (SQLException e) {
				System.err.println("[DB에러] 사유: " + e);
			}catch (Exception e) {
				System.err.println("DB연결후 진행요망");
			}
		}// while e
	} // main e
} // class e
