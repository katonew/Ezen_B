package 과제.과제7.Model;

public class Sinhan extends Account {
	
	final String bankno = "03";
	
	public Sinhan(String acountno, String password, String name, int money) {
		nowAccount(acountno,password,name,money);
	}
	
	@Override
	public void nowAccount(String acountno, String password, String name, int money) {
		super.acountno = acountno;
		super.password = password;
		super.name = name;
		super.money = money;
		super.bankno = bankno;
		System.out.println("신한은행 계좌생성을 해주셔서 감사합니다.");
	}
	
	
}
