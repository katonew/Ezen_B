package Day20.gallary.Model.Dao;

public class BoardDao extends Dao{

	//1. 싱글톤
	private static BoardDao dao = new BoardDao();
	private BoardDao() {}
	public static BoardDao getInstance() {return dao;}
	
	
	
	
}
