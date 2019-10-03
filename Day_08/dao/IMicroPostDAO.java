package dao;

import java.util.List;

import entity.MicroPost;
import entity.User;

public interface IMicroPostDAO {
	public List<MicroPost> all();
	
	public MicroPost find(int id);
	
	public List<MicroPost> findByUser(User user);
	
	public void create(MicroPost microPost);
	
	public void update(MicroPost microPost);
	
	public void delete(MicroPost microPost);
	
}
