package Day06;

public class Ex2_문자열 {	//class s
	public static void main(String[] args) { //main s
		
		//1. 자바 문자열을 사용하는 바업
			//1. 배열
		char[] 문자열1 = new char[]{'안','녕'};
			//2. 클래스 [객체]
		String 문자열2 = new String("안녕");
			//3. 문자 리터럴 " "
		String 문자열3 = "안녕";
		
		//2. [156p]
		String strVar1 = "홍길동";	//10번지
		String strVar2 = "홍길동";	//10번지
		
			//1. 주소 비교
		if(strVar1==strVar2) {
			//만약에 두 주소가 같으면
			System.out.println("참조[주소] 같음");
		}else {System.out.println("참조[주소] 다름");}
		
			//2. 주소 안에 있는 데이터 비교
		if(strVar1.equals(strVar2)) {
			//만약에 두 변수가 가지고 있는 주소의 데이터가 같으면
			System.out.println("참조[주소] 내부도 같다");
		}else {System.out.println("참조[주소] 내부는 다르다");}
		
		String strVar3 = new String("홍길동");	//20번지
		String strVar4 = new String("홍길동");	//30번지
		
		if(strVar3==strVar4) {
			//만약에 두 주소가 같으면
			System.out.println("참조[주소] 같음");
		}else {System.out.println("참조[주소] 다름");}
		
		if(strVar4.equals(strVar4)) {
			//만약에 두 변수가 가지고 있는 주소의 데이터가 같으면
			System.out.println("참조[주소] 내부는 같다");
		}else {System.out.println("참조[주소] 내부도 다르다");}
		
		// 157p
		String hobby = "";	// "" vs null
		if(hobby.equals("")) {System.out.println("\"\"의 객체");}
		
		String hobby2 = null;	
		//if(hobby2.equals(null)) {System.out.println("null의 객체의 데이터 확인");}
		if(hobby2==null) {System.out.println("null 주소확인");}
		
		//문자열 api함수
		//1. .charAt(인덱스);
		String ssn = "9506241230123";
		char sex = ssn.charAt(6);	System.out.println(sex);
		if(sex=='1'||sex=='3'){
			System.out.println("남자");
		}else{System.out.println("여자");}
		
		//2. .length()
		int length = ssn.length();	//길이:13 , 인덱스 : 0 ~ 12
		if(length==13) {
			System.out.println("주민등록번호 자릿수 맞음");
		}else {System.out.println("주민등록번호 자릿수 다름");}
		
		//3. .replace("기존문자","새로운문자");
		String oldStr = "자바 문자열 불변입니다. 자바 문자열은 String입니다";
		String newStr = oldStr.replace("자바", "JAVA");
		
		System.out.println(oldStr);
		System.out.println(newStr);
		
		// 4. .subString(인덱스); vs .split("자를기준");
		String ssn2 = "880815-1234567";
		System.out.println(ssn2.substring(7));		//ssn의 7번째 인덱스 앞까지 자름
		System.out.println(ssn2.substring(0,6));	//ssn의 0부터 6인덱스 전까지 출력 후 나머지는 자름
		
		System.out.println(ssn2.split("-"));  			// "-" 자르면 2조각/인덱스
		System.out.println(ssn2.split("-")[0]);  		// "-" 자른 후 1번 조각 확인
		System.out.println(ssn2.split("-")[1]);  		// "-" 자른 후 2번 조각 확인
		
		String board = "1, 자바, 학습, 참조 타입 String을 학습합니다. , 홍길동";
		String[] tokens = board.split(",");	// ,기준으로 분리했을때 4조각/인덱스 4개===>배열로 반환
		System.out.println("번호 : "+ tokens[0]);
		System.out.println("제목 : "+ tokens[1]);
		System.out.println("내용 : "+ tokens[2]);
		System.out.println("성명 : "+ tokens[3]);
				
		//5. .indexOf("찾을문자"); vs .contains("찾을문자");
		String subject = "자바 프로그래밍"; //띄어쓰기도 문자
		System.out.println(subject.indexOf("자바"));			//찾으면 0 ~ 인덱스
		System.out.println(subject.indexOf("파이썬"));		//없으면 -1
		
		System.out.println(subject.contains("자바"));		//있으면 true
		System.out.println(subject.contains("파이썬"));		//없으면 false
		
		
	} //main e
} //class e


/*
  
 	' ' : 	문자 	char 	기본타입
 	" " : 	문자열 	String 	참조타입
	
	
	자바 문자열 사용하는 방법
		1. 배열, 클래스, 문자리터럴
		2. 클래스
			String 문자열3 = new Stirng("안녕"); //10번지
			String 문자열4 = new Stirng("안녕"); //20번지
			문자열3 == 문자열4 	===> false
			문자열.equals(문자열4)	===> true
			- new 연산자 [객체 메모리 주소 생성]
		3. 문자리터럴
			String 문자열3 = "안녕"; //10번지
			String 문자열4 = "안녕"; //10번지
			문자열3 == 문자열4 	===> true
			문자열.equals(문자열4)	===> true
			- 문자리터럴이 동일한 경우 -> 객체 공유 [ 주소 같다 == ]
			 
	자바 문자열의 함수들
		1. 	.charAt(인덱스);						: 인데스 위치의 문자 1개 추출
		2. 	.length();							: 문자열의 길이
		3. 	.replace("기존문자","새로운문자");		: 기존 문자를 새로운 문자로 치환
		4. 	.subString(인덱스);					: 0~인덱스까지 자르기 
		4-1	.subString(시작인덱스,끝인덱스);			: 시작 인덱스부터 마지막 인덱스까지 자르기
		5.	.split("자를기준");					: 기준 문자 기준으로 자르기
		6. 	.indexOf("찾을문자");					: 찾을 문자의 찾은 인덱스 번호 반환
		7.	.contains("찾을문자");				: 찾을 문자가 존재하면 true/ 없으면 false
		8. 	.getBytes()							: 
		

*/
























