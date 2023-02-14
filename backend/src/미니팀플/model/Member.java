package 미니팀플.model;

import java.util.ArrayList;

public class Member {
	//1. 필드
	String id;
	String pw;
	String name;
	String phone;
	ArrayList<Product> product;
	ArrayList<Memo> sendMemo;
	ArrayList<Memo> receivememo;
	
	//2.생성자
	public Member() {}
	
	public Member(String id, String pw, String name, String phone, ArrayList<Product> product, ArrayList<Memo> sendMemo,
			ArrayList<Memo> receivememo) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.product = product;
		this.sendMemo = sendMemo;
		this.receivememo = receivememo;
	}
	
	//3.메소드
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public ArrayList<Product> getProduct() {
		return product;
	}

	public void setProduct(ArrayList<Product> product) {
		this.product = product;
	}

	public ArrayList<Memo> getSendMemo() {
		return sendMemo;
	}

	public void setSendMemo(ArrayList<Memo> sendMemo) {
		this.sendMemo = sendMemo;
	}

	public ArrayList<Memo> getReceivememo() {
		return receivememo;
	}

	public void setReceivememo(ArrayList<Memo> receivememo) {
		this.receivememo = receivememo;
	}
	
	
	
	
	
}
