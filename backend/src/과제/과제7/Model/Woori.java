package 과제.과제7.Model;

public class Woori extends Account{
	
	
	final String bankno = "05";
	
	public Woori(String acountno, String password, String name, int money) {
		nowAccount(acountno,password,name,money);
	}
	
	@Override
	public void nowAccount(String acountno, String password, String name, int money) {
		super.acountno = acountno;
		super.password = password;
		super.name = name;
		super.money = money;
		super.bankno = bankno;
		System.out.println("우리은행 계좌생성을 해주셔서 감사합니다.");
	}
	
	
}
