package dao;

import java.util.List;

import entity.MicroPost;
import entity.User;

public interface IUserDAO {
	public List<User> all();

	public User find(int id);

	public void create(User user);

	public void update(User user);

	public void delete(User user);
	
	public List<MicroPost> findMicroPost(User user);

	public List<User> findFollowing(User user);
	
	public List<User> findFollowed(User user);
	
	public int quantityMicroPost(User user);
}