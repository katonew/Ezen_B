package practice.과제.과제1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class printDao extends Dao{
	
	private static printDao dao = new printDao();
	private printDao() {}
	public static printDao getInstance() {return dao;}
	
	// 출력 메소드 [ 전체출력 ] 
	public ArrayList<Mdto> print(){
		ArrayList<Mdto> list = new ArrayList<>();
		String sql = "select e.no , e.img , e.name , e.jobgrade , e.type , e.indate , e.outdate , e.outreason , p.partname, p.pno from employee e , part p where e.pno=p.pno order by no";
		try {
			ps = con.prepareStatement(sql); 
			rs = ps.executeQuery();
			while(rs.next()) {
				Mdto mdto = new Mdto(rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getString(6).substring(0, 10), 
						rs.getString(7)==null? null : rs.getString(7).substring(0, 10), rs.getString(8),
						rs.getString(9), rs.getInt(10));
				System.out.println(rs.getString(6));
				System.out.println(rs.getString(7));
				list.add(mdto);
				System.out.println("mdto : "+ mdto);
			} // while e
		} catch (Exception e) {System.out.println("print DB에러 : "+ e);}
		return list;
	} // print e
	
	public boolean onDelete(int no) {
		String sql = "delete from employee where no=?; ";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			int count = ps.executeUpdate();
			if(count==1) {return true;}
		} catch (Exception e) {System.out.println("onDelete에러 : "+ e);}
		return false;
	}
	
	
	public boolean onUpdate(String img, String name,String type, String part, int no) {
		String sql = "update employee set img=?, name=?, type=?, pno=? where no= ? ";
		
		int pno = regDao.getInstance().partFind(part);
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, img);
			ps.setString(2, name);
			ps.setString(3, type);
			ps.setInt(4, pno);
			ps.setInt(5, no);
			int count = ps.executeUpdate(); // 수정된 레코드 수 반환
			if(count==1) {return true;}
		} catch (Exception e) {System.out.println("onUpdate DB에러 : "+ e);}
		return false;
	}
	
	
	// 재직자 출력
	public ArrayList<Mdto> inprint(){
		ArrayList<Mdto> list = new ArrayList<>();
		String sql = "select e.no,e.img,e.name,e.jobgrade,e.type,e.indate,e.outdate,e.outreason,p.partname , p.pno from employee e , part p where e.pno=p.pno and e.outdate is null order by no";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Mdto mdto = new Mdto(rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getString(6), 
						rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getInt(10));
				list.add(mdto);
				System.out.println("mdto : "+ mdto);
			} // while e
		} catch (Exception e) {System.out.println("inprint DB에러 : "+ e);}
		return list;
	} // print e
	
	// 퇴직자 출력
	public ArrayList<Mdto> outprint(){
		ArrayList<Mdto> list = new ArrayList<>();
		String sql = "select e.no , e.img , e.name , e.jobgrade , e.type , e.indate , e.outdate , e.outreason , p.partname , p.pno from employee e , part p where e.pno=p.pno and e.outdate is not null order by no";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Mdto mdto = new Mdto(rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getString(6), 
						rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getInt(10));
				list.add(mdto);
				System.out.println("mdto : "+ mdto);
			} // while e
		} catch (Exception e) {System.out.println("outprint DB에러 : "+ e);}
		return list;
	} // print e
	
	// 검색 메소드
	public ArrayList<Mdto> serch(String serch){
		System.out.println("serch : "+serch);
		ArrayList<Mdto> list = new ArrayList<>();
		String sql = "select e.no , e.img , e.name , e.jobgrade ,  "
				+ "e.type , e.indate , e.outdate , e.outreason , p.partname ,  "
				+ "p.pno from employee e , part p where e.pno=p.pno and name like ?  "
				+ "order by no;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+serch+"%");
			rs = ps.executeQuery();
			while(rs.next()) {
				Mdto mdto = new Mdto(rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getString(6), 
						rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getInt(10));
				list.add(mdto);
				System.out.println("mdto : "+ mdto);
			} // while e
		} catch (Exception e) {System.out.println("serch DB에러 : "+ e);}
		return list;
	} // print e
}
