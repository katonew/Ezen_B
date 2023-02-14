package 미니팀플.model;

public class Memo {
	// 1. 필드
	String title;	
	String content;
	Product product;
	Member sendMember;	//보낸사람
	Member receiveMember;
	//2. 생성자
	public Memo() {}

	public Memo(String title, String content, Product product, Member sendMember, Member receiveMember) {
		super();
		this.title = title;
		this.content = content;
		this.product = product;
		this.sendMember = sendMember;
		this.receiveMember = receiveMember;
	}
	//3. 메소드
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Member getSendMember() {
		return sendMember;
	}

	public void setSendMember(Member sendMember) {
		this.sendMember = sendMember;
	}

	public Member getReceiveMember() {
		return receiveMember;
	}

	public void setReceiveMember(Member receiveMember) {
		this.receiveMember = receiveMember;
	}	
	
	
	
} // class e
