package 과제.과제7.Model;

public class Kookmin extends Account{
	final String bankno = "04";
	
	public Kookmin(String acountno, String password, String name, int money) {
		nowAccount(acountno,password,name,money);
	}
	@Override
	public void nowAccount(String acountno, String password, String name, int money) {
		super.acountno = acountno;
		super.password = password;
		super.name = name;
		super.money = money;
		super.bankno = bankno;
	}
}
