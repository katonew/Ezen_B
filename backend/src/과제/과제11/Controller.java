package 과제.과제11;

import java.util.ArrayList;

public class Controller {
	//싱글톤
	private static Controller con = new Controller();
	private Controller() {}
	public static Controller getInstance() {return con;}
	
	
	//제품 등록 함수
	public boolean add(String pname,int pprice,int pinven) {
		ProductDto dto = new ProductDto(0, pname, pprice, pinven);
		return ProductDao.getInstance().add(dto);
	}
	// 제품 출력 함수
	public ArrayList<ProductDto> print() {
		return ProductDao.getInstance().print();
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
}
