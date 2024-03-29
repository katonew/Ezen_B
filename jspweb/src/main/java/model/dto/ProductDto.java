package model.dto;

import java.util.List;

public class ProductDto {
	
	private int pno;		// 제품번호
	private String pname ;		// 제품명
	private String pcomment;	// 제품설명
	private int pprice ;		// 제품가격
	private int pstate ;		// 상태 [ 1 : 판매중, 2 : 예약중, 3 : 판매완료 ]
	private String plat ;		// 위도
	private String plng ;		// 경도
	private int  pview ;		// 조회수
	private String pdate ;		// 등록일
	// 추가 필드
	private int mno;					// 등록한 회원 번호
	private String mid; 				// 등록한 회원 아이디
	private String mimg;				// 등록한 회원 프로필 이미지
	private List<String> pimgList;		// 등록한 사진 목록들

	public ProductDto() {
		// TODO Auto-generated constructor stub
	}

	public ProductDto(int pno, String pname, String pcomment, int pprice, int pstate, String plat, String plng,
			int pview, String pdate, int mno, String mid, String mimg, List<String> pimgList) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.pcomment = pcomment;
		this.pprice = pprice;
		this.pstate = pstate;
		this.plat = plat;
		this.plng = plng;
		this.pview = pview;
		this.pdate = pdate;
		this.mno = mno;
		this.mid = mid;
		this.mimg = mimg;
		this.pimgList = pimgList;
	}
	
	// 등록용 생성자 [ 상품이름, 상품설명, 가격, 위도, 경도, 등록한 사람번호, 등록한 사진이름목록 ]
	public ProductDto(String pname, String pcomment, int pprice, String plat, String plng, int mno,
			List<String> pimgList) {
		super();
		this.pname = pname;
		this.pcomment = pcomment;
		this.pprice = pprice;
		this.plat = plat;
		this.plng = plng;
		this.mno = mno;
		this.pimgList = pimgList;
	}
	
	
	
	
	

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPcomment() {
		return pcomment;
	}

	public void setPcomment(String pcomment) {
		this.pcomment = pcomment;
	}

	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}

	public int getPstate() {
		return pstate;
	}

	public void setPstate(int pstate) {
		this.pstate = pstate;
	}

	public String getPlat() {
		return plat;
	}

	public void setPlat(String plat) {
		this.plat = plat;
	}

	public String getPlng() {
		return plng;
	}

	public void setPlng(String plng) {
		this.plng = plng;
	}

	public int getPview() {
		return pview;
	}

	public void setPview(int pview) {
		this.pview = pview;
	}

	public String getPdate() {
		return pdate;
	}

	public void setPdate(String pdate) {
		this.pdate = pdate;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMimg() {
		return mimg;
	}

	public void setMimg(String mimg) {
		this.mimg = mimg;
	}

	public List<String> getPimgList() {
		return pimgList;
	}

	public void setPimgList(List<String> pimgList) {
		this.pimgList = pimgList;
	}

	@Override
	public String toString() {
		return "ProductDto [pno=" + pno + ", pname=" + pname + ", pcomment=" + pcomment + ", pprice=" + pprice
				+ ", pstate=" + pstate + ", plat=" + plat + ", plng=" + plng + ", pview=" + pview + ", pdate=" + pdate
				+ ", mno=" + mno + ", mid=" + mid + ", mimg=" + mimg + ", pimgList=" + pimgList + "]";
	}
	
	

	
	

}
