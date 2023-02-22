package Day15.Ex9_MVC패턴;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDao {
	
	//*싱글톤 : Dao 싱글톤을 사용하는 이유 : 프로그램 내 DB 연동 1번만 해서 하나의 연동 객체 사용
	 	// 1. 내부에 객체 만들기
	private static MemberDao dao = new MemberDao();
		// 2. 생성자는 private -> 외부에서 new 사용금지 
		// 3. 외부에서 내부객체 사용할 수 있게 내부객체 반환 메소드 [getInstance]
	public static MemberDao getInstance() {return dao;}
	
	// 1. 필드
	private Connection conn;		// 1. 연결된 DB구현객체를 가지고 있는 인터페이스
	private PreparedStatement ps;	// 2. 연결된 SQL 조작 [ + 매개변수 가능 ]
	private ResultSet rs;			// 3. 실행된 SQL 결과
	
	// 2. 생성자 [ 연동코드 -> 객체 생성시 바로 연동 될 수 있게 하기 위해 ]
	private MemberDao() {
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/day15","root","1234");
		}catch (Exception e) {System.out.println(e.getMessage());}
	}
	
	// 3. SQL 처리 메소드
		// 1. 회원가입 메소드 [ 인수 : Dto(id,pw) , 반환 : 성공[true]/실패[false] ]
	public boolean signup(MemberDto dto) {
		// 1. SQL 작성
		String sql = "insert into member(mid,mpw) values(?,?);";
		// 2. 연동 DB에 SQL 대입한다. [ ps -> 매개변수 조작 가능]
		try {
			ps = conn.prepareStatement(sql);
			// 3. ps는 매개변수에 대한 조작 가능
			ps.setString(1, dto.getMid() );	// 첫번째 ?
			ps.setString(2, dto.getMpw() );	// 두번째 ?
			// 4. ps가 sql 실행
			ps.executeUpdate();
			// 5. 결과 반환
			return true; 	// 여기까지 문제 없었으면 저장 성공
		} catch (SQLException e) {
			System.out.println("DB 오류 : "+e.getMessage());
		}
		return false;	//try에서 문제가 있으면 실행되는 구역 -> 저장 실패
	}// signup e
	
	// 2. 모든 회원 출력 [ 인수:X 반환:여러명[ArrayList vs 배열]회원[Member]]
	public ArrayList<MemberDto> list() {	
		//* 여러명의 회원 dto 객체를 저장하기 위한 리스트 선언
		ArrayList<MemberDto> list = new ArrayList<>();
		// 1. SQL 작성
		String sql = "select *from member";
		// 2. 연결된 DB에 작성된 SQL 대입
		try {
			ps = conn.prepareStatement(sql);
			// 3. SQL 조작	[매개변수 없으면 생략]
			// 4. SQL 실행	[SQL 결과를 rs 인터페이스에 저장]
			rs = ps.executeQuery();	//결과 : 검색된 모든 레코드
			// 5. SQL 결과
				//레코드 --자바형태--> 객체 - DTO	// 레코드 1개 -> DTO 1개 -> 회원 1개
			while( rs.next() ) {	//rs.next() 다음 레코드 이동 [ 없으면 false ] // 마지막 레코드까지 무한루프
				//레코드 ---> 객체화 [ rs.get~~(필드순서번호)]
				MemberDto dto = new MemberDto(
						rs.getInt(1), rs.getString(2), rs.getString(3));
				//1개 객체를 list에 담기
				list.add(dto);
			}
			return list;
		}catch (Exception e) {
			System.out.println("DB 오류 : "+e.getMessage());
		}
		return null;
	}//list e
	
	// 3. 비밀번호 수정 [ 인수 : 누구의(mno),비밀번호를 무엇으로(newpw) / 반환 : 성공/실패 ]
	public boolean updatepw(int mno,String newpw) {
		
		// 1. SQL 작성
		String sql = "update member set mpw = ? where mno = ?";
		
		// 2. 연결 DB에 SQL 대입
		try {
			ps = conn.prepareStatement(sql);
		
			// 3. SQL 조작
			ps.setString(1, newpw);
			ps.setInt(2, mno);
			// 4. SQL 실행
			ps.executeUpdate();	//insert , update, delete -> executeUpdate();	/ 결과 1개
								// select -> executeQuery();					/ 결과 여러개
			
			// 5. SQL 결과
			return true;
		}catch (Exception e) {
			System.out.println("DB 오류 : "+e.getMessage());
			return false;
		}
	} // updatepw e
	
	// 4. 삭제 함수 [ 인수 : 어떤 회원을 삭제할건지(mno) 반환 : 성공/실패]
	public boolean delete(int mno) {
		
		// 1. SQL 작성
		String sql = "delete from member where mno = ?;";
		
		// 2. 연결 DB에 SQL 대입
		try {
			ps = conn.prepareStatement(sql);
			// 3. SQL 조작
			ps.setInt(1, mno);
			// 4. SQL 실행
			ps.executeUpdate();	
			// 5. SQL 결과
			return true;
		}catch (Exception e) {
			System.out.println("DB 오류 : "+e.getMessage());
			return false;
		}
	} // delete e
	
	
	
	
} // class e























