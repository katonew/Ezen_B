package Day09.Ex7_p252;

/*
	final 필드 : 최종적 뜻
		- 수정 불가 만들기
		- 무조건 초기화가 있어야 한다.
		- 필드에 직접 초기화 or 생성자를 이용한 초기화
	static final 필드 : 상수	
		- 수정 불가능, 공유 메모리
		- 상수 이름 : 관례적으로 대문자 사용
*/

public class Korean {

	// 1. final	: 수정불가 [메모리 공유 X]
	final String nation = "대한민국";
	final String ssn;	//final 무조건 초기화 존재해야 함
	
	String name;
	
	public Korean(String ssn, String name) {
		this.ssn = ssn;
		this.name = name;
	}
	
	// 2. static final : 수정불가 [메모리 공유 X]
	static final double EARTH_RADIUS = 6400;
	static final double EARTH_SURFACE_AREA;
	static {
		EARTH_SURFACE_AREA = 4 * Math.PI * EARTH_RADIUS * EARTH_RADIUS;
	}
	
} //class e
