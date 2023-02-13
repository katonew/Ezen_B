package Day09.Ex10_게시판.controller;

import java.util.ArrayList;
import java.util.Date;

import Day09.Ex10_게시판.model.Board;


public class Bcontroller {
	private ArrayList<Board> BoardDb= new ArrayList<>();
			
	// 1. 싱글톤 객체
	private static Bcontroller bc = new Bcontroller();
	private  Bcontroller() {}
	
	
	public static Bcontroller getInstance() {
		return bc;
	}
	
	//2. 쓰기 함수
	public boolean write(String title, String content, String writer, String password, Date date,int view) {
		//1. 유효성 검사 [생략]
		//2. 저장[DB대신 리스트]
			//1.객체화[	]
		Board board = new Board(title,content,writer,password,date,view);
			//2. 객체를 리스트 담기
		BoardDb.add(board);
		//3. 결과 반환
		return false;
	}
}
