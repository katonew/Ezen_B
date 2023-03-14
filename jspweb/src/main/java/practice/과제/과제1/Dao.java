package practice.과제.과제1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {

	public Connection con;
	public PreparedStatement ps;
	public ResultSet rs;
	
	public Dao() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/과제1",
					"root",
					"1234" );
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
