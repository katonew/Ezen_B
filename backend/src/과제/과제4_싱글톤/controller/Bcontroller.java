package 과제.과제4_싱글톤.controller;


import java.util.ArrayList;
import 과제.과제4_싱글톤.model.Board;


/*

컨트롤(이벤트) 설계
	5. 글쓰기 처리
		인수 : title, content, 				반환 : true 성공/ false 실패
	6. 글 출력 데이터 반환
		인수 : X[페이징처리,검색처리]				반환 : 모든글이 담긴  ArrayList
	7. 글 상세 데이터 반환
		인수 : 글번호							반환 : 글 하나 board
		조회수 증가
	8. 글 삭제 처리
		인수 : 글번호							반환 : true 성공 / false 실패
	9. 글 수정 처리
		인수 : 글번호,새로운제목,새로운내용			반환 : true 성공 / false 실패
	

*/



public class Bcontroller {
	// 싱글톤
	private static Bcontroller bc = new Bcontroller();
	private Bcontroller() {}
	public static Bcontroller getInstance() {return bc;}
	
	// 필드
	private ArrayList<Board> boardDb = new ArrayList<>();
	
	public ArrayList<Board> getBoardDb() {
		return boardDb;
	}

	//5. 글쓰기 처리
	public boolean write(String title, String content) {
		// 1. 유효성 검사.[로그인이 안되어 있으면 false]
		if(Mcontroller.getInstance().getLoginSession()==null) {
			return false;
		}
		// 2. DB저장
			// 1.객체화 [ 글작성 : 입력받은 데이터 2개, 초기값 0, 로그인한 회원객체=글쓴이]
		Board board = new Board(title, content, 0, Mcontroller.getInstance().getLoginSession());
			// 2. 멤버객체에 내가 쓴글 등록
		Mcontroller.getInstance().getLoginSession().getBoardlist().add(board);
			// 3. DB에 저장
		boardDb.add(board);
		return true;
	}
	
	//6. 글출력 처리
	public ArrayList<Board> getList() {
		// 추후에 검색처리, 페이징 처리 등등 로직이 들어갈 예정
		return boardDb;
	}
	
	//7. 글상세
	public Board getBoard(int bno) {
		boardDb.get(bno).setView(boardDb.get(bno).getView()+1);
		return boardDb.get(bno);		//인수로 전달받은 인덱스의 게시물 반환
	}
	
	//8. 글 삭제
	public boolean delete(int bno) {
		boardDb.remove(bno);	//인수로 전달받은 인덱스의 게시물 삭제
		return true;
	}
	
	//8. 글 수정
	public boolean update(int bno,String title,String content) {
		boardDb.get(bno).setTitle(title);		//인수로 전달받은 인덱스의 게시물 제목 수정
		boardDb.get(bno).setContent(content);	//인수로 전달받은 인덱스의 게시물 내용 수정
		return true;
	}
	

}
