package practice.과제.과제1;

import java.util.ArrayList;

public class regDao extends Dao {

	
	private static regDao dao = new regDao();
	private regDao() {}
	public static regDao getInstance() {
		return dao;
	}
	
	
	// 1. 인사등록
	public boolean regist( Mdto dto ) {
		
		
		int pno = partFind( dto.getPart() );
		
		String sql = "insert into employee ( img , name , jobgrade , type , pno ) value ( ? , ? , ? , ? , ?)";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, dto.getImg() );
			ps.setString(2, dto.getName() );
			ps.setString(3, dto.getJobgrade());
			ps.setString(4, dto.getType() );
			ps.setInt(5, pno);
			
			ps.executeUpdate();
			
			return true;
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return false; 
	}
	
	// 2. 파트찾기
	public int partFind( String part ) {
		
		String sql = "select pno from part where partname = ?";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, part);
			
			rs = ps.executeQuery();
			
			if( rs.next() ) { return rs.getInt(1); }
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	// 3. 탈퇴처리
	public boolean outdate( int no , String outreason ) {
		
		String sql = "update employee set outdate = now() , outreason = ? where no = ?";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, outreason);
			ps.setInt(2, no);
			
			ps.executeUpdate();
			
			return true;
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return false; 
	}
	
	// 4. 부서목록 가져오기
	public ArrayList<Pdto> partList() {
		
		ArrayList<Pdto> list = new ArrayList<>();
		
		String sql = "select * from part";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				
				Pdto dto = new Pdto(
						rs.getInt(1), rs.getString(2), rs.getString(3));
				
				list.add(dto);
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
}
