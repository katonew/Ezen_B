package practice.과제.과제1;

public class Pdto {

	// 1. 필드
	private int pno;
	private String partname;
	private String manager;
	
	
	
	// 2. 생성자
	public Pdto() {}
	
	public Pdto(int pno, String partname, String manager) {
		this.pno = pno;
		this.partname = partname;
		this.manager = manager;
	}
	
	
	// 3. 메소드
	
	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getPartname() {
		return partname;
	}

	public void setPartname(String partname) {
		this.partname = partname;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}
	
	
}
