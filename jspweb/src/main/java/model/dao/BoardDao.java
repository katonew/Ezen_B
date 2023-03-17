package model.dao;

import java.util.ArrayList;

import controller.board.BoardDto;

public class BoardDao extends Dao{
	// 싱글톤
	private static BoardDao dao = new BoardDao();
	private BoardDao() {}
	public static BoardDao getInstance() { return dao; }
	
	// 1. 글쓰기 메소드
	public boolean bwrite(BoardDto dto) {
		String sql = "insert into board(btitle,bcontent,bfile,mno,cno) values (?,?,?,?,?) ; ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getBtitle());
			ps.setString(2, dto.getBcontent());
			ps.setString(3, dto.getBfile());
			ps.setInt(4, dto.getMno());
			ps.setInt(5, dto.getCno());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("글쓰기 함수 에러 :" + e);}
		return false;
	} // bwrite e
	
	// 2. 모든 글 출력
	public ArrayList<BoardDto> getBoardList(){
		ArrayList<BoardDto> list = new ArrayList<>();
		String sql = "select board.*, member.mid from member natural join board order by bdate desc";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				BoardDto dto = new BoardDto(
						rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), 
						rs.getInt(9),rs.getInt(10), rs.getString(11));
				list.add(dto);
			}
		} catch (Exception e) {System.out.println("모든 글 출력 에러 : "+e);}
		return list;
	}
	
	// 3. 개별 글 조희
	public BoardDto getBoard(int bno){
		BoardDto dto = null;
		String sql = "select  board.*, member.mid, member.mimg from board natural join member where board.bno = ?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bno);
			rs = ps.executeQuery();
			if(rs.next()) {
				 dto = new BoardDto(
					rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), 
					rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), 
					rs.getInt(9),rs.getInt(10), rs.getString(11));
				 return dto;
			}
		} catch (Exception e) {System.out.println("개별 글 출력 에러 : "+e);}
		return null;
	} // getboard e
	
	// 5. 게시물 삭제
	public boolean bdelete(int bno) {
		String sql = "delete from board where bno = " + bno ;
		try {
			ps = con.prepareStatement(sql);
			int count = ps.executeUpdate();
			if(count==1) {return true;}
		} catch (Exception e) {
			System.out.println("게시글 삭제 오류 : " + e);
		}
		return false;
	}
	
	// 6. 게시물 수정
	public boolean bupdate(BoardDto dto) {
		String sql = "update board set btitle = ?,bcontent=?,bfile=?,cno=? where bno = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getBtitle());
			ps.setString(2, dto.getBcontent());
			ps.setString(3, dto.getBfile());
			ps.setInt(4, dto.getCno());
			ps.setInt(5,dto.getBno());
			int count = ps.executeUpdate();
			if(count==1) {return true;}
		} catch (Exception e) {System.out.println("수정DB오류 : " +  e);}
		return false;
	} //  bupdate e
	
	// 7. 첨부파일 삭제
	public boolean bfiledelete(int bno) {
		String sql = "update board set bfile=? where bno ="+bno;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, null);
			int count = ps.executeUpdate();
			if(count==1) {return true;}
		} catch (Exception e) {System.out.println("첨부파일삭제 DB오류 : " +  e);}
		return false;
	}
	

}
