package 과제.과제11;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class View {
	
	//싱글톤
	private static View view = new View();
	private View() {}
	public static View getInstance() {return view;}
	
	Scanner sc = new Scanner(System.in);
	
	public void index() {
		
		while(true) {
			System.out.println("----------시작------------");
			try {
				System.out.print("1.등록 2.출력 3.제품수정 4.재고수정 5.삭제 : ");
				int ch = sc.nextInt();
				if(ch==1) {add();}
				else if(ch==2) {print();}
				else if(ch==3) {pupdate();}
				else if(ch==4) {iupdate();}
				else if(ch==5) {delete();}
			}catch (InputMismatchException e) {
				System.out.println("잘못 입력하였습니다.");
			}catch (Exception e) {
				System.out.println("시스템 오류");
			}
			
			
		} // while e
		
	}//index e
	
	// 제품 등록 페이지
	public void add() {
		System.out.print("제품 이름 : ");				String pname = sc.next();
		System.out.print("제품 가격 : ");				int pprice = sc.nextInt();
		System.out.print("제품 초기 재고 수량 : ");		int pinven = sc.nextInt();
		// 1. 컨트롤에게 입력받은 값을 전달해서 결과를 저장
		boolean result = Controller.getInstance().add(pname,pprice,pinven);
		if(result) {System.out.println("제품 등록 완료");
		}else {System.out.println("등록실패");}
	}
	
	// 제품 출력 페이지
	public void print() {
		ArrayList<ProductDto> result =  Controller.getInstance().print();
		System.out.println("------------제품 현황------------");
		System.out.println("제품번호\t제품이름\t제품가격\t제품재고수량");
		for(int i=0;i<result.size();i++) {
			System.out.printf("%d\t%s\t%d\t%d\n",
								result.get(i).getPno(),
								result.get(i).getPname(),
								result.get(i).getPprice(),
								result.get(i).getPinven() );
		}
	}
	
	// 제품 수정 페이지
	public void pupdate() {
		System.out.print("수정될 제품번호 : ");	int pno = sc.nextInt();
		System.out.print("수정할 제품이름 : ");	String pname = sc.next();
		System.out.print("수정할 제품가격 : ");  int pprice = sc.nextInt();
		// 1. 컨트롤에게 입력받은 값을 전달해서 결과를 저장
		boolean result = Controller.getInstance().pupdate(pno,pname,pprice);
		if(result) {System.out.println("수정 성공");}
		else {System.out.println("수정 실패");}
		
	}
	
	// 재고 수정 페이지
	public void iupdate() {
		System.out.print("수정될 제품번호 : ");	int pno = sc.nextInt();
		System.out.print("수정할 재고수량 : ");  int pprice = sc.nextInt();
		// 1. 컨트롤에게 입력받은 값을 전달해서 결과를 저장
		boolean result = Controller.getInstance().iupdate(pno, pprice);
		if(result) {System.out.println("수정 성공");}
		else {System.out.println("수정 실패");}
	}
	
	// 삭제 페이지
	public void delete() {
		System.out.print("삭제될 제품번호 : ");	int pno = sc.nextInt();
		// 1. 컨트롤에게 입력받은 값을 전달해서 결과를 저장
		boolean result = Controller.getInstance().delete(pno);
		if(result) {System.out.println("삭제 성공");}
		else {System.out.println("삭제 실패");}
	}
	

}//class e
