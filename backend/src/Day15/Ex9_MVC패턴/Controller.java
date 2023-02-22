package Day15.Ex9_MVC패턴;

import java.util.ArrayList;

public class Controller {

	// 싱글톤
	private static Controller con = new Controller();
	private Controller() {}
	public static Controller getInstance() {return con;}
	
	
	// 회원가입 메소드
	public boolean signup(String mid,String mpw) {
		// 1. 유효성 검사 생략
		// 2. 객체화 [ 이유 : 여러개 변수가 이동하면 로직이 길어짐 -> 여러개 변수를 하나의 객체로 ]
		MemberDto dto = new MemberDto(0, mid,mpw);
		// 3. 해당 객체를 DB에 저장 [ DAO 호출 ] 하고 실행결과 저장
		boolean result = MemberDao.getInstance().signup(dto);
		// 실행 결과 반환
		return result;
	}//signup e
	
	// 회원정보 출력 메소드
	public ArrayList<MemberDto> list() {
		// 1. 모든 회원을 호출하는 DAO 메소드 호출해서 결과 얻기
		return MemberDao.getInstance().list();
	}//list e
	
	// 비밀번호 수정 메소드
	public boolean updatepw(int mno,String newpw) {
		return MemberDao.getInstance().updatepw(mno, newpw);
	}
	
	// 삭제 메소드
		public boolean delete(int mno) {
			return MemberDao.getInstance().delete(mno);
		}
	
	
	
}
