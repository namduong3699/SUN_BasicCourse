package entity;

public class Following {
	private int id;
	private int user_id;
	private int follow_id;
	
	public Following() {
		
	}
	
	public Following(int id, int user_id, int follow_id) {
		this.id = id;
		this.user_id = user_id;
		this.follow_id = follow_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getFollow_id() {
		return follow_id;
	}

	public void setFollow_id(int follow_id) {
		this.follow_id = follow_id;
	}
	
	@Override
	public String toString() {
		return "Following: " + id + " " + user_id + " " + follow_id;
	}
}
