package 과제.과제11;

import java.util.ArrayList;

public class Controller {
	//싱글톤
	private static Controller con = new Controller();
	private Controller() {}
	public static Controller getInstance() {return con;}
	
	ArrayList<ProductDto> basket = new ArrayList<>();
	
	//제품 등록 함수
	public boolean add(String pname,int pprice,int pinven) {
		ProductDto dto = new ProductDto(0, pname, pprice, pinven);
		return ProductDao.getInstance().add(dto);
	}
	// 관리자용 제품 출력 함수
	public ArrayList<ProductDto> Print() {
		return ProductDao.getInstance().Print();
	}
	
	// 제품 수정 함수
	public boolean pupdate(int pno,String pname,int pprice) {
		return ProductDao.getInstance().pupdate( pno, pname, pprice);
	}
	// 재고 수정 함수
	public boolean iupdate(int pno,int pprice) {
		return ProductDao.getInstance().iupdate(pno, pprice);
	}
	// 삭제 함수
	public boolean delete(int pno) {
		return ProductDao.getInstance().delete(pno);
	}	
	// 상품 장바구니에 담기 함수
	public void choice(int pno) {
		ProductDto result = ProductDao.getInstance().choice(pno);
		if(result==null) {System.out.println("재고가 없습니다.");}
		else{
			basket.add(result);
			System.out.println("장바구니에 담습니다.");
		}
	} //choice e
	
	// 결제 함수
	public ArrayList<ProductDto> payment() {
		//장바구니 출력을 위한 list 반환
		return basket;
	} // payment e
	
	//장바구니 초기화 함수
	public void clean() {
		basket.removeAll(basket);
	}
	
} // class e
