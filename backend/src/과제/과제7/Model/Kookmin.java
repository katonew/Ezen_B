package 과제.과제7.Model;

public class Kookmin extends Account{
	final String bankno = "04";
	
	public Kookmin() {}
	
	public Kookmin(String acountno, String password, String name, int money) {
		super(acountno,password,name,money);
		super.setBankno(bankno);
	}
}
