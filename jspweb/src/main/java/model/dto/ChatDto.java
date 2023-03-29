package model.dto;

public class ChatDto {
	
	private int nno;			// 고유번호
    private String ncontent;	// 채팅내용
    private String ndate ;		// 채팅 보낸 시간
    private int pno ;			// 제품번호
    private int frommno ;		// 채팅을 받는사람
    private int tomno ;			// 채팅을 보낸사람
    // 추가필드
    private String frommid;		// 보낸 사람의 아이디
    private String frommimg;		// 보낸 사람의 프로필이미지
    
    public ChatDto() {}


	public ChatDto(int nno, String ncontent, String ndate, int pno, int frommno, int tomno) {
		super();
		this.nno = nno;
		this.ncontent = ncontent;
		this.ndate = ndate;
		this.pno = pno;
		this.frommno = frommno;
		this.tomno = tomno;
	}

	public ChatDto(int nno, String ncontent, String ndate, int pno, int frommno, int tomno, String frommid,
			String frommimg) {
		super();
		this.nno = nno;
		this.ncontent = ncontent;
		this.ndate = ndate;
		this.pno = pno;
		this.frommno = frommno;
		this.tomno = tomno;
		this.frommid = frommid;
		this.frommimg = frommimg;
	}


	public String getFrommid() {
		return frommid;
	}


	public void setFrommid(String frommid) {
		this.frommid = frommid;
	}


	public String getFrommimg() {
		return frommimg;
	}


	public void setFrommimg(String frommimg) {
		this.frommimg = frommimg;
	}


	public int getNno() {
		return nno;
	}


	public void setNno(int nno) {
		this.nno = nno;
	}


	public String getNcontent() {
		return ncontent;
	}


	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}


	public String getNdate() {
		return ndate;
	}


	public void setNdate(String ndate) {
		this.ndate = ndate;
	}


	public int getPno() {
		return pno;
	}


	public void setPno(int pno) {
		this.pno = pno;
	}


	public int getFrommno() {
		return frommno;
	}


	public void setFrommno(int frommno) {
		this.frommno = frommno;
	}


	public int getTomno() {
		return tomno;
	}


	public void setTomno(int tomno) {
		this.tomno = tomno;
	}


	@Override
	public String toString() {
		return "ChatDto [nno=" + nno + ", ncontent=" + ncontent + ", ndate=" + ndate + ", pno=" + pno + ", frommno="
				+ frommno + ", tomno=" + tomno + "]";
	}
    
    

}
