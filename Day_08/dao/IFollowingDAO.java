package dao;

import com.sun.tools.javac.util.List;

import entity.Following;
import entity.User;

public interface IFollowingDAO {
	public List<Following> all();

	public Following find(int id);
	
//	public Following findByUser(User user);
//	
//	public Following findUserFollow(User user);

	public void create(Following following);

	public void delete(Following following);
}
