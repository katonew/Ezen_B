package Day20.gallary.Model.Dao;

import Day20.gallary.Model.Dto.MemberDto;

public class MemberDao extends Dao{

	//1. 싱글톤
	private static MemberDao dao = new MemberDao();
	private MemberDao() {}
	public static MemberDao getInstance() {return dao;}
	
	// 기능 메소드
	
	// 1. 아이디 중복체크
	public boolean idcheck(String mid) {
		String sql = "select *from member where mid = ?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,mid);
			rs = ps.executeQuery();
			if(rs.next()) {return true;}	// 검색된 레코드가 있으면
			else {return false;}	// 없으면 중복된 아이디가 아니다.
		}catch (Exception e) {System.out.println(e);}
		return true;
	} // idcheck e
	
	// 2. 회원가입
	public int signup(MemberDto dto) {
		String sql = "insert into member(mid,mpw,mname,mphone) values ( ? , ?, ?, ?);";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,dto.getMid());
			ps.setString(2,dto.getMpw());
			ps.setString(3,dto.getMname());
			ps.setString(4,dto.getMphone());
			ps.executeUpdate();
			return 1;
		}catch (Exception e) {System.out.println(e);}
		return 3;
	} // signup e
	
	// 3. 로그인 [ 반환 : 로그인 성공한 회원 번호 반환]
		// - 로그인 [ 로그인 하는 동안 저장되는 ] 세션 : 1.회원번호 2. logindto
	public int login(String mid,String mpw) {
		String sql = "select * from member where mid = ? and mpw = ?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,mid);
			ps.setString(2,mpw);
			rs = ps.executeQuery();
			if(rs.next()) {return rs.getInt(1);}	// 검색된 레코드가 있으면
			else {return 0;}
		}catch (Exception e) {System.out.println(e);}
		return 0;
	}
	
}
