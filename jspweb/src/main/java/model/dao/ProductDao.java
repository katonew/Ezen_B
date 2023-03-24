package model.dao;


import model.dto.ProductDto;

public class ProductDao extends Dao{
	
	// 싱글톤
	private static ProductDao dao = new ProductDao();
	private ProductDao() {}
	public static ProductDao getInstance() {return dao;}
	
	public boolean onwrite(ProductDto dto) {
		String sql = "insert into product(pname,pcomment,pprice,,plat,plng) values(?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getPname());
			ps.setString(1, dto.getPname());
			ps.setString(1, dto.getPname());
			ps.setString(1, dto.getPname());
			ps.setString(1, dto.getPname());
			
		} catch (Exception e) {
			System.out.println("상품등록 오류 : " + e);
		}
		return false;
	}
	

}
