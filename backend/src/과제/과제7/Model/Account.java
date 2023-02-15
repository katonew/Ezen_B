package 과제.과제7.Model;

public class Account {
	//계좌번호[ 은행코드-난수2자리-난수2자리 ] , 계좌비밀번호[4자리] , 계좌주 , 잔금 [초기 0원 ]
	private String acountno;
	private String password;
	private String name;
	private String bankno;
	public int money;
	
	public Account() {}

	public Account(String acountno, String password, String name, int money) {
		super();
		this.acountno = acountno;
		this.password = password;
		this.name = name;
		this.money = money;
		this.bankno = null;
	}
	
	

	public String getBankno() {
		return bankno;
	}

	public void setBankno(String bankno) {
		this.bankno = bankno;
	}

	@Override
	public String toString() {
		return "Acount [acountno=" + acountno + ", password=" + password + ", name=" + name + ", money=" + money + "]";
	}

	public String getAcountno() {
		return acountno;
	}

	public void setAcountno(String acountno) {
		this.acountno = acountno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	
}
