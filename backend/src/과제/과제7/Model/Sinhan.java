package 과제.과제7.Model;

public class Sinhan extends Account {
	
	final String bankno = "03";
	
	public Sinhan() {}
	
	public Sinhan(String acountno, String password, String name, int money) {
		super(acountno,password,name,money);
		super.setBankno(bankno);
	}
	
	
}
