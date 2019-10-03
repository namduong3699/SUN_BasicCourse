package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.MicroPost;
import entity.User;

public class UserDAO extends CommonDAO implements IUserDAO {

	@Override
	public List<User> all() {
		ResultSet rs = null;
		try {
			Connection connection = connect();
			String sql = "SELECT id, name, email, birth_day FROM user";
			PreparedStatement ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			List<User> list = new ArrayList<User>();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date birth_day = rs.getDate("birth_day");
				User user = new User(id, name, email, birth_day);
				list.add(user);
			}
			return list;
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
	public User find(int id) {
		ResultSet rs = null;
		try {
			Connection connection = connect();
			String sql = "SELECT id, name, email, birth_day FROM user WHERE id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date birthDay = rs.getDate("birth_day");
				User user = new User(id, name, email, birthDay);
				return user;
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
	public void create(User user) {
		try {
			Connection connection = connect();
			String sql = "INSERT INTO user(name, email, birth_day) VALUES (?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String stringDate = dateFormat.format(user.getBirthDay());
			ps.setDate(3, java.sql.Date.valueOf(stringDate));
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(User user) {
		try {
			Connection connection = connect();
			String sql = "UPDATE user SET name = ?, email = ?, birth_day = ? WHERE id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String stringDate = dateFormat.format(user.getBirthDay());
			ps.setDate(3, java.sql.Date.valueOf(stringDate));
			ps.setInt(4, user.getId());
			ps.execute();
//			System.out.println("Updated: " + user);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(User user) {
		try {
			Connection connection = connect();
			String sql = "DELETE FROM user WHERE id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, user.getId());
			ps.execute();
//			System.out.println("Deleted: " + user);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<MicroPost> findMicroPost(User user) {
		MicroPostDAO microPostDAO = new MicroPostDAO();
		List<MicroPost> list = null;
		list = microPostDAO.findByUser(user);
		return list;
	}

	@Override
	public List<User> findFollowing(User user) {
		ResultSet rs = null;
		try {
			Connection connection = connect();
			String sql = "SELECT u.id, u.name, u.email, u.birth_day " 
					 + "FROM user u"
					 + "INNER JOIN following f ON u.id = f.follow_id"
					 + "WHERE f.user_id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, user.getId());
			rs = ps.executeQuery();
			List<User> list = new ArrayList<User>();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date birthDay = rs.getDate("birth_day");
				User _user = new User(id, name, email, birthDay);
				list.add(_user);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<User> findFollowed(User user) {
		ResultSet rs = null;
		try {
			Connection connection = connect();
//			String sql = "SELECT u.id, u.name, u.email, u.birth_day " 
//					 + "FROM user u"
//					 + "INNER JOIN following f ON u.id = f.user_id"
//					 + "WHERE f.follow_id = ?";
			String sql = "SELECT id, name, email, birth_day " + 
					"FROM user " + 
					"WHERE id IN (" + 
					"	SELECT user_id" + 
					"	FROM following" + 
					"	WHERE follow_id = ?" + 
					")";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, user.getId());
			rs = ps.executeQuery();
			List<User> list = new ArrayList<User>();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date birthDay = rs.getDate("birth_day");
				User _user = new User(id, name, email, birthDay);
				list.add(_user);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int quantityMicroPost(User user) {
		ResultSet rs = null;
		int quantity = 0;
		try {
			Connection connection = connect();
			String sql = "SELECT COUNT(user_id) as count "
					+ "FROM micro_post "
					+ "WHERE user_id = ?"
					+ "GROUP BY user_id";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, user.getId());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				quantity = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return quantity;
	}

}