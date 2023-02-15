package 과제.과제7.Controller;

import java.util.ArrayList;
import 과제.과제7.Model.Account;

public class Controller {
	ArrayList<Account> AccountList = new ArrayList<>();
	
	private static Controller co = new Controller();
	private Controller() {}
	public static Controller getInstance() {return co;}
	
	// 총계좌 출력 메소드
	//AccountList 다가져와서 순서대로 출력
	public ArrayList<Account> PrintAccount(){
		return AccountList;
	}
	
	// 계좌 생성 메소드
	public Account addAccount(String password, String name) {
		int random1 = (int)((Math.random()*99)+1);
		int random2 = (int)((Math.random()*99)+1);
		String Accountno = "00-"+random1+"-"+random2;
		Account Account = new Account(Accountno, password, name, 0);
		AccountList.add(Account);
		return Account;
	}

	
	
	// 계좌 입금 메소드
	public boolean plusmoney(String Accountno, int plusmoney) {
		for(int i=0;i<AccountList.size();i++) {
			if(Accountno.equals(AccountList.get(i).acountno)) {
				AccountList.get(i).money += plusmoney;
				return true;
			}
		}// for e
		return false;
	}

	
}
