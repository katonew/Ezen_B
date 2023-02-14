package 미니팀플.model;

public class Product {
	//1. 필드
	String name;
	String content;
	int price;
	Member member;
	boolean state;
	
	//2.생성자
	public Product() {}
	
	public Product(String name, String content, int price, Member member,boolean state) {
		this.name = name;
		this.content = content;
		this.price = price;
		this.member = member;
		this.state = state;
	}
	
	//3. 메소드
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
	
	
}
