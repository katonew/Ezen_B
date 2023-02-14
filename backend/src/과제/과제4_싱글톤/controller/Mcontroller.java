package 과제.과제4_싱글톤.controller;

import java.util.ArrayList;


import 과제.과제4_싱글톤.model.Member;
/*
컨트롤(이벤트) 설계
	1. 회원가입 처리
		인수 : id,pw,confirmpw,name,phone	반환 : 0: 성공 / 1: 실패
	2. 로그인 처리
		인수 : id,pw							반환 : i==회원번호 / -1:비밀번호 틀림 / -2: 아이디 없음
	3. 아이디 찾기 처리
		인수 : name, phone					반환 : 찾은아이디 or null
	4. 비밀번호 차기 처리
		인수 : id,phone						반환 : 찾은 비밀번호 or null
	10. 로그아웃 처리
		인수 : X								반환 : true 성공 / false 실패
*/



public class Mcontroller {
	
	// 싱글톤 : 다른곳에서 해당 객체를 공유 메모리[멤버=필드,메소드] 
		// 1. 본인 클래스로 본인 객체 만들기
	private static Mcontroller mc = new Mcontroller();
		// 2. 외부에서 생성자를 사용할 수 없도록 생성자에 private
	private Mcontroller() {}
		// 3. 객체는 외부로부터 차단하고 getInstance 함수를 통해 객체를 내보낸다.[유효성검사 위해]
	public static Mcontroller getInstance() {
		return mc;
	}
		// 4. 외부에서 getInstance 함수를 사용하려면 객체가 필요하지만 외부에서 객체 생성 불가능하기때문에 정적멤버 사용
	
	
	
	//DB대신 ArrayList
	private ArrayList<Member> memberDb = new ArrayList<>();
	//로그인 한 회원의 객체를 저장 [ * 동시접속시 문제점 발생!!]
		// 사용목적 : 페이지가 바뀌더라도 정보저장 [ *메소드가 종료 되더라도 정보는 저장]
	private Member loginSession = null;
	
	public Member getLoginSession() {
		return loginSession;
	}
	
	//1.회원가입 처리
	public int signup(String id,String pw,String confirmpw,String name,String phone) {
		// 1. 유효성 검사
		if(!pw.equals(confirmpw)) {return 1;}
		// 2. DB에 저장
			// 1. 객체화 [ 입력받은 데이터 4개와 회원마다 글을 저장할 리스트 메모리 초기화]
		Member m = new Member(id,pw,name,phone,new ArrayList<>());
			// id, pw, name, phone : 스택 영역에 저장된 힙주소 전달
			// new ArrayList<>() : 힙영역에 생성된 힙주소 전달
			// 2. 리스트에 저장
		memberDb.add(m);
		return 0;
	}//sign up e
	
	//2.로그인 처리
	public int login(String id,String pw) {
		for(int i=0;i<memberDb.size();i++) {
			if(memberDb.get(i).getId().equals(id)) { // i번째 인덱스의 아이디와 입력받은 아이디가 같으면
				if(memberDb.get(i).getPw().equals(pw)) {
					//비밀번호도 일치하면 로그인 성공 [!로그인했다는 식별]
					loginSession = memberDb.get(i);	//로그인 성공한 회원 객체를 필드에 저장
					return i;
				}else {
					return -1;
				}
			}
		}
		return -2;
	}//login e
	
	//3. 아이디 찾기 처리
	public String findid(String name,String phone) {
		for(Member m : memberDb) {	//* memberDb 여러개의 member객체가 들어있고 하나씩 member 객체를 꺼내기 반복
			if(m.getName().equals(name) && m.getPhone().equals(phone)) {
					return m.getId();	//위 조건이 일치할 경우 찾은 아이디 반환
			}
		}
		
		return null;
	}//findid e
	
	//4. 비밀번호 찾기 처리
	public String findpw(String id,String phone) {
		for(Member m : memberDb) {
			if(m.getId().equals(id) && m.getPhone().equals(phone)) {
					return m.getPw(); //위 조건이 일치할 경우 찾은 비밀번호 반환
			}
		}
		return null;
	}//findpw e
	
	//5.로그아웃 처리
	public boolean logOut() {
		loginSession = null;	//필드에 저장된 로그인 성공한 회원객체를 지우기 [ null 대입하면 GC가 메모리를 자동제거]
		return true;
	}//logOut e
	
}



































