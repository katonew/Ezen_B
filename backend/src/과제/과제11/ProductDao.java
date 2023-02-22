package 과제.과제11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Day15.Ex9_MVC패턴.MemberDto;

public class ProductDao {
	
	//싱글톤
	private static ProductDao dao = new ProductDao();
	public static ProductDao getInstance() {return dao;}
	
	private Connection conn;		// 1. 연결된 DB구현객체를 가지고 있는 인터페이스
	private PreparedStatement ps;	// 2. 연결된 SQL 조작 [ + 매개변수 가능 ]
	private ResultSet rs;			// 3. 실행된 SQL 결과
	
	private ProductDao() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","1234");
		}catch (Exception e) {
			System.out.println("DB오류 : "+e);
		}
	}
	
	
	//제품 등록 함수
	public boolean add(ProductDto dto) {
		// 1. SQL 작성
		String sql = "insert into product (pname,pprice,pinven) values(?,?,?); ";
		// 2. 연동 DB에 SQL 대입
		try {
			ps = conn.prepareStatement(sql);
			// 3. SQL 조작
			ps.setString(1, dto.getPname());
			ps.setInt(2, dto.getPprice());
			ps.setInt(3, dto.getPinven());
			// 4. SQL 실행
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println("DB에러" + e);
		}
		// 5. SQL 결과
		return false;
	}
	// 제품 출력 함수
	public ArrayList<ProductDto> print() {
		ArrayList<ProductDto> list = new ArrayList<>();
		// 1. SQL 작성
		String sql = "select *from product;";
		// 2. 연동 DB에 SQL 대입
		try {
			ps = conn.prepareStatement(sql);
			// 3. SQL 조작
			// 4. SQL 실행
			rs = ps.executeQuery(); // SQL 결과를 rs 인터페이스로 반환
			while(rs.next()) {
				ProductDto dto = new ProductDto(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				list.add(dto);
			}//while e
			return list;
		}catch (Exception e) {
			System.out.println("DB에러" + e);
		}
		// 5. SQL 결과
		return null;
	}
	// 제품 수정 함수
	public boolean pupdate(int pno,String pname,int pprice) {
		// 1. SQL 작성
		String sql = "update product set pname = ? where pno = ?;";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pname);
			ps.setInt(2, pno);
			ps.executeUpdate();
			
			sql = "update product set pprice= ? where pno = ?;";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pprice);
			ps.setInt(2, pno);
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println("DB에러" + e);
		}
		// 5. SQL 결과
		return false;
	}
	// 재고 수정 함수
	public boolean iupdate(int pno,int pprice) {
		// 1. SQL 작성
		String sql = "update product set pinven = ? where pno = ?;";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pprice);
			ps.setInt(2, pno);
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println("DB에러" + e);
		}
		// 5. SQL 결과
		return false;
	}
	// 삭제 함수
	public boolean delete(int pno) {
		String sql = "delete from product where pno = ?;";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pno);
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println("DB에러" + e);
		}
		// 5. SQL 결과
		return false;
	}	
	
}
