package controller.board;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardDto {

	private int bno;
	private String btitle;
	private String bcontent;
	private String bfile;
	private String bdate;
	private int bview;
	private int bup;
	private int bdown;
	private int mno;
	private int cno;
	
	// 추가 -- > 작성자 ID , 카테고리 이름, 작성자 이미지
	private String mid;	// 작성자 아이디
	private String mimg; // 작성자 프로필
	private int rcount; // 댓글개수
	
    
	// 1. 빈생성자 : 사용할 용도 거의 없음
    public BoardDto() {}
    
    // 2. 풀 생성자(mid 제외) : 객체만들때 [DAO에서 주로 사용]
    public BoardDto(int bno, String btitle, String bcontent, String bfile, String bdate, int bview, int bup, int bdown,
			int mno, int cno) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.bdate = bdate;
		this.bview = bview;
		this.bup = bup;
		this.bdown = bdown;
		this.mno = mno;
		this.cno = cno;
	}

    // 3. 등록용 생성자
    public BoardDto(String btitle, String bcontent, String bfile, int mno, int cno) {
		super();
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.mno = mno;
		this.cno = cno;
	}
    
    // 4. 출력용 생성자
    public BoardDto(int bno, String btitle, String bcontent, String bfile, String bdate, int bview, int bup, int bdown,
			int mno, int cno, String mid) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		// 오늘 날짜와 작성일이 동일하면 시간표기 아니면 날짜만 표기
			// 1. 오늘 날짜
		Date date = new Date();
		// 현재의 날짜를 SQL과 같은 포맷으로 설정
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String now = sdf.format(date);
			// 2. 만약 오늘 날짜와 작성일이 동일하면
			// now.split(" ")[0] : 오늘 날짜 , now.split(" ")[1] : 현재 시간
		if(now.split(" ")[0].equals(bdate.split(" ")[0])) {
			this.bdate = bdate.split(" ")[1];
		}else { // 오늘 날짜와 작성일이 동일하지 않으면 날짜
			this.bdate = bdate.substring(5, 11);
		}
		this.bview = bview;
		this.bup = bup;
		this.bdown = bdown;
		this.mno = mno;
		this.cno = cno;
		this.mid = mid;
	}
    
    // 5. 수정용 생성자
    public BoardDto(int bno, String btitle, String bcontent, String bfile, int cno) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.cno = cno;
	}
    
    // getter & setter
    public int getRcount() {
		return rcount;
	}

	public void setRcount(int rcount) {
		this.rcount = rcount;
	}
	
	public String getMimg() {
		return mimg;
	}


	public void setMimg(String mimg) {
		this.mimg = mimg;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public String getBfile() {
		return bfile;
	}

	public void setBfile(String bfile) {
		this.bfile = bfile;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public int getBview() {
		return bview;
	}

	public void setBview(int bview) {
		this.bview = bview;
	}

	public int getBup() {
		return bup;
	}

	public void setBup(int bup) {
		this.bup = bup;
	}

	public int getBdown() {
		return bdown;
	}

	public void setBdown(int bdown) {
		this.bdown = bdown;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	@Override
	public String toString() {
		return "BoardDto [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bfile=" + bfile
				+ ", bdate=" + bdate + ", bview=" + bview + ", bup=" + bup + ", bdown=" + bdown + ", mno=" + mno
				+ ", cno=" + cno + ", mid=" + mid + ", mimg=" + mimg + "]";
	}
    
    
    
    
}
