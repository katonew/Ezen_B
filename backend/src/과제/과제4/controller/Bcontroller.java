package 과제.과제4.controller;

import java.util.ArrayList;

import 과제.과제4.model.Board;

public class Bcontroller {
	ArrayList<Board> boradDb = new ArrayList<>();
	
	//게시판 출력함수
	public String printBoard(){
		String temp = "--------------------커뮤니티---------------------\n번호\t조회수\t작성자\t내용\n";
		for(int i=0;i<boradDb.size();i++) {
			temp += i+"\t"+boradDb.get(i).views+"\t"+boradDb.get(i).writer+"\t"+boradDb.get(i).content+"\n";
		}
		return temp;
	} // 게시판 출력함수 e
	
	//글 쓰기 함수
	public void writeBorad(String loginid, String title, String content) {
		Board board = new Board(0,loginid,content);
		boradDb.add(board);
	}//글 쓰기 함수 e
	
	//글 보기 함수
	public Board viewBoard(String loginid, int selectno) {
		return boradDb.get(selectno);
	}//글 보기 함수 e
	
	
	
	
} // class e
