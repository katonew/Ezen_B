package model.dao;


import java.util.ArrayList;

import model.dto.ProductDto;

public class ProductDao extends Dao{
	
	// 싱글톤
	private static ProductDao dao = new ProductDao();
	private ProductDao() {}
	public static ProductDao getInstance() {return dao;}
	
	// 상품 등록 함수
	public boolean onwrite(ProductDto dto) {
		String sql = "insert into product(pname,pcomment,pprice,plat,plng) values(?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getPname());
			ps.setString(2, dto.getPcomment());
			ps.setInt(3, dto.getPprice());
			ps.setString(4, dto.getPlat());
			ps.setString(5, dto.getPlng());
			int count = ps.executeUpdate();
			if(count==1) {return true;}
		} catch (Exception e) {
			System.out.println("상품등록 오류 : " + e);
		}
		return false;
	}
	
	public ArrayList<ProductDto> getlist(String 동,String 서,String 남,String 북){
		ArrayList<ProductDto> list = new ArrayList<>();
		String sql ="SELECT * FROM product where ? >= plng and ? <= plng and ? <= plat and ? >= plat ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , 동 );	
			ps.setString( 2 , 서 );	
			ps.setString( 3 , 남 );	
			ps.setString( 4 , 북 );
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductDto dto = new ProductDto(rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), 
						rs.getString(7), rs.getInt(8), rs.getString(9));
				list.add(dto);
			}
		} catch (Exception e) {
			System.out.println("상품가져오기 오류 : " + e);
		}
		return list;
	}
	
	// 찜하기 등록/ 취소 
	public int setplike(int pno,int mno) {
		
		// 1. 찜 등록인지 취소인지 확인
		String sql = "select *from plike where pno = ? and mno =?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, pno);
			ps.setInt(2, mno);
			rs = ps.executeQuery();
			if(rs.next()) { // 검색 내용이 있으면 해당 멤버가 이미 찜하기를 했으므로 취소
				sql = "delete from plike where pno = ? and mno =?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, pno);
				ps.setInt(2, mno);
				int count = ps.executeUpdate();
				if(count==1) {return 1;}
			}else { // 찜 안한것이므로 등록
				sql = "insert into plike (pno,mno) values (?,?)";
				ps = con.prepareStatement(sql);
				ps.setInt(1, pno);
				ps.setInt(2, mno);
				int count = ps.executeUpdate();
				if(count==1) {return 2;}
			}
		} catch (Exception e) {
			System.out.println("setplike 오류" + e);
		}
		return 3;
		
	}
	
	// 4. 해당 회원이 해당 제품 찜하기 상태인지 확인
	public boolean getplike(int pno, int mno) {
		System.out.println("pno1 :" + pno);
		System.out.println("mno1 :" + mno);
		String sql = "select *from plike where pno = ? and mno =?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, pno);
			ps.setInt(2, mno);
			rs = ps.executeQuery();
			if(rs.next()) {return true;}
		} catch (Exception e) {System.out.println("getplikec 오류" + e);}
		return false;
	}
}



















