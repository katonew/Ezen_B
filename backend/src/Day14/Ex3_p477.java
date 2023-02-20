package Day14;

public class Ex3_p477 {
	
	//1.
	public static void findClass() throws Exception{
		Class.forName("java.lang.String2"); // 일반 예외
	}
	
	
	public static void main(String[] args) throws Exception{
		try {findClass();}
		catch(Exception e) {e.printStackTrace();}
		System.out.println("종료확인");
	}//main e
} // class e



/*
	예외 떠넘기기
		- 메소드 내부에서 예외발생했을때 메소드 호출했던 곳으로 예외를 떠넘기기
		- throws
		- 메소드 마다 예외처리를 하면 코드가 많아진다. - > 이동 후 한곳에서 처리

*/



