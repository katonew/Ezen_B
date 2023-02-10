package 과제.과제4.controller;

import java.util.ArrayList;
import 과제.과제4.model.Member;

// * 처리 제어 담당
public class Mcontroller {
	//* DB를 대신할 [데이터 저장소 리스트]
	ArrayList<Member> memberDb = new ArrayList<>();
	
	
	// 1. 회원가입 로직
	public int signup(String id, String pwd, String confirmpwd, String name, String phone) {
		// 1. 유효성 검사
		if(!pwd.equals(confirmpwd)){return 1;}	//회원가입 실패 : 1
		// 2. 객체 만들기
		Member member = new Member(id,pwd,name,phone);
		// 3. DB처리
		memberDb.add(member);
		return 0;	//회원가입 성공 : 0
	}
	// 2. 로그인 로직
	public int login(String id, String pwd) {
		// 모든 회원들 중 동일한 아이디 비밀번호 찾기
		for(int i=0; i<memberDb.size();i++) {
			//만약에 i번째 회원의 아이디와 입력받은 아이디가 같으면
			if(memberDb.get(i).id.equals(id)) {
				//2. 만약에 i번째 회원의 비밀번호와 입력받은 비밀번호가 같으면
				if(memberDb.get(i).pwd.equals(pwd)) {
					return i;
				}else {return -1;} //비밀번호가 틀림
			} //if e
		} //for e
		return -2;	//아이디가 없음
	}
	
	// 3. 아이디 찾기 로직
	public String findId(String name, String phone) {
			for(int i=0; i<memberDb.size();i++) {
				if(memberDb.get(i).name.equals(name)) {
					if(memberDb.get(i).phone.equals(phone)) {
						return "찾은 아이디 : "+memberDb.get(i).id;
					}else {return "입력정보가 틀렸습니다.";}
				} //if e
			} //for e
			return "일치하는 정보가 없습니다.";
		}
	
	// 4. 비밀번호 찾기 로직
	public String findpwd(String id, String phone) {
		for(int i=0; i<memberDb.size();i++) {
			if(memberDb.get(i).id.equals(id)) {
				if(memberDb.get(i).phone.equals(phone)) {
					return "찾은 비밀번호 : " + memberDb.get(i).pwd;
				}else {return "입력정보가 틀렸습니다.";}
			} //if e
		} //for e
		return "일치하는 정보가 없습니다.";
	}
}
