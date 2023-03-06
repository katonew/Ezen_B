package jspweb.model;

import java.sql.*;
import java.util.ArrayList;

public class Dao {
	
	
	// 1. 내부 객체와 내부 객체 반환 메소드
	private static Dao dao = new Dao();
	public static Dao getInstance() {return dao;}
	
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	private Dao() {
		try {
			// * [웹서버] : 해당 MYSQL 드라이버[라이브러리] 찾기
			Class.forName("com.mysql.cj.jdbc.Driver");			// 웹서버 프로젝트 O
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jspweb",
					"root",
					"1234");
			System.out.println("연동 성공");
		}catch (SQLException e) {System.out.println("DB연동 실패 : "+ e);}
		catch (Exception e) {System.out.println("에러 : "+e);}
	}
	
	// 2. SQL 메소드 : 데이터 저장
	public boolean setData(String data) {
		
		// 1. SQL 작성
		String sql = "insert into ex1 values(?)";
		// 2. SQL 대입
		try {
			ps = con.prepareStatement(sql);
			// 3. SQL 조작
			ps.setString(1, data);
			// 4. SQL 실행 --> 5.SQL 결과
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
		
		// 6. 응답
		
	} // setDate e
	
	// 데이터들 호출 [ 1개 : String / 여러개 : ArrayList<String> ]
	public ArrayList<String> getData(){
		ArrayList<String> list = new ArrayList();
		// 1. sql 작성
		String sql = "select *from ex1;";
		try {
			// 2. SQL 대입
			ps = con.prepareStatement(sql);
			// 3. SQL 조작 X
			// 4. SQL 실행 --> 5.SQL 결과
			rs = ps.executeQuery();
			// 레코드 1 개 if / 레코드 여러개 while
			while(rs.next()) {
				list.add(rs.getString(1)); // 해당 레코드의 첫번째 필드를 리스트에 저장
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
		
	}
	
	public boolean q1SetData(String data) {
		
		String sql = "insert into q1 values(?);";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, data);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("오류 : " + e);
		}
		return false;
		
	}
	public ArrayList<String> q1GetData(){
		ArrayList<String> list = new ArrayList();
		String sql = "select *from q1;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (Exception e) {
			System.out.println("에러 : "+ e);
		}
		return list;
	}

}
