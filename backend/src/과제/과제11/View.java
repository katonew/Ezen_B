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
		try {
			System.out.print("1.관리자 2.사용자 : ");
			int ch = sc.nextInt();
			if(ch==1) {admin();}
			else if(ch==2) {consumer();}
		}catch (InputMismatchException e) {
			System.out.println("잘못 입력하였습니다.");
		}catch (Exception e) {
			System.out.println("시스템 오류 : "+ e);
		}
		
	}//index e
	
	// 관리자 페이지
	public void admin() {
		while(true) {
			System.out.println("----------관리자 시작------------");
			try {
				System.out.print("1.등록 2.출력 3.제품수정 4.재고수정 5.삭제 : ");
				int ch = sc.nextInt();
				if(ch==1) {add();}
				else if(ch==2) {adminPrint();}
				else if(ch==3) {pupdate();}
				else if(ch==4) {iupdate();}
				else if(ch==5) {delete();}
			}catch (InputMismatchException e) {
				System.out.println("잘못 입력하였습니다.");
			}catch (Exception e) {
				System.out.println("시스템 오류 : "+e);
			}
		} // while e
	}
	
	// 사용자 페이지
	public void consumer() {
		System.out.println("----------사용자 시작------------");
		while(true) {
			consumerPrint();
			try {
				System.out.print("0:결제 N:장바구니에 담을 제품번호선택 : ");
				int ch = sc.nextInt();
				if(ch==0) {payment();}
				else if(ch>0) {choice(ch);}
				else {System.out.println("잘못 입력하였습니다.");}
			}catch (InputMismatchException e) {
				System.out.println("잘못 입력하였습니다.");
			}catch (Exception e) {
				System.out.println("시스템 오류" + e);
			}
		} // while e
	}
	
	
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
	
	// 관리자용 제품 출력 페이지
	public void adminPrint() {
		ArrayList<ProductDto> result =  Controller.getInstance().Print();
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
	
	// 사용자용 제품 출력 페이지
		public void consumerPrint() {
			ArrayList<ProductDto> result =  Controller.getInstance().Print();
			System.out.println("------------제품 현황------------");
			System.out.println("제품번호\t제품이름\t제품가격\t제품판매상태");
			for(int i=0;i<result.size();i++) {
				System.out.printf("%d\t%s\t%d\t",
									result.get(i).getPno(),
									result.get(i).getPname(),
									result.get(i).getPprice() );
				System.out.println(result.get(i).getPinven()==0?"구매불가":"구매가능" );
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
	
	
	//결제 페이지
	public void payment() {
		ArrayList<ProductDto> result =  Controller.getInstance().Print();
		ArrayList<ProductDto> result2 =  Controller.getInstance().payment();
		System.out.println("-------------결제-----------");
		System.out.println("제품이름\t구매수량\t구매금액");
		for(int i=0;i<result.size();i++) {
			int temp=0;
			for(int j=0;j<result2.size();j++) {
				if(result.get(i).getPno()==result2.get(j).getPno()) {
					temp++;
				}
			}
			if(temp!=0) {
				System.out.println(result.get(i).getPname()+"\t"+temp+"\t"+(temp*result.get(i).getPprice()));
			}
		}
		System.out.println("--------결제되었습니다--------");
		Controller.getInstance().clean();
		
	}
	
	//상품선택 페이지
	public void choice(int pno) {
		Controller.getInstance().choice(pno);
		//장바구니 초기화
	}
	

}//class e
