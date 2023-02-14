package 미니팀플.controller;

import java.util.ArrayList;

import 미니팀플.model.Member;
import 미니팀플.model.Memo;
import 미니팀플.model.Product;

/*

	- 쪽지 보내기
		인수: Product올린사람member , 쪽지title, 쪽지content		반환 : true / false
		
	- 내게 온 쪽지	
		인수: X												반환 : 모든 내게 온 쪽지가 담긴 ArrayList
		
	- 내가 보낸 쪽지	
		인수: X												반환 : 모든 내게 온 쪽지가 담긴 ArrayList
	
	- 쪽지보기	
		인수: 쪽지인덱스 										반환 : 해당 Memo
		
	
		
*/
public class MemoController {
	//* 싱글톤
	private static MemoController memoc = new MemoController();
	private MemoController() {}
	public static MemoController getInstance() {return memoc;}
	
	
	
	// 쪽지 보내기
	public boolean sendMemo(Member Member,String title, Product product, String content) {
		Memo memo = new Memo(title, content, product, Mcontroller.getInstance().getLoginSession(), Member);
		Member.getReceivememo().add(memo);
		return true;
	} // sendMemo e
	
	//내게 온 쪽지
	public ArrayList<Memo> receiveMemo() {
		/*로그인 한 사람 정보*/
		return Mcontroller.getInstance().getLoginSession().getReceivememo();
	}// receiveMemo e
	
	//내가 보낸 쪽지
	public ArrayList<Memo> mysendMemo() {
		return Mcontroller.getInstance().getLoginSession().getSendMemo();
	} //mysendMemo e
	
	//쪽지 상세보기
	public Memo getMemo(int mno) {
		return Mcontroller.getInstance().getLoginSession().getReceivememo().get(mno);
	} //getMemo e
	
	

} // class e
