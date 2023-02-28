package Day20.gallary.Contoller;

import Day20.gallary.Model.Dao.MemberDao;
import Day20.gallary.Model.Dto.MemberDto;

public class Mcontroller {
	//1. 싱글톤
	private static Mcontroller Mcon = new Mcontroller();
	private Mcontroller() {}
	public static Mcontroller getInstance() {return Mcon;}
	
	private int loginSession = 0;
	public int getLoginSession() {return loginSession;}
	public void setLoginSession(int loginSession) {this.loginSession = loginSession;}
	
	// 1. 회원가입 처리 [ 아이디 중복체크 ]
	public int signup(String mid, String mpw, String mname, String mphone) {
		// 1. 유효성 검사
			// 1. 아이디 중복체크
		if(MemberDao.getInstance().idcheck(mid)) {
			return 2;	// 중복된 아이디
		}
		// 2. 객체화
		MemberDto dto = new MemberDto(0, mid, mpw, mname, mphone);
		
		// 3. 회원가입 DB처리 후 결과 반환
		return MemberDao.getInstance().signup(dto);
	} // signup e
	
	// 2. 로그인 
	public boolean login(String mid,String mpw) {
		// 1. 유효성 검사
		// 2. 로그인 처리
		int result = MemberDao.getInstance().login(mid, mpw);
		
		// 3. 로그인 성공 증거 [ 로그인 저장소 ]
		if(result==0) {return false;}
		else {
			loginSession = result;
			return true;
		}
	}
}
