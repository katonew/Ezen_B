package 과제.과제7.Model;

public class Woori extends Account{
	
	
	final String bankno = "05";
	
	public Woori() {}
	
	public Woori(String acountno, String password, String name, int money) {
		super(acountno,password,name,money);
		super.setBankno(bankno);
	}
	
	
}
