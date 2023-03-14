package practice.과제.과제1;
/*
 create table part (
	pno int auto_increment primary key,				-- 부서번호
    partname varchar(20),							-- 부서명
    manager varchar(10)								-- 관리자
);

create table employee (
	no int auto_increment primary key,				-- 사원번호
    img longtext,									-- 사원이미지
    name varchar(10),								-- 사원이름
    jobgrade varchar(10),							-- 직급
    type varchar(10), 								-- 고용형태
    indate datetime default now(),					-- 입사일
    outdate datetime default null,					-- 퇴사일
    outreason varchar(1000) default null,			-- 퇴사사유
    pno int,										-- 부서번호
    foreign key ( pno ) references part ( pno ) on delete set null
);
 */


public class Mdto {
	

	// 1. 필드
	private int no;
	private String img;
	private String name;
	private String jobgrade;
	private String type;
	private String indate;
	private String outdate;
	private String outreason;
	private String part;
	private int pno;
	
	
	// 2. 생성자
	public Mdto() {}

	public Mdto(int no, String img, String name, String jobgrade, String type, String indate, String outdate, String outreason, String part , int pno) {
		this.no = no;
		this.img = img;
		this.name = name;
		this.jobgrade = jobgrade;
		this.type = type;
		this.indate = indate;
		this.outdate = outdate;
		this.outreason = outreason;
		this.part = part;
		this.pno = pno;
	}
	
	public Mdto(int no, String img, String name, String jobgrade, String type, String indate, String outdate, String outreason, int pno) {
		this.no = no;
		this.img = img;
		this.name = name;
		this.jobgrade = jobgrade;
		this.type = type;
		this.indate = indate;
		this.outdate = outdate;
		this.outreason = outreason;
		this.pno = pno;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJobgrade() {
		return jobgrade;
	}

	public void setJobgrade(String jobgrade) {
		this.jobgrade = jobgrade;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	public String getOutdate() {
		return outdate;
	}

	public void setOutdate(String outdate) {
		this.outdate = outdate;
	}

	public String getOutreason() {
		return outreason;
	}

	public void setOutreason(String outreason) {
		this.outreason = outreason;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	@Override
	public String toString() {
		return "Mdto [no=" + no + ", img=" + img + ", name=" + name + ", jobgrade=" + jobgrade + ", type=" + type
				+ ", indate=" + indate + ", outdate=" + outdate + ", outreason=" + outreason + ", pno=" + pno + "]";
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}
	
	
}
