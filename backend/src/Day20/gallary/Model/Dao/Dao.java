package Day20.gallary.Model.Dao;

import java.sql.*;

public class Dao {

	// 1. jdbc 인터페이스 3개
	Connection con;			// DB연동 인터페이스
	PreparedStatement ps;	// SQL 조작 인터페이스
	ResultSet rs;			// SQL 결과 조작 인터페이스
	
	public Dao() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/boarddb","root","1234");
		}catch (Exception e) {
			System.out.println("DB오류 : "+e);
		}
				
	}
	
	
	
	
}
