package practice.day03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductDao {
	
	private static ProductDao dao = new ProductDao();
	public static ProductDao getInstance() {return dao;};

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public ProductDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspweb","root","1234");
			
		} catch (Exception e) {
			System.out.println("오류 : " +  e);
		}
	}
	
	// 1. 등록
	public boolean addproduct(ProductDto dto) {
		String sql = "insert into product(pname , pprice) value (?,?); ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getPname());
			ps.setInt(2, dto.getPprice());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("오류 : " + e);
		}
		return false;
	}
	
	// 2. 모든 제품 출력
	public ArrayList<ProductDto> plist(){
		ArrayList<ProductDto> plist = new ArrayList<>();
		String sql = "select *from product;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductDto dto = new ProductDto(rs.getInt(1), rs.getString(2), rs.getInt(3));
				plist.add(dto);
			} // while e
		}  // try e
		catch (Exception e) {System.out.println(e);}
		return plist;
	}
	
	// 3. 삭제
	public boolean pdelete(int pno){
		String sql = "delete from product where pno = ? ;";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, pno);
			ps.executeUpdate();
			return true;
		}
		catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	// 4. 수정
	public boolean pupdate(int pno, String newName, int newPrice) {
		String sql = "update product set pname = ? , pprice = ? where pno = ? ;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, newName);
			ps.setInt(2, newPrice);
			ps.setInt(3, pno);
			ps.executeUpdate();
			return true;
		}
		catch (Exception e) {System.out.println(e);}
		return false;
	}
}
