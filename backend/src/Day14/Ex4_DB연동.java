package Day14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class Ex4_DB연동 {
	public static void main(String[] args) {
		
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/java",	"root",	"1234"); // java에서 db생성 불가능 하기 때문에 db생성하고난 후 실행
			System.out.println(" [DB 연동 성공]");
			
			// 2. table 생성 하는 sql 구문을 문자열 변수에 저장
			String sql = "create table member(mno int, mid varchar(20), mpw varchar(20))";
			
			//3. DML DDL 조작 인터페이스에 연결된 DB연결구현객체에 SQL 대입
			PreparedStatement ps = con.prepareStatement(sql);
			
			//4. SQL 실행
			ps.execute();
			
			sql = "drop table member";
		}
		catch(Exception e) {
			System.out.println("[DB 연동 실패] 사유 : " + e);
		}
	}
}




/*
	
	JDBC : 자바와 DB 연결 드라이브
		- 해당 DBMS 마다 라이브러리[.JAR] 파일 필요
		- 보관장소 : C://mysql-connector-j-8.0.32
	- 1. 라이브러리 추가
		1. 프로젝트 오른쪽 클릭 -> bulid path -> configure bulid
		2. Libraries 탭에서 -> edit -> javaSE 버전 변경(1.8) -> apply
		3. add External jars ->  mysql-connector-j-8.0.32 추가 -> apply
		
	- 2. 
		Connection : DB 연결 인터페이스로 다양한 객체를 제공
		DriverManager : DB 연결 클래스 구현객체 제공
		DriverManager.getConnection(DB주소, 계정, 비밀번호)
			- 일반예외 발생 -> 예외처리 필수
			- mysql server주소 : jdbc:mysql://ip주소:포트번호/db명
							- 로컬pc기준 : jdbc:mysql://localhost:3306/db명
			- mysql : create database java;
*/







