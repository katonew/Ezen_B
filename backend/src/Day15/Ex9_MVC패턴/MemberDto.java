package Day15.Ex9_MVC패턴;

public class MemberDto {

	// 1. 필드	[ DB필드와 일치화]
	private int mno;
	private String mid;
	private String mpw;
	
	
	// 2. 생성자 [ 무조건 : 1. 빈생성자 2. 풀생성자 ]
	public MemberDto() {}
	
	public MemberDto(int mno, String mid, String mpw) {
		this.mno = mno;
		this.mid = mid;
		this.mpw = mpw;
	}
	

	// 3. 메소드	[ 무조건 : 1.get/set 2.toString() ]
	

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpw() {
		return mpw;
	}

	public void setMpw(String mpw) {
		this.mpw = mpw;
	}

	@Override
	public String toString() {
		return "BoardDto [mno=" + mno + ", mid=" + mid + ", mpw=" + mpw + "]";
	}
	
	
	
	
	
}
