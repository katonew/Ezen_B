package 과제.과제4.controller;

import java.util.ArrayList;

import 과제.과제4.model.Board;

public class Bcontroller {
	ArrayList<Board> boardDb = new ArrayList<>();
	
	//게시판 출력함수
	public String printBoard(){
		String temp = "--------------------커뮤니티---------------------\n번호\t조회수\t작성자\t제목\t\n";
		for(int i=0;i<boardDb.size();i++) {
			temp += i+"\t"+boardDb.get(i).views+"\t"+boardDb.get(i).writer+"\t"+boardDb.get(i).title+"\n";
		}
		return temp;
	} // 게시판 출력함수 e
	
	//글 쓰기 함수
	public void writeBorad(String loginid, String title, String content) {
		Board board = new Board(0,loginid,title,content);
		boardDb.add(board);
	}//글 쓰기 함수 e
	
	//글 보기 함수
	public Board viewBoard(String loginid, int selectno) {
		return boardDb.get(selectno);
	}//글 보기 함수 e
	
	
	//글 삭제 함수
	public void boardDelte(int boardno) {
		boardDb.remove(boardno);
	}
	
	//글 수정 함수
	public void boardEdit(int boardno, String editContent) {
		boardDb.get(boardno).content = editContent;
	}
	
} // class e
