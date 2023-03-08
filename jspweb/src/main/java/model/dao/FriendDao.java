package model.dao;

public class FriendDao extends Dao{
	
	private static FriendDao dao = new FriendDao();
	private FriendDao() {}
	public static FriendDao getInstance() {return dao;}

}
