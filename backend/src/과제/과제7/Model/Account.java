package 과제.과제7.Model;

public class Account {
	//계좌번호[ 은행코드-난수2자리-난수2자리 ] , 계좌비밀번호[4자리] , 계좌주 , 잔금 [초기 0원 ]
	public String acountno;
	public String password;
	public String name;
	public int money;
	
	public Account() {}

	public Account(String acountno, String password, String name, int money) {
		super();
		this.acountno = acountno;
		this.password = password;
		this.name = name;
		this.money = money;
	}

	@Override
	public String toString() {
		return "Acount [acountno=" + acountno + ", password=" + password + ", name=" + name + ", money=" + money + "]";
	}
	
	
}
