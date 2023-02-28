package Day20.gallary.Model.Dao;

import java.util.ArrayList;

import Day20.gallary.Model.Dto.BoardDto;
import Day20.gallary.Model.Dto.CategoryDto;

public class BoardDao extends Dao{

	//1. 싱글톤
	private static BoardDao dao = new BoardDao();
	private BoardDao() {}
	public static BoardDao getInstance() {return dao;}
	
	
	
	// 1. 카테고리 추가 SQL
	public boolean categoryAdd(String cname) {
		String sql = "insert into category(cname) values (?);";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,cname);
			ps.executeUpdate();
			return true;
		}catch (Exception e) {System.out.println(e);}
		return false;
	} // add e
	
	// 2. 모든 카테고리 호출 SQL
	public ArrayList<CategoryDto> categoryPrint(){
		ArrayList<CategoryDto> clist = new ArrayList<>();
		String sql = "select *from category;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) { // rs.next() : 다음 레코드가 존재하면 true 없으면 false
				// 레코드 ==> dto
				CategoryDto dto = new CategoryDto(rs.getInt(1), rs.getString(2));
				clist.add(dto);
			}
			return clist;
		}catch (Exception e) {System.out.println(e);}
		return null;
	} // print e
	
	
	// 3. 게시물 등록
	public boolean boardAdd(String btitle,String bcontent, int mno, int cno) {
		String sql = "insert into board(btitle,bcontent,mno_fk,cno_fk) values (?,?,?,?);";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,btitle);
			ps.setString(2,bcontent);
			ps.setInt(3,mno);
			ps.setInt(4,cno);
			ps.executeUpdate();
			return true;
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	// 4. 최신 게시물 3개 출력
	public ArrayList<BoardDto> boardPrintRecent() {
		String sql = "select b.bno, b.btitle, b.bcontent, b.bdate, bview , m.mid, c.cname "
				+ " from board b, member m, category c "
				+ " where b.mno_fk = m.mno and b.cno_fk=c.cno "
				+ " order by b.bdate desc limit 3; ";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ArrayList<BoardDto> clist = new ArrayList<>();
				BoardDto dto = new BoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7));
				clist.add(dto);
				
			}
		}catch (Exception e) {System.out.println(e);}
		return null;
	}
	
	// 5. 해당 카테고리의 모든 게시물 출력
	public ArrayList<BoardDto> boardPrint(int cno) {
		String sql = "select b.bno, b.btitle, b.bcontent, b.bdate, bview , m.mid, c.cname\r\n"
				+ "    from board b, member m, category c\r\n"
				+ "    where b.mno_fk = m.mno and b.cno_fk=c.cno and b.cno_fk=?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1,cno);
			rs = ps.executeQuery();
			while(rs.next()) {
				ArrayList<BoardDto> clist = new ArrayList<>();
				BoardDto dto = new BoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7));
				clist.add(dto);
			}
		}catch (Exception e) {System.out.println(e);}
		return null;
	}
	// 6. 해당 게시물 출력
	
	
	
} // class e


















