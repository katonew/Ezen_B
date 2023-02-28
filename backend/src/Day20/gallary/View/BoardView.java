package Day20.gallary.View;

import java.util.ArrayList;
import java.util.Scanner;

import Day20.gallary.Contoller.Bcontroller;
import Day20.gallary.Contoller.Mcontroller;
import Day20.gallary.Model.Dto.BoardDto;
import Day20.gallary.Model.Dto.CategoryDto;

public class BoardView {

	//1. 싱글톤
	private static BoardView view = new BoardView();
	private BoardView() {}
	public static BoardView getInstance() {return view;}
	
	private Scanner scanner = new Scanner(System.in);
	
			
	// 1. 게시판의 모든 게시글 출력
	public void index() {
		while(true) {
			System.out.println("========게시판======");
			// 최근 게시물 3개 출력
			boardPrintRecent();
			categoryPrint(); // 모든 갤러리 출력
			System.out.print("-1:로그아웃 / 0:갤러리 추가 / 이동할 갤러리 번호 선택 : ");
			int ch = scanner.nextInt();
			if (ch==-1) {
				Mcontroller.getInstance().setLoginSession(0);
				System.out.println("로그아웃 되었습니다.");
				break;
			}
			else if(ch==0) {categoryAdd();}
			else if (ch>0) {boardPrint(ch);}
		} // while e
	} // index e
	
	
	// 2. 갤러리 추가
	public void categoryAdd() {
		System.out.println("========갤러리 추가======");
		System.out.print("추가할 갤러리 이름 : ");
		scanner.nextLine();
		String cname = scanner.nextLine();
		
		boolean result = Bcontroller.getInstance().categoryAdd(cname);
		if(result) {
			System.out.println("등록완료 : 갤러리가 추가되었습니다.");
		}else {System.out.println("등록실패 : 관리자에게 문의하세요.");}
	}
	
	
	// 3. 모든 갤러리 호출
	public void categoryPrint() {
		// 모든 카테고리 요청 후 리스트에 담기
		ArrayList<CategoryDto> clist = Bcontroller.getInstance().categoryPrint();
		/*
		// 2. 출력1
		for(int i =0; i<clist.size();i++) {
			System.out.println(clist.get(i).getCno()+"-"+clist.get(i).getCname());
		}
		*/
		
		// 3. 출력2
		System.out.println("번호\t갤러리명");
		for(CategoryDto dto : clist) {
			System.out.println(dto.getCno() + "\t"+dto.getCname());
		}
	}
	
	// 4. 게시글 추가
	public void boardAdd(int cno) {
		System.out.println("게시물 쓰기");
		System.out.print("제목 : "); 	String btitle = scanner.next();
		System.out.print("내용 : ");	String bcontent = scanner.next();
		boolean result = Bcontroller.getInstance().boardAdd(btitle, bcontent,cno);
		if(result) {System.out.println("게시글 등록 성공");}
		else {System.out.println("게시글 등록 실패");}
	}
	
	// 5. 최신 글 3개 출력
	public void boardPrintRecent() {
		ArrayList<BoardDto> blist = Bcontroller.getInstance().boardPrintRecent();
		System.out.println("=====최신글 목록======");
		System.out.printf("%10s\t%10s\t%10s\t%10s\t%10s\t%10s", "번호","제목","작성자","조회수","갤러리","작성일");
		for(BoardDto dto : blist) {
			System.out.printf("%10s\t$10s\t$10s\t$10s\t$10s\t%10s", 
					dto.getBno(),dto.getBtitle(),dto.getMid(),dto.getBview(),dto.getCname(),dto.getBdate());
		}
	}
	
	// 6. 선택한 갤러리의 모든 게시글 출력
	public void boardPrint(int cno) {
		ArrayList<BoardDto> blist = Bcontroller.getInstance().boardPrint(cno);
		for(BoardDto dto : blist) {
			System.out.printf("%10s\t%10s\t%10s\t%10s\t%10s", "번호","제목","작성자","작성일","조회수","갤러리");
			System.out.printf("%10s\t%10s\t%10s\t%10s\t%10s", 
					dto.getBno(),dto.getBtitle(),dto.getMid(),dto.getBview(),dto.getBdate());
		} // for e
		while(true) {
			System.out.println("-----갤러리 메뉴------");
			System.out.println("1. 뒤로가기 2.게시물쓰기 3.게시물보기 : ");
			int ch = scanner.nextInt();
			if(ch==1) {break;}
			else if(ch==2){boardAdd(cno);}
			else if(ch==3){}	// 미구현
		}
	}
	
	
	
} // class e



















