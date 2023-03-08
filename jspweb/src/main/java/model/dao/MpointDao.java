package model.dao;

public class MpointDao extends Dao{
	
	private static MpointDao dao = new MpointDao();
	private MpointDao() {}
	public static MpointDao getInstance() {return dao;}

}
