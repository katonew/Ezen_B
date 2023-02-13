package Day09.Ex4_p239;

public class 실행 {
	public static void main(String[] args) {
		
		Calculator myCalcu = new Calculator();
		
		double result1 = myCalcu.areaRectangle(10);
		double result2 = myCalcu.areaRectangle(10, 20);
		
		System.out.println("정사각형넓이 : "+result1);
		System.out.println("직사각형넓이 : "+result2);
		
	}	//main e
} //class e
