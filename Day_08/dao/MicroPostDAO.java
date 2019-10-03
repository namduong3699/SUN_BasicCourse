package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.MicroPost;
import entity.User;

public class MicroPostDAO extends CommonDAO implements IMicroPostDAO{

	@Override
	public List<MicroPost> all() {
		ResultSet rs = null;
		try {
			Connection connection = connect();
			String sql = "SELECT id, user_id, content FROM micro_post";
			PreparedStatement ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			List<MicroPost> list = new ArrayList<MicroPost>();
			while(rs.next()) {
				int id = rs.getInt("id");
				int user_id = rs.getInt("id");
				String content = rs.getString("content");
				MicroPost microPost = new MicroPost(id, user_id, content);
				list.add(microPost);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if(rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	@Override
	public MicroPost find(int id) {
		ResultSet rs = null;
		try {
			Connection connection = connect();
			String sql = "SELECT id, user_id, content FROM micro_post WHERE id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				int user_id = rs.getInt("id");
				String content = rs.getString("content");
				MicroPost microPost = new MicroPost(id, user_id, content);
				return microPost;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public List<MicroPost> findByUser(User user) {
		ResultSet rs = null;
		try {
			Connection connection = connect();
			String sql = "SELECT id, user_id, content FROM micro_post WHERE user_id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, user.getId());
			rs = ps.executeQuery();
			List<MicroPost> list = new ArrayList<MicroPost>();
			while(rs.next()) {
				int id = rs.getInt("id");
				int user_id = rs.getInt("id");
				String content = rs.getString("content");
				MicroPost microPost = new MicroPost(id, user_id, content);
				list.add(microPost);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if(rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	@Override
	public void create(MicroPost microPost) {
		try {
			Connection connection = connect();
			String sql = "INSERT INTO micro_post(user_id, content) VALUES (?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, microPost.getUser_id());
			ps.setString(2, microPost.getContent());
			
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(MicroPost microPost) {
		try {
			Connection connection = connect();
			String sql = "UPDATE micro_post SET user_id = ?, content = ? WHERE id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, microPost.getUser_id());
			ps.setString(2, microPost.getContent());
			ps.setInt(3, microPost.getId());
			ps.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(MicroPost microPost) {
		try {
			Connection connection = connect();
			String sql = "DELETE FROM micro_post WHERE id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, microPost.getId());
			ps.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
