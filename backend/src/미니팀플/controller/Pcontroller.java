package 미니팀플.controller;

import java.util.ArrayList;

import 미니팀플.model.Product;

/*
 
 	- 상품 출력
		인수: X							반환 : 모든 제품이 담긴 ArrayList
	- 상품 등록
		인수: title,content,price		반환 : true / false
	- 상품 개별보기
		인수: 해당상품인덱스번호				반환 : product 한개
		
*/





public class Pcontroller {
	
	//* 싱글톤
	private static Pcontroller pc = new Pcontroller();
	private Pcontroller() {}
	public static Pcontroller getInstance() {return pc;}
	
	//DB 대신할 상품리스트
	ArrayList<Product> productDb = new ArrayList<>();
	
	//상품 출력함수
	public ArrayList<Product> printProduct() {
		// 모든 상품리스트 반환
		return productDb;
	}
	
	//상품 등록함수
	public boolean plusProduct(String title,String content,int price) {
		// 1. 유효성 검사 : 파일 합쳐지면 할것임
		// 2. DB에 저장
		Product product = new Product(title, content, price, null/*로그인중인 멤버 들어와야할 부분*/, true);
		productDb.add(product);
		return true;
	}
	
	//상품 개별보기 함수
	public Product getProduct(int pno) {
		return productDb.get(pno);
	}
		
}
