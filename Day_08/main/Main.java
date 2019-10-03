package main;

import java.text.SimpleDateFormat;

import dao.MicroPostDAO;
import dao.UserDAO;

import entity.User;
import entity.MicroPost;;

public class Main {

	public static void main(String[] args) {
		try {
			UserDAO userDAO = new UserDAO();

			// CREATE
//			User newUser = new User();
//			newUser.setName("Chu Anh Tuan");
//			newUser.setEmail("chu.anh.tuan@sun-asterisk.com");
//			SimpleDateFormat dateformat2 = new SimpleDateFormat("MM/dd/yyyy");
//			newUser.setBirthDay(dateformat2.parse("1/1/1983"));
//			userDAO.create(newUser);

			// FIND ALL
//			List<User> users = userDAO.all();
//			for (User user : users) {
//				System.out.println(user);
//			}

			// FIND
			User user = userDAO.find(5);

//			UPDATE
//			user.setName("Duong Hoai Nam");
//			user.setEmail("namduong3699@gmail.com");
//			SimpleDateFormat dateformat2 = new SimpleDateFormat("MM/dd/yyyy");
//			user.setBirthDay(dateformat2.parse("6/3/1999"));
//			userDAO.update(user);

			// DELETE
//			userDAO.delete(user);

			MicroPostDAO microPostDAO = new MicroPostDAO();

			// CREATE
			MicroPost microPost = new MicroPost();
			microPost.setUser_id(user.getId());
			microPost.setContent("Lorem abc");
			microPostDAO.create(microPost);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}